<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
   <head>
      <title>Home</title>
      <link rel="stylesheet" type="text/css" href="style.css">
   </head>

   <body>
            <table>
                    <tbody>
                            <tr><th>ID</th><th>Name</th><th>Action</th></tr>
                            <c:forEach items="${cities}" var="city">

                                   <tr><td><c:out value="${city.id}"></c:out></td>
                                   <td><c:out value="${city.name}"></c:out></td>

                                   <td>
                                   <form action="/neighbours" method="get">
                                        <input type="submit" value="Start">
                                        <input type="hidden" name="cname" value="${city.name}"/>
                                   </form>
                                   </td>
                            </tr>

                            </c:forEach>
                    </tbody>
            </table>

   </body>

</html>