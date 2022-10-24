package com.demo;

import java.util.List;

import com.temenos.api.TStructure;
import com.temenos.t24.api.complex.eb.templatehook.TransactionContext;
import com.temenos.t24.api.complex.eb.templatehook.TransactionData;
import com.temenos.t24.api.hook.system.RecordLifecycle;
import com.temenos.t24.api.records.customer.CustomerRecord;
import com.temenos.t24.api.system.Session;
import com.temenos.t24.api.records.deaddress.DeAddressRecord;

/**
 * TODO: Document me!
 *
 * @author DS00843856
 *
 */
public class CusAuthRtn extends RecordLifecycle {

    @Override
    public void updateRecord(String application, String currentRecordId, TStructure currentRecord,
            TStructure unauthorisedRecord, TStructure liveRecord, TransactionContext transactionContext,
            List<TransactionData> transactionData, List<TStructure> currentRecords) {
        // TODO Auto-generated method stub
        
        CustomerRecord cusRec = new CustomerRecord(currentRecord);
        String cusStreet = cusRec.getStreet(0).getValue().toString();
        Session ses = new Session(this);
        String comId = ses.getCompanyId().toString();
        String c = ".C-";
        String id = currentRecordId;
        String p = ".print.1" ;
        
        DeAddressRecord deAdd = new DeAddressRecord(); //SINCE WE ARE CREATING A NEW RECORD//
        
        deAdd.setShortName("test street", 0);
        deAdd.setName1(" Dhanushtest", 0);
        deAdd.setStreetAddr(cusStreet,0);
        deAdd.setTitle("Bishop");
        deAdd.setAddrLocation("primary");
        
        TransactionData td = new TransactionData();
        td.setVersionId("DE.ADDRESS,DHA");
        td.setNumberOfAuthoriser("0");
        td.setTransactionId(comId + c + id + p);
        
        
        transactionData.add(td);
        currentRecords.add(deAdd.toStructure());
        
     
    }
    
    

}
