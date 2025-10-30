import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class VisitCounterServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        int visitCount = 0; // default if no cookie exists

        // Step 1: Get all cookies sent by browser
        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("visitCount")) {
                    visitCount = Integer.parseInt(c.getValue());
                }
            }
        }

        // Step 2: Increment the visit count
        visitCount++;

        // Step 3: Create or update cookie
        Cookie visitCookie = new Cookie("visitCount", Integer.toString(visitCount));
        visitCookie.setMaxAge(60 * 60 * 24 * 7); // cookie lasts 7 days
        response.addCookie(visitCookie);

        // Step 4: Display visit info
        out.println("<html><body>");
        out.println("<h1>Welcome to my servlet!</h1>");
        out.println("<h3>You have visited this page " + visitCount + " times.</h3>");
        out.println("</body></html>");

        out.close();
    }
}
