<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Klasse liste</title>
    </head>
    
    <body>
        <c:forEach var="student" items="${requestScope.student}">
        <li>
            ${student.name}
        </li>
    </c:forEach>
        
</body>


</html>
