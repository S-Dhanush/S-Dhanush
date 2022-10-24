package com.demo;

import com.temenos.api.TStructure;
import com.temenos.t24.api.complex.eb.templatehook.TransactionContext;

import com.temenos.t24.api.hook.system.RecordLifecycle;
import com.temenos.t24.api.records.dates.DatesRecord;
import com.temenos.t24.api.records.fundstransfer.FundsTransferRecord;
import com.temenos.t24.api.system.DataAccess;
import com.temenos.t24.api.system.Session;

/**
 * TODO: Document me!
 *
 * @author DS00843856
 *
 */
public class FTInputRtn extends RecordLifecycle {

    @Override
    public void defaultFieldValues(String application, String currentRecordId, TStructure currentRecord,
            TStructure unauthorisedRecord, TStructure liveRecord, TransactionContext transactionContext) {
        // TODO Auto-generated method stub
        FundsTransferRecord  ftRec = new FundsTransferRecord(currentRecord);
        Session ses = new Session(this);
        DataAccess da = new DataAccess(this);
        
        String Locaccy = ses.getLocalCurrency();
        DatesRecord DaRec = new DatesRecord(da.getRecord("DATES", ses.getCompanyId())); // USING DATAACCESS CLASS BECAUSE WE ARE GETING THE DATA FROM THE RECORD//
        String Tday = DaRec.getToday().getValue().toString();
        ftRec.setDebitValueDate(Tday);
        ftRec.setCreditValueDate(Tday);
        ftRec.setDebitCurrency(Locaccy);
        ftRec.setDebitTheirRef("LOCAL PAYMENT");
        
        currentRecord.set(ftRec.toStructure());
    }

   

}
