import java.util.*;
import java.io.*;
import java.text.DecimalFormat;
import java.util.Random;
public class CustomerApp
{
    private static DecimalFormat df2 = new DecimalFormat("0.00");
    public static void main (String args[])
    {
        try
        {
            FileReader file = new FileReader("Package.txt");
            BufferedReader infile = new BufferedReader(file);

            FileWriter fw = new FileWriter("Summary Report.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter sales = new PrintWriter(bw);

            Scanner in = new Scanner (System.in);
            Scanner inLine = new Scanner (System.in);

            Customer[] cust = new Customer[100];
            PackageFile[] pf = new PackageFile[3];
            String[] name = new String[4];
            int[] age = new int[4];
            int[] seat = new int[4];
            int a=0,p1=0,index=0,ref=1;
            boolean flag = true;

            String pPackageType="";
            double pAddOns=0.0, pAmount=0.0;

            // Summary Report
            String[] sDestination = new String[5];
            int[] sPassenger = new int[5];
            int[] sEconomy = new int[5];
            int[] sBusiness = new int[5];
            int[] sOneWay = new int[5];
            int[] sReturn = new int[5];
            double[] sAddOns = new double[5];
            double[] sAmount = new double[5];
            int stPassenger=0,stEconomy=0,stBusiness=0,stOneWay=0,stReturn=0,sPackage=0,sManual=0;
            double stAddOns=0,stAmount=0;

            String pFix = "";
            double pFix1 = 0.0;
            for (int i=0;i<5;i++)
            {
                sDestination[i] = "";
                sPassenger[i] = 0;
                sEconomy[i] = 0;
                sBusiness[i] = 0;
                sOneWay[i] = 0;
                sReturn[i] = 0;
                sAddOns[i] = 0.0;
                sAmount[i] = 0.0;
            }

            sDestination[0] = "JAKARTA";
            sDestination[1] = "BANGKOK";
            sDestination[2] = "PHNOM";
            sDestination[3] = "HANOI";
            sDestination[4] = "MANILA";
            PackageFile print = new PackageFile("","","","",0.0);
            
            String input = null;
            while (flag)
            {
                System.out.print("\n============= MAIN MENU =============");
                System.out.println("\n[1] Package\n[2] Manual Reservation\n[3] Exit");
                int menu = in.nextInt();
                System.out.print("\f");

                while((input = infile.readLine()) != null)
                {
                    StringTokenizer st = new StringTokenizer(input,";");  
                    while(st.hasMoreTokens())
                    {
                        String packageT = st.nextToken();
                        String dest = st.nextToken();
                        String ptime = st.nextToken();
                        String stype = st.nextToken();
                        double am = Double.parseDouble(st.nextToken());
                        pf[p1] = new PackageFile(packageT,dest,ptime,stype,am);
                    }
                    p1++;
                }
                if (menu == 1)
                {
                    System.out.print("Enter flight date (DD/MM/YYYY) : ");
                    String date = in.next();
                    System.out.println("\f");
                    System.out.println("PACKAGE\t  PASSENGER\tDEPARTURE\tDESTINATION\tTIME\t  SEAT TYPE\t   AMOUNT(RM)");
                    System.out.println("===========================================================================================================");
                    System.out.println("   A   \t    4\t\tKUALA LUMPUR\tBANGKOK\t\t09:00AM\t  ECONOMY CLASS\t   1800.00");
                    System.out.println("   B   \t    4\t\tKUALA LUMPUR\tHANOI\t\t03:00PM\t  ECONOMY CLASS\t   2800.00");
                    System.out.print("   C   \t    4\t\tKUALA LUMPUR\tMANILA\t\t10:00PM\t  ECONOMY CLASS\t   3000.00");

                    
                    System.out.println("\n\nChoose package ( A / B / C )");
                    String packageType = in.next();
                    System.out.print("\f");

                    for (int i=0;i<4;i++)
                    {
                        System.out.print("\nEnter passenger " + (i+1) + " name\t\t: ");
                        name[i] = inLine.nextLine();
                        System.out.print("Enter passenger " + (i+1) + " age\t\t: ");
                        age[i] = in.nextInt();
                        System.out.print("Enter passenger " + (i+1) + " seat(1-80)\t: ");
                        seat[i] = in.nextInt();
                    }

                    System.out.print("\f");
                    System.out.print("\nChoose Add-Ons :\n[1] Meals\t\t(+RM40.00)\n[2] Weight (10kg)\t(+RM50.00)\n[3] Meals and Weight\t(+RM90.00)\n[4] No thanks\n");
                    int aO = in.nextInt();
                    String addOns = "";
                    if (aO == 1)
                    {
                        addOns = "Meals";
                        pAddOns = 40.00;
                    }
                    else if (aO == 2)
                    {
                        addOns = "Weight";
                        pAddOns = 50.00;
                    }
                    else if (aO == 3)
                    {
                        addOns = "Meals & Weight";
                        pAddOns = 90.00;
                    }
                    else
                    {
                        addOns = "None";
                        pAddOns = 0.00;
                    }

                    if (packageType.equalsIgnoreCase("A"))
                    {
                        index = 0;
                        pPackageType = pf[0].getpPackageType();
                        pAmount = pf[0].getpAmount();
                        sPassenger[1] += 4;
                        sEconomy[1] += 4;
                        sOneWay[1] += 4;
                        sAddOns[1] += pAddOns;
                        sAmount[1] += pf[0].getpAmount() + pAddOns;
                    }
                    else if (packageType.equalsIgnoreCase("B"))
                    {
                        index = 1;
                        pPackageType = pf[1].getpPackageType();
                        pAmount = pf[1].getpAmount();
                        sPassenger[3] += 4;
                        sEconomy[3] += 4;
                        sOneWay[3] += 4;
                        sAddOns[3] += pAddOns;
                        sAmount[3] += pf[1].getpAmount() + pAddOns;
                    }
                    else
                    {
                        index = 2;
                        pPackageType = pf[2].getpPackageType();
                        pAmount = pf[2].getpAmount();
                        sPassenger[4] += 4;
                        sEconomy[4] += 4;
                        sOneWay[4] += 4;
                        sAddOns[4] += pAddOns;
                        sAmount[4] += pf[2].getpAmount() + pAddOns;
                    }

                    pAmount +=  pAddOns;
                    cust[a] = new Package (name,age,seat,date,addOns,pAmount,pPackageType);

                    System.out.print("\f");
                    Package p = (Package) cust[a];
                    System.out.print("\n\n======================================================================="); 
                    System.out.println("\n e-Boarding Pass                                   Ref no : MY20196200"+ref);
                    System.out.println("=======================================================================");
                    System.out.println("DATE\t\t: " + p.getDate() + "\t\tADD-ONS\t: " + p.getAddOns());
                    System.out.println("TIME\t\t: " + pf[index].getpTime());
                    System.out.println("DEPARTURE\t: KUALA LUMPUR");
                    System.out.print("ARRIVAL\t\t: " + pf[index].getpDestination());
                    for (int i=0;i<4;i++)
                    {
                        System.out.print("\n\nNAME "+(i+1)+"\t: " + p.getName()[i]);
                        System.out.print("\nAGE  "+(i+1)+"\t: " + p.getAge()[i] + "\t\t\t\t\t" + pf[index].getpSeatType());
                        System.out.print("\nSEAT "+(i+1)+"\t: " + p.getSeat()[i]);
                    }
                    System.out.print("\n\nTOTAL AMOUNT : RM" + df2.format(pAmount));
                    System.out.print("\n=======================================================================");

                    ref++;
                    a++;
                    sPackage++;
                    System.out.print("\n\n(Enter any key to continue)");
                    in.next();
                    System.out.print("\f");
                }
                else if (menu == 2)
                {
                    System.out.print("\n");
                    System.out.print(print.printer());
                    System.out.println("\n\nChoose destination :\n[1] JAKARTA\t[4] HANOI");
                    System.out.println("[2] BANGKOK\t[5] MANILA");
                    System.out.println("[3] PHNOM");
                    int dest = in.nextInt();
                    System.out.print("\f");
                    System.out.print("\n");
                    System.out.print(print.printer());
                    System.out.println("\n\nEnter flight type : \n[1] One-Way\n[2] Return");
                    int flightType = in.nextInt();
                    System.out.print("\f");
                    System.out.print("\n\nEnter outgoing flight date (DD/MM/YYYY) : ");
                    String date1 = in.next();
                    System.out.println("\nChoose outgoing flight time : \n[1] 07.30AM\n[2] 11.30AM\n[3] 04.00PM\n[4] 11.00PM");
                    int time1 = in.nextInt();
                    System.out.print("\f");
                    String destt = "",flightTypee = "",outTime1 = "",outTime2 = "",date2 = "",seatTypee = "",addOns = "";
                    int time2=0;
                    double amount;
                    amount = 0.0;
                    if (flightType == 2)
                    {
                        System.out.print("\nEnter return flight date (DD/MM/YYYY) : ");
                        date2 = in.next();
                        System.out.println("\nChoose return flight time : \n[1] 07.30AM\n[2] 11.30AM\n[3] 04.00PM\n[4] 10.00PM");
                        time2 = in.nextInt();
                        System.out.print("\f");
                    }
                    System.out.print("\nEnter number of passenger (1-4 only) : ");
                    int num = in.nextInt();
                    System.out.print("\f");
                    System.out.print("\n");
                    System.out.print(print.printer2());
                    System.out.println("\n\nEnter seat type : \n[1] Business Class\n[2] Economy Class");
                    int seatType = in.nextInt();
                    System.out.print("\f");
                    for (int i=0;i<num;i++)
                    {
                        System.out.print("\nEnter passenger " + (i+1) + " name \t\t: ");
                        name[i] = inLine.nextLine();
                        System.out.print("Enter passenger " + (i+1) + " age\t\t: ");
                        age[i] = in.nextInt();
                        System.out.print("Enter passenger " + (i+1) + " seat(1-80)\t: ");
                        seat[i] = in.nextInt();
                    }
                    System.out.print("\f");

                    System.out.print("\nChoose Add-Ons :\n[1] Meals\t\t(+RM40.00)\n[2] Weight (10kg)\t(+RM50.00)\n[3] Meals and Weight\t(+RM90.00)\n[4] No thanks\n");
                    int aO = in.nextInt();
                    System.out.print("\f");

                    double price=0.0;

                    if (dest==1){   destt = "JAKARTA"; price = 400.00;}
                    else if (dest==2){   destt = "BANGKOK"; price = 500.00;} //sPassenger[1] += num;}
                    else if (dest==3){   destt = "PHNOM"; price = 600.00;}//sPassenger[2] += num;}
                    else if (dest==4){   destt = "HANOI"; price = 700.00;} //sPassenger[3] += num;}
                    else {   destt = "MANILA"; price = 800.00;} //sPassenger[4] += num;}

                    amount = price * num;
                    // Add Ons
                    if (aO == 1)
                        amount = amount + 40.00;
                    else if (aO == 2)
                        amount = amount + 50.00;
                    else if (aO == 3)
                        amount = amount + 90.00;
                    if (flightType == 1)
                    {   
                        flightTypee = "ONE-WAY";
                        if (seatType == 1)
                            amount = amount + ((price / 10) * num);
                    }
                    else 
                    {  
                        flightTypee = "RETURN";
                        amount = amount * 2;
                        if (seatType == 1)
                            amount = amount + (((price / 10) * num) * 2);
                    }

                    if (time1 == 1){  outTime1 = "7.30AM";}
                    else if (time1 == 2){  outTime1 = "11.30AM";}
                    else if (time1 == 3){  outTime1 = "4.00PM";}
                    else {  outTime1 = "10.00PM";}

                    if (time2 == 1){  outTime2 = "7.30AM";}
                    else if (time2 == 2){  outTime2 = "11.30AM";}
                    else if (time2 == 3){  outTime2 = "4.00PM";}
                    else {  outTime2 = "10.00PM";}

                    if (seatType == 1){ seatTypee = "Business Class";}
                    else {  seatTypee = "Economy Class";}

                    if (aO == 1){   addOns = "Meals";}
                    else if (aO == 2){  addOns = "Weight";}
                    else if (aO == 3){  addOns = "Meals and Weight";}
                    else {  addOns = "None";}

                    cust[a] = new Reserve (name,age,seat,date1,addOns,amount,destt,num,outTime1,seatTypee,flightTypee);
                    System.out.print("\f");
                    Reserve r = (Reserve) cust[a];
                    System.out.print("\n\n================================================================================="); 
                    System.out.println("\n e-Boarding Pass                                   Ref no : MY20196200"+ref);
                    System.out.println("=================================================================================");
                    System.out.println("FLIGHT TYPE\t: " + r.getOneWay());
                    System.out.println("\nOUTGOING DATE\t: " + r.getDate() + "\t\tADD-ONS\t: " + r.getAddOns());
                    System.out.println("OUTGOING TIME\t: " + r.getTime());
                    System.out.println("DEPARTURE\t: KUALA LUMPUR");
                    System.out.print("ARRIVAL\t\t: " + r.getDestination());
                    for (int i=0;i<num;i++)
                    {
                        System.out.print("\n\nNAME "+(i+1)+"\t: " + r.getName()[i]);
                        System.out.print("\nAGE  "+(i+1)+"\t: " + r.getAge()[i] + "\t\t\t\t\t" + r.getSeatType());
                        System.out.print("\nSEAT "+(i+1)+"\t: " + r.getSeat()[i]);
                    }
                    if (flightType == 2)
                    {
                        System.out.print("\n_________________________________________________________________________________");
                        System.out.println("\nRETURN DATE\t: " + date2 + "\t\tADD-ONS\t: " + r.getAddOns());
                        System.out.println("RETURN TIME\t: " + outTime2);
                        System.out.println("DEPARTURE\t: " + r.getDestination());
                        System.out.print("ARRIVAL\t\t: KUALA LUMPUR");
                        for (int i=0;i<num;i++)
                        {
                            System.out.print("\n\nNAME "+(i+1)+"\t: " + r.getName()[i]);
                            System.out.print("\nAGE  "+(i+1)+"\t: " + r.getAge()[i] + "\t\t\t\t\t" + r.getSeatType());
                            System.out.print("\nSEAT "+(i+1)+"\t: " + r.getSeat()[i]);
                        }
                    }
                    System.out.print("\n\nTOTAL AMOUNT : RM" + df2.format(r.getAmount()));
                    System.out.print("\n=================================================================================");

                    for (int i=0;i<5;i++)
                    {
                        if (sDestination[i].equalsIgnoreCase(destt))
                        {
                            sPassenger[i] += num;
                            if (seatType == 2)
                                sEconomy[i] += num;
                            else
                                sBusiness[i] += num;

                            if (flightType == 1)
                                sOneWay[i] += num;
                            else
                                sReturn[i] += num;

                            if (aO <= 3)
                            {
                                if (aO == 1)
                                    sAddOns[i] += 40.00;
                                else if (aO == 2)
                                    sAddOns[i] += 50.00;
                                else
                                    sAddOns[i] += 90.00;
                            }

                            sAmount[i] += r.getAmount();
                        }   
                    }

                    a++;
                    sManual++;
                    ref++;
                    System.out.print("\n\n(Enter any key to continue)");
                    in.next();
                    System.out.print("\f");
                }
                else if (menu == 3)
                {
                    System.out.print("\nSystem Terminated");
                    break;
                }
                else
                {
                    System.out.print("\nChoose A Proper Option");
                    System.out.print("\f");
                }

            }

            for (int i=0;i<5;i++)
            {
                stPassenger += sPassenger[i];
                stEconomy += sEconomy[i];
                stBusiness += sBusiness[i];
                stOneWay += sOneWay[i];
                stReturn += sReturn[i];
                stAddOns += sAddOns[i];
                stAmount += sAmount[i];
            }

            sales.print("DESTINATION\tPASSENGER\tECONOMY\tBUSINESS\tONE-WAY\t\tRETURN\t\tADD-ONS(RM)\tAMOUNT(RM)");
            sales.print("\n________________________________________________________________________________________________________________________________________________________________________");
            sales.print("\n\n"+sDestination[0]+"\t\t"+sPassenger[0]+"\t\t"+sEconomy[0]+"\t\t"+sBusiness[0]+"\t\t"+sOneWay[0]+"\t\t"+sReturn[0]+"\t\t"+df2.format(sAddOns[0])+"\t\t"+df2.format(sAmount[0]));
            sales.print("\n\n"+sDestination[1]+"\t"+sPassenger[1]+"\t\t"+sEconomy[1]+"\t\t"+sBusiness[1]+"\t\t"+sOneWay[1]+"\t\t"+sReturn[1]+"\t\t"+df2.format(sAddOns[1])+"\t\t"+df2.format(sAmount[1]));
            for (int i=2;i<5;i++)
            {
                sales.print("\n\n"+sDestination[i]+"\t\t"+sPassenger[i]+"\t\t"+sEconomy[i]+"\t\t"+sBusiness[i]+"\t\t"+sOneWay[i]+"\t\t"+sReturn[i]+"\t\t"+df2.format(sAddOns[i])+"\t\t"+df2.format(sAmount[i]));
            }
            sales.print("\n________________________________________________________________________________________________________________________________________________________________________");
            sales.print("\nTOTAL\t\t"+stPassenger+"\t\t"+stEconomy+"\t\t"+stBusiness+"\t\t"+stOneWay+"\t\t"+stReturn+"\t\t"+df2.format(stAddOns)+"\t\t"+df2.format(stAmount));
            sales.print("\n\nNUMBER OF RESERVATION \nPACKAGE : "+sPackage+"\nMANUAL  : "+sManual);
            infile.close();
            sales.close();
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Problem: " + e.getMessage());
        }
        catch(IOException ioe)
        {
            System.out.println("Problem: " + ioe.getMessage());
        }
    }
}