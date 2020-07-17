
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@page import="model.logic.StudentShort"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE web-app PUBLIC
 "-//Sun Microsystems, Inc.//DTD Web Application 2.3//EN"
 "http://java.sun.com/dtd/web-app_2_3.dtd" >
<html>
<head>
  <meta charset="utf-8">
  <title>Start</title>
  <meta content="width=device-width, initial-scale=1.0" name="viewport">
  <meta content="" name="keywords">
  <meta content="" name="description">

  <!-- Favicons -->
  <link href="img/favicon.png" rel="icon">
  <link href="img/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Main Stylesheet File -->
  <link rel="stylesheet" href="css/styleTable.css">
  <style>
      .button {
      width: 100%;
        padding: 10%px;
        font-size: 14pt;
      }
      #delete{
          background-color: #ff4d4d;
      }
      #add{
          background-color: #009933;
      }

     th, td{
      border: 1px solid white;
      }
      </style>
</head>
<body>
<main>
<%try{String classNumber = (String)request.getAttribute("classNumber");%>
<form method="get" action="addStudent">
<input type="number" hidden name="classToAdd" value="<%=classNumber%>" />
<input type="submit" value="Add student" id="add" class="button">
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
                   <form method="get" action="viewDetails">
                      <input type="number" hidden name="StudentView" value="<%=student.getId()%>" />
                     <input type="submit" value="View details & Edit" class="button">
                    </form>
                     <br/>

                     <input type="button" value="View marks" class="button">
                     <br/>
                     <%try{String classNumber = (String)request.getAttribute("classNumber");%>
                      <form method="post" action="deleteStudent">
                         <input type="number" hidden name="StudentForDelete" value="<%=student.getId()%>" />
                          <input type="number" hidden name="classN" value="<%=student.getClassNumber()%>" />
                         <input type="submit" name="delete" value="Delete" id="delete" class="button"/>
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
</main>

</body>
</html>
