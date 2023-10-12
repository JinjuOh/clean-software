package chapter19.schedule;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class WeeklySchedule implements PaymentSchedule {
    @Override
    public boolean isPayDate(LocalDate date) {
        return date.getDayOfWeek().equals(DayOfWeek.FRIDAY);
    }
}
