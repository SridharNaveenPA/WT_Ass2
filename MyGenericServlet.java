public import java.io.*;
import jakarta.servlet.*;

public class MyGenericServlet extends GenericServlet {
    public void init() throws ServletException {
        // optional
    }

    @Override
    public void service(ServletRequest req, ServletResponse res)
            throws ServletException, IOException {
        res.setContentType("text/plain");
        PrintWriter out = res.getWriter();
        out.println("Hello from GenericServlet");
        // use req.getParameter(...) etc.
    }

    public void destroy() {
        // cleanup
    }
}
 {
    
}
