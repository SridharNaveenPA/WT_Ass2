public import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class ServletHello extends HttpServlet {
    private int count=0;
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        count++;
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body><h1>UPPU POTTU OOMBU "+count+" THADAVA</h1></body></html>");
        out.close();
    }
} Counter {
    
}
