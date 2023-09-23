package chapter19;

public class TimeCard {
    private long itsDate;
    private double itsHours;

    public TimeCard(long itsDate, double itsHours) {
        this.itsDate = itsDate;
        this.itsHours = itsHours;
    }

    public long getItsDate() {
        return itsDate;
    }

    public double getHours() {
        return itsHours;
    }
}
