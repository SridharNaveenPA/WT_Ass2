import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.util.*;

public class ServletHello extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Read form data
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String gender = request.getParameter("gender");
        String[] skills = request.getParameterValues("skills");

        // Print form data back to browser
        out.println("<html><body>");
        out.println("<h2>Form Data Received:</h2>");
        out.println("<b>Name:</b> " + name + "<br>");
        out.println("<b>Age:</b> " + age + "<br>");
        out.println("<b>Gender:</b> " + gender + "<br>");

        out.println("<b>Skills:</b><br>");
        if (skills != null) {
            for (String s : skills) {
                out.println("- " + s + "<br>");
            }
        } else {
            out.println("No skills selected.<br>");
        }

        out.println("</body></html>");
        out.close();
    }
}