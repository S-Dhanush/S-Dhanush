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
public class CusInputSector extends RecordLifecycle {

    
        @Override
    public TValidationResponse validateRecord(String application, String currentRecordId, TStructure currentRecord,
            TStructure unauthorisedRecord, TStructure liveRecord, TransactionContext transactionContext) {
        // TODO Auto-generated method stub
            CustomerRecord customerRecord = new CustomerRecord();

            String accountOfficer = customerRecord.getAccountOfficer().getValue().toString();
            String secTor = customerRecord.getSector().getValue().toString();

            TField sec = customerRecord.getSector();

            if (!accountOfficer.equals(5) && secTor.equals(1001)) {
                sec.setError("Sector Can't be 1001");
            }
            return customerRecord.getValidationResponse();
        }

    }

       

