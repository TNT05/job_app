<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Home</title>
</head>
<body>
    <h2>Welcome to the Home Page</h2>
    <c:if test="${not empty user}">
        <p>User Name: ${user.user_name}</p>
        <p>User Email: ${user.user_email}</p>
        <form action="index" method="get">
            <button type="submit">Logout</button>
        </form>
    </c:if>
</body>
</html>
