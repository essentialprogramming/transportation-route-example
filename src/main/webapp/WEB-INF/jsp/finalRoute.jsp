<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
   <head>
      <title>Home</title>
      <style>
        table,th,td {
                border:1px solid black;
        }
      </style>
   </head>

   <body>

   <h2> Final route: </h2>
      <json:array name="route" prettyPrint="true">

            <c:forEach var="city" items="${route}" varStatus="loop">
                      <json:object>
                            <c:out value="${city.name}" />
                            <c:if test="${!loop.last}"> ===></c:if>
                            <json:property name="Name" value="${city.name}"/>
                      </json:object>
            </c:forEach>

      </json:array>

      <br>
      <input type="button" onClick="window.location='/cities';" value="Create new route" />

   </body>
</html>