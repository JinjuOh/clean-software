package chapter19.transaction;

import chapter19.classification.HourlyClassification;
import chapter19.classification.PaymentClassification;
import chapter19.schedule.PaymentSchedule;
import chapter19.schedule.WeeklySchedule;

public class ChangeHourlyTransaction extends ChangeClassificationTransaction {

    private double hourlyDate;

    public ChangeHourlyTransaction(int empId, double hourlyDate) {
        super(empId);
        this.hourlyDate = hourlyDate;
    }

    @Override
    public PaymentClassification getClassification() {
        return new HourlyClassification(hourlyDate);
    }

    @Override
    public PaymentSchedule getSchedule() {
        return new WeeklySchedule();
    }
}
