<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
   <head>
      <title>Home</title>
      <style>
        table,th,td {
                border:1px solid black;
                width:70%
        }
      </style>
   </head>

   <body>
      <json:array name="cities" prettyPrint="true">
          <c:forEach var="city" items="${cities}">
                      <json:object>
                            <c:out value="${city.id}" />
                            <c:out value="${city.name}" />
                            <c:out value="<br>" escapeXml="false"></c:out>

                            <json:property name="Id" value="${city.id}"/>
                            <json:property name="Name" value="${city.name}"/>
                      </json:object>
                  </c:forEach>
      </json:array>


   </body>
</html>