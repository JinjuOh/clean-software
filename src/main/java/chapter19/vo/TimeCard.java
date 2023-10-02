package chapter19.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TimeCard {
    private long itsDate;
    private double hours;

    public TimeCard(long itsDate, double hours) {
        this.itsDate = itsDate;
        this.hours = hours;
    }
}
