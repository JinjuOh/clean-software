package chapter19.transaction.change;

import chapter19.Employee;
import chapter19.classification.PaymentClassification;
import chapter19.schedule.PaymentSchedule;

public abstract class ChangeClassificationTransaction extends ChangeEmployeeTransaction {
    public ChangeClassificationTransaction(int empId) {
        super(empId);
    }

    @Override
    public void change(Employee e) {
        e.setClassification(getClassification());
        e.setSchedule(getSchedule());
    }

    public abstract PaymentClassification getClassification();
    public abstract PaymentSchedule getSchedule();
}
