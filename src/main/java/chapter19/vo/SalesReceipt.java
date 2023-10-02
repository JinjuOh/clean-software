package chapter19.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SalesReceipt {
    private int empId;
    private long date;
    private int amount;

    public SalesReceipt(int empId, long date, int amount) {
        this.empId = empId;
        this.date = date;
        this.amount = amount;
    }
}
