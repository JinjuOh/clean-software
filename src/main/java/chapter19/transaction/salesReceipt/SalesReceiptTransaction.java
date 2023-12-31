package chapter19.transaction.salesReceipt;

import chapter19.vo.Employee;
import chapter19.PayrollDatabase;
import chapter19.classification.CommissionedClassification;
import chapter19.classification.PaymentClassification;
import chapter19.transaction.Transaction;
import chapter19.vo.SalesReceipt;

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
                cc.addSalesReceipt(new SalesReceipt(itsEmpId, itsDate, amount));
            } catch (Exception exception) {
                throw new Exception("Tried to add Sales-Receipt to non-commissioned employee");
            }
        } else {
            throw new Exception("No such employee");
        }
    }
}
