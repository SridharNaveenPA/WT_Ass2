public import java.io.*;
import java.util.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class ServletHello extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Set the response type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h2>Parameter Demo</h2>");

        // 1️⃣ getQueryString()
        out.println("<h3>1. Query String:</h3>");
        String query = request.getQueryString();
        out.println("Query String: " + query + "<br><br>");

        // 2️⃣ getParameterNames()
        out.println("<h3>2. Parameter Names:</h3>");
        Enumeration<String> paramNames = request.getParameterNames();
        while (paramNames.hasMoreElements()) {
            String param = paramNames.nextElement();
            out.println("Parameter: " + param + "<br>");
        }
        out.println("<br>");

        // 3️⃣ getParameter(String name)
        out.println("<h3>3. getParameter()</h3>");
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        out.println("Name: " + name + "<br>");
        out.println("Age: " + age + "<br><br>");

        // 4️⃣ getParameterValues(String name)
        out.println("<h3>4. getParameterValues()</h3>");
        String[] skills = request.getParameterValues("skills");
        if (skills != null) {
            out.println("Skills:<br>");
            for (String s : skills) {
                out.println("- " + s + "<br>");
            }
        } else {
            out.println("No skills provided.<br>");
        }

        out.println("</body></html>");
        out.close();
    }
} {
    
}
