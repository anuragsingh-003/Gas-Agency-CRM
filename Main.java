package CRM;

import CRM.gasBookinginfo.Delivery;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import static CRM.gasSuppierinfo.gasSupplier.*;


public class  Main {

    static public int count =0 ,sno=0;
    static int bcount=0 , ccount =0 , dcount =0 , pcount =0;
    static String dpName;

    public static void cylinderCount(Delivery[] obj){    // passing object it can access all the properties of delivery have all properties of previous java classes
        String[] months = new String[]{"January" , "February" , " March" , "April", "May", "June", "July",
                "August", "September", "October", "August", "November", "December"};

        for(Delivery delivery: obj){  // it iterates through all properties of delivery class

            System.out.println("In month of "+(months[delivery.dt2.getMonth()])+" for person "+(sno+1));
            if(delivery.status.equals("D")){
                count+= delivery.numberOfCylinder;
            }
            System.out.println(" - "+count+" Total Cylinder Delivered");
        }
        System.out.println("\n");

    }

    public static void checkLateDel(Delivery[] obj){
        String[] months = new String[]{"January" , "February" , " March" , "April", "May", "June", "July",
                "August", "September", "October", "August", "November", "December"};
        int month[] = new int[12];

        for(Delivery delivery : obj){
            if(delivery.status.equals("D") && delivery.amount<800){
                System.out.println("----Late Delivery----");
                month[delivery.dt2.getMonth()]+=1; //feb index in arr 1 and in order is 2
            }
        }



        for(int i =0 ; i<12 ; i++){
            if(month[i]!=0){
                System.out.println("In "+months[i]+"there are "+month[i]);
            }
        }
        System.out.println("\n");
    }

    public static void numOfSingleCylinder(Delivery[] obj){
        System.out.println("--Single Cylinders Holder--");
        for(int i =0 ; i<obj.length; i++){

            if(obj[i].numberOfCylinder==1){
                System.out.println((i+1)+" Customer Name "+obj[i].name);
                System.out.println(" Customer Phone Number "+ obj[i].mobileNumber);
                System.out.println(" Customer GasConnection Number "+(i+101));
                System.out.println("\n");
            }
        }
        System.out.println("\n");
    }

    public static void DeliveryDetails(Delivery[] obj){
        System.out.println("---Delivery Details---");
        System.out.print("Enter the name of Delivery Person: ");
        dpName = new Scanner(System.in).nextLine();
        for(Delivery delivery : obj){
            if(delivery.status.equals("D") && delivery.delPersonName.equals(dpName)){
                System.out.println("Customer Name: "+delivery.name);
                System.out.println(" Address "+delivery.area+" Pincode"+delivery.pincode);
            }
        }
        System.out.println("\n");

    }

    public static void printReport(Delivery[] obj){
        System.out.println("----Delivery Report ----");
        for(int i =0 ; i< obj.length; i++){
            if(obj[i].status.equals("D")){
                dcount++;
            }
            else if(obj[i].status.equals("C")){
                ccount++;
            }
            else if(obj[i].status.equals("B")){
                bcount++;
            }
            else if(obj[i].status.equals("P")){
                pcount++;
            }else{
                System.out.println("--Status Invalid--");
            }
        }
        System.out.println("Booked: "+bcount);
        System.out.println("Delivered: "+dcount);
        System.out.println("Canceled: "+ccount);
        System.out.println("Pending: "+pcount);
        System.out.println("\n");
    }

    public static void printInvoice(Delivery[] obj){

        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat();
        String InvoiceDate = sdf.format(d);
        for(int i=0 ; i< obj.length; i++){
            if(obj[i].status.equals("D")){
                System.out.println("\t----INVOICE "+(i+1)+"----  " + "Date: ("+InvoiceDate+")");
                System.out.println("Gas Agency Code: "+agencyCode+" Agency Name: "+agencyName+ "Agency Number: "+agencyNumber);
                System.out.println("Gas Connection Number: "+(i+101)+" Customer Name: "+obj[i].name);
                System.out.println("Booking Date: "+sdf.format(obj[i].dt1) + " Customer No. "+obj[i].mobileNumber);
                System.out.println("Delivery Date: "+sdf.format(obj[i].dt2));
                System.out.println("Deliver Person Name: "+obj[i].delPersonName);
                System.out.println("Amount: "+obj[i].amount);
                System.out.println("Refund: "+obj[i].refund);
                System.out.println("Total Amount: "+(obj[i].amount - obj[i].refund));
                System.out.println("\n");
            }
        }
        System.out.println("ThankYou");
        System.out.println("\n");
    }

    public static void main(String[] args) {
        System.out.println("***********************************");
        System.out.println("          GAS AGENCY               ");
        System.out.println("***********************************");
        Delivery[] Person = new Delivery[2];
        Person[0]= new Delivery("Anurag","BCM","LKO","26701","7355956314",1);
        Person[1]= new Delivery("Akash","Ashiyan","south","26201","0055956314",1);


        for(Delivery delivery: Person){
            delivery.delPersonDetails();
            delivery.getLastDate();
            delivery.getDate();
            delivery.delDate();
            delivery.validate();
            delivery.validateOtp();
            delivery.refund();

        }
        System.out.println("\n");
        cylinderCount(Person);
        checkLateDel(Person);
        numOfSingleCylinder(Person);
        DeliveryDetails(Person);
        printReport(Person);
        printInvoice(Person);

    }


}

