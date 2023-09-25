package chapter19.transaction.serviceCharge;

import chapter19.Employee;
import chapter19.PayrollDatabase;
import chapter19.affilliation.Affiliation;
import chapter19.affilliation.UnionAffiliation;
import chapter19.transaction.Transaction;

public class ServiceChargeTransaction implements Transaction {
    private int memeberId;
    private long date;
    private double charge;

    public ServiceChargeTransaction(int memeberId, long date, double charge) {
        this.memeberId = memeberId;
        this.date = date;
        this.charge = charge;
    }

    @Override
    public void execute() {
        Employee e = PayrollDatabase.getUnionMember(memeberId);
        Affiliation af = e.getAffiliation();
        try {
            UnionAffiliation uaf = (UnionAffiliation) af;
            uaf.addServiceCharge(date, charge);
        } catch (Exception exception) {

        }
    }
}
