import java.sql.*;

public class ProductDAO {

    public void addProduct(Product p) {

        try (Connection conn = DBConnection.getConnection()) {

            String query = "INSERT INTO products VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(query);

            ps.setInt(1, p.getId());
            ps.setString(2, p.getName());
            ps.setDouble(3, p.getPrice());

            ps.executeUpdate();
            System.out.println("Product added");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void viewProducts() {

        try (Connection conn = DBConnection.getConnection()) {

            String query = "SELECT * FROM products";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                System.out.println(
                    rs.getInt(1) + " | " +
                    rs.getString(2) + " | " +
                    rs.getDouble(3)
                );
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void deleteProduct(int id) {

        try (Connection conn = DBConnection.getConnection()) {

            String query = "DELETE FROM products WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(query);

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("Product deleted");
            else
                System.out.println("Product not found");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}