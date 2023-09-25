package chapter19.transaction.change;

import chapter19.Employee;
import chapter19.classification.PaymentClassification;
import chapter19.paymentmethod.PaymentMethod;
import chapter19.schedule.PaymentSchedule;

public abstract class ChangeMethodTransaction extends ChangeEmployeeTransaction {
    public ChangeMethodTransaction(int empId) {
        super(empId);
    }

    @Override
    public void change(Employee e) {
        e.setMethod(getMethod());
    }

    abstract PaymentMethod getMethod();
}
