package chapter19.schedule;

import java.time.LocalDate;

public interface PaymentSchedule {
    boolean isPayDate(LocalDate date);
}
