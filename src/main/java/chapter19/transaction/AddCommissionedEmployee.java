package chapter19.transaction;

import chapter19.classification.CommissionedClassification;
import chapter19.classification.PaymentClassification;
import chapter19.schedule.BiweeklySchedule;
import chapter19.schedule.PaymentSchedule;

public class AddCommissionedEmployee extends AddEmployeeTransaction {
    private double salary;
    private double commissionRate;

    public AddCommissionedEmployee() {
    }

    public AddCommissionedEmployee(int itsEmpId, String itsName, String itsAddress, double salary, double commissionRate) {
        super(itsEmpId, itsName, itsAddress);
        this.salary = salary;
        this.commissionRate = commissionRate;
    }

    @Override
    public PaymentClassification getClassification() {
        return new CommissionedClassification();
    }

    @Override
    public PaymentSchedule getSchedule() {
        return new BiweeklySchedule();
    }
}
