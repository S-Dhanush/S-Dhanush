package com.demo;

import com.temenos.api.TStructure;
import com.temenos.t24.api.complex.eb.templatehook.TransactionContext;
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
public class AccInputRtn extends RecordLifecycle {

    @Override
    public void defaultFieldValues(String application, String currentRecordId, TStructure currentRecord,
            TStructure unauthorisedRecord, TStructure liveRecord, TransactionContext transactionContext) {
        // TODO Auto-generated method stub
        AccountRecord accRec = new AccountRecord(currentRecord);
        DataAccess da = new DataAccess(this);
        CustomerRecord cusRec = new CustomerRecord(da.getRecord("CUSTOMER", accRec.getCustomer().getValue().toString()) );
        String mne = cusRec.getMnemonic().getValue().toString();
        String shor = cusRec.getShortName().toString();
        
        accRec.setMnemonic(mne + "ACC");
        accRec.setAccountTitle1(shor + "ACC", 0);
        
       currentRecord.set(accRec.toStructure()); 
       
    }
    
    

}
