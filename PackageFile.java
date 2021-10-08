public class PackageFile
{
    private String pPackageType;
    private String pDestination;
    private String pTime;
    private String pSeatType;
    private double pAmount;
    
    public PackageFile (String p, String d, String t, String sT, double a)
    {
        this.pPackageType = p;
        this.pDestination = d;
        this.pTime = t;
        this.pSeatType = sT;
        this.pAmount = a;
    }
    
    public void setpPackageType (String p)
    {   this.pPackageType = p;}
    public void setpDestination (String d)
    {   this.pDestination = d;}
    public void setpTime (String t)
    {   this.pTime = t;}
    public void setpSeatType (String sT)
    {   this.pSeatType = sT;}
    public void setpAmount (double a)
    {   this.pAmount = a;}
    
    public String getpPackageType()
    {   return this.pPackageType;}
    public String getpDestination()
    {   return this.pDestination;}
    public String getpTime()
    {   return this.pTime;}
    public String getpSeatType()
    {   return this.pSeatType;}
    public double getpAmount()
    {   return this.pAmount;}
    
    public String printer()
    {
        return "\nDEPARTURE\tDESTINATION\tONE-WAY(RM)\tRETURN(RM)" +
        "\n===========================================================" +
        "\nKUALA LUMPUR\tJAKARTA\t\t400.00\t\t800.00" +
        "\nKUALA LUMPUR\tBANGKOK\t\t500.00\t\t1000.00" +
        "\nKUALA LUMPUR\tPHNOM\t\t600.00\t\t1200.00" +
        "\nKUALA LUMPUR\tHANOI\t\t700.00\t\t1400.00" +
        "\nKUALA LUMPUR\tMANILA\t\t800.00\t\t1600.00";
    }
    public String printer2()
    {
        return "\nDEPARTURE\tDESTINATION\t     ECONOMY CLASS\t\tBUSINESS CLASS" +
        "\n\t\t\t\tONE-WAY(RM)  RETURN(RM)\t    ONE-WAY(RM)  RETURN(RM)" +
        "\n====================================================================================" +
        "\nKUALA LUMPUR\tJAKARTA\t\t  -\t\t -\t     +40.00\t  +80.00" +
        "\nKUALA LUMPUR\tBANGKOK\t\t  -\t\t -\t     +50.00\t  +100.00" +
        "\nKUALA LUMPUR\tPHNOM\t\t  -\t\t -\t     +60.00\t  +120.00" +
        "\nKUALA LUMPUR\tHANOI\t\t  -\t\t -\t     +70.00\t  +140.00" +
        "\nKUALA LUMPUR\tMANILA\t\t  -\t\t -\t     +80.00\t  +160.00";
    }
    
}