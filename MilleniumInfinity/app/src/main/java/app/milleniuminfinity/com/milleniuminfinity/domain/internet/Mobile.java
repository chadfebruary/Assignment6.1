package app.milleniuminfinity.com.milleniuminfinity.domain.internet;

/**
 * Write a description of class Mobile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mobile extends Connection
{
    public Mobile() {
    }

    @Override
    public String handleRequest(int request)
    {
        if(request == 3)
        {
            return "Mobile";
        }
        else
        {
            if(nextConnectionType != null)
            {
                return nextConnectionType.handleRequest(request);

            }

            return "Invalid option";
        }
    }
}
