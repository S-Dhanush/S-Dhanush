package com.demo;

import java.util.ArrayList;
import java.util.List;

import com.temenos.api.TStructure;
import com.temenos.t24.api.complex.de.deliveryhook.Field;
import com.temenos.t24.api.complex.de.deliveryhook.MultiValue;
import com.temenos.t24.api.hook.system.Delivery;
import com.temenos.t24.api.records.account.AccountRecord;
import com.temenos.t24.api.records.customer.CustomerRecord;
import com.temenos.t24.api.records.dates.DatesRecord;
import com.temenos.t24.api.records.fundstransfer.FundsTransferRecord;
import com.temenos.t24.api.system.DataAccess;
import com.temenos.t24.api.system.Session;

/**
 * TODO: Document me!
 *
 * @author DS00843856
 *
 */
public class DeMappingWorkShop extends Delivery {

    @Override
    public List<Field> mapAdditionalDataToMessageType(TStructure record1, TStructure record2, TStructure record3,
            TStructure record4, TStructure record5, TStructure record6, TStructure record7, TStructure record8,
            String mappingKey, TStructure record11) {
        // TODO Auto-generated method stub

        List<Field> list = new ArrayList<>();
        try {
            Field f91 = new Field();

            Field f92 = new Field();
            Field f93 = new Field();
            MultiValue muVal = new MultiValue();
            MultiValue f92Val = new MultiValue();
            List<String> listOfFt = null;
            Float l = null;

            FundsTransferRecord ftRec = new FundsTransferRecord(record1);
            String debAcc = ftRec.getDebitAcctNo().getValue().toString();
            DataAccess da = new DataAccess();
            AccountRecord acRec = new AccountRecord(da.getRecord("ACCOUNT", debAcc));
            String cusId = acRec.getCustomer().getValue().toString();
            CustomerRecord cusRec = new CustomerRecord(da.getRecord("CUSTOMER", cusId));
            String address = cusRec.getAddress(0).get(0).getValue().toString();
            String street = cusRec.getStreet(0).getValue().toString();
            String pincode = cusRec.getPostCode(0).getValue().toString();

            muVal.setSubValues(address, 0);
            muVal.setSubValues(street, 1);
            muVal.setSubValues(pincode, 2);

            f91.addMultiValues(muVal); // setted the value for f91

            Session ses = new Session();
            String comId = ses.getCompanyId().toString();
            DatesRecord daRec = new DatesRecord(da.getRecord("DATES", comId));
            String tday = daRec.getToday().getValue().toString();

            listOfFt = da.selectRecords("", "FUNDSTRANSFER", "",
                    "DEBIT.ACCT.NO EQ" + debAcc + "AND DEBIT.VALUE.DATE EQ" + tday);
            int i = listOfFt.size();

            for (int j = 0; j < i; j++) {
                String ftId = listOfFt.get(0).toString();
                f92Val.setSubValues(ftId, j);
            }
            f92.addMultiValues(f92Val); // setted the f92 value

            for (int k = 0; k < i; k++) {
                String ftId = listOfFt.get(0).toString();
                FundsTransferRecord tFtRec = new FundsTransferRecord(da.getRecord("FUNDSTRANSFER", ftId));

                String amt = tFtRec.getDebitAmount().getValue().toString();
                l = l + Float.parseFloat(amt);

            }
            String totalAmt = String.valueOf(l);

            f93.setValue(totalAmt); // F93 is setted

            list.add(f91);
            list.add(f92);
            list.add(f93);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

}
