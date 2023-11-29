<%@ page import="vn.edu.iuh.fit.lab1_vanquangphong_week2.backend.services.CustomerService" %>
<%@ page import="vn.edu.iuh.fit.lab1_vanquangphong_week2.backend.models.Customers" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: vupho
  Date: 11/29/2023
  Time: 3:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<body>
<h1>Cutomer</h1>
<table>
    <tr>
        <th>ID</th>
        <th>Address</th>
        <th>Email</th>
        <th>Full name</th>
        <th>Phone number</th>
    </tr>
    <%
        CustomerService customerService = new CustomerService();
        List<Customers> listCust = customerService.getAll();
        for (Customers customer : listCust) {
    %>
    <tr>
        <td><%= customer.getId() %></td>
        <td><%= customer.getAddress() %></td>
        <td><%= customer.getEmail() %></td>
        <td><%= customer.getName() %></td>
        <td><%= customer.getPhone() %></td>
    </tr>
    <%
        }
    %>
</table>
<br />
<form action="customerController" method="post">
    <label>ID:</label>
    <input type="text" name="id">
    <br />
    <label>Address: </label>
    <input type="text" name="address">
    <br />
    <label>Email: </label>
    <input type="text" name="email">
    <br />
    <label>Full name: </label>
    <input type="text" name="name">
    <br />
    <label>Phone number: </label>
    <input type="text" name="phone">
    <br />
    <button>
        Add
        <input type="hidden" name="action" value="addCust">
    </button>
    <button>
        Update
        <input type="hidden" name="action" value="updateCust">
    </button>
    <button type="reset">Clear</button>
    <br />
    <input type="text" name="deleteId" placeholder="write ID you want to delete">
    <button>
        Delete
        <input type="hidden" name="action" value="deleteCust">
    </button>
</form>
</body>
</body>
</html>
