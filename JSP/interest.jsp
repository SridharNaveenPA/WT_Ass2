<%@ page import="java.io.*" %>

<%
    // Fetch values from form
    String pStr = request.getParameter("p");
    String nStr = request.getParameter("n");
    String rStr = request.getParameter("r");

    double p = Double.parseDouble(pStr);
    double n = Double.parseDouble(nStr);
    double r = Double.parseDouble(rStr);

    // Compute Simple Interest
    double si = (p * n * r) / 100;
%>

<html>
<body>

<h3>Simple Interest Result</h3>

<p>Principal (P): <%= p %></p>
<p>Years (N): <%= n %></p>
<p>Rate (R): <%= r %></p>

<h3>Simple Interest = <%= si %></h3>

</body>
</html>
