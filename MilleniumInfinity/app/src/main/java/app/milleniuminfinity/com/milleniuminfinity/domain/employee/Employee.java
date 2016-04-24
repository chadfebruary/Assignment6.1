package app.milleniuminfinity.com.milleniuminfinity.domain.employee;

import java.util.Date;
import java.io.Serializable;

/**
 * Created by 208023429 on 4/14/2016.
 */
public class Employee implements Serializable{
    private String name, surname;
    private String dateOfBirth;
    private String employeeID;

    public Employee(){}

    public Employee(Builder builder)
    {
        this.name = builder.name;
        this.surname = builder.surname;
        this.dateOfBirth = builder.dateOfBirth;
        this.employeeID = builder.employeeID;
    }

    public String getName()
    {
        return name;
    }
    public String getSurname()
    {
        return surname;
    }

    public String getDateOfBirth()
    {
        return dateOfBirth;
    }

    public String getEmployeeID()
    {
        return employeeID;
    }

    public static class Builder
    {
        private String name, surname;
        String dateOfBirth;
        String employeeID;


        public Builder employeeID(String value)
        {
            this.employeeID = value;
            return this;
        }
        
        public Builder name(String value)
        {
            this.name = value;
            return this;
        }

        public Builder surname(String value)
        {
            this.surname = value;
            return this;
        }

        public Builder dateOfBirth(String value)
        {
            this.dateOfBirth = value;
            return this;
        }

        public Builder copy(Employee value)
        {
            this.name = value.getName();
            this.surname = value.getSurname();
            this.dateOfBirth = value.getDateOfBirth();
            this.employeeID = value.getEmployeeID();

            return this;
        }

        public Employee build()
        {
            return new Employee(this);
        }
    }
    
    @Override
    public boolean equals(Object o)
    {
        if(this == o) return true;
        
        if(o == null || getClass() != o.getClass()) return false;
        
        Employee employee = (Employee) o;
        
        return employeeID != null ? employeeID.equals(employee.employeeID) : employee.employeeID == null;
        
    }
    
    @Override
    public int hashCode()
    {
        return employeeID != null ? employeeID.hashCode() : 0;
    }

}
