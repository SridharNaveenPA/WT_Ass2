<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
    <title>Employee Details</title>
</head>
<body style="font-family: Arial; margin: 40px;">

    <!-- JSP Declaration -->
    <%! 
        // Declaring a method to calculate annual salary
        public double calculateAnnualSalary(double monthlySalary) {
            return monthlySalary * 12;
        }
    %>

    <!-- JSP Scriptlet -->
    <%
        // Java code to create and store data
        String empName = "Jegan";
        double monthlySalary = 35000.50;
        request.setAttribute("empName", empName);
        request.setAttribute("monthlySalary", monthlySalary);
    %>

    <h2>Employee Details</h2>
    <hr>

    <!-- JSP Expression -->
    <p><strong>Name:</strong> <%= empName %></p>
    <p><strong>Monthly Salary:</strong> ₹<%= monthlySalary %></p>
    <p><strong>Annual Salary:</strong> ₹<%= calculateAnnualSalary(monthlySalary) %></p>

    <hr>

    <h3>Using JSTL and EL (Expression Language)</h3>

    <p><strong>Name:</strong> ${empName}</p>
    <p><strong>Monthly Salary:</strong> 
        <fmt:formatNumber value="${monthlySalary}" type="currency"/>
    </p>

    <p><strong>Annual Salary (formatted):</strong> 
        <fmt:formatNumber value="${monthlySalary * 12}" type="currency"/>
    </p>

    <hr>

    <!-- JSTL Core Tag Example -->
    <c:set var="departments" value="${['HR', 'IT', 'Finance', 'Marketing']}" />
    <h3>Departments List (Using JSTL Loop)</h3>
    <ul>
        <c:forEach var="dept" items="${departments}">
            <li>${dept}</li>
        </c:forEach>
    </ul>

</body>
</html>