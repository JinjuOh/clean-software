package chapter19.transaction.delete;

import chapter19.PayrollDatabase;
import chapter19.transaction.Transaction;

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
