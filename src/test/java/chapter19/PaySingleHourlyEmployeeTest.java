package chapter19;

import chapter19.transaction.add.AddHourlyEmployee;
import chapter19.transaction.add.AddSalariedEmployee;
import chapter19.transaction.payday.PayCheck;
import chapter19.transaction.payday.PaydayTransaction;
import chapter19.transaction.timeCard.TimeCardTransaction;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class PaySingleHourlyEmployeeTest {

    @Test
    public void paySingleHourlyEmployeeNoTimeCard() throws Exception {
        int empId = 2;
        AddHourlyEmployee t = new AddHourlyEmployee(empId, "Bill", "Home", 15.25);
        t.execute();
        LocalDate payDate = LocalDate.parse("2001-11-09");
        PaydayTransaction pt = new PaydayTransaction(payDate);
        pt.execute();

        validateHourlyPaycheck(pt, empId, payDate, 0.0);
    }

    @Test
    void paySingleHourlyEmployeeOneTimeCard() throws Exception {
        int empId = 2;
        AddHourlyEmployee t = new AddHourlyEmployee(empId, "Bill", "Home", 15.25);
        t.execute();
        LocalDate payDate = LocalDate.parse("2001-11-09");

        TimeCardTransaction tc = new TimeCardTransaction(empId, 20011109, 2.0);
        tc.execute();
        PaydayTransaction pt = new PaydayTransaction(payDate);
        pt.execute();

        PayCheck pc = pt.getPayCheck(empId);
        assertNull(pc);

        validateHourlyPaycheck(pt, empId, payDate, (8 + 1.5) * 15.25);
    }

    @Test
    void paySingleHourlyTwoTimeCards() throws Exception {
        int empId = 2;
        AddHourlyEmployee t = new AddHourlyEmployee(empId, "Bill", "Home", 15.25);
        t.execute();
        LocalDate payDate = LocalDate.parse("2001-11-09");

        TimeCardTransaction tc = new TimeCardTransaction(empId, 20011109, 2.0);
        tc.execute();
        TimeCardTransaction tc2 = new TimeCardTransaction(empId, 20011108, 5.0);
        tc2.execute();
        PaydayTransaction pt = new PaydayTransaction(payDate);
        pt.execute();

        PayCheck pc = pt.getPayCheck(empId);
        validateHourlyPaycheck(pt, empId, payDate, 7 * 15.25);
    }

    void validateHourlyPaycheck(PaydayTransaction pt, int empId, LocalDate payDate, double pay) {
        PayCheck pc = pt.getPayCheck(empId);
//        assertNotNull(pc);
        assertEquals(payDate, pc.getPayDate());
        assertEquals(pay, pc.getGrossDay());
//        assertEquals("Hold", pc.getField("Disposition"));
        assertEquals(0.0, pc.getDeductions());
        assertEquals(pay, pc.getNetPay());
    }
}
