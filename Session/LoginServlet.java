import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Get form data
        String user = request.getParameter("username");
        String pass = request.getParameter("password");

        // Simple authentication check (you can replace this with database logic)
        if ("sridhar".equals(user) && "1234".equals(pass)) {

            // Create or get existing session
            HttpSession session = request.getSession();

            // Store user data in session
            session.setAttribute("username", user);

            out.println("<h3>Login successful!</h3>");
            out.println("<a href='DashboardServlet'>Go to Dashboard</a>");
        } else {
            out.println("<h3>Invalid credentials!</h3>");
            out.println("<a href='login.html'>Try Again</a>");
        }
    }
}
