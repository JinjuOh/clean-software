package chapter19.classification;

import chapter19.transaction.payday.PayCheck;
import chapter19.vo.TimeCard;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class HourlyClassification implements PaymentClassification {
    private double rate;
    private Map<Long, TimeCard> timecards = new HashMap<>();

    public HourlyClassification(double rate) {
        this.rate = rate;
    }

    public void addTimeCard(TimeCard timeCard) {
        timecards.put(timeCard.getItsDate(), timeCard);
    }

    public TimeCard getTimeCard(long time) {
        return timecards.get(time);
    }

    @Override
    public double calculatePay(PayCheck pc) {
        return 1000;
    }
}
