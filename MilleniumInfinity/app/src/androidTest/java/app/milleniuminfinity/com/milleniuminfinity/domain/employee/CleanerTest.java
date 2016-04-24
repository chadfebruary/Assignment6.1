package app.milleniuminfinity.com.milleniuminfinity.domain.employee;

import junit.framework.Assert;
/**
 * Created by 208023429 on 4/14/2016.
 */
import java.util.Date;

public class CleanerTest {

    Cleaner object = new Cleaner();

    public void getEmployeeTest()
    {
        object.getEmployee("Name", "Surname", "01/01/2000", "1234");
        
        Assert.assertEquals(object.getName(), "Name");
        Assert.assertEquals(object.getSurname(), "Surname");
        Assert.assertEquals(object.getDateOfBirth(), "01/01/2000");
        Assert.assertEquals(object.getEmployeeID(), 1234);
    }

    public void getEmployeeRoleTest()
    {
        Assert.assertEquals(object.getEmployeeRole(), "Cleaner");
    }
}
