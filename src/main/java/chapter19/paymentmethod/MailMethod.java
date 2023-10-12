package chapter19.paymentmethod;

import chapter19.transaction.payday.PayCheck;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MailMethod implements PaymentMethod {
    private String address;

    public MailMethod(String address) {
        this.address = address;
    }

    @Override
    public void pay(PayCheck pc) {

    }
}
