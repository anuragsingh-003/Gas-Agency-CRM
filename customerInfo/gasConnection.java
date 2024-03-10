package CRM.customerInfo;

import java.text.SimpleDateFormat;
import java.util.*;

public class gasConnection extends Customer {
   public  int numberOfCylinder ;
    String date;
    static int connectionNumber =100;
    {
        connectionNumber+=1;

    }
     public Date lastDate;
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");

    public gasConnection(String name, String street, String area, String pincode, String mobileNumber, int numberOfCylinder) {
        super(name, street, area, pincode, mobileNumber);
        this.numberOfCylinder = numberOfCylinder;
    }

    public void getLastDate() {
        System.out.println("Enter the Previous Booking Date dd/mm/yyyy");
        date = new Scanner (System.in).nextLine();

       try {
           lastDate = dateFormat.parse(date);
       }catch (Exception e){
           System.out.println("Error in previous Booking date "+e);
       }
    }
}
