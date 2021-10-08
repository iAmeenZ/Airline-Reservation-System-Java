public class Package extends Customer
{
    private String packageType;

    public Package(String[] n, int[] a,int[] s, String d, String aO, double am, String pT)
    {
        super(n,a,s,d,aO,am);
        this.packageType = pT;
    }

    public void setPackageType (String pT)
    {   this.packageType = pT;}

    public String getPackageType()
    {   return this.packageType;}

    public double calcPayment()
    {
        return super.amount = super.amount * 300.00;
    }

    public String print()
    {
        return "\n\nNAME "+ super.name  +
               "\nAGE  "+ super.age + 
               "\nSEAT "+ super.seat;
    }
}