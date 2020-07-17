<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE web-app
        PUBLIC "-//Sun Microsystems, Inc.//DTD Web Application 2.3//EN" "http://java.sun.com/dtd/web-app_2_3.dtd">
<html>
<head>
<title>Add Student</title>
<link href="css/style.css" rel="stylesheet" type="text/css" media="all"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Easy Contact Form  Responsive, Login form web template, Sign up Web Templates, Flat Web Templates, Login signup Responsive web template, Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<!--web-fonts-->
<link href='//fonts.googleapis.com/css?family=Ubuntu:400,300,300italic,400italic,500,500italic,700,700italic' rel='stylesheet' type='text/css'>
<style>
 body{
        background-color: #5bb9b8;
        font-color: black;
     }
     table{
     background-color:#89d4e9;
     box-shadow: 0px 0px 50px 2px #488d8c;
     margin:auto;
     padding:3%;
      border-radius: 7px;
     }
     input{
       width:100%;
       background:#c8f4f4;
       border:2px solid #79c9c9;
     }
    .button {
    	background-color:#5bb9b8;
    	border-radius:28px;
    	border:1px solid #89d4e9;
    	display:inline-block;
    	cursor:pointer;
    	color:#ffffff;
    	font-family:Arial;
    	font-size:17px;
    	padding:16px 31px;
    	text-decoration:none;
    	text-shadow:0px 1px 0px #2f6627;
    }
    .button:hover {
    	background-color:#5bb9a4;

      </style>
<!--web-fonts-->
</head>
<body>
<div class="main">
				<div class="main-section">
					<div class="login-form">
   <form method="post" action="addStudent">
   <table>
        <tr>
             <td>
               <p> Personal file Number:&#9;
             </td>
             <td>
                 <p><input type="text" name="personalFile"></p>
             </td>
         </tr>
         <tr>
             <td>
                 <p>Entry date : &#9;
              </td>
              <td>
                 <p><input type="date" name="entryDate"></p>
             </td>
         </tr>
        <tr>
           <td>
               <p> Surname: &#9;</p>
            </td>
            <td>
                <p><input type="text" name="surname"></p>
            </td>
         </tr>
       <tr>
          <td>
                <p >Name: &#9;</p>
          </td>
          <td>
                <p><input type="text" name="name"></p>
          </td>
        </tr>
        <tr>
          <td>
               <p > Father name: &#9;</p>
          </td>
          <td>
                <input type="text" name="fatherName"></p>
          </td>
        </tr>
        <tr>
          <td>
               <p> Birth Date: &#9;</p>
          </td>
          <td>
                <p><input type="date" name="bDay"></p>
          </td>
        </tr>
        <tr>
          <td>
               <p> Phone number: &#9;</p>
          </td>
          <td>
               <p> <input type="tel" name="phone"></p>
          </td>
        </tr>
         <tr>
          <td>
               <p> City: &#9;</p>
          </td>
          <td>
                <p><input type="text" name="city"></p>
          </td>
        </tr>
         <tr>
          <td>
               <p> Street: &#9;</p>
          </td>
          <td>
                <p><input type="text" name="street"></p>
          </td>
        </tr>
         <tr>
          <td>
               <p> House: &#9;</p>
          </td>
          <td>
                <p><input type="text" name="house"></p>
          </td>
        </tr>
         <tr>
          <td>
                <p>Flat: &#9;</p>
          </td>
          <td>
                <p><input type="text" name="flat"></p>
          </td>
       </tr>
                <tr>
                <td>
                </td>
                 <td>
                     <input type="submit" value="Add" class="button">
                 </td>

               </tr>

        </table>


   </form>
					</div>
				</div>
			</div>

</body>

</html>