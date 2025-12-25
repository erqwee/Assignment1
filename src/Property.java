import java.util.Objects;

public abstract class Property {
    private String address;
    private double price;
    private int size;

    public Property(String address, double price, int size) {
        this.address = address;
        this.price = price;
        this.size = size;
    }

    public abstract double calculateTax();


    @Override
    public String toString() {
        return String.format("Property{Address='%s', Price=%.2f, Size=%d}", address, price, size);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Property property = (Property) o;
        return Objects.equals(address, property.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address);
    }

    public double getPrice() { return price; }
    public String getAddress() { return address; }
}