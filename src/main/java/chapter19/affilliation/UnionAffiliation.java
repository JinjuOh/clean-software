package chapter19.affilliation;

import chapter19.PayrollDatabase;
import chapter19.transaction.payday.PayCheck;
import chapter19.vo.ServiceCharge;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
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

    public ServiceCharge getServiceCharge(long date) {
        return serviceCharges.get(date);
    }

    public void addServiceCharge(long date, double charge) {
        serviceCharges.put(date, new ServiceCharge(date, charge));
    }

    @Override
    public double calculateDeductions(PayCheck pc) {
        return 0;
    }
}
