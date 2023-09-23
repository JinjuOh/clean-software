package chapter19;

import chapter19.classification.HourlyClassification;
import chapter19.classification.PaymentClassification;
import chapter19.classification.SalariedClassification;
import chapter19.paymentmethod.HoldMethod;
import chapter19.paymentmethod.PaymentMethod;
import chapter19.schedule.MonthlySchedule;
import chapter19.schedule.PaymentSchedule;
import chapter19.schedule.WeeklySchedule;
import chapter19.transaction.AddHourlyEmployee;
import chapter19.transaction.AddSalariedEmployee;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddHourlyEmployeeTest {

    @Test
    public void addSalariedEmployee() {
        int empId = 1;
        AddHourlyEmployee t = new AddHourlyEmployee(empId, "Bob", "Home", 1000.00);
        t.execute();

        Employee e = PayrollDatabase.getEmployee(empId);
        assertEquals("Bob", e.getName());

        PaymentClassification pc = e.getClassification();
        HourlyClassification sc = (HourlyClassification) pc;
        assertEquals(pc, sc);

//        assertEquals(1000.00, sc.getSalary());
        PaymentSchedule ps = e.getSchedule();
        WeeklySchedule ms = (WeeklySchedule) ps;
        assertEquals(ps, ms);

        PaymentMethod pm = e.getMethod();
        HoldMethod hm = (HoldMethod) pm;
        assertEquals(pm, hm);
    }
}
