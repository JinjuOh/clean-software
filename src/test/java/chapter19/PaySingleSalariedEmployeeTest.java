package chapter19;

import chapter19.transaction.add.AddSalariedEmployee;
import chapter19.transaction.payday.PayCheck;
import chapter19.transaction.payday.PaydayTransaction;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class PaySingleSalariedEmployeeTest {

    @Test
    public void paySingleSalariedEmployee() throws Exception {
        int empId = 1;
        AddSalariedEmployee t = new AddSalariedEmployee(empId, "Bob", "Home", 1000.00);
        t.execute();
        LocalDate payDate = LocalDate.parse("2001-11-30");
        PaydayTransaction pt = new PaydayTransaction(payDate);
        pt.execute();
        PayCheck pc = pt.getPayCheck(empId);
        assertNotNull(pc);
        assertEquals(payDate, pc.getPayDate());
        assertEquals(1000.00, pc.getGrossDay());
//        assertEquals("Hold", pc.getField("Disposition"));
        assertEquals(0.0, pc.getDeductions());
        assertEquals(1000.00, pc.getNetPay());
    }

    @Test
    public void paySingleSalariedEmployeeOnWrongDate() throws Exception {
        int empId = 1;
        AddSalariedEmployee t = new AddSalariedEmployee(empId, "Bob", "Home", 1000.00);
        t.execute();
        LocalDate payDate = LocalDate.parse("2001-11-29");
        PaydayTransaction pt = new PaydayTransaction(payDate);
        pt.execute();
        PayCheck pc = pt.getPayCheck(empId);
        assertNull(pc);
    }
}
