package chapter19.transaction.change;

import chapter19.vo.Employee;
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

    abstract PaymentClassification getClassification();
    abstract PaymentSchedule getSchedule();
}
