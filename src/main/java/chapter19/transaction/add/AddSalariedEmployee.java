package chapter19.transaction.add;

import chapter19.classification.PaymentClassification;
import chapter19.classification.SalariedClassification;
import chapter19.schedule.MonthlySchedule;
import chapter19.schedule.PaymentSchedule;

public class AddSalariedEmployee extends AddEmployeeTransaction {

    private double itsSalary;

    public AddSalariedEmployee() {
    }

    public AddSalariedEmployee(int itsEmpId, String itsName, String itsAddress, double itsSalary) {
        super(itsEmpId, itsName, itsAddress);
        this.itsSalary = itsSalary;
    }

    @Override
    public PaymentClassification getClassification() {
        return new SalariedClassification(itsSalary);
    }

    @Override
    public PaymentSchedule getSchedule() {
        return new MonthlySchedule();
    }
}
