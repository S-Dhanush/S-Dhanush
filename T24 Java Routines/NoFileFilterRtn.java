package com.demo;

import java.util.ArrayList;
import java.util.List;

import com.temenos.t24.api.complex.eb.enquiryhook.EnquiryContext;
import com.temenos.t24.api.complex.eb.enquiryhook.FilterCriteria;
import com.temenos.t24.api.hook.system.Enquiry;
import com.temenos.t24.api.records.account.AccountRecord;
import com.temenos.t24.api.records.category.CategoryRecord;
import com.temenos.t24.api.records.customer.CustomerRecord;
import com.temenos.t24.api.records.customeraccount.CustomerAccountRecord;
import com.temenos.t24.api.records.dates.DatesRecord;
import com.temenos.t24.api.records.fundstransfer.FundsTransferRecord;
import com.temenos.t24.api.records.sector.SectorRecord;
import com.temenos.t24.api.system.DataAccess;
import com.temenos.t24.api.system.Session;

/**
 * TODO: Document me!
 *
 * @author DS00843856
 *
 */
public class NoFileFilterRtn extends Enquiry {

        static private String dimField = "*";
    @Override
    public List<String> setIds(List<FilterCriteria> filterCriteria, EnquiryContext enquiryContext) {
        // TODO Auto-generated method stub
        
        
        List<String> mylist = new ArrayList<String>(); //which we are building//
        List<String> ftlist = null; //to avoid fatal error can be written as ftlist = new ArrayList<string> // 
        
        
        Session ses = new Session(this);
        DataAccess da = new DataAccess(this);
        String comId = ses.getCompanyId().toString();
        DatesRecord dr = new DatesRecord(da.getRecord("DATES", comId));
        String tday = dr.getToday().getValue().toString();
        String acId= "" ;
        for (int j = 0 ; j<filterCriteria.size(); j++){
            if(filterCriteria.get(j).getFieldname().equals("ACC.NUM")){
                    acId = filterCriteria.get(j).getValue();
                
            }
        }
        if(!acId.equals("")){
            ftlist = da.selectRecords("", "FUNDS.TRANSFER", "", "PROCESSING.DATE EQ "+tday+ " AND DEBIT.ACCT.NO EQ "+acId);
        }else{
            
        
        ftlist = da.selectRecords("", "FUNDS.TRANSFER", "", "PROCESSING.DATE EQ "+tday);
        }
        int ftListSize = 0;
        ftListSize = ftlist.size();
        
        for(int i = 0 ; i <ftListSize ; i++){
            String ftNum = ftlist.get(i);
            FundsTransferRecord FtRec = new FundsTransferRecord(da.getRecord("FUNDS.TRANSFER", ftNum));
            String accNum = FtRec.getDebitAcctNo().getValue().toString();
            
            AccountRecord acRec = new AccountRecord(da.getRecord("ACCOUNT", accNum));
            String shortName = acRec.getShortTitle(0).getValue().toString();
            String cusId = acRec.getCustomer().getValue().toString();
            String acCate = acRec.getCategory().getValue().toString();
            
            CustomerRecord cusRec = new CustomerRecord(da.getRecord("CUSTOMER", cusId));
            String cusMnemo = cusRec.getMnemonic().getValue().toString();
            String cusSector = cusRec.getSector().getValue().toString();
            
            
            CategoryRecord catRec = new CategoryRecord(da.getRecord("CATEGORY", acCate));
            String catDescrip = catRec.getDescription(0).getValue().toString();
            
            SectorRecord secRec = new SectorRecord(da.getRecord("SECTOR", cusSector));
            String secDescrip = secRec.getDescription(0).getValue().toString();
            
            
            CustomerAccountRecord cusAcc = new CustomerAccountRecord(da.getRecord("CUSTOMER.ACCOUNT", cusId));
            String accs = cusAcc.getAccountNumber().getValue().toString();
            
            mylist.add(ftNum +dimField +accNum +dimField+ shortName + dimField + cusId + dimField + cusMnemo + dimField + acCate + dimField + catDescrip + dimField + accs + dimField + cusSector + dimField + secDescrip);
        }
        
        
      
        return mylist;
    }

}
