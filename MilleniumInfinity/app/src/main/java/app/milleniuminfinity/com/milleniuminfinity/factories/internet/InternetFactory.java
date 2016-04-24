package app.milleniuminfinity.com.milleniuminfinity.factories.internet;


import app.milleniuminfinity.com.milleniuminfinity.domain.internet.Internet;

/**
 * Write a description of class InternetFactory here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class InternetFactory
{
    public static Internet getInternetType(String ISP, String planName, int price, int dataAllowance)
    {
        Internet internet = new Internet.Builder()
        .ISP(ISP)
        .planName(planName)
        .price(price)
        .dataAllowance(dataAllowance)
        .build();

        return internet;
    }
}
