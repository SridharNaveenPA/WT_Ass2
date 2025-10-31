import java.sql.*;

public class PostgresJDBCExample {
    public static void main(String[] args) {
        // Step 1: Database credentials
        String url = "jdbc:postgresql://localhost:5432/mydatabase"; // change DB name
        String user = "postgres";  // your PostgreSQL username
        String password = "your_password"; // your PostgreSQL password

        Connection conn = null;
        Statement stmt = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // Step 2: Register the PostgreSQL driver
            Class.forName("org.postgresql.Driver");

            // Step 3: Establish the connection
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("✅ Connected to the database successfully!");

            // Step 4: Create a Statement
            stmt = conn.createStatement();

            // Step 5: Execute SQL query using Statement
            String sql = "SELECT E_ID, E_NAME, AGE, GENDER, PHONE_NO FROM EMPLOYEE";
            rs = stmt.executeQuery(sql); // executeQuery for SELECT

            System.out.println("\n--- Employee Records (Using Statement) ---");
            while (rs.next()) {
                int id = rs.getInt("E_ID");
                String name = rs.getString("E_NAME");
                int age = rs.getInt("AGE");
                String gender = rs.getString("GENDER");
                long phone = rs.getLong("PHONE_NO");

                System.out.println(id + " | " + name + " | " + age + " | " + gender + " | " + phone);
            }

            // Step 6: Using PreparedStatement (Parameterized Query)
            String prepSql = "SELECT E_ID, E_NAME, AGE FROM EMPLOYEE WHERE AGE > ?";
            pstmt = conn.prepareStatement(prepSql);
            pstmt.setInt(1, 25); // Example parameter value

            rs = pstmt.executeQuery();

            System.out.println("\n--- Employees Older Than 25 (Using PreparedStatement) ---");
            while (rs.next()) {
                System.out.println(rs.getInt("E_ID") + " | " +
                                   rs.getString("E_NAME") + " | " +
                                   rs.getInt("AGE"));
            }

        } catch (ClassNotFoundException e) {
            System.out.println("❌ PostgreSQL Driver not found: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("❌ SQL Error: " + e.getMessage());
        } finally {
            // Step 7: Close resources
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println("Error closing resources: " + e.getMessage());
            }
        }
    }
}
