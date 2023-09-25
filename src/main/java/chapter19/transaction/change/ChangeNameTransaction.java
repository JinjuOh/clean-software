package chapter19.transaction.change;

import chapter19.vo.Employee;

public class ChangeNameTransaction extends ChangeEmployeeTransaction {

    private String name;

    public ChangeNameTransaction(int empId, String name) {
        super(empId);
        this.name = name;
    }

    @Override
    public void change(Employee e) {
        e.setName(name);
    }
}
