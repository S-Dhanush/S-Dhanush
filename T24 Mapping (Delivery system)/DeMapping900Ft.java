package com.demo;

import java.util.ArrayList;
import java.util.List;

import com.temenos.api.TStructure;
import com.temenos.t24.api.complex.de.deliveryhook.Field;
import com.temenos.t24.api.complex.de.deliveryhook.MultiValue;
import com.temenos.t24.api.hook.system.Delivery;
import com.temenos.t24.api.records.account.AccountRecord;
import com.temenos.t24.api.records.customer.CustomerRecord;
import com.temenos.t24.api.records.fundstransfer.FundsTransferRecord;
import com.temenos.t24.api.records.sector.SectorRecord;
import com.temenos.t24.api.system.DataAccess;

/**
 * TODO: Document me!
 *
 * @author DS00843856
 *
 */
public class DeMapping900Ft extends Delivery {

    @Override
    public List<Field> mapAdditionalDataToMessageType(TStructure record1, TStructure record2, TStructure record3,
            TStructure record4, TStructure record5, TStructure record6, TStructure record7, TStructure record8,
            String mappingKey, TStructure record11) {
        // TODO Auto-generated method stub
        
        List<Field> list = new ArrayList<>(); //list of "type - FIELD , with Class as ArrayList
        try {
        Field f91 = new Field();
        Field f92 = new Field();
        Field f93 = new Field();
        
        MultiValue accmul = new MultiValue();
       
        
        FundsTransferRecord ftRec = new FundsTransferRecord(record1);
        String drAcc = ftRec.getDebitAcctNo().getValue().toString();
        
        DataAccess da = new DataAccess();
        AccountRecord acRec = new AccountRecord(da.getRecord("ACCOUNT", drAcc));
        String cusId = acRec.getCustomer().getValue().toString();
        CustomerRecord cusRec = new CustomerRecord(da.getRecord("CUSTOMER", cusId));
        String sector = cusRec.getSector().getValue().toString();
        SectorRecord secRec = new SectorRecord(da.getRecord("SECTOR", sector));
        String secDes = secRec.getDescription(0).getValue().toString();
        
        
        
        List<String> accRecSel = da.selectRecords("", "ACCOUNT", "", "WITH CUSTOMER.NO EQ "+cusId);
        int count = accRecSel.size();
        
        for (int j =0 ; j<count ;j++){
            String acId = accRecSel.get(0);
            accmul.setSubValues(acId, j);
        }
        f92.addMultiValues(accmul);
        String num = String.valueOf(count);
        f91.setValue(num);
        f93.setValue(secDes);
        list.add(f91);
        list.add(f92);
        list.add(f93);
        
        }
        catch (Exception e){
            e.printStackTrace();
        }
        
        
        
        return list;
    }

    
}
