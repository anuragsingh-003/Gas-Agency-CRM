package CRM.gasBookinginfo;

import java.util.concurrent.TimeUnit;
import java.util.*;

public class Delivery extends gasBooking{

    public Delivery(String name, String street, String area, String pincode, String mobileNumber, int numberOfCylinder) {
        super(name, street, area, pincode, mobileNumber, numberOfCylinder);
    }

    public String delPersonName;
    int customerOtp;
    public long new_diff;


    public void refund(){
        try{
            long raw_score =  dt2.getTime() - dt1.getTime();
            new_diff = TimeUnit.DAYS.convert(raw_score,TimeUnit.MILLISECONDS);
        }catch (Exception e){
            System.out.println("Error in calculating days of delay "+e);
        }

        if(new_diff>7 && status.equals("D")){
            refund=42;
            System.out.println("Delivery tooks more than 7 days ");
            System.out.println("Refund Processed");
            amount = amount-refund;
            System.out.println("Amount to be Paid after refund deduction "+amount);
        }
        else if(status.equals("D")) {
            {
                System.out.println("Delivered within the time period");
                System.out.println("Amount to be paid " + amount);
                System.out.println("Thankyou");
                System.out.println("\n");

            }
        }else {
            System.out.println("Booking Canceled");
            System.out.println("\n");
        }
    }

    public void validateOtp(){
        try {
            if (status.equals("B")) {
                System.out.println("Enter OTP : ");
                customerOtp = new Scanner(System.in).nextInt();

                if (customerOtp == otp) {
                    status = "D";
                    System.out.println("OTP Correct");
                } else {
                    status = "C";
                    System.out.println("Incorrect OTP");
                }
            } else {
                System.out.println("No Booking Found");
            }
        }catch(Exception e){
            System.out.println("Incorrect Otp Syntax");
        }
    }

    public void delPersonDetails() {

        System.out.println("Enter Delivery Person Name");
        delPersonName = new Scanner (System.in).nextLine();
    }


}
