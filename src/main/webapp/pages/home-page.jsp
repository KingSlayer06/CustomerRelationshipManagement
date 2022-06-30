<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
    <head>
        <title>Customer Relationship Management</title>
    </head>
    <body>
        <h1>Customer Relationship Management</h1>
        <form>
            <input type="submit" value="Add Customer" formaction="addCustomer">
            <table>
                <thead>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Email</th>
                    <th>Action</th>
                </thead>
                <tbody>
                    <c:forEach items="${Customers}" var="customer">
                        <tr>
                            <td><c:out value="${customer.firstName}"/></td>
                            <td><c:out value="${customer.lastName}"/></td>
                            <td><c:out value="${customer.email}"/></td>
                            <td>
                                <a href="/customers/updateCustomer?id=${customer.id}">Update</a> |
                                <a href="/customers/deleteCustomer?id=${customer.id}"
                                   onclick="if(!(confirm('Are you sure you want to delete?'))) return false">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </form>
    </body>
</html>
