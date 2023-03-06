<%-- 
    Document   : register
    Created on : Mar 2, 2023, 12:12:14 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="<c:url value="/account/register_handler.do"/>">
            <label>Email:</label>
            <input type="email" name="email"></br>
            <label>Password:</label>
            <input type="password" name="password"></br>
            <label>Full name:</label>
            <input type="text" name="fullName"></br>
            <label>Phone number:</label>
            <input type="tel" name="phoneNo"></br>
            <label>Address:</label>
            <input type="text" name="address"></br>
            <button type="submit" name="op" value="register">Register</button>
            <button type="submit" name="op" value="cancel">Cancel</button>
        </form>
            <i>${message}</i>
    </body>
</html>
