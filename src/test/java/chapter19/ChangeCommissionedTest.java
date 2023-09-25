package chapter19;

import chapter19.classification.CommissionedClassification;
import chapter19.classification.PaymentClassification;
import chapter19.schedule.BiweeklySchedule;
import chapter19.schedule.PaymentSchedule;
import chapter19.transaction.add.AddCommissionedEmployee;
import chapter19.transaction.change.ChangeCommissionedTransaction;
import chapter19.vo.Employee;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ChangeCommissionedTest {

    @Test
    public void changeHourlyTest() throws Exception {
        int empId = 3;
        AddCommissionedEmployee t = new AddCommissionedEmployee(empId, "Lance", "Home", 2500, 3.5);
        t.execute();
        ChangeCommissionedTransaction cht = new ChangeCommissionedTransaction(empId, 3000, 4.0);
        cht.execute();
        Employee e = PayrollDatabase.getEmployee(empId);
        assertNotNull(e);
        PaymentClassification pc = e.getClassification();
        assertNotNull(pc);
        CommissionedClassification cc = (CommissionedClassification) pc;
        assertEquals(pc, cc);
        assertEquals(3000, cc.getSalary());
        assertEquals(4.0, cc.getRate());
        PaymentSchedule ps = e.getSchedule();
        BiweeklySchedule bs = (BiweeklySchedule) ps;
        assertEquals(ps, bs);
    }
}
