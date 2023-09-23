package chapter19;

import java.util.HashMap;
import java.util.Map;

public class PayrollDatabase {

    private static Map<Integer, Employee> itsEmployee = new HashMap<>();
    private static Map<Integer, Employee> itsUnionMember = new HashMap<>();

    public PayrollDatabase() {
    }

    public static Employee getEmployee(int empId) {
        return itsEmployee.get(empId);
    }

    public static void addEmployee(int empId, Employee employee) {
        itsEmployee.put(empId, employee);
    }

    public static void clear() {
        itsEmployee.clear();
    }

    public static void deleteEmployee(int itsEmpId) {
        itsEmployee.remove(itsEmpId);
    }

    public static Map<Integer, Employee> getAllEmployee() {
        return itsEmployee;
    }

    public static Employee getUnionMember(int memberId) {
        return itsUnionMember.get(memberId);
    }

    public static void addUnionMember(int memberId, Employee e) {
        itsUnionMember.put(memberId, e);
    }
}
