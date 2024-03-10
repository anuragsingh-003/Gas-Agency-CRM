package CRM.customerInfo;
import CRM.gasSuppierinfo.gasSupplier;
public class Customer implements gasSupplier{
    public String name;
    public String Street;
    public String area;
    public String pincode;
    public  String mobileNumber;

    public Customer(String name, String street, String area, String pincode, String mobileNumber) {
        this.name = name;
        Street = street;
        this.area = area;
        this.pincode = pincode;
        this.mobileNumber = mobileNumber;
    }
}