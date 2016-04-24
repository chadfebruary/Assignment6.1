package app.milleniuminfinity.com.milleniuminfinity.domain.internet;

/**
 * Write a description of class ADSL here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ADSL extends Connection
{
    @Override
    public String handleRequest(int request)
    {
        if(request == 1)
        {
            return "ADSL";
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
