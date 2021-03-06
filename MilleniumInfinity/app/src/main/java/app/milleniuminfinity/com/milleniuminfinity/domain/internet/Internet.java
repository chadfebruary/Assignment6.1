package app.milleniuminfinity.com.milleniuminfinity.domain.internet;
/**
 * Write a description of class Internet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.io.Serializable;

public class Internet implements Serializable
{
    private String ipAddress, ISP, planName;
    String price, dataAllowance;
    private Internet nextInternetType;
    
    private Internet(){}
    
    private Internet(Builder builder)
    {
        this.ipAddress = builder.ipAddress;
        this.ISP = builder.ISP;
        this.planName = builder.planName;
        this.price = builder.price;
        this.dataAllowance = builder.dataAllowance;
    }
    
    public String getIPAddress()
    {
        return ipAddress;
    }
    
    public String getISP()
    {
        return ISP;
    }
    
    public String getPlanName()
    {
        return planName;
    }
    
    public String getPrice()
    {
        return price;
    }
    
    public String getDataAllowance()
    {
        return dataAllowance;
    }
    
    public void setNextInternetType(Internet nextInternetType)
    {
        this.nextInternetType = nextInternetType;
    }
    
    public static class Builder
    {
        private String ipAddress, ISP, planName;
        String price, dataAllowance;

        public Builder ipAddress(String value)
        {
            this.ipAddress = value;
            return this;
        }
        
        public Builder ISP(String value)
        {
            this.ISP = value;
            return this;
        }
        
        public Builder planName(String value)
        {
            this.planName = value;
            return this;
        }
        
        public Builder price(String value)
        {
            this.price = value;
            return this;
        }
        
        public Builder dataAllowance(String value)
        {
            this.dataAllowance = value;
            return this;
        }
        
        public Builder copy(Internet value)
        {
            this.ipAddress = value.ipAddress;
            this.ISP = value.ISP;
            this.planName = value.planName;
            this.price = value.price;
            this.dataAllowance = value.dataAllowance;
            
            return this;
        }
        
        public Internet build()
        {
            return new Internet(this);
        }
    }
    
    @Override
    public boolean equals(Object o)
    {
        if(this == o) return true;
        
        if(o == null || getClass() != o.getClass()) return false;
        
        Internet internet = (Internet) o;
        
        return ipAddress != null ? ipAddress.equals(internet.ipAddress) : internet.ipAddress == null;
    }
    
    @Override
    public int hashCode()
    {
        return ipAddress != null ? ipAddress.hashCode() : 0;
    }
}
