package chapter19.classification;

import chapter19.transaction.payday.PayCheck;

public interface PaymentClassification {
    double calculatePay(PayCheck pc);
}
