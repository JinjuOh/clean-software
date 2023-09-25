package chapter19.transaction.change;

import chapter19.paymentmethod.DirectMethod;
import chapter19.paymentmethod.MailMethod;
import chapter19.paymentmethod.PaymentMethod;

public class ChangeMailTransaction extends ChangeMethodTransaction {
    private String address;

    public ChangeMailTransaction(int empId, String address) {
        super(empId);
        this.address = address;
    }

    @Override
    public PaymentMethod getMethod() {
        return new MailMethod(address);
    }
}
