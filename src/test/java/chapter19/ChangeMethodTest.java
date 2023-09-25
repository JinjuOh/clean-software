package chapter19;

import chapter19.classification.HourlyClassification;
import chapter19.classification.PaymentClassification;
import chapter19.paymentmethod.DirectMethod;
import chapter19.paymentmethod.HoldMethod;
import chapter19.paymentmethod.MailMethod;
import chapter19.paymentmethod.PaymentMethod;
import chapter19.schedule.PaymentSchedule;
import chapter19.schedule.WeeklySchedule;
import chapter19.transaction.add.AddCommissionedEmployee;
import chapter19.transaction.add.AddSalariedEmployee;
import chapter19.transaction.change.ChangeDirectTransaction;
import chapter19.transaction.change.ChangeHoldTransaction;
import chapter19.transaction.change.ChangeHourlyTransaction;
import chapter19.transaction.change.ChangeMailTransaction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ChangeMethodTest {

    @Test
    public void changeDirectTest() throws Exception {
        int empId = 3;
        AddSalariedEmployee t = new AddSalariedEmployee(empId, "Lance", "Home", 2500);
        t.execute();

        ChangeDirectTransaction chm = new ChangeDirectTransaction(empId, "wooribank", "1002");
        chm.execute();
        Employee e = PayrollDatabase.getEmployee(empId);
        assertNotNull(e);
        PaymentMethod pm = e.getMethod();
        assertNotNull(pm);
        DirectMethod dm = (DirectMethod) pm;
        assertEquals(pm, dm);
        assertEquals("wooribank", dm.getBank());
        assertEquals("1002", dm.getAccount());
    }

    @Test
    public void changeHoldTest() throws Exception {
        int empId = 3;
        AddSalariedEmployee t = new AddSalariedEmployee(empId, "Lance", "Home", 2500);
        t.execute();

        ChangeHoldTransaction chm = new ChangeHoldTransaction(empId);
        chm.execute();
        Employee e = PayrollDatabase.getEmployee(empId);
        assertNotNull(e);
        PaymentMethod pm = e.getMethod();
        assertNotNull(pm);
        HoldMethod hm = (HoldMethod) pm;
        assertEquals(pm, hm);
    }

    @Test
    public void changeMailTest() throws Exception {
        int empId = 3;
        AddSalariedEmployee t = new AddSalariedEmployee(empId, "Lance", "Home", 2500);
        t.execute();

        ChangeMailTransaction chm = new ChangeMailTransaction(empId, "Away From Home");
        chm.execute();
        Employee e = PayrollDatabase.getEmployee(empId);
        assertNotNull(e);
        PaymentMethod pm = e.getMethod();
        assertNotNull(pm);
        MailMethod mm = (MailMethod) pm;
        assertEquals(pm, mm);
        assertEquals("Away From Home", mm.getAddress());
    }
}
