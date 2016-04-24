package app.milleniuminfinity.com.milleniuminfinity.domain.internet;

/**
 * Created by 208023429 on 4/18/2016.
 */
public abstract class Connection{

    Connection nextConnectionType;

    public void setNextConnectionType(Connection nextConnectionType)
    {
        this.nextConnectionType = nextConnectionType;
    }

    public abstract String handleRequest(int number);

}
