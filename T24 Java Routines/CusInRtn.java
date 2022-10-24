package com.demo;

import com.temenos.api.TStructure;
import com.temenos.t24.api.complex.eb.templatehook.TransactionContext;
import com.temenos.t24.api.hook.system.RecordLifecycle;
import com.temenos.t24.api.records.customer.CustomerRecord;

/**
 * TODO: Document me!
 *
 * @author DS00843856
 *
 */
public class CusInRtn extends RecordLifecycle {

    @Override
    public void defaultFieldValues(String application, String currentRecordId, TStructure currentRecord,
            TStructure unauthorisedRecord, TStructure liveRecord, TransactionContext transactionContext) {
        // TODO Auto-generated method stub

        CustomerRecord cusRec1 = new CustomerRecord(currentRecord);

        cusRec1.setMnemonic("DGHJKUI");
        cusRec1.setName1("DHAKSHAN", 0);
        cusRec1.setStreet("87 - TechM-Chennai-SBC Techpark ,M/S Tech Mahindra Limited ,SBC Tech Park", 0);
        cusRec1.setSector("1001");
        cusRec1.setIndustry("267");
        cusRec1.setTarget("333");
        cusRec1.setNationality("US");
        cusRec1.setLanguage("1");

        currentRecord.set(cusRec1.toStructure());

    }

}
