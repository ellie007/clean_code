public abstract class Employee {
    public abstract boolean isPayday();
    public abstract Money calculatePay();
    public abstract void deliverPay(Money pay);
}

-----------------------------

public interface EmployeeFactory {
    public Employee makeEmploee(EmployeeRecord r) throws Invalid EmployeeType;
}

------------------------------

public class EmployeeFactoryImp1 implements EmployeeFactory {
    public Employee makeEmployee(EmployeeRecord r) throws InvalidEmployeeType {
        switch (r.type) {
            case COMMISSIONED:
                return new CommissionedEmployee(r) ;
            case HOURLY:
                return new HourlyEmployee(r);
            case SALARIED:
                return new SalariedEmployee (r);
            default:
                throw new InvalidEmployeeType(r.type);
        }
    }
}