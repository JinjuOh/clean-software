package chapter19.classification;

import chapter19.transaction.payday.PayCheck;
import chapter19.vo.TimeCard;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
        double totalPay = 0;
        LocalDate payPeriod = pc.getPayDate();
        List<Long> dates = new ArrayList<>(timecards.keySet());
        for (int i = 0; i < dates.size(); i++) {
            TimeCard tc = timecards.get(dates.get(i));
            if(isInPayPeriod(tc, payPeriod)) {
                totalPay += calculatePayForTimeCard(tc);
            }
        }
        return totalPay;
    }

    private boolean isInPayPeriod(TimeCard tc, LocalDate payPeriod) {
        LocalDate payPeriodEndDate = payPeriod;
        LocalDate payPeriodStartDate = payPeriod.minusDays(5);
        LocalDate timeCardDate = LocalDate.parse(String.valueOf(tc.getItsDate()));

        return (( timeCardDate.compareTo(payPeriodStartDate) >= 0 ) && ( timeCardDate.compareTo(payPeriodEndDate) <= 0 ));
    }

    private double calculatePayForTimeCard(TimeCard tc) {
        double hours = tc.getHours();
        double overtime = Math.max(0.0, hours - 8.0);
        double straightTime = hours - overtime;
        return straightTime * rate + overtime * rate * 1.5;
    }
}
