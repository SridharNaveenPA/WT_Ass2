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

public class CreateCookieServlet extends HttpServlet {
    public void doPost(HttpServletRequest var1, HttpServletResponse var2) throws IOException, ServletException {
        var2.setContentType("text/html");
        PrintWriter var3 = var2.getWriter();
        String var4 = var1.getParameter("username");
        String var5 = var1.getParameter("secretcode");
        Cookie var6 = new Cookie("userName", var4);
        Cookie var7 = new Cookie("secretCode", var5);
        var6.setMaxAge(3600);
        var7.setMaxAge(3600);
        var2.addCookie(var6);
        var2.addCookie(var7);
        var3.println("<h3>Cookies created successfully!</h3>");
        var3.println("<a href='read'>Click here to view cookies</a>");
    }
}
