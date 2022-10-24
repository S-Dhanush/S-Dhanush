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
import com.temenos.t24.api.system.Session;

/**
 * TODO: Document me!
 *
 * @author DS00843856
 *
 */
public class FTLastWorkingDate extends RecordLifecycle {

    @Override
    public TValidationResponse validateRecord(String application, String currentRecordId, TStructure currentRecord,
            TStructure unauthorisedRecord, TStructure liveRecord, TransactionContext transactionContext) {
        // TODO Auto-generated method stub
        
        FundsTransferRecord ftRec  = new FundsTransferRecord(currentRecord);
        TField f1 = ftRec.getDebitValueDate();
        
        Session ses = new Session(this);
        DataAccess da = new DataAccess(this);
        String drValDat = ftRec.getDebitValueDate().getValue();
        String comId = ses.getCompanyId();
        DatesRecord daRec = new DatesRecord(da.getRecord("DATES", comId ));
        String lasWorDat = daRec.getLastWorkingDay().getValue();
        String datFor = "YYYYMMDD";
        Date dValDate = null;
        
        try {
            dValDate = new SimpleDateFormat(datFor).parse(drValDat);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            // Uncomment and replace with appropriate logger
            // LOGGER.error(e, e);
        }
        Date lasWorDate = null;
        try {
            lasWorDate = new SimpleDateFormat(datFor).parse(lasWorDat);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            // Uncomment and replace with appropriate logger
            // LOGGER.error(e, e);
        }
        
        if(dValDate.before(lasWorDate)){
            f1.setError("the LAst working date is higher");
            
            
        }
        
        return ftRec.getValidationResponse();
        
    }
    

}
