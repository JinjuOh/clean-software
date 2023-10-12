package chapter19.affilliation;

import chapter19.transaction.payday.PayCheck;

public interface Affiliation {
    double calculateDeductions(PayCheck pc);
}
