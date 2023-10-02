package chapter19.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServiceCharge {
    private long date;
    private double charge;

    public ServiceCharge(long date, double charge) {
        this.date = date;
        this.charge = charge;
    }
}
