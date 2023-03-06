<%-- 
    Document   : login
    Created on : Mar 1, 2023, 10:15:00 PM
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
        <form action="<c:url value="/account/login_handler.do"/>">
            <label for="email">Email</label>
            <input type="email" name="email" placeholder="Enter email"></br>
            <label for="password">Password</label>
            <input type="password" name="password" placeholder="Enter password"></br>
            <button type="submit" value="login" name="op">Login</button>
            <button type="submit" value="cancel" name="op">Cancel</button>
        </form>
        <i style="color:red;">${message}</i>
    </body>
</html>
