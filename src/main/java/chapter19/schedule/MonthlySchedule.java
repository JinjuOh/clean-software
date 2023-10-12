package chapter19.schedule;

import java.time.LocalDate;

public class MonthlySchedule implements PaymentSchedule {
    @Override
    public boolean isPayDate(LocalDate date) {
        return date == date.withDayOfMonth(date.lengthOfMonth());
    }
}
