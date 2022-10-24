package com.demo;

import com.temenos.api.TField;
import com.temenos.api.TStructure;
import com.temenos.api.TValidationResponse;

import com.temenos.t24.api.complex.eb.templatehook.TransactionContext;
import com.temenos.t24.api.hook.system.RecordLifecycle;
import com.temenos.t24.api.records.customer.CustomerRecord;

/**
 * TODO: Document me!
 *
 * @author DS00843856
 *
 */
public class TuesDay extends RecordLifecycle {

    @Override
    public TValidationResponse validateRecord(String application, String currentRecordId, TStructure currentRecord,
            TStructure unauthorisedRecord, TStructure liveRecord, TransactionContext transactionContext) {
        // TODO Auto-generated method stub
        
        
        
        CustomerRecord cusRec = new CustomerRecord(currentRecord);
        TField f1 = cusRec.getSector();
        String Sect = cusRec.getSector().toString();
        String acOffi = cusRec.getAccountOfficer().getValue().toString();
        
        if((Sect.equals("1001")) && (acOffi.equals("2"))){
            
            f1.set("Sector Can't be 1001");
            
        }
        
        return cusRec.getValidationResponse();
    }
    

}
