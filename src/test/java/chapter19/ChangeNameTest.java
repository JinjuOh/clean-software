package chapter19;

import chapter19.transaction.add.AddHourlyEmployee;
import chapter19.transaction.change.ChangeNameTransaction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChangeNameTest {

    @Test
    public void changeNameTest() throws Exception {
        int empId = 2;
        AddHourlyEmployee t = new AddHourlyEmployee(empId, "Bill", "Home", 15.25);
        t.execute();
        ChangeNameTransaction cnt = new ChangeNameTransaction(empId, "Bob");
        cnt.execute();
        Employee e = PayrollDatabase.getEmployee(empId);
        assertEquals("Bob", e.getName());
    }
}
