import java.sql.Connection;
import java.util.*;
import java.util.stream.Collectors;
import java.sql.*;

public class Main {
    public static void main(String[] args) {
        try {
            Connection conn = dbConnection.getConnection();
            System.out.println("DATABASE CONNECTED");
        }catch (SQLException e) {
            e.printStackTrace();
        }
        String insertSQL =
                "INSERT INTO \"ResidentialProperty\" (address, price, size, bedrooms) VALUES (?, ?, ?, ?)";

        try (Connection conn = dbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(insertSQL)) {

            ps.setString(1, "Astana");
            ps.setDouble(2, 420000);
            ps.setInt(3, 95);
            ps.setInt(4, 3);

            ps.executeUpdate();
            System.out.println("INSERT DONE");
        }catch (SQLException e) {
            e.printStackTrace();}
        String selectSQL = "SELECT * FROM \"ResidentialProperty\"";

        try (Connection conn = dbConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(selectSQL)) {

            System.out.println("--- DATABASE DATA ---");
            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                                rs.getString("address") + " | " +
                                rs.getDouble("price")
                );
            }
        }catch (SQLException e) {
            e.printStackTrace();}
        String updateSQL =
                "UPDATE \"ResidentialProperty\" SET price = ? WHERE address = ?";

        try (Connection conn = dbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(updateSQL)) {

            ps.setDouble(1, 450000);
            ps.setString(2, "Astana");

            ps.executeUpdate();
            System.out.println("UPDATE DONE");
        }catch (SQLException e) {
            e.printStackTrace();}
        String deleteSQL =
                "DELETE FROM \"ResidentialProperty\" WHERE address = ?";

        try (Connection conn = dbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(deleteSQL)) {

            ps.setString(1, "Astana");
            ps.executeUpdate();
            System.out.println("DELETE DONE");
        }catch (SQLException e) {
            e.printStackTrace();}

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
