package chapter19;

import chapter19.classification.HourlyClassification;
import chapter19.classification.PaymentClassification;
import chapter19.transaction.AddCommissionedEmployee;
import chapter19.transaction.AddHourlyEmployee;
import chapter19.transaction.DeleteEmployeeTransaction;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class TimeCardTransactionTest {

    @Test
    public void timeCardTransaction() throws Exception {
        int empId = 2;
        AddHourlyEmployee t = new AddHourlyEmployee(empId, "Bill", "Home", 15.25);
        t.execute();

        TimeCardTransaction tct = new TimeCardTransaction(empId, 20011031, 8.0);
        tct.execute();

        Employee e = PayrollDatabase.getEmployee(empId);
        assertNotNull(e);

        PaymentClassification pc = e.getClassification();
        HourlyClassification hc = (HourlyClassification) pc;
        assertEquals(pc, hc);

        TimeCard tc = hc.getTimeCard(20011031);
        assertNotNull(tc);
        assertEquals(8.0, tc.getHours());
    }
}
