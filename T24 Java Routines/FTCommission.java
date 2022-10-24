package com.demo;

import com.temenos.api.TStructure;
import com.temenos.t24.api.complex.eb.templatehook.TransactionContext;
import com.temenos.t24.api.hook.system.RecordLifecycle;
import com.temenos.t24.api.records.account.AccountRecord;
import com.temenos.t24.api.records.customer.CustomerRecord;
import com.temenos.t24.api.records.fundstransfer.FundsTransferRecord;
import com.temenos.t24.api.records.fundstransfer.CommissionTypeClass;
import com.temenos.t24.api.system.DataAccess;
import com.temenos.t24.api.records.ftcommissiontype.FtCommissionTypeRecord;

/**
 * TODO: Document me!
 *
 * @author DS00843856
 *
 */
public class FTCommission extends RecordLifecycle {

    @Override
    public void defaultFieldValues(String application, String currentRecordId, TStructure currentRecord,
            TStructure unauthorisedRecord, TStructure liveRecord, TransactionContext transactionContext) {
        // TODO Auto-generated method stub
        FundsTransferRecord ftRec = new FundsTransferRecord(currentRecord);
        DataAccess da = new DataAccess(this);

        String commiss = ftRec.getCommissionType().get(0).getCommissionType().toString();

        if (!commiss.isEmpty()) {
            String dbAcc = ftRec.getDebitAcctNo().getValue().toString();

            AccountRecord acRec = new AccountRecord(da.getRecord("ACCOUNT", dbAcc));
            String cusDet = acRec.getCustomer().getValue().toString();

            CustomerRecord cusRec = new CustomerRecord(da.getRecord("CUSTOMER", cusDet));
            String cusDa = cusRec.getName1(0).getValue().toString();

            FtCommissionTypeRecord comType = new FtCommissionTypeRecord(da.getRecord("FT.COMMISSION.TYPE", commiss));
            String ftAmt = comType.getCurrency().get(0).getFlatAmt().toString();
            float chr = Float.parseFloat(ftAmt);
            float a = 10, b = 100;
            float c = (a * chr) / b;
            float d = c + chr;
            String amt = Float.toString(d);

            CommissionTypeClass comValue = new CommissionTypeClass();
            comValue.setCommissionAmt(amt);


            ftRec.setPaymentDetails(cusDa, 0);
            ftRec.setCommissionType(comValue, 0);


            currentRecord.set(ftRec.toStructure());
        }

    }

}
