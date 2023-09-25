package chapter19.transaction;

import chapter19.Employee;
import chapter19.PayrollDatabase;

public abstract class ChangeEmployeeTransaction implements Transaction {

    private int empId;

    public ChangeEmployeeTransaction(int empId) {
        this.empId = empId;
    }

    @Override
    public void execute() throws Exception {
        Employee e = PayrollDatabase.getEmployee(empId);
        if(e != null) {
            change(e);
        }
    }

    public abstract void change(Employee e);
}
