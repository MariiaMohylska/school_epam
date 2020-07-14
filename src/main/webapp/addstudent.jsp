<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE web-app
        PUBLIC "-//Sun Microsystems, Inc.//DTD Web Application 2.3//EN" "http://java.sun.com/dtd/web-app_2_3.dtd">
<html>

<body>
   <form method="post" action="addStudent">
   <table>
        <tr>
             <td>
                 Personal file Number:&#9;
             </td>
             <td>
                 <input type="text" name="personalFile">
             </td>
         </tr>
         <tr>
             <td>
                 Entry date : &#9;
              </td>
              <td>
                 <input type="date" name="entryDate">
             </td>
         </tr>
        <tr>
           <td>
                Surname: &#9;
            </td>
            <td>
                <input type="text" name="surname">
            </td>
         </tr>
       <tr>
          <td>
                Name: &#9;
          </td>
          <td>
                <input type="text" name="name">
          </td>
        </tr>
        <tr>
          <td>
                Father name: &#9;
          </td>
          <td>
                <input type="text" name="fatherName">
          </td>
        </tr>
        <tr>
          <td>
                Birth Date: &#9;
          </td>
          <td>
                <input type="date" name="bDay">
          </td>
        </tr>
        <tr>
          <td>
                Phone number: &#9;
          </td>
          <td>
                <input type="tel" name="phone">
          </td>
        </tr>
         <tr>
          <td>
                City: &#9;
          </td>
          <td>
                <input type="text" name="city">
          </td>
        </tr>
         <tr>
          <td>
                Street: &#9;
          </td>
          <td>
                <input type="text" name="street">
          </td>
        </tr>
         <tr>
          <td>
                House: &#9;
          </td>
          <td>
                <input type="text" name="house">
          </td>
        </tr>
         <tr>
          <td>
                Flat: &#9;
          </td>
          <td>
                <input type="text" name="flat">
          </td>
        </tr>

        </table>
        <input type="submit" value="Add">

   </form>


</body>

</html>