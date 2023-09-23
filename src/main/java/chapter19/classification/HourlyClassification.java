package chapter19.classification;

import chapter19.vo.TimeCard;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HourlyClassification extends PaymentClassification {
    private double hourlyRate;
    private Map<Long, TimeCard> timecards = new HashMap<>();

    public void addTimeCard(TimeCard timeCard) {
        timecards.put(timeCard.getItsDate(), timeCard);
    }

    public TimeCard getTimeCard(long time) {
        return timecards.get(time);
    }
}
