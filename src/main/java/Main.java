import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Main {
    static void main() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc",
                    "postgres",
                    "postgres");


            conn.setAutoCommit(false);

            try {


                conn.commit();
            } catch (Exception e) {
                conn.rollback();
            }


        } catch (Exception e) {
            System.out.printf("Error: %s %n", e.getMessage());
        }
    }
}
