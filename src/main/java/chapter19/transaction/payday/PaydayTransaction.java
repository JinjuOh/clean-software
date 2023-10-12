package chapter19.transaction.payday;

import chapter19.PayrollDatabase;
import chapter19.transaction.Transaction;
import chapter19.vo.Employee;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PaydayTransaction implements Transaction {

    private LocalDate payDate;
    private Map<Integer, PayCheck> itsPaychecks = new HashMap<>();

    public PaydayTransaction(LocalDate payDate) {
        this.payDate = payDate;
    }

    @Override
    public void execute() throws Exception {
        List<Integer> empIds = PayrollDatabase.getAllEmployeeIds();
        for (Integer empId : empIds) {
            Employee e = PayrollDatabase.getEmployee(empId);
            if(null != e) {
                if(e.isPayDate(payDate)) {
                    PayCheck pc = new PayCheck(payDate);
                    itsPaychecks.put(empId, pc);
                    e.payDay(pc);
                }
            }
        }
    }

    public PayCheck getPayCheck(int empId) {
        return itsPaychecks.get(empId);
    }
}
