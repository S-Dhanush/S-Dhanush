package com.demo;

import java.util.List;

import com.temenos.api.TStructure;
import com.temenos.t24.api.complex.eb.templatehook.TransactionContext;
import com.temenos.t24.api.complex.eb.templatehook.TransactionData;
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
public class FTDebitAuth extends RecordLifecycle {

    @Override
    public void updateRecord(String application, String currentRecordId, TStructure currentRecord,
            TStructure unauthorisedRecord, TStructure liveRecord, TransactionContext transactionContext,
            List<TransactionData> transactionData, List<TStructure> currentRecords) {
        // TODO Auto-generated method stub
        
        FundsTransferRecord ftRec = new FundsTransferRecord(currentRecord);
        
        String dacc = ftRec.getDebitAcctNo().getValue().toString();
        
        String dAmt = ftRec.getDebitAmount().getValue().toString();
        float dAmtt = Float.parseFloat(dAmt);
        DataAccess da = new DataAccess(this);
        AccountRecord acRec = new AccountRecord(da.getRecord("ACCOUNT",dacc));
        String acBal = acRec.getWorkingBalance().getValue().toString();
        float acworBal = Float.parseFloat(acBal);
        
        
        if (dAmtt > acworBal){
            
            acRec.setPostingRestrict("1", 0);
            
                
        
        
        TransactionData td = new TransactionData();
        td.setVersionId("ACCOUNT,DHA");
        td.setNumberOfAuthoriser("0");
        td.setTransactionId(dacc);
        
        transactionData.add(td);
        currentRecords.add(acRec.toStructure());
        
        }
        
   
    }
    
    

}
