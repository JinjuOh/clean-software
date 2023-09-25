package chapter19.transaction.add;

import chapter19.Employee;
import chapter19.PayrollDatabase;
import chapter19.classification.PaymentClassification;
import chapter19.paymentmethod.HoldMethod;
import chapter19.paymentmethod.PaymentMethod;
import chapter19.schedule.PaymentSchedule;
import chapter19.transaction.Transaction;

public abstract class AddEmployeeTransaction implements Transaction {

    private int itsEmpId;
    private String itsName;
    private String itsAddress;

    public AddEmployeeTransaction() {

    };

    public AddEmployeeTransaction(int itsEmpId, String itsName, String itsAddress) {
        this.itsEmpId = itsEmpId;
        this.itsName = itsName;
        this.itsAddress = itsAddress;
    }

    public abstract PaymentClassification getClassification();
    public abstract PaymentSchedule getSchedule();

    public void execute() {
        PaymentClassification pc = getClassification();
        PaymentSchedule ps = getSchedule();
        PaymentMethod pm = new HoldMethod();
        Employee e = new Employee(itsEmpId, itsName, itsAddress);
        e.setClassification(pc);
        e.setSchedule(ps);
        e.setMethod(pm);
        PayrollDatabase.addEmployee(itsEmpId, e);
    };
}
