package chapter19.transaction;

import chapter19.Employee;
import chapter19.PayrollDatabase;
import chapter19.classification.CommissionedClassification;
import chapter19.classification.HourlyClassification;
import chapter19.classification.PaymentClassification;

public class SalesReceiptTransaction implements Transaction {
    private int itsEmpId;
    private long itsDate;
    private int amount;

    public SalesReceiptTransaction(int itsEmpId, long itsDate, int amount) {
        this.itsEmpId = itsEmpId;
        this.itsDate = itsDate;
        this.amount = amount;
    }

    @Override
    public void execute() throws Exception {
        Employee e = PayrollDatabase.getEmployee(itsEmpId);
        if(e != null) {
            PaymentClassification pc = e.getClassification();
            try {
                CommissionedClassification cc = (CommissionedClassification) pc;
            } catch (Exception exception) {
                throw new Exception("Tried to add Sales-Receipt to non-commissioned employee");
            }
        } else {
            throw new Exception("No such employee");
        }
    }
}
