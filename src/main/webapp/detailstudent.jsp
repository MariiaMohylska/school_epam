<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@page import="model.logic.NewStudentObject"%>
<%@page import="model.entity.*"%>
<%@page import="java.time.LocalDate"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE web-app>
<html>

<body>
    <%try{NewStudentObject student = (NewStudentObject)request.getAttribute("students");%>
    <table>
                <tr>
                <td>
                    <h1>Personal file Number:<h1>&#9;
                </td>
                <td>
                    <input type="number" hidden name="personalFileID" value="<%=student.getPersonalFile()%>" />
                    <h1><%=student.getPersonalFile().getNumber()%></h1>
                </td>
            </tr>
            <tr>
                <td>
                    Entry date : &#9;
                </td>
                <td>
                    <%=student.getPersonalFile().getEntryDate()%>
                </td>
            </tr>
            <tr>
            <form method="get" action="editPersonalFile">
                <td>
                    Graduation date : &#9;
                </td>
                <td>
                    <%=student.getPersonalFile().getGradDate()%>
                </td>
                <td>
                    <input type="submit" name="editGradDate" value="Edit Graduation Date" />
                </td>
</form>
            </tr>
            <tr>
                        <hr />
                    </tr>
      </table>
      <table>
        <form method="get">
            <tr>
                <td>
                    <h3>Class : &#9;</h3>
                </td>
                <td>
                    <p><%=student.getClasses().getClasses()%></p>
                </td>
                <td>
                    <input type="number" hidden name="classNumber" value="<%=student.getClasses()%>" />
                    <input type="submit" name="editClasses" value="Edit Class" />
                </td>
            </tr>
        </form>
        </table>
              <table>
            <tr>
                <br />
                <form mathod="get" action="editName">
                    <td>
                        <h3>Name</h3>
                    </td>
                    <td>
                        <input type="number" hidden name="nameID" value="<%=student.getName()%>" />
                        <input type="submit" name="editName" value="Edit Name" />
                    </td>
            </tr>
        </form>
        <tr>
            <hr />
        </tr>

        <tr>
            <td>
                Surname:&#9;
            </td>
            <td>
                <p><%=student.getName().getSurname()%></p>
            </td>
        </tr>
        <tr>
            <td>
                Name : &#9;
            </td>
            <td>
                <p><%=student.getName().getName()%></p>
            </td>
        </tr>
        <tr>
            <td>
                Father Name: &#9;
            </td>
            <td>
                <p><%=student.getName().getFatherName()%></p>
            </td>
        </tr>
        <br />
        </table>
              <table>
        <tr>
            <form mathod="get" action="editStudent">
                <td>
                    <h3>Birthday &#9;</h3>
                </td>
                <td>
                    <%=student.getBday()%>
                </td>
                <td>
                    <input type="number" hidden name="studentID" value="<%=student.getId()%>" />
                    <input type="submit" name="editBDay" value="Edit Birth Day" />
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
                <td>
                    <h3>Address</h3>
                </td>
                <td>
                    <input type="number" hidden name="addressID" value="<%=student.getAddress()%>" />
                    <input type="submit" name="editAddress" value="Edit Address" />
                </td>
            </form>
        </tr>
        <tr>
            <td>
                City:&#9;
            </td>
            <td>
                <p><%=student.getAddress().getCity()%></p>
            </td>
        </tr>
        <tr>
            <td>
                Street : &#9;
            </td>
            <td>
                <p><%=student.getAddress().getStreet()%></p>
            </td>
        </tr>
        <tr>
            <td>
                House / Flat: &#9;
            </td>
            <td>
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
            <td>
                <h3>Phone</h3>
            </td>
            <td>
                <p><%=student.getPhone().getPhone()%></p>
            </td>
            <td>
                <input type="number" hidden name="phoneID" value="<%=student.getPhone()%>" />
                <input type="submit" name="editPhone" value="Edit Phone" />
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

</body>

</html>