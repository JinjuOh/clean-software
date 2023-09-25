package chapter19.transaction.change;

import chapter19.Employee;
import chapter19.PayrollDatabase;
import chapter19.affilliation.Affiliation;
import chapter19.affilliation.NoAffiliation;
import chapter19.affilliation.UnionAffiliation;

public abstract class ChangeUnAffiliatedTransaction extends ChangeAffiliationTransaction {

    public ChangeUnAffiliatedTransaction(int empId) {
        super(empId);
    }

    @Override
    Affiliation getAffiliation() {
        return new NoAffiliation();
    }

    @Override
    void recordMembership(Employee e) {
        Affiliation af = e.getAffiliation();
        try {
            UnionAffiliation uf = (UnionAffiliation) af;
            int memberId = uf.getMemberId();
            PayrollDatabase.removeUnionMember(memberId);
        } catch (Exception exception) {

        }
    }
}
