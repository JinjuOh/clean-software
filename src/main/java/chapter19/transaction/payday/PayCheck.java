package chapter19.transaction.payday;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class PayCheck {
    private LocalDate payDate;
    private double grossDay;
    private double deductions;
    private double netPay;

    public PayCheck(LocalDate payDate) {
        this.payDate = payDate;
    }

    public String getField(String disposition) {
        return "";
    }
}
