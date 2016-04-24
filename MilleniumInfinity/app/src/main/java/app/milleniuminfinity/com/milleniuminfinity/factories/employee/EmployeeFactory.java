package app.milleniuminfinity.com.milleniuminfinity.factories.employee;

/**
 * Created by Admin on 2016/04/15.
 */
import java.util.Date;

import app.milleniuminfinity.com.milleniuminfinity.domain.employee.Cleaner;
import app.milleniuminfinity.com.milleniuminfinity.domain.employee.Employee;
import app.milleniuminfinity.com.milleniuminfinity.domain.employee.Manager;
import app.milleniuminfinity.com.milleniuminfinity.domain.employee.SalesRepresentative;

public class EmployeeFactory {

    private static EmployeeFactory factory = null;

    public static void getInstance(String type, String name, String surname, String dateOfBirth, String employeeID)
    {
        Employee employee;
        
        if(type.equals("Sales representative"))
        {
            SalesRepresentative salesRep = new SalesRepresentative();
            
            salesRep.getEmployee(name, surname, dateOfBirth, employeeID);
            
        }
        else if(type.equals("Cleaner"))
        {
            Cleaner cleaner = new Cleaner();;
            
            cleaner.getEmployee(name, surname, dateOfBirth, employeeID);
        }
        else
        {
            Manager manager = new Manager();
            
            manager.getEmployee(name, surname, dateOfBirth, employeeID);
        }   
    }
}
