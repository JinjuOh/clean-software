package chapter19;

import chapter19.classification.PaymentClassification;
import chapter19.classification.SalariedClassification;
import chapter19.paymentmethod.HoldMethod;
import chapter19.paymentmethod.PaymentMethod;
import chapter19.schedule.MonthlySchedule;
import chapter19.schedule.PaymentSchedule;
import chapter19.transaction.add.AddSalariedEmployee;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddSalariedEmployeeTest {

    @Test
    public void addSalariedEmployee() {
        int empId = 1;
        AddSalariedEmployee t = new AddSalariedEmployee(empId, "Bob", "Home", 1000.00);
        t.execute();

        Employee e = PayrollDatabase.getEmployee(empId);
        assertEquals("Bob", e.getName());

        PaymentClassification pc = e.getClassification();
        SalariedClassification sc = (SalariedClassification) pc;
        assertEquals(pc, sc);

//        assertEquals(1000.00, sc.getSalary());
        PaymentSchedule ps = e.getSchedule();
        MonthlySchedule ms = (MonthlySchedule) ps;
        assertEquals(ps, ms);

        PaymentMethod pm = e.getMethod();
        HoldMethod hm = (HoldMethod) pm;
        assertEquals(pm, hm);
    }
}
