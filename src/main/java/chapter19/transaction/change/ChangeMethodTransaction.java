package chapter19.transaction.change;

import chapter19.vo.Employee;
import chapter19.paymentmethod.PaymentMethod;

public abstract class ChangeMethodTransaction extends ChangeEmployeeTransaction {
    public ChangeMethodTransaction(int empId) {
        super(empId);
    }

    @Override
    public void change(Employee e) {
        e.setMethod(getMethod());
    }

    abstract PaymentMethod getMethod();
}
