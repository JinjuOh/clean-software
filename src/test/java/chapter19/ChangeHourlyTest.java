package chapter19;

import chapter19.classification.HourlyClassification;
import chapter19.classification.PaymentClassification;
import chapter19.schedule.PaymentSchedule;
import chapter19.schedule.WeeklySchedule;
import chapter19.transaction.add.AddCommissionedEmployee;
import chapter19.transaction.change.ChangeHourlyTransaction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ChangeHourlyTest {

    @Test
    public void changeHourlyTest() throws Exception {
        int empId = 3;
        AddCommissionedEmployee t = new AddCommissionedEmployee(empId, "Lance", "Home", 2500, 3.2);
        t.execute();
        ChangeHourlyTransaction cht = new ChangeHourlyTransaction(empId, 27.52);
        cht.execute();
        Employee e = PayrollDatabase.getEmployee(empId);
        assertNotNull(e);
        PaymentClassification pc = e.getClassification();
        assertNotNull(pc);
        HourlyClassification hc = (HourlyClassification) pc;
        assertEquals(pc, hc);
        assertEquals(27.52, hc.getRate());
        PaymentSchedule ps = e.getSchedule();
        WeeklySchedule ws = (WeeklySchedule) ps;
        assertEquals(ps, ws);
    }
}
