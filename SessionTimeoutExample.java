import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class SessionTimeoutExample extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Create or get existing session
        HttpSession session = request.getSession();

        // Set attribute
        session.setAttribute("username", "Sridhar");

        // Set session timeout to 60 seconds
        session.setMaxInactiveInterval(5);

        out.println("<h2>Session Example</h2>");
        out.println("<p>Session ID: " + session.getId() + "</p>");
        out.println("<p>Username: " + session.getAttribute("username") + "</p>");
        out.println("<p>Session Timeout set to: " + session.getMaxInactiveInterval() + " seconds</p>");
        out.println("<p>Wait for 1 minute without refreshing — then try again!</p>");
    }
    }
