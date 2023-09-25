package chapter19.transaction.change;

import chapter19.Employee;
import chapter19.affilliation.Affiliation;

public abstract class ChangeAffiliationTransaction extends ChangeEmployeeTransaction {

    public ChangeAffiliationTransaction(int empId) {
        super(empId);
    }

    @Override
    public void change(Employee e) {
        recordMembership(e);
        e.setAffiliation(getAffiliation());
    }

    abstract Affiliation getAffiliation();
    abstract void recordMembership(Employee e);
}
