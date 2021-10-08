public abstract class Customer
{
    protected String[] name = new String[4];
    protected int[] age = new int[4];
    protected int[] seat = new int[4];
    protected String date;
    protected String addOns;
    protected double amount;

    public Customer (String n[], int a[], int s[], String d, String aO, double am)
    {
        name = new String[4];
        age = new int[4];
        seat = new int[4];
        this.date = d;
        this.addOns = aO;
        this.amount = am;

        for(int i=0;i<4;i++)
        {
            name[i] = n[i];
            age[i]  = a[i];
            seat[i] = s[i];
        }
    }

    public void setName (String[] n)
    {   this.name = n;}

    public void setAge (int[] a)
    {   this.age = a;}

    public void setSeat (int[] s)
    {   this.seat = s;}

    public void setDate (String d)
    {   this.date = d;}

    public void setAddOns (String aO)
    {   this.addOns = aO;}

    public void setAmount (double am)
    {   this.amount= am;}

    public String[] getName()
    {   return this.name;}

    public int[] getAge()
    {   return this.age;}

    public int[] getSeat()
    {   return this.seat;}

    public String getDate()
    {   return this.date;}

    public String getAddOns()
    {   return this.addOns;}

    public double getAmount()
    {   return this.amount;}

    public abstract double calcPayment();

    public abstract String print();

}