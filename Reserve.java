public class Reserve extends Customer
{
    private String destination;
    private int numPassenger;
    private String time;
    private String seatType;
    private String oneWay;
    
    public Reserve (String[] name, int[] age, int[] seat, String d, String aO, double am, String da, int n, String t, String sT, String oW)
    {
        super(name,age,seat,d,aO,am);
        this.destination = da;
        this.numPassenger = n;
        this.time = t;
        this.seatType = sT;
        this.oneWay = oW;
    }
    
    public void setDestination (String da)
    {   this.destination = da;}
    public void setNumPassenger (int n)
    {   this.numPassenger = n;}
    public void setTime (String t)
    {   this.time = t;}
    public void setSeatType (String sT)
    {   this.seatType = sT;}
    public void setOneWay (String oW)
    {   this.oneWay = oW;}
    
    public String getDestination()
    {   return this.destination;}
    public int getNumPassenger()
    {   return this.numPassenger;}
    public String getTime()
    {   return this.time;}
    public String getSeatType()
    {   return this.seatType;}
    public String getOneWay()
    {   return this.oneWay;}
    
    public double calcPayment()
    {
        return super.amount * getNumPassenger();
    }
    public String print()
    {
        return "Name\t: " + super.name +
               "Age\t: " + super.age +
               "Seat\t: " + super.seat;
    }
}