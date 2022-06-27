<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
    <head>
        <title>Customer Relationship Management</title>
    </head>
    <body>
        <h1>Customer Relationship Management</h1>
        <h3>Save Customer</h3>
        <form action="saveCustomer" method="post">
            <table>
                <tbody>
                <tr>
                    <td>
                        First Name:
                        <input type="text" name="firstName" placeholder="firstName" value="${Customer.firstName}">
                    </td>
                </tr>
                <tr>
                    <td>
                        Last Name:
                        <input type="text" name="lastName" placeholder="lastName" value="${Customer.lastName}">
                    </td>
                </tr>
                <tr>
                    <td>
                        Email:
                        <input type="text" name="email" placeholder="email" value="${Customer.email}">
                    </td>
                </tr>
                </tbody>
            </table>
        <input type="submit" value="Save">
        </form>
        <a href="/customers/home">Back to List</a>
    </body>
</html>
