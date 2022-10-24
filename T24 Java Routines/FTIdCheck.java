package com.demo;

import com.temenos.api.TField;
import com.temenos.api.TStructure;
import com.temenos.api.TValidationResponse;
import com.temenos.t24.api.complex.eb.templatehook.TransactionContext;
import com.temenos.t24.api.hook.system.RecordLifecycle;
import com.temenos.t24.api.records.fundstransfer.FundsTransferRecord;

/**
 * TODO: Document me!
 *
 * @author DS00843856
 *
 */
public class FTIdCheck extends RecordLifecycle {

    @Override
    public TValidationResponse validateRecord(String application, String currentRecordId, TStructure currentRecord,
            TStructure unauthorisedRecord, TStructure liveRecord, TransactionContext transactionContext) {
        // TODO Auto-generated method stub
        FundsTransferRecord  ftRec = new FundsTransferRecord(currentRecord);
        TField f1 = ftRec.getDebitAcctNo();
        
        if(!currentRecordId.substring(0, 2).equals("FT")){
            f1.setError("the Record Id is not equal to FT");
            
        }
        
        
        return ftRec.getValidationResponse();
        
    }
    
    

}
