package CRM.gasBookinginfo;

import CRM.customerInfo.*;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class gasBooking extends gasConnection {

    public double otp = 5678 , amount =925.0 , refund =0;
    public String dt , delDate ,status ;
    public Date dt1 ; // current date
    public Date dt2; // delivery date


    public gasBooking(String name, String street, String area, String pincode, String mobileNumber, int numberOfCylinder) {
        super(name, street, area, pincode, mobileNumber, numberOfCylinder);
    }


    public void getDate(){
        System.out.println("Enter Current Booking Date in format dd/mm/yyyy");
        dt = new Scanner(System.in).nextLine();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
        try{
           dt1 = dateFormat.parse(dt);
        }catch (Exception e){
            System.out.println("Error in getDate Functuion "+e);
        }

    }
    public void delDate(){
        System.out.println("Enter the Delivery Date ");
        delDate = new Scanner(System.in).nextLine();
        SimpleDateFormat dateFormat2 = new SimpleDateFormat("dd/mm/yyyy");
        try{
            dt2 = dateFormat2.parse(delDate);
        }catch (Exception e){
            System.out.println("Error in delivery date "+e);
        }

        try{
            long distance = dt2.getTime() -dt1.getTime();
            long newdifference = TimeUnit.DAYS.convert(distance,TimeUnit.MILLISECONDS);
            if(newdifference >7){
                status = "Pending";
            }
        }catch (Exception e){
            System.out.println("Error while finding difference in dates "+e);
        }


    }



    public void validate(){
        long constraintdel = dt1.getTime() - lastDate.getTime();
        long diff = TimeUnit.DAYS.convert(constraintdel,TimeUnit.MILLISECONDS);
        System.out.println("The previous duration of Cylinder usage is  "+diff);
        if(numberOfCylinder ==1){
            if(diff<30){
                System.out.println("Booking Canceled cannot be done");
                status = "C";
            }else{
                System.out.println("Booked");
                status ="B";
                lastDate = dt1;
            }
        } else if (numberOfCylinder ==2) {
            if(diff<50){
                System.out.println("Booking Canceled cannot be done");
                status = "C";
            }else{
                System.out.println("Booked");
                status ="B";
                lastDate = dt1;
            }
        }
    }
}
