package chapter19.affilliation;

import chapter19.transaction.payday.PayCheck;

public class NoAffiliation implements Affiliation {
    @Override
    public double calculateDeductions(PayCheck pc) {
        return 0;
    }
}
