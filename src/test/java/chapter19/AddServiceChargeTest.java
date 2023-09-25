package chapter19;

import chapter19.affilliation.UnionAffiliation;
import chapter19.transaction.add.AddHourlyEmployee;
import static org.junit.jupiter.api.Assertions.*;

import chapter19.transaction.serviceCharge.ServiceChargeTransaction;
import chapter19.vo.Employee;
import chapter19.vo.ServiceCharge;
import org.junit.jupiter.api.Test;

public class AddServiceChargeTest {
    @Test
    public void addServiceChargeTest() {
        int empId = 2;
        AddHourlyEmployee t = new AddHourlyEmployee(empId, "Bill", "Home", 15.25);
        t.execute();

        Employee e = PayrollDatabase.getEmployee(empId);
        assertNotNull(e);

        UnionAffiliation af = new UnionAffiliation(12.5);
        e.setAffiliation(af);
        int memberId = 86;  // Maxwell Smart
        PayrollDatabase.addUnionMember(memberId, e);
        ServiceChargeTransaction sct = new ServiceChargeTransaction(memberId, 20011101, 12.95);
        sct.execute();
        ServiceCharge sc = af.getServiceCharge(20011101);
        assertNotNull(sc);
        assertEquals(12.95, sc.getCharge());
    }
}
