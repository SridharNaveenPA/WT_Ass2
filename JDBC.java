import java.sql.DriverManager;

public class JDBC {
    public static void main(String[] args) {
        try{
            Class.forName("org.postgresql.Driver");

            String url = "jdbc:postgresql://localhost:5432/testdb";
            String user = "postgres";
            String password = "admin";

            Connection con = DriverManager.getConnection(url,user,password);

            Statement stmt = con.createStatement();
            S
        }
}
