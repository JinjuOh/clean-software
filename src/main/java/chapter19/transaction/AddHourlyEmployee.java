package chapter19.transaction;

import chapter19.classification.HourlyClassification;
import chapter19.classification.PaymentClassification;
import chapter19.schedule.PaymentSchedule;
import chapter19.schedule.WeeklySchedule;

public class AddHourlyEmployee extends AddEmployeeTransaction {

    private double hourlyRate;

    public AddHourlyEmployee() {
    }

    public AddHourlyEmployee(int itsEmpId, String itsName, String itsAddress, double hourlyRate) {
        super(itsEmpId, itsName, itsAddress);
        this.hourlyRate = hourlyRate;
    }

    @Override
    public PaymentClassification getClassification() {
        return new HourlyClassification();
    }

    @Override
    public PaymentSchedule getSchedule() {
        return new WeeklySchedule();
    }
}
