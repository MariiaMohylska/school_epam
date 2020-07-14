<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@page import="model.entity.Classes"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE web-app
        PUBLIC "-//Sun Microsystems, Inc.//DTD Web Application 2.3//EN" "http://java.sun.com/dtd/web-app_2_3.dtd">
<html>

<body>
        <table border=1px>
                <%try{ArrayList<Classes> list = (ArrayList<Classes>)request.getAttribute("classes");
        int i = 0;%>
                <tr>
                        <%for(Classes c:list){
                i++;
                if(i==5){
                i=1;
                out.println("</tr><tr>");
                }
                %>
                        <td>
                                <form method="get" action="students">
                                        <input type="submit" name="class" value="<%=c.getClasses()%>" />
                                         <input type="number" hidden name="classId" value="<%=c.getId()%>" />
                                </form>
                                <form method="post" action="deleteClass">
                                        <input type="number" hidden name="classForDelete" value="<%=c.getId()%>" />
                                        <input type="submit" name="delete" value="Delete"/>
                                 </form>
                        </td>
                        <%}%>
        </tr>
        <%}catch(Exception e){
                e.printStackTrace();
        }%>
        </table>
        <br />
         <form method="get" action="mainAfterTransfer">
        <input type="button" value="Transfer all classes">
        </form>
         <form method="get" action="addClass">
        <input type="submit" value="Add new class">
        </form>


</body>

</html>