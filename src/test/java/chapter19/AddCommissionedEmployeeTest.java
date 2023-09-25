package chapter19;

import chapter19.classification.CommissionedClassification;
import chapter19.classification.PaymentClassification;
import chapter19.paymentmethod.HoldMethod;
import chapter19.paymentmethod.PaymentMethod;
import chapter19.schedule.BiweeklySchedule;
import chapter19.schedule.PaymentSchedule;
import chapter19.transaction.add.AddCommissionedEmployee;
import chapter19.vo.Employee;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddCommissionedEmployeeTest {

    @Test
    public void addSalariedEmployee() {
        int empId = 1;
        AddCommissionedEmployee t = new AddCommissionedEmployee(empId, "Bob", "Home", 1000.00, 1);
        t.execute();

        Employee e = PayrollDatabase.getEmployee(empId);
        assertEquals("Bob", e.getName());

        PaymentClassification pc = e.getClassification();
        CommissionedClassification sc = (CommissionedClassification) pc;
        assertEquals(pc, sc);

//        assertEquals(1000.00, sc.getSalary());
        PaymentSchedule ps = e.getSchedule();
        BiweeklySchedule ms = (BiweeklySchedule) ps;
        assertEquals(ps, ms);

        PaymentMethod pm = e.getMethod();
        HoldMethod hm = (HoldMethod) pm;
        assertEquals(pm, hm);
    }
}
