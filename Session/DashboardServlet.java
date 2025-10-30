import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class DashboardServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Get current session (do not create new)
        HttpSession session = request.getSession(false);

        if (session != null && session.getAttribute("username") != null) {
            String user = (String) session.getAttribute("username");
            out.println("<h2>Welcome back, " + user + "!</h2>");
            out.println("<a href='LogoutServlet'>Logout</a>");
        } else {
            out.println("<h3>Please login first.</h3>");
            out.println("<a href='login.html'>Login</a>");
        }
    }
}
