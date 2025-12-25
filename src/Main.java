import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Property> dataPool = new ArrayList<>();
        dataPool.add(new ResidentialProperty("New York", 500000, 80, 2));
        dataPool.add(new ResidentialProperty("Los Angeles", 650000, 90, 3));
        dataPool.add(new ResidentialProperty("Texas", 300000, 100, 4));

        dataPool.sort(Comparator.comparingDouble(Property::getPrice));

        System.out.println("--- Affordable Properties (Price < 600,000) ---");
        List<Property> affordable = dataPool.stream()
                .filter(p -> p.getPrice() < 600000)
                .collect(Collectors.toList());

        affordable.forEach(System.out::println);

        for (Property p : dataPool) {
            System.out.println(p.getAddress() + " Tax is: " + p.calculateTax());
        }
    }
}