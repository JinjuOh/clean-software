package chapter19.vo;

public class SalesReceipt {
    private int empId;
    private long date;
    private int amount;

    public SalesReceipt(int empId, long date, int amount) {
        this.empId = empId;
        this.date = date;
        this.amount = amount;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
