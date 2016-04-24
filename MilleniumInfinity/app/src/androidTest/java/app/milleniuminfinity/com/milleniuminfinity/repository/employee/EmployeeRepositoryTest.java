package app.milleniuminfinity.com.milleniuminfinity.repository.employee;

import android.test.AndroidTestCase;

import junit.framework.Assert;

import java.util.Set;

import app.milleniuminfinity.com.milleniuminfinity.domain.employee.Employee;
import app.milleniuminfinity.com.milleniuminfinity.repository.employee.Impl.EmployeeRepositoryImpl;

/**
 * Write a description of class TestInternet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */



public class EmployeeRepositoryTest extends AndroidTestCase
{
    private static final String TAG = "EMPLOYEE TEST";
    
    public void createReadUpdateDeleteTest() throws Exception
    {
        EmployeeRepository repository = new EmployeeRepositoryImpl(this.getContext());
        String employeeID;
        
        //Create
        Employee createdEmployee = new Employee.Builder()
                                            .employeeID("1234")
                                            .name("Name")
                                            .surname("Surname")
                                            .dateOfBirth("01/01/2000")
                                            .build();
        
        Employee insertedEmployee = repository.save(createdEmployee);
        employeeID = insertedEmployee.getEmployeeID();
        Assert.assertNotNull(TAG + " CREATE", insertedEmployee);
        
        //Read all
        Set<Employee> employees = repository.findAll();
        Assert.assertTrue(TAG + " READ ALL", employees.size() > 0);
        
        //Read entity
        Employee employee = repository.findById(employeeID);
        Assert.assertNotNull(TAG + " READ EMPLOYEE", employee);
        
        //Update employee
        Employee updateEmployee = new Employee.Builder()
                                            .copy(employee)
                                            .surname("NewSurname")
                                            .build();
        repository.update(updateEmployee);
        Employee newEmployee = repository.findById(employeeID);
        Assert.assertEquals(TAG + " UPDATE EMPLOYEE", "NewSurname", newEmployee.getSurname());
        
        //Delete employee
        repository.delete(updateEmployee);
        Employee deletedEmployee = repository.findById(employeeID);
        Assert.assertNull(TAG + " DELETE", deletedEmployee);
    }
}
