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
public class FTVersionDemo extends RecordLifecycle {

    @Override
    public TValidationResponse validateRecord(String application, String currentRecordId, TStructure currentRecord,
            TStructure unauthorisedRecord, TStructure liveRecord, TransactionContext transactionContext) {
        // TODO Auto-generated method stub
        FundsTransferRecord ftRec = new FundsTransferRecord(currentRecord);
        TField f2 = ftRec.getCreditCurrency();
        
        String drCcr = ftRec.getDebitCurrency().getValue();
        String crCcr = ftRec.getCreditCurrency().getValue();
        
        if(!drCcr.equals(crCcr)){
            f2.setError("Credit currency is not equal to Debit currency");
            
        }
        return ftRec.getValidationResponse();
        
    }

}
