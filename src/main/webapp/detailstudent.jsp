<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@page import="model.logic.NewStudentObject"%>
<%@page import="model.entity.*"%>
<%@page import="java.time.LocalDate"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE web-app>
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
  .Descriprion {
  width: 25%;
    padding: 10%px;
  }
  .Value {
  width: 25%;
    padding: 10%px;
  }
  </style>
</head>

<body>
<main>
    <%try{NewStudentObject student = (NewStudentObject)request.getAttribute("students");%>
    <table>
                <tr>
                <td class="Descriprion">
                    <h1>Personal file Number:<h1>&#9;
                </td>
                <td class="Value">
                    <input type="number" hidden name="personalFileID" value="<%=student.getPersonalFile()%>" />
                    <h1><%=student.getPersonalFile().getNumber()%></h1>
                </td>
            </tr>
            <tr>
                <td class="Descriprion">
                    Entry date : &#9;
                </td>
                <td class="Value">
                    <%=student.getPersonalFile().getEntryDate()%>
                </td>
            </tr>
            <tr>
            <form method="get" action="editPersonalFile">
                <td class="Descriprion">
                    Graduation date : &#9;
                </td>
                <td class="Value">
                    <%=student.getPersonalFile().getGradDate()%>
                </td>
                <td>
                    <input type="number" hidden name="personalFileID" value="<%=student.getPersonalFile().getId()%>" />
                    <input type="number" hidden name="studentID" value="<%=student.getId()%>" />
                    <input type="submit" name="editPersonalFile" value="Edit Graduation Date" class="button" />
                </td>
</form>
            </tr>
            <tr>
                        <hr />
                    </tr>
      </table>
      <table>
        <form method="get" action="editClassForStudent">
            <tr>
                <td class="Descriprion">
                    <h2>Class : &#9;</h2>
                </td>
                <td class="Value">
                    <p><%=student.getClasses().getClasses()%></p>
                </td>
                <td>
                    <input type="number" hidden name="studentId" value="<%=student.getId()%>" />
                    <input type="submit" name="editClasses" value="Edit Class" class="button" />
                </td>
            </tr>
        </form>
        </table>
              <table>
            <tr>
                <br />
                <form mathod="get" action="editName">
                    <td class="Descriprion">
                        <h2>Name</h2>
                    </td>
                    <td class="Value">
                                    </td>
                    <td>
                        <input type="number" hidden name="nameID" value="<%=student.getName().getId()%>" />
                        <input type="number" hidden name="studentID" value="<%=student.getId()%>" />
                        <input type="submit" name="editName" value="Edit Name" class="button" />
                    </td>
            </tr>
        </form>
        <tr>
            <hr />
        </tr>

        <tr>
            <td class="Descriprion">
                Surname:&#9;
            </td>
            <td class="Value">
                <p><%=student.getName().getSurname()%></p>
            </td>
        </tr>
        <tr>
            <td class="Descriprion">
                Name : &#9;
            </td>
            <td class="Value">
                <p><%=student.getName().getName()%></p>
            </td>
        </tr>
        <tr>
            <td class="Descriprion">
                Father Name: &#9;
            </td>
            <td class="Value">
                <p><%=student.getName().getFatherName()%></p>
            </td>
        </tr>
        <br />
        </table>
              <table>
        <tr>
            <form mathod="get" action="editBday">
                <td class="Descriprion">
                    <h2>Birthday &#9;</h2>
                </td>
                <td class="Value">
                    <%=student.getBday()%>
                </td>
                <td>
                    <input type="number" hidden name="studentID" value="<%=student.getId()%>" />
                    <input type="submit" name="editBDay" value="Edit Birth Day" class="button" />
                </td>
            </form>
        </tr>
        <tr>
                    <hr />
                </tr>
</table>
      <table>

        <tr>
            <form mathod="get" action="editAddress">
                <td class="Descriprion">
                    <h3>Address</h3>
                </td>
                <td class="Value">
                </td>
                <td>
                    <input type="number" hidden name="addressID" value="<%=student.getAddress()%>" />
                    <input type="submit" name="editAddress" value="Edit Address" class="button"/>
                </td>
            </form>
        </tr>
        <tr>
            <td class="Descriprion">
                City:&#9;
            </td>
            <td class="Value">
                <p><%=student.getAddress().getCity()%></p>
            </td>
        </tr>
        <tr>
            <td class="Descriprion">
                Street : &#9;
            </td>
            <td class="Value">
                <p><%=student.getAddress().getStreet()%></p>
            </td>
        </tr>
        <tr>
            <td class="Descriprion">
                House / Flat: &#9;
            </td>
            <td class="Value">
                <p><%=student.getAddress().getHouse()%> / <%=student.getAddress().getFlat()%></p>
            </td>
        </tr>
        <tr>
                    <hr/>
                </tr>
        </table>
        <table>
        <br />
        <form mathod="get" action="editPhone">
            <td class="Descriprion">
                <h2>Phone</h2>
            </td>
            <td class="Value">
                <p><%=student.getPhone().getPhone()%></p>
            </td>
            <td>
                <input type="number" hidden name="phoneID" value="<%=student.getPhone()%>" />
                <input type="submit" name="editPhone" value="Edit Phone" class="button"/>
            </td>
            </tr>
        </form>
        <tr>
            <hr/>
        </tr>
    </table>
    <%}catch(Exception e){
                        e.printStackTrace();
                }%>
</main>
</body>

</html>