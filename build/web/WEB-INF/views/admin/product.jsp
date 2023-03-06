<%-- 
    Document   : product
    Created on : Mar 3, 2023, 11:04:07 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1>Manage product here</h1>
<table>
    <c:forEach items="${list}" var="product" varStatus="loop">
        <tr>
            <th>${product.productId}</th>
            <th>${product.productName}</th>
            <th>${product.price}</th>
            <th>${product.category}</th>
            <th>${product.brandId}</th>
            <th>${product.description}</th>
        </tr>
    </c:forEach>
</table>

