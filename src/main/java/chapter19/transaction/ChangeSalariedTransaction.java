package chapter19.transaction;

import chapter19.classification.HourlyClassification;
import chapter19.classification.PaymentClassification;
import chapter19.classification.SalariedClassification;
import chapter19.schedule.MonthlySchedule;
import chapter19.schedule.PaymentSchedule;
import chapter19.schedule.WeeklySchedule;

public class ChangeSalariedTransaction extends ChangeClassificationTransaction {

    private double salary;

    public ChangeSalariedTransaction(int empId, double salary) {
        super(empId);
        this.salary = salary;
    }

    @Override
    public PaymentClassification getClassification() {
        return new SalariedClassification(salary);
    }

    @Override
    public PaymentSchedule getSchedule() {
        return new MonthlySchedule();
    }
}
