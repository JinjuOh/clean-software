package chapter19;

import chapter19.affilliation.Affiliation;
import chapter19.affilliation.UnionAffiliation;
import chapter19.classification.HourlyClassification;
import chapter19.classification.PaymentClassification;
import chapter19.schedule.PaymentSchedule;
import chapter19.schedule.WeeklySchedule;
import chapter19.transaction.add.AddCommissionedEmployee;
import chapter19.transaction.add.AddHourlyEmployee;
import chapter19.transaction.change.ChangeHourlyTransaction;
import chapter19.transaction.change.ChangeMemberTransaction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ChangeMemberTest {

    @Test
    public void changeMemberTest() throws Exception {
        int empId = 2;
        int memberId = 7734;
        AddHourlyEmployee t = new AddHourlyEmployee(empId, "Bill", "Home", 15.25);
        t.execute();
        ChangeMemberTransaction cmt = new ChangeMemberTransaction(empId, memberId, 99.42);
        cmt.execute();
        Employee e = PayrollDatabase.getEmployee(empId);
        assertNotNull(e);
        Affiliation af = e.getAffiliation();
        assertNotNull(af);
        UnionAffiliation uf = (UnionAffiliation) af;
        assertEquals(af, uf);
        assertEquals(99.42, uf.getAmount());
        Employee member = PayrollDatabase.getUnionMember(memberId);
        assertNotNull(member);
        assertEquals(e, member);
    }
}
