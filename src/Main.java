public class Main {

    public static void main(String[] args) {

        Property p1 = new Property("New York", 500000, 80);
        Property p2 = new Property("Los Angeles", 650000, 90);

        Realtor realtor = new Realtor("Alice", 5);
        RealEstateAgency agency = new RealEstateAgency("Dream Homes", realtor);

        p1.displayInfo();
        p2.displayInfo();
        agency.displayInfo();

        if (p1.getPrice() > p2.getPrice()) {
            System.out.println("Property 1 is more expensive. ");
        } else {
            System.out.println("Property 2 is more expensive.");
        }
    }
}
