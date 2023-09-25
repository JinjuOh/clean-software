package chapter19.transaction.change;

import chapter19.classification.CommissionedClassification;
import chapter19.classification.PaymentClassification;
import chapter19.schedule.BiweeklySchedule;
import chapter19.schedule.PaymentSchedule;

public class ChangeCommissionedTransaction extends ChangeClassificationTransaction {

    private double salary;
    private double commissionedRate;

    public ChangeCommissionedTransaction(int empId, double salary, double commissionedRate) {
        super(empId);
        this.salary = salary;
        this.commissionedRate = commissionedRate;
    }

    @Override
    public PaymentClassification getClassification() {
        return new CommissionedClassification(salary, commissionedRate);
    }

    @Override
    public PaymentSchedule getSchedule() {
        return new BiweeklySchedule();
    }
}
