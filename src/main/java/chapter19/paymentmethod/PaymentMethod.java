package chapter19.paymentmethod;

import chapter19.transaction.payday.PayCheck;

public interface PaymentMethod {
    void pay(PayCheck pc);
}
