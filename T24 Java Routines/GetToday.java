package com.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.temenos.api.TField;
import com.temenos.api.TStructure;
import com.temenos.api.TValidationResponse;
import com.temenos.t24.api.complex.eb.templatehook.TransactionContext;
import com.temenos.t24.api.hook.system.RecordLifecycle;
import com.temenos.t24.api.records.dates.DatesRecord;
import com.temenos.t24.api.records.fundstransfer.FundsTransferRecord;
import com.temenos.t24.api.system.DataAccess;
import com.temenos.t24.api.system.Session;;

/**
 * TODO: Document me!
 *
 * @author DS00843856
 *
 */
public class GetToday extends RecordLifecycle {

    @Override
    public TValidationResponse validateRecord(String application, String currentRecordId, TStructure currentRecord,
            TStructure unauthorisedRecord, TStructure liveRecord, TransactionContext transactionContext) {
        // TODO Auto-generated method stub
        FundsTransferRecord ftRec = new FundsTransferRecord(currentRecord);
        TField f1 = ftRec.getProcessingDate();
        
        
        String prDat = ftRec.getProcessingDate().getValue();
        Session ses = new Session(this);
        String comId = ses.getCompanyId();
        DataAccess da = new DataAccess(this);
        DatesRecord daRec = new DatesRecord(da.getRecord("DATES", comId));
        
        String tDAy = daRec.getToday().getValue();
        String daFor = "YYYYMMDD";
        Date tDay = null;
        try {
            tDay = new SimpleDateFormat(daFor).parse(tDAy);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            // Uncomment and replace with appropriate logger
            // LOGGER.error(e, e);
        }
        Date prDAt = null;
        try {
                prDAt = new SimpleDateFormat(daFor).parse(prDat);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            // Uncomment and replace with appropriate logger
            // LOGGER.error(e, e);
        }
        
        if (prDAt.before(tDay)){
            f1.setError("the Processing date is lower than the today ");
        }
        
        
        
        
     
        return ftRec.getValidationResponse();
        
    }
    

}
