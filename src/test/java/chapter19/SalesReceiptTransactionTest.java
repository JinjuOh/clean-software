package chapter19;

import chapter19.classification.CommissionedClassification;
import chapter19.classification.PaymentClassification;
import chapter19.transaction.AddCommissionedEmployee;
import chapter19.transaction.SalesReceiptTransaction;
import chapter19.vo.SalesReceipt;
import chapter19.vo.TimeCard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SalesReceiptTransactionTest {

    @Test
    public void salesReceiptTransaction() throws Exception {
        int empId = 2;
        AddCommissionedEmployee t = new AddCommissionedEmployee(empId, "Bill", "Home", 2500, 3);
        t.execute();

        SalesReceiptTransaction tct = new SalesReceiptTransaction(empId, 20011031, 3);
        tct.execute();

        Employee e = PayrollDatabase.getEmployee(empId);
        assertNotNull(e);

        PaymentClassification pc = e.getClassification();
        CommissionedClassification cc = (CommissionedClassification) pc;
        assertEquals(pc, cc);

        SalesReceipt sr = cc.getSalesReceipt(2);
        assertNotNull(sr);
        assertEquals(3, sr.getAmount());
    }
}
