
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@page import="model.logic.NewStudent"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE web-app PUBLIC
 "-//Sun Microsystems, Inc.//DTD Web Application 2.3//EN"
 "http://java.sun.com/dtd/web-app_2_3.dtd" >
<html>
<body>
<table border=1px>
<tr>
<td>
&nbsp;Personal File Number &nbsp;
</td>
<td>
Name
</td>
<td>
&nbsp; Class Number &nbsp;
</td>
<td>
&nbsp; Phone numbers &nbsp;
</td>
<td>
&nbsp; Birth Date &nbsp;
</td>
</tr>
        <%try{ArrayList<NewStudent> list = (ArrayList<NewStudent>)request.getAttribute("students");%>

                <%for(NewStudent student:list){
                %>
                 <tr>
                 <td>
                <%=student.getFileNumber()%>
                 </td>
                 <td>
                 <%=student.getSurname()%>
                 <br/>
                 <%=student.getName()%> &nbsp;
                 <%=student.getFatherName()%>
                 </td>
                 <td>
                 <%=student.getClassNumber()%>
                 </td>
                 <td>
                  <%for(String s: student.getPhone()){%>
                   <%=s%>
                   <br/>
                  <%}%>
                  </td>
                   <td>
                   <%=student.getBDay()%>
                   </td>

                 </tr>
                <%}%>

        <%}catch(Exception e){
                e.printStackTrace();
        }%>
        </table>
        <br/>

</body>
</html>
