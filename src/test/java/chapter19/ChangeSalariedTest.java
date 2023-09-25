package chapter19;

import chapter19.classification.PaymentClassification;
import chapter19.classification.SalariedClassification;
import chapter19.schedule.MonthlySchedule;
import chapter19.schedule.PaymentSchedule;
import chapter19.transaction.add.AddSalariedEmployee;
import chapter19.transaction.change.ChangeSalariedTransaction;
import chapter19.vo.Employee;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ChangeSalariedTest {

    @Test
    public void changeHourlyTest() throws Exception {
        int empId = 3;
        AddSalariedEmployee t = new AddSalariedEmployee(empId, "Lance", "Home", 2500);
        t.execute();
        ChangeSalariedTransaction cht = new ChangeSalariedTransaction(empId, 3000);
        cht.execute();
        Employee e = PayrollDatabase.getEmployee(empId);
        assertNotNull(e);
        PaymentClassification pc = e.getClassification();
        assertNotNull(pc);
        SalariedClassification sc = (SalariedClassification) pc;
        assertEquals(pc, sc);
        assertEquals(3000, sc.getSalary());
        PaymentSchedule ps = e.getSchedule();
        MonthlySchedule ms = (MonthlySchedule) ps;
        assertEquals(ps, ms);
    }
}
