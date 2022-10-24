package com.demo;

import com.temenos.api.TField;
import com.temenos.api.TStructure;
import com.temenos.api.TValidationResponse;
import com.temenos.t24.api.complex.eb.templatehook.TransactionContext;
import com.temenos.t24.api.hook.system.RecordLifecycle;
import com.temenos.t24.api.records.account.AccountRecord;
import com.temenos.t24.api.records.fundstransfer.FundsTransferRecord;
import com.temenos.t24.api.system.DataAccess;

/**
 * TODO: Document me!
 *
 * @author DS00843856
 *
 */
public class WorkBalCheck extends RecordLifecycle {

    @Override
    public TValidationResponse validateRecord(String application, String currentRecordId, TStructure currentRecord,
            TStructure unauthorisedRecord, TStructure liveRecord, TransactionContext transactionContext) {
        // TODO Auto-generated method stub
     
        FundsTransferRecord ftRec = new FundsTransferRecord(currentRecord);
        TField f1 = ftRec.getDebitAmount();
        String dacc = ftRec.getDebitAcctNo().getValue().toString();
        
        String dAmt = ftRec.getDebitAmount().getValue().toString();
        float dAmtt = Float.parseFloat(dAmt);
        DataAccess da = new DataAccess(this);
        AccountRecord acRec = new AccountRecord(da.getRecord("ACCOUNT",dacc));
        String acBal = acRec.getWorkingBalance().getValue().toString();
        float acworBal = Float.parseFloat(acBal);
        
        
        if (dAmtt > acworBal){
            
            f1.setError("YOUR balance is low");
            
        }
        
        return ftRec.getValidationResponse();
    }

 
    

}
