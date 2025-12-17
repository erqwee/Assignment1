public class RealEstateAgency {

    private String agencyName;
    private Realtor realtor;

    public RealEstateAgency(String agencyName, Realtor realtor) {
        this.agencyName = agencyName;
        this.realtor = realtor;
    }

    public void displayInfo() {
        System.out.println("Agency: " + agencyName);
        realtor.displayInfo();
    }
}
