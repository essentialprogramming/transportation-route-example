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
      <json:array name="neighbours" prettyPrint="true">

            <table>
                    <tbody>
                            <tr><th>ID</th><th>Name</th><th>Action</th></tr>
                            <c:forEach items="${neighbours}" var="item">

                                   <tr><td><c:out value="${item.id}"></c:out></td>
                                   <td><c:out value="${item.name}"></c:out></td>

                                   <form action="/neighbours" method="get">
                                        <td><input type="submit" value="Add to route"</td>
                                        <input type="hidden" name="cname" value="${item.name}"/>
                                   </form>

                            </c:forEach>
                    </tbody>
            </table>

      </json:array>

      <input type="button" onClick="window.location='http://localhost:8080/route';" value="Complete route" />
      <input type="button" onClick="window.location='http://localhost:8080/undo';" value="Undo" />

   </body>
</html>