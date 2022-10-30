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
public class CusValidateShortname extends RecordLifecycle {

    @Override
    public TValidationResponse validateRecord(String application, String currentRecordId, TStructure currentRecord,
            TStructure unauthorisedRecord, TStructure liveRecord, TransactionContext transactionContext) {
        // TODO Auto-generated method stub
        CustomerRecord cusRec = new CustomerRecord();
        TField f1 = cusRec.getMnemonic();

        String mne = cusRec.getMnemonic().getValue().toString();
        String shortName = cusRec.getShortName(0).getValue().toString();

        if (mne.equals(shortName)) {
            f1.setError("Mnemonic and Short name are same");
        }
        return cusRec.getValidationResponse();

    }
}
