import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class ServletHello extends HttpServlet{
public void doGet(HttpServletResponse response,HttpServletRequest request) throws IOException,ServletException{
    response.setContentType("text/html");

    PrintWriter out = response.getWriter();

    out.println("<html><body><h1>UPPU POTTU OOMBU</h1></body></html>");

    out.close();
}
}