package chapter19.transaction.change;

import chapter19.paymentmethod.HoldMethod;
import chapter19.paymentmethod.PaymentMethod;

public class ChangeHoldTransaction extends ChangeMethodTransaction {

    public ChangeHoldTransaction(int empId) {
        super(empId);
    }

    @Override
    public PaymentMethod getMethod() {
        return new HoldMethod();
    }
}
