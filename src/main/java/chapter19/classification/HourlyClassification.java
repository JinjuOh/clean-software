package chapter19.classification;

import chapter19.TimeCard;

public class HourlyClassification extends PaymentClassification {
    private double hourlyRate;

    public TimeCard getTimeCard(int time) {
        // 원래는 DB에서 해당 사용자의 날짜로 검색하여야함
        return new TimeCard(time, 8.0);
    }
}
