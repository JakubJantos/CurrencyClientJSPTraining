<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>listUser</title>
    </head>
    <body>
        <c:if test="${res == true}">
            <h2 style="color: green; font-family: Arial;">User sucsefuly createt</h2>
        </c:if>
        <c:if test="${deleteUsersResuld == true}">
            <h2 style="color: green; font-family: Arial;">User sucsefuly deleted</h2>
        </c:if>
        <a href="/users">Add user</a>
        <c:forEach var="user" items="${users}">
            <div>${user.email} ${user.date} <a href="/users/delete?userId=${user.id}">DELETE</a></div>
        </c:forEach>
    </body>
</html>
