<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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

    <c:if test="${not empty jobList}">
        <h3>Job Listings</h3>
        <ul>
            <c:forEach var="job" items="${jobList}">
                <li>${job.job_title} - ${job.job_description}
                    <form action="/apply" method="post">
                        <input type="hidden" name="job_id" value="${job.job_id}" />
                        <button type="submit">Apply</button>
                    </form>
                </li>
            </c:forEach>
        </ul>
    </c:if>

    <c:if test="${empty jobList}">
        <p>No jobs available.</p>
    </c:if>
</body>
</html>
