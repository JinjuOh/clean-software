package chapter19.transaction.change;

import chapter19.Employee;
import chapter19.PayrollDatabase;
import chapter19.affilliation.Affiliation;
import chapter19.affilliation.UnionAffiliation;

public class ChangeMemberTransaction extends ChangeAffiliationTransaction {
    private int memberId;
    private double dues;

    public ChangeMemberTransaction(int empId, int memberId, double dues) {
        super(empId);
        this.memberId = memberId;
        this.dues = dues;
    }

    @Override
    Affiliation getAffiliation() {
        return new UnionAffiliation(memberId, dues);
    }

    @Override
    void recordMembership(Employee e) {
        PayrollDatabase.addUnionMember(memberId, e);
    }
}
