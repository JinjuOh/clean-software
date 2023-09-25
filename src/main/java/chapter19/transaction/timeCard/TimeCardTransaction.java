package chapter19.transaction.timeCard;

import chapter19.vo.Employee;
import chapter19.PayrollDatabase;
import chapter19.classification.HourlyClassification;
import chapter19.classification.PaymentClassification;
import chapter19.transaction.Transaction;
import chapter19.vo.TimeCard;

public class TimeCardTransaction implements Transaction {

    private int itsEmpId;
    private long itsDate;
    private double itsHours;

    public TimeCardTransaction(int itsEmpId, long itsDate, double itsHours) {
        this.itsEmpId = itsEmpId;
        this.itsDate = itsDate;
        this.itsHours = itsHours;
    }

    @Override
    public void execute() throws Exception {
        Employee e = PayrollDatabase.getEmployee(itsEmpId);
        if(e != null) {
            PaymentClassification pc = e.getClassification();
            try {
                HourlyClassification hc = (HourlyClassification) pc;
                hc.addTimeCard(new TimeCard(itsDate, itsHours));
            } catch (Exception exception) {
                throw new Exception("Tried to add timecard to non-hourly employee");
            }
        } else {
            throw new Exception("No such employee");
        }
    }
}
