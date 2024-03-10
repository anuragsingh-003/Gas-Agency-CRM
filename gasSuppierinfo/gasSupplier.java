package CRM.gasSuppierinfo;

public interface gasSupplier {
    public String agencyName = "Indian Gas";
    public int agencyCode = 021;

    public long agencyNumber = 735595631;

    default void agencyDisplay(){
        System.out.println("Agency Name "+agencyName);
        System.out.println("Agency Code "+agencyCode);
        System.out.println("Agency Phone Number "+agencyNumber);
    }

}
