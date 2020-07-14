
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@page import="model.logic.StudentShort"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE web-app PUBLIC
 "-//Sun Microsystems, Inc.//DTD Web Application 2.3//EN"
 "http://java.sun.com/dtd/web-app_2_3.dtd" >
<html>
<body>
<%try{String classNumber = (String)request.getAttribute("classNumber");%>
<form method="get" action="addStudent">
<input type="number" hidden name="classToAdd" value="<%=classNumber%>" />
<input type="submit" value="Add student">
</form>
 <%}catch(Exception e){
                e.printStackTrace();
        }%>
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
<td>
&nbsp; Actions &nbsp;
</td>
</tr>
        <%try{ArrayList<StudentShort> list = (ArrayList<StudentShort>)request.getAttribute("students");%>

                <%for(StudentShort student:list){
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
                   <td>
                   <br/>
                     <input type="button" value="Edit">
                     <br/>
                     <input type="button" value="View marks">
                     <br/>
                     <%try{String classNumber = (String)request.getAttribute("classNumber");%>
                      <form method="post" action="deleteStudent">
                         <input type="number" hidden name="StudentForDelete" value="<%=student.getId()%>" />
                          <input type="number" hidden name="classN" value="<%=classNumber%>" />
                         <input type="submit" name="delete" value="Delete"/>
                       </form>
                       <%}catch(Exception e){
                        e.printStackTrace();
                        }%>
                     <br/>
                     <br/>
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
