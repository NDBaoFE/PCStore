<%-- 
    Document   : index
    Created on : Mar 1, 2023, 9:40:02 PM
    Author     : Admin
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
        <h1>We sell computer</h1>
        <c:if test="${sessionScope.account.role == "ROLE_CUSTOMER"}">
            <%--login as customer--%>
            You are customer
        </c:if>
        <c:if test="${sessionScope.account.role == "ROLE_EMPLOYEE"}">
            <%--login as customer--%>
            You are employee
        </c:if>
        <c:if test="${sessionScope.account.role == "ROLE_ADMIN"}">
            <%--login as customer--%>
            You are admin
        </c:if>

