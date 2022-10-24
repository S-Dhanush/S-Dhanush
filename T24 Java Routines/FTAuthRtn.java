package com.demo;

import java.util.List;

import com.temenos.api.TStructure;
import com.temenos.t24.api.complex.eb.templatehook.TransactionContext;
import com.temenos.t24.api.complex.eb.templatehook.TransactionData;
import com.temenos.t24.api.hook.system.RecordLifecycle;
import com.temenos.t24.api.records.account.AccountRecord;
import com.temenos.t24.api.records.customer.CustomerRecord;
import com.temenos.t24.api.system.DataAccess; 

/**
 * TODO: Document me!
 *
 * @author DS00843856
 *
 */
public class FTAuthRtn extends RecordLifecycle {

    @Override
    public void updateRecord(String application, String currentRecordId, TStructure currentRecord,
            TStructure unauthorisedRecord, TStructure liveRecord, TransactionContext transactionContext,
            List<TransactionData> transactionData, List<TStructure> currentRecords) {
        // TODO Auto-generated method stub
        AccountRecord acRec = new AccountRecord(currentRecord);
        String acOffi = acRec.getAccountOfficer().getValue().toString();
        String cusId = acRec.getCustomer().getValue().toString();
        DataAccess da = new DataAccess(this);
        CustomerRecord cusRec = new CustomerRecord(da.getRecord("CUSTOMER", cusId));
        cusRec.setAccountOfficer(acOffi);  // from account we are editing cus , so we will use ofs messing 
        
        TransactionData td = new TransactionData();
        
        td.setVersionId("CUSTOMER,RTN");
        td.setNumberOfAuthoriser("0");
        td.setTransactionId(cusId);
       
  
        
        transactionData.add(td);
        currentRecords.add(cusRec.toStructure());
        
      
    }
    

}
