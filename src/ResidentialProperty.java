public class ResidentialProperty extends Property {
    private int bedrooms;

    public ResidentialProperty(String address, double price, int size, int bedrooms) {
        super(address, price, size);
        this.bedrooms = bedrooms;
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.05;
    }
}
