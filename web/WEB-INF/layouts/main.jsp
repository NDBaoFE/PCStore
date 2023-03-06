<%-- 
    Document   : main
    Created on : Mar 1, 2023, 9:39:19 PM
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
        <header>
            <c:if test="${sessionScope.account==null}">
                <%--chua login --%>
                <a href="<c:url value="/" />">Home</a> |
                <a href="<c:url value="/product/index.do" />">Product</a> | 
                <a href="<c:url value="/home/aboutus.do" />">About Us</a>
                <span style="float: right"><a href="<c:url value="/account/login.do" />">Login</a> | 
                    <a href="<c:url value="/account/register.do" />">Register</a>
                </span>
            </c:if>
            <c:if test="${sessionScope.account != null}">
                <%--da login --%>
                <c:if test="${sessionScope.account.role == "ROLE_ADMIN"}">
                    <%-- login as admin --%>
                    <a href="<c:url value="/" />">Home</a> |
                    <a href="<c:url value="/admin/product.do" />">Product</a> | 
                    <a href="<c:url value="/admin/employees.do" />">Employees</a>
                </c:if>
                <c:if test="${sessionScope.account.role == "ROLE_EMPLOYEE"}">
                    <%--login as employee --%>
                    <a href="<c:url value="/" />">Home</a> |
                </c:if>
                <c:if test="${sessionScope.account.role == "ROLE_CUSTOMER"}">
                    <%--login as customer--%>
                    <a href="<c:url value="/" />">Home</a> |
                    <a href="<c:url value="/product/index.do" />">Product</a> | 
                    <a href="<c:url value="/home/aboutus.do" />">About Us</a>
                </c:if>
                <span style="float: right">Welcome ${sessionScope.account.fullName} | 
                    <a href="<c:url value="/account/logout.do" />">Logout</a>
                </span>
            </c:if>
        </header>
        <main><hr><jsp:include page="/WEB-INF/views/${controller}/${action}.jsp" /><hr></main>
        <footer>
            Copyright &copy; by FPT students
        </footer>
    </body>
</html>
