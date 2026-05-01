import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
    static void main() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc",
                    "postgres",
                    "postgres");


            conn.setAutoCommit(false);

            try {
                System.out.println("Hello world!");

                conn.commit();
            } catch (Exception e) {
                conn.rollback();
            }


        } catch (Exception e) {
            System.out.printf("Error: %s %n", e.getMessage());
        }
    }
}
