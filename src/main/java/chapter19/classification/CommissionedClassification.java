package chapter19.classification;

import chapter19.vo.SalesReceipt;

import java.util.HashMap;
import java.util.Map;

public class CommissionedClassification extends PaymentClassification {
    private double commissionedRate;
    private double salary;
    private Map<Integer, SalesReceipt> salesReceipts = new HashMap<>();

    public void addSalesReceipt(SalesReceipt salesReceipt) {
        salesReceipts.put(salesReceipt.getEmpId(), salesReceipt);
    }

    public SalesReceipt getSalesReceipt(int empId) {
        return salesReceipts.get(empId);
    }
}
