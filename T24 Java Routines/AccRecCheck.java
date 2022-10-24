package com.demo;

import com.temenos.api.TField;
import com.temenos.api.TStructure;
import com.temenos.api.TValidationResponse;
import com.temenos.t24.api.complex.eb.templatehook.TransactionContext;
import com.temenos.t24.api.hook.system.RecordLifecycle;
import com.temenos.t24.api.records.account.AccountRecord;

/**
 * TODO: Document me!
 *
 * @author DS00843856
 *
 */
public class AccRecCheck extends RecordLifecycle {

    @Override
    public TValidationResponse validateRecord(String application, String currentRecordId, TStructure currentRecord,
            TStructure unauthorisedRecord, TStructure liveRecord, TransactionContext transactionContext) {
        // TODO Auto-generated method stub
        AccountRecord acRec = new AccountRecord(currentRecord);
       TField f1 = acRec.getCategory();
       TField f2 = acRec.getCurrency();
        String Categ = acRec.getCategory().getValue().toString();
        String curren = acRec.getCurrency().getValue().toString();
        //float Category = Float.parseFloat(Categ);
        if (!Categ.equals("1001")){
            f1.setError("Category  is not Valid");
        }
        if (!curren.equals("USD")){
            f2.setError("Currency is not Valid");
            
        }
        return acRec.getValidationResponse();
    }
    

}
