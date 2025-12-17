public class Property {

    private String address;
    private double price;
    private int size;

    public Property(String address, double price, int size) {
        this.address = address;
        this.price = price;
        this.size = size;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void displayInfo() {
        System.out.println("Address: " + address +
                ", Price: $" + price +
                ", Size: " + size + " sqm");
    }
}
