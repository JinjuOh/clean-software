package chapter19.classification;

import chapter19.transaction.payday.PayCheck;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SalariedClassification implements PaymentClassification {
    private double salary;

    public SalariedClassification(double salary) {
        this.salary = salary;
    }

    @Override
    public double calculatePay(PayCheck pc) {
        return salary;
    }
}
