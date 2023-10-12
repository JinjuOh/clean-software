package chapter19.vo;

import chapter19.affilliation.Affiliation;
import chapter19.classification.PaymentClassification;
import chapter19.paymentmethod.PaymentMethod;
import chapter19.schedule.PaymentSchedule;
import chapter19.transaction.payday.PayCheck;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Employee {

    private int empId;
    private String name;
    private String address;
    private PaymentClassification classification;
    private PaymentSchedule schedule;
    private PaymentMethod method;
    private Affiliation affiliation;


    public Employee(int empId, String name, String address) {
        this.empId = empId;
        this.name = name;
        this.address = address;
    }

    public boolean isPayDate(LocalDate date) {
        return schedule.isPayDate(date);
    }

    public void setPayDay(PayCheck pc) {
    }

    public void payDay(PayCheck pc) {
        double grossDay = classification.calculatePay(pc);
        double deductions = affiliation.calculateDeductions(pc);
        double netPay = grossDay - deductions;
        pc.setGrossDay(grossDay);
        pc.setDeductions(deductions);
        pc.setNetPay(netPay);
        method.pay(pc);
    }
}
