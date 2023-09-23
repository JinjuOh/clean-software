package chapter19.vo;

public class ServiceCharge {
    private long date;
    private double charge;

    public ServiceCharge(long date, double charge) {
        this.date = date;
        this.charge = charge;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public double getCharge() {
        return charge;
    }

    public void setCharge(double charge) {
        this.charge = charge;
    }
}
