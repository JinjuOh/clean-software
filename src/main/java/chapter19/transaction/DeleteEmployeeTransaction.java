package chapter19.transaction;

import chapter19.PayrollDatabase;

public class DeleteEmployeeTransaction implements Transaction {

    private int itsEmpId;

    public DeleteEmployeeTransaction(int itsEmpId) {
        this.itsEmpId = itsEmpId;
    }

    @Override
    public void execute() {
        PayrollDatabase.deleteEmployee(itsEmpId);
    }
}
