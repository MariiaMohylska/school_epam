
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@page import="model.entity.Classes"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE web-app PUBLIC
 "-//Sun Microsystems, Inc.//DTD Web Application 2.3//EN"
 "http://java.sun.com/dtd/web-app_2_3.dtd" >
<html>
<body>
<table >


        <%try{ArrayList<Classes> std =
            (ArrayList<Classes>)request.getAttribute("classes");
        for(Classes c:std){%>
                <tr>
                <td><%=c.getClasses()%></td>
            </tr>
            <%}
            }catch(Exception e){
            e.printStackTrace();
            }%>
        </table>

</body>
</html>
