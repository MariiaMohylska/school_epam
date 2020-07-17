/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2020-07-17 09:35:13 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.logic.StudentShort;
import java.util.ArrayList;

public final class students_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE web-app PUBLIC\r\n");
      out.write(" \"-//Sun Microsystems, Inc.//DTD Web Application 2.3//EN\"\r\n");
      out.write(" \"http://java.sun.com/dtd/web-app_2_3.dtd\" >\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("  <meta charset=\"utf-8\">\r\n");
      out.write("  <title>Start</title>\r\n");
      out.write("  <meta content=\"width=device-width, initial-scale=1.0\" name=\"viewport\">\r\n");
      out.write("  <meta content=\"\" name=\"keywords\">\r\n");
      out.write("  <meta content=\"\" name=\"description\">\r\n");
      out.write("\r\n");
      out.write("  <!-- Favicons -->\r\n");
      out.write("  <link href=\"img/favicon.png\" rel=\"icon\">\r\n");
      out.write("  <link href=\"img/apple-touch-icon.png\" rel=\"apple-touch-icon\">\r\n");
      out.write("\r\n");
      out.write("  <!-- Main Stylesheet File -->\r\n");
      out.write("  <link rel=\"stylesheet\" href=\"css/styleTable.css\">\r\n");
      out.write("  <style>\r\n");
      out.write("      .button {\r\n");
      out.write("      width: 100%;\r\n");
      out.write("        padding: 10%px;\r\n");
      out.write("        font-size: 14pt;\r\n");
      out.write("      }\r\n");
      out.write("      #delete{\r\n");
      out.write("          background-color: #ff4d4d;\r\n");
      out.write("      }\r\n");
      out.write("      #add{\r\n");
      out.write("          background-color: #009933;\r\n");
      out.write("      }\r\n");
      out.write("\r\n");
      out.write("     th, td{\r\n");
      out.write("      border: 1px solid white;\r\n");
      out.write("      }\r\n");
      out.write("      </style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<main>\r\n");
try{String classNumber = (String)request.getAttribute("classNumber");
      out.write("\r\n");
      out.write("<form method=\"get\" action=\"addStudent\">\r\n");
      out.write("<input type=\"number\" hidden name=\"classToAdd\" value=\"");
      out.print(classNumber);
      out.write("\" />\r\n");
      out.write("<input type=\"submit\" value=\"Add student\" id=\"add\" class=\"button\">\r\n");
      out.write("</form>\r\n");
      out.write(" ");
}catch(Exception e){
                e.printStackTrace();
        }
      out.write("\r\n");
      out.write("<table border=1px>\r\n");
      out.write("<tr>\r\n");
      out.write("<td>\r\n");
      out.write("&nbsp;Personal File Number &nbsp;\r\n");
      out.write("</td>\r\n");
      out.write("<td>\r\n");
      out.write("Name\r\n");
      out.write("</td>\r\n");
      out.write("<td>\r\n");
      out.write("&nbsp; Class Number &nbsp;\r\n");
      out.write("</td>\r\n");
      out.write("<td>\r\n");
      out.write("&nbsp; Phone numbers &nbsp;\r\n");
      out.write("</td>\r\n");
      out.write("<td>\r\n");
      out.write("&nbsp; Birth Date &nbsp;\r\n");
      out.write("</td>\r\n");
      out.write("<td>\r\n");
      out.write("&nbsp; Actions &nbsp;\r\n");
      out.write("</td>\r\n");
      out.write("</tr>\r\n");
      out.write("        ");
try{ArrayList<StudentShort> list = (ArrayList<StudentShort>)request.getAttribute("students");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                ");
for(StudentShort student:list){
                
      out.write("\r\n");
      out.write("                 <tr>\r\n");
      out.write("                 <td>\r\n");
      out.write("                ");
      out.print(student.getFileNumber());
      out.write("\r\n");
      out.write("                 </td>\r\n");
      out.write("                 <td>\r\n");
      out.write("                 ");
      out.print(student.getSurname());
      out.write("\r\n");
      out.write("                 <br/>\r\n");
      out.write("                 ");
      out.print(student.getName());
      out.write(" &nbsp;\r\n");
      out.write("                 ");
      out.print(student.getFatherName());
      out.write("\r\n");
      out.write("                 </td>\r\n");
      out.write("                 <td>\r\n");
      out.write("                 ");
      out.print(student.getClassNumber());
      out.write("\r\n");
      out.write("                 </td>\r\n");
      out.write("                 <td>\r\n");
      out.write("                  ");
for(String s: student.getPhone()){
      out.write("\r\n");
      out.write("                   ");
      out.print(s);
      out.write("\r\n");
      out.write("                   <br/>\r\n");
      out.write("                  ");
}
      out.write("\r\n");
      out.write("                  </td>\r\n");
      out.write("                   <td>\r\n");
      out.write("                   ");
      out.print(student.getBDay());
      out.write("\r\n");
      out.write("                   </td>\r\n");
      out.write("                   <td>\r\n");
      out.write("                   <br/>\r\n");
      out.write("                   <form method=\"get\" action=\"viewDetails\">\r\n");
      out.write("                      <input type=\"number\" hidden name=\"StudentView\" value=\"");
      out.print(student.getId());
      out.write("\" />\r\n");
      out.write("                     <input type=\"submit\" value=\"View details & Edit\" class=\"button\">\r\n");
      out.write("                    </form>\r\n");
      out.write("                     <br/>\r\n");
      out.write("\r\n");
      out.write("                     <input type=\"button\" value=\"View marks\" class=\"button\">\r\n");
      out.write("                     <br/>\r\n");
      out.write("                     ");
try{String classNumber = (String)request.getAttribute("classNumber");
      out.write("\r\n");
      out.write("                      <form method=\"post\" action=\"deleteStudent\">\r\n");
      out.write("                         <input type=\"number\" hidden name=\"StudentForDelete\" value=\"");
      out.print(student.getId());
      out.write("\" />\r\n");
      out.write("                          <input type=\"number\" hidden name=\"classN\" value=\"");
      out.print(student.getClassNumber());
      out.write("\" />\r\n");
      out.write("                         <input type=\"submit\" name=\"delete\" value=\"Delete\" id=\"delete\" class=\"button\"/>\r\n");
      out.write("                       </form>\r\n");
      out.write("                       ");
}catch(Exception e){
                        e.printStackTrace();
                        }
      out.write("\r\n");
      out.write("                     <br/>\r\n");
      out.write("                     <br/>\r\n");
      out.write("                     </td>\r\n");
      out.write("                 </tr>\r\n");
      out.write("                ");
}
      out.write("\r\n");
      out.write("\r\n");
      out.write("        ");
}catch(Exception e){
                e.printStackTrace();
        }
      out.write("\r\n");
      out.write("        </table>\r\n");
      out.write("        <br/>\r\n");
      out.write("</main>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
