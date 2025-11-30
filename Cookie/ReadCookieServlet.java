//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ReadCookieServlet extends HttpServlet {
    public void doGet(HttpServletRequest var1, HttpServletResponse var2) throws IOException, ServletException {
        var2.setContentType("text/html");
        PrintWriter var3 = var2.getWriter();
        Cookie[] var4 = var1.getCookies();
        if (var4 != null) {
            String var5 = null;
            String var6 = null;

            for(Cookie var10 : var4) {
                if (var10.getName().equals("userName")) {
                    var5 = var10.getValue();
                }

                if (var10.getName().equals("secretCode")) {
                    var6 = var10.getValue();
                }
            }

            if (var5 != null && var6 != null) {
                var3.println("<h2>Cookie Details:</h2>");
                var3.println("Name: " + var5 + "<br>");
                var3.println("Secret Code: " + var6);
            } else {
                var3.println("<h3>No cookies found!</h3>");
            }
        } else {
            var3.println("<h3>No cookies found!</h3>");
        }

    }
}
