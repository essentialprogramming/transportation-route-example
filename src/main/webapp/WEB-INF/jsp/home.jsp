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
      <json:array name="cities" prettyPrint="true">

            <table>
                    <tbody>
                            <tr><th>ID</th><th>Name</th><th>Action</th></tr>
                            <c:forEach items="${cities}" var="city">

                                   <tr><td><c:out value="${city.id}"></c:out></td>
                                   <td><c:out value="${city.name}"></c:out></td>

                                   <form action="/neighbours" method="get">
                                        <td><input type="submit" value="Add to route"</td>
                                        <input type="hidden" name="cname" value="${city.name}"/>
                                   </form>

                            </c:forEach>
                    </tbody>
            </table>

      </json:array>


   </body>
</html>