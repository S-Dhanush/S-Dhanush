package com.demo;

import com.temenos.api.TField;
import com.temenos.api.TStructure;
import com.temenos.api.TValidationResponse;
import com.temenos.t24.api.records.customer.*;
import com.temenos.t24.api.complex.eb.templatehook.TransactionContext;
import com.temenos.t24.api.hook.system.RecordLifecycle;

/**
 * TODO: Document me!
 *
 * @author DS00843856
 *
 */
public class CusInputOverride extends RecordLifecycle {

    @Override
    public TValidationResponse validateRecord(String application, String currentRecordId, TStructure currentRecord,
            TStructure unauthorisedRecord, TStructure liveRecord, TransactionContext transactionContext) {
        // TODO Auto-generated method stub
        
        CustomerRecord cusRec = new CustomerRecord();
        TField f1 = cusRec.getResidence();
        String resi = cusRec.getResidence().getValue().toString();
        
        if (!resi.equals("ES")){        
            f1.setOverride("NOT SPAIN RESIDENT");
        }
        return cusRec.getValidationResponse();
    }

    
    

}
