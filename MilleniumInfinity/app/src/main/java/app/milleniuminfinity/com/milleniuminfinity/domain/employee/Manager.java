package app.milleniuminfinity.com.milleniuminfinity.domain.employee;

import java.lang.String;

/**
 * Created by 208023429 on 4/14/2016.
 */
public class Manager implements Person{
    
    @Override
    public Employee getEmployee(String name, String surname, String dateOfBirth, String employeeID) {

        Employee employee = new Employee.Builder()
                                .name(name)
                                .surname(surname)
                                .dateOfBirth(dateOfBirth)
                                .employeeID(employeeID)
                                .build();

        return employee;
    }
    
    public String getEmployeeRole()
    {
        return "Manager";
    }
}
