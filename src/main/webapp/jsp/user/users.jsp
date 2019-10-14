<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html; charset=utf-8" language="java" %>
<html>
    <head>
        <title>users</title>
    </head>
    <body>
        <h1 style="font-family: Arial;">
            CREATE USERS
        </h1>
        <c:if test="${errorMsg !=null}">
            <div style="background-color: red;">${errorMsg}</div>
        </c:if>

        <form method="post" action="/users"/>

            <label>Email: </label>
                <input type="email" name="email"/>
            <label>Password:</label>
                <input type="password" name="paswd" />
            <label>Birthday: </label>
                <input type="date" name="date" />
            <input type="submit" value="register"/>
        </form>
    <a href="/users/list">show List</a>
    </body>
</html>