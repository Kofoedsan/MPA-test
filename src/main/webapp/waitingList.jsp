<%-- 
    Document   : waitingList
    Created on : 24 Aug 2021, 15:36:00
    Author     : Kofoed
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Waitinglist</title>
    </head>
    <body>
        Tilføj dit navn til ventelisten.
        Her kan du se ventelisten..
        
        <p>
            ${requestScope.waitingname}
            ${requestScope.waitingnameSQL}
        </p>
        
          <p>
          <form action="WaitingList" method="post">
            <input type="hidden" name="command" value="add"/>
            <input type="text" name="requestname"/>
            <input type="submit" value="Add"/>
       </form>
          
          <c:if test="${requestScope.FEJL != null }">
              <p style="color:red">
                  ${requestScope.FEJL}
              </p>
          </c:if>
          
          <form action="WaitingList" method="post">
              <input name ="remove" type="submit" value="remove"/>
          </form>
        </p>
    </body>
</html>
