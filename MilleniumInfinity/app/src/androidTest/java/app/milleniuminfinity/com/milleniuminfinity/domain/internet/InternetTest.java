package app.milleniuminfinity.com.milleniuminfinity.domain.internet;

import app.milleniuminfinity.com.milleniuminfinity.factories.internet.InternetFactory;

/**
 * Write a description of class TestInternet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */


public class InternetTest
{
    public void testInternetFactory() 
    {
        InternetFactory internetFactoryObject = new InternetFactory();
        Internet internetObject = internetFactoryObject.getInternetType("Telkom", "Faster 100", 10, 100);
    }
}
