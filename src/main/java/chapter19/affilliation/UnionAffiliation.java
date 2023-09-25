package chapter19.affilliation;

import chapter19.PayrollDatabase;
import chapter19.vo.ServiceCharge;

import java.util.HashMap;
import java.util.Map;

public class UnionAffiliation implements Affiliation {

    private int memberId;
    private double amount;
    private Map<Long, ServiceCharge> serviceCharges = new HashMap<>();

    public UnionAffiliation(double amount) {
        this.amount = amount;
    }

    public UnionAffiliation(int memberId, double amount) {
        this.memberId = memberId;
        this.amount = amount;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public ServiceCharge getServiceCharge(long date) {
        return serviceCharges.get(date);
    }

    public void addServiceCharge(long date, double charge) {
        serviceCharges.put(date, new ServiceCharge(date, charge));
    }
}
