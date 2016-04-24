package app.milleniuminfinity.com.milleniuminfinity.domain.employee;

import java.util.Date;

/**
 * Created by 208023429 on 4/14/2016.
 */
public interface Person {

  Employee getEmployee(String name, String surname, String dateOfBirth, String employeeID);
  
}
