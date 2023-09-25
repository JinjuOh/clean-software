package chapter19;

import chapter19.transaction.add.AddCommissionedEmployee;
import chapter19.transaction.delete.DeleteEmployeeTransaction;
import chapter19.vo.Employee;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class DeleteEmployeeTest {

    @Test
    public void deleteEmployeeTest() {
        int empId = 3;
        AddCommissionedEmployee t = new AddCommissionedEmployee(empId, "Lance", "Home", 2500, 3.2);
        t.execute();

        Employee e = PayrollDatabase.getEmployee(empId);
        assertNotNull(e);

        DeleteEmployeeTransaction dt = new DeleteEmployeeTransaction(empId);
        dt.execute();

        Map<Integer, Employee> data = PayrollDatabase.getAllEmployee();

        Employee e2 = PayrollDatabase.getEmployee(empId);
        assertNull(e2);
    }
}
