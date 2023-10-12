package chapter19.classification;

import chapter19.transaction.payday.PayCheck;
import chapter19.vo.SalesReceipt;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class CommissionedClassification implements PaymentClassification {
    private double salary;
    private double rate;
    private Map<Integer, SalesReceipt> salesReceipts = new HashMap<>();

    public CommissionedClassification(double salary, double rate) {
        this.salary = salary;
        this.rate = rate;
    }

    public void addSalesReceipt(SalesReceipt salesReceipt) {
        salesReceipts.put(salesReceipt.getEmpId(), salesReceipt);
    }

    public SalesReceipt getSalesReceipt(int empId) {
        return salesReceipts.get(empId);
    }

    @Override
    public double calculatePay(PayCheck pc) {
        return 1000;
    }
}
