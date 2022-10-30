package com.demo;

import java.util.List;

import com.temenos.api.TStructure;
import com.temenos.t24.api.complex.eb.servicehook.ServiceData;
import com.temenos.t24.api.complex.eb.servicehook.SynchronousTransactionData;
import com.temenos.t24.api.complex.eb.servicehook.TransactionControl;
import com.temenos.t24.api.hook.system.ServiceLifecycle;
import com.temenos.t24.api.records.customer.CustomerRecord;
import com.temenos.t24.api.system.DataAccess;
import com.temenos.t24.api.system.Session;
import com.temenos.t24.api.records.deaddress.DeAddressRecord;

/**
 * TODO: Document me!
 *
 * @author GM00843854 25/10/2022
 *
 */
public class CusTestService extends ServiceLifecycle {

    @Override
    public void updateRecord(String id, ServiceData serviceData, String controlItem,
            TransactionControl transactionControl, List<SynchronousTransactionData> transactionData,
            List<TStructure> records) {
        // TODO Auto-generated method stub

        DataAccess da = new DataAccess(this);
        CustomerRecord cusRec = new CustomerRecord(da.getRecord("CUSTOMER", id));

        String shortName = cusRec.getShortName().toString();
        String name1 = cusRec.getName1(0).getValue().toString();
        String name2 = cusRec.getName2(0).getValue().toString();
        String strAdd = cusRec.getStreet(0).getValue().toString();
        String townCtry = cusRec.getTownCountry(0).getValue().toString();
        String postCode = cusRec.getPostCode(0).getValue().toString();

        DeAddressRecord deAdd = new DeAddressRecord();
        deAdd.setShortName(shortName, 0);
        deAdd.setName1(name1, 0);
        deAdd.setName2(name2, 0);
        deAdd.setStreetAddr(strAdd, 0);
        deAdd.setTownCountry(townCtry, 0);
        deAdd.setPostCode(postCode, 0);

        Session ses = new Session(this);
        String cmpId = ses.getCompanyId().toString();
        String c = ".C-";
        String iD = id;
        String p = ",print.1";

        SynchronousTransactionData std = new SynchronousTransactionData();
        std.setFunction("I");
        std.setVersionId("DE.ADDRESS,DHA");
        std.setSourceId("JAVAL3"); // OFS.SOURCE, I JAVAL3
        std.setTransactionId(cmpId + c + iD + p);

        transactionData.add(std);
        records.add(deAdd.toStructure());

    }

    @Override
    public List<String> getIds(ServiceData serviceData, List<String> controlList) {
        // TODO Auto-generated method stub

        List<String> List = null;

        DataAccess da = new DataAccess(this);
        List = da.selectRecords("", "CUSTOMER", "", "SECTOR EQ 1000");

        return List;
    }

    @Override
    public void initialise(ServiceData serviceData) {
        // TODO Auto-generated method stub

    }

}