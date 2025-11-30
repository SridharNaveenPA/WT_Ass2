import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBC {
    public static void main(String[] args) {
        try{
            Class.forName("org.postgresql.Driver");

            String url = "jdbc:postgresql://localhost:5432/testdb";
            String user = "postgres";
            String password = "admin";

            Connection con = DriverManager.getConnection(url,user,password);

            Statement stmt = con.createStatement();
            String query = "SELECT * FROM student";
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String city = rs.getString("city");
                System.out.println("ID: " + id + ", Name: " + name + ", City: " + city);
                
            }
            

            PreparedStatement pt = con.prepareStatement("insert into student values(?,?,?)");
            pt.setInt(1,101);
            pt.setString(2,"John Doe");
            pt.setString(3,"New York");

            int i = pt.executeUpdate();
            System.out.println(i+" records inserted");
        }
}
