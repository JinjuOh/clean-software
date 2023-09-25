package chapter19.transaction.change;

import chapter19.paymentmethod.DirectMethod;
import chapter19.paymentmethod.PaymentMethod;

public class ChangeDirectTransaction extends ChangeMethodTransaction {
    private String bank;
    private String account;

    public ChangeDirectTransaction(int empId, String bank, String account) {
        super(empId);
        this.bank = bank;
        this.account = account;
    }

    @Override
    public PaymentMethod getMethod() {
        return new DirectMethod(bank, account);
    }
}
