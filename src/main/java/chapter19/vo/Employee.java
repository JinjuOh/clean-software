package chapter19.vo;

import chapter19.affilliation.Affiliation;
import chapter19.classification.PaymentClassification;
import chapter19.paymentmethod.PaymentMethod;
import chapter19.schedule.PaymentSchedule;
import lombok.Getter;
import lombok.Setter;

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
}
