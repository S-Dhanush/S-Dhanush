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
public class Gtthous extends RecordLifecycle {

    @Override
    public TValidationResponse validateRecord(String application, String currentRecordId, TStructure currentRecord,
            TStructure unauthorisedRecord, TStructure liveRecord, TransactionContext transactionContext) {
        // TODO Auto-generated method stub
        FundsTransferRecord ftRec = new FundsTransferRecord(currentRecord);
        TField f2 = ftRec.getCreditAmount();
        TField f1 = ftRec.getDebitAmount();
        
        String drCcr = ftRec.getDebitAmount().getValue().toString();
        float a = Float.parseFloat(drCcr);
        String crCcr = ftRec.getCreditAmount().getValue().toString();
        float b = Float.parseFloat(crCcr);

        if(a > 10000){
            f2.setError("Debit Amount is greater than Limit ");
     
        }else if (b>10000){
            f1.setError("Credit Amount is greater than limit");
         
        }
        return ftRec.getValidationResponse();
        
    }

}
