package com.demo;

import java.util.List;

import com.temenos.api.TStructure;
import com.temenos.t24.api.complex.eb.servicehook.ServiceData;
import com.temenos.t24.api.complex.eb.servicehook.SynchronousTransactionData;
import com.temenos.t24.api.complex.eb.servicehook.TransactionControl;
import com.temenos.t24.api.hook.system.ServiceLifecycle;
import com.temenos.t24.api.records.customer.CustomerRecord;
import com.temenos.t24.api.system.DataAccess;;

/**
 * TODO: Document me!
 *
 * @author DS00843856
 *
 */
public class CusUpdateService extends ServiceLifecycle {
    
    
    
    
    
    @Override
    public void updateRecord(String id, ServiceData serviceData, String controlItem,
            TransactionControl transactionControl, List<SynchronousTransactionData> transactionData,
            List<TStructure> records) {
        // TODO Auto-generated method stub
        
    
        DataAccess da = new DataAccess(this);
        CustomerRecord cusRec = new CustomerRecord(da.getRecord("CUSTOMER", id));

        String street = cusRec.getStreet(0).getValue().toString();
        String postCode = cusRec.getPostCode(0).getValue().toString();
        String country = cusRec.getCountry(0).getValue().toString();
        String intro = cusRec.getIntroducer().getValue().toString();
        String iD = id;
        
        
        if (street.isEmpty()){
            cusRec.setStreet("newstreet", 0);
        }
        if(postCode.isEmpty()){
            cusRec.setPostCode("601234", 0);
               
        }
        if (country.isEmpty()){
            cusRec.setCountry("IND", 0);
        }
        if(intro.isEmpty()){
            cusRec.setIntroducer("sulaiman");
        }
        SynchronousTransactionData std = new SynchronousTransactionData();
        std.setFunction("I");
        std.setVersionId("CUSTOMER,SERVICE");
        std.setSourceId("JAVAL3");
        std.setTransactionId(iD);
        std.setNumberOfAuthoriser("0");

        transactionData.add(std);
        records.add(cusRec.toStructure());
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
