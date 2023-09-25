package chapter19.transaction.change;

import chapter19.vo.Employee;
import chapter19.PayrollDatabase;
import chapter19.transaction.Transaction;

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
