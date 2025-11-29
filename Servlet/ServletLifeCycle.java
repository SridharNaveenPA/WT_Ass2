import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class ServletHello extends HttpServlet {

    // 1️⃣ Called only once — when servlet is first loaded
    public void init() throws ServletException {
        System.out.println("🟢 init() called — Servlet is being initialized!");
    }

    // 2️⃣ Called for each request — handles the browser request
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        System.out.println(" doGet() called — Handling a new GET request!");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Servlet Life Cycle Demo</h1>");
        out.println("<p><b>init()</b> — called once when servlet loads.</p>");
        out.println("<p><b>doGet()</b> — called for every browser request.</p>");
        out.println("<p><b>destroy()</b> — called once when server stops.</p>");
        out.println("</body></html>");
        out.close();
    }

    // 3️⃣ Called only once — when servlet is unloaded (server stops)
    public void destroy() {
        System.out.println(" destroy() called — Servlet is being destroyed!");
    }
}