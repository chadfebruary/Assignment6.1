package app.milleniuminfinity.com.milleniuminfinity.conf.databases;
/**
 * Write a description of class DBConstantsTest here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import junit.framework.Assert;
public class DBConstantsTest
{
    public void databaseNameTest()
    {
        Assert.assertEquals(DBConstants.DATABASE_NAME, "pvtdroid");
    }

    public void databaseVersionTest()
    {
        Assert.assertEquals(DBConstants.DATABASE_VERSION, 1);
    }
}
