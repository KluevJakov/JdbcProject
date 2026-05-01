import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.UUID;

public class Main {
    static void main() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc",
                    "postgres",
                    "postgres");


            //changes

            PreparedStatement ps = conn.prepareStatement("select * from users");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                UUID uuid = UUID.fromString(rs.getString(1));
                String name = rs.getString(2);
                int age = rs.getInt(3);

                System.out.printf("%s %s %s %n", uuid, name, age);
            }
        } catch (Exception e) {
            System.out.printf("Error: %s %n", e.getMessage());
        }
    }
}
