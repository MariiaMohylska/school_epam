<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@page import="model.entity.Classes"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE web-app
        PUBLIC "-//Sun Microsystems, Inc.//DTD Web Application 2.3//EN" "http://java.sun.com/dtd/web-app_2_3.dtd">
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
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">

  <link rel="stylesheet" href="css/styleTable.css">
   <style>
    .button {
    width: 100%;
      padding: 10%px;
      font-size: 25pt;
    }
    #delete{
        background-color: #ff4d4d;
    }
   th, td{
    border: 1px solid white;
    }
    </style>
</head>

<body>
<main>
        <table>
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
                                        <input type="submit" name="class" value="<%=c.getClasses()%>" class="button"/>
                                         <input type="number" hidden name="classId" value="<%=c.getId()%>" />
                                </form>
                                <form method="post" action="deleteClass">
                                        <input type="number" hidden name="classForDelete" value="<%=c.getId()%>" />
                                        <input type="submit" name="delete" value="Delete" id="delete" class="button delete"/>
                                 </form>
                        </td>
                        <%}%>
        </tr>
        <%}catch(Exception e){
                e.printStackTrace();
        }%>
        </table>
        </main>
        <br />
         <form method="get" action="mainAfterTransfer">
        <input type="button" value="Transfer all classes" class="button">
        </form>
         <form method="get" action="addClass">
        <input type="submit" value="Add new class" class="button">
        </form>


</body>

</html>