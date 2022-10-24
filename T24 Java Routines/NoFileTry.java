package com.demo;

import java.util.ArrayList;
import java.util.List;

import com.temenos.t24.api.complex.eb.enquiryhook.EnquiryContext;
import com.temenos.t24.api.complex.eb.enquiryhook.FilterCriteria;
import com.temenos.t24.api.hook.system.Enquiry;
import com.temenos.t24.api.records.account.AccountRecord;
import com.temenos.t24.api.records.dates.DatesRecord;
import com.temenos.t24.api.records.fundstransfer.FundsTransferRecord;
import com.temenos.t24.api.system.DataAccess;
import com.temenos.t24.api.system.Session;

/**
 * TODO: Document me!SS<NOFILE.TRY,ENQUIRY<ENQ.NOFILE.TRY,EB.API<API.NOFILE.TRY
 *
 * @author DS00843856
 *
 */
public class NoFileTry extends Enquiry {

    static private String dimField = "*";

    @Override
    public List<String> setIds(List<FilterCriteria> filterCriteria, EnquiryContext enquiryContext) {
        // TODO Auto-generated method stub
        List<String> finalList = new ArrayList<String>();
        List<String> list = null;
        List<String> listOfFtWithToday = null;
        List<String> listOfFtTotal = null;
        float totalAmt = 0;
        float totalAmtOfAll = 0;

        Session ses = new Session(this);
        DataAccess da = new DataAccess(this);
        String comId = ses.getCompanyId().toString();
        DatesRecord datesRec = new DatesRecord(da.getRecord("DATES", comId));
        String tDay = datesRec.getToday().getValue().toString();
        String acId = "";

        for (int j = 0; j < filterCriteria.size(); j++) {
            if (filterCriteria.get(j).getFieldname().equals("AC.NUM")) {
                acId = filterCriteria.get(j).getValue();

            }
        }
        if (!acId.equals("")) {
            list = da.selectRecords("", "ACCOUNT", "", "@ID EQ " + acId);
        } else {

            list = da.selectRecords("", "ACCOUNT", "", "");
        }
        int acSize = 0;
        acSize = list.size();

        for (int i = 0; i < acSize; i++) {
            String dataOfAccId = list.get(i); // the account number will be here
                                              // and coulmn1
            AccountRecord acRec = new AccountRecord(da.getRecord("ACCOUNT", dataOfAccId));
            String cusId = acRec.getCustomer().getValue().toString(); // coulmn
                                                                      // 2
            String workBal = acRec.getWorkingBalance().getValue().toString(); // coulmn7

            // now getting ft with processing date eq today

            listOfFtWithToday = da.selectRecords("", "FUNDS.TRANSFER", "","PROCESSING.DATE EQ " + tDay + "AND DEBIT.ACCT.NO EQ " + dataOfAccId);
            int numOfFtWthTday = listOfFtWithToday.size(); // coulmn3

            for (int k = 0; k < numOfFtWthTday; k++) {
                String dataOfFtTday = listOfFtWithToday.get(k);
                FundsTransferRecord FtRec = new FundsTransferRecord(da.getRecord("FUNDS.TRANSFER", dataOfFtTday));
                String DeAmt = FtRec.getDebitAmount().getValue().toString();

                float amt = Float.parseFloat(DeAmt);
                totalAmt = totalAmt + amt; // column5

            } //THIS ONE WITH ALL THE FT 

            listOfFtTotal = da.selectRecords("", "FUNDS.TRANSFER", "$HIS", " DEBIT.ACCT.NO EQ " + dataOfAccId);
            int numOfFtTotal = listOfFtTotal.size(); // coulmn4

            for (int l = 0; l < numOfFtTotal; l++) {
                String dataOfFtAll = listOfFtTotal.get(l);
                FundsTransferRecord FtRec = new FundsTransferRecord(da.getRecord("FUNDS.TRANSFER", dataOfFtAll));
                String DeAmtTotal = FtRec.getDebitAmount().getValue().toString();

                float amtOfTotal = Float.parseFloat(DeAmtTotal);
                totalAmtOfAll = totalAmtOfAll + amtOfTotal; // column6

            }

            finalList.add(dataOfAccId + dimField + cusId + dimField + numOfFtWthTday + dimField + numOfFtTotal
                    + dimField + totalAmt + dimField + totalAmtOfAll + dimField + workBal);

        }

        return finalList;
    }

}
