package chapter19.classification;

public class SalariedClassification extends PaymentClassification {
    private double salary;

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}