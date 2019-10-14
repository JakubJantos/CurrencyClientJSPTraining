<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Companies</title>
    </head>
    <body>

        <form method="post" action="/companies">
            <label>NIP: </label>
            <input type="text" name="NIP"/>
            <label>nazwa: </label>
            <input type="text" name="nazwa"/>
            <input type="submit" value="search" />
        </form>

<c:if test="${companies != null}">
    <c:forEach var="company" items="${companies}">
        Nazwa: ${company.nazwa}<br/>
        NIP: ${company.NIP}<br/>
        Regon: ${company.regon}<br/>
        Ulica: ${company.address.street}<br/>
        Numer: ${company.address.number}<br/>
        Miasto: ${company.address.city}<br/>

    </c:forEach>
</c:if>
    </body>
</html>