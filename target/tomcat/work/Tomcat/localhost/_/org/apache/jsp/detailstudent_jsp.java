/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2020-07-17 09:13:03 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.logic.NewStudentObject;
import model.entity.*;
import java.time.LocalDate;

public final class detailstudent_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("<!DOCTYPE web-app>\r\n");
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
      out.write("  .Descriprion {\r\n");
      out.write("  width: 25%;\r\n");
      out.write("    padding: 10%px;\r\n");
      out.write("  }\r\n");
      out.write("  .Value {\r\n");
      out.write("  width: 25%;\r\n");
      out.write("    padding: 10%px;\r\n");
      out.write("  }\r\n");
      out.write("  </style>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("<main>\r\n");
      out.write("    ");
try{NewStudentObject student = (NewStudentObject)request.getAttribute("students");
      out.write("\r\n");
      out.write("    <table>\r\n");
      out.write("                <tr>\r\n");
      out.write("                <td class=\"Descriprion\">\r\n");
      out.write("                    <h1>Personal file Number:<h1>&#9;\r\n");
      out.write("                </td>\r\n");
      out.write("                <td class=\"Value\">\r\n");
      out.write("                    <input type=\"number\" hidden name=\"personalFileID\" value=\"");
      out.print(student.getPersonalFile());
      out.write("\" />\r\n");
      out.write("                    <h1>");
      out.print(student.getPersonalFile().getNumber());
      out.write("</h1>\r\n");
      out.write("                </td>\r\n");
      out.write("            </tr>\r\n");
      out.write("            <tr>\r\n");
      out.write("                <td class=\"Descriprion\">\r\n");
      out.write("                    Entry date : &#9;\r\n");
      out.write("                </td>\r\n");
      out.write("                <td class=\"Value\">\r\n");
      out.write("                    ");
      out.print(student.getPersonalFile().getEntryDate());
      out.write("\r\n");
      out.write("                </td>\r\n");
      out.write("            </tr>\r\n");
      out.write("            <tr>\r\n");
      out.write("            <form method=\"get\" action=\"editPersonalFile\">\r\n");
      out.write("                <td class=\"Descriprion\">\r\n");
      out.write("                    Graduation date : &#9;\r\n");
      out.write("                </td>\r\n");
      out.write("                <td class=\"Value\">\r\n");
      out.write("                    ");
      out.print(student.getPersonalFile().getGradDate());
      out.write("\r\n");
      out.write("                </td>\r\n");
      out.write("                <td>\r\n");
      out.write("                    <input type=\"number\" hidden name=\"personalFileID\" value=\"");
      out.print(student.getPersonalFile().getId());
      out.write("\" />\r\n");
      out.write("                    <input type=\"number\" hidden name=\"studentID\" value=\"");
      out.print(student.getId());
      out.write("\" />\r\n");
      out.write("                    <input type=\"submit\" name=\"editPersonalFile\" value=\"Edit Graduation Date\" class=\"button\" />\r\n");
      out.write("                </td>\r\n");
      out.write("</form>\r\n");
      out.write("            </tr>\r\n");
      out.write("            <tr>\r\n");
      out.write("                        <hr />\r\n");
      out.write("                    </tr>\r\n");
      out.write("      </table>\r\n");
      out.write("      <table>\r\n");
      out.write("        <form method=\"get\" action=\"editClassForStudent\">\r\n");
      out.write("            <tr>\r\n");
      out.write("                <td class=\"Descriprion\">\r\n");
      out.write("                    <h2>Class : &#9;</h2>\r\n");
      out.write("                </td>\r\n");
      out.write("                <td class=\"Value\">\r\n");
      out.write("                    <p>");
      out.print(student.getClasses().getClasses());
      out.write("</p>\r\n");
      out.write("                </td>\r\n");
      out.write("                <td>\r\n");
      out.write("                    <input type=\"number\" hidden name=\"studentId\" value=\"");
      out.print(student.getId());
      out.write("\" />\r\n");
      out.write("                    <input type=\"submit\" name=\"editClasses\" value=\"Edit Class\" class=\"button\" />\r\n");
      out.write("                </td>\r\n");
      out.write("            </tr>\r\n");
      out.write("        </form>\r\n");
      out.write("        </table>\r\n");
      out.write("              <table>\r\n");
      out.write("            <tr>\r\n");
      out.write("                <br />\r\n");
      out.write("                <form mathod=\"get\" action=\"editName\">\r\n");
      out.write("                    <td class=\"Descriprion\">\r\n");
      out.write("                        <h2>Name</h2>\r\n");
      out.write("                    </td>\r\n");
      out.write("                    <td class=\"Value\">\r\n");
      out.write("                                    </td>\r\n");
      out.write("                    <td>\r\n");
      out.write("                        <input type=\"number\" hidden name=\"nameID\" value=\"");
      out.print(student.getName().getId());
      out.write("\" />\r\n");
      out.write("                        <input type=\"number\" hidden name=\"studentID\" value=\"");
      out.print(student.getId());
      out.write("\" />\r\n");
      out.write("                        <input type=\"submit\" name=\"editName\" value=\"Edit Name\" class=\"button\" />\r\n");
      out.write("                    </td>\r\n");
      out.write("            </tr>\r\n");
      out.write("        </form>\r\n");
      out.write("        <tr>\r\n");
      out.write("            <hr />\r\n");
      out.write("        </tr>\r\n");
      out.write("\r\n");
      out.write("        <tr>\r\n");
      out.write("            <td class=\"Descriprion\">\r\n");
      out.write("                Surname:&#9;\r\n");
      out.write("            </td>\r\n");
      out.write("            <td class=\"Value\">\r\n");
      out.write("                <p>");
      out.print(student.getName().getSurname());
      out.write("</p>\r\n");
      out.write("            </td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("            <td class=\"Descriprion\">\r\n");
      out.write("                Name : &#9;\r\n");
      out.write("            </td>\r\n");
      out.write("            <td class=\"Value\">\r\n");
      out.write("                <p>");
      out.print(student.getName().getName());
      out.write("</p>\r\n");
      out.write("            </td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("            <td class=\"Descriprion\">\r\n");
      out.write("                Father Name: &#9;\r\n");
      out.write("            </td>\r\n");
      out.write("            <td class=\"Value\">\r\n");
      out.write("                <p>");
      out.print(student.getName().getFatherName());
      out.write("</p>\r\n");
      out.write("            </td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <br />\r\n");
      out.write("        </table>\r\n");
      out.write("              <table>\r\n");
      out.write("        <tr>\r\n");
      out.write("            <form mathod=\"get\" action=\"editBday\">\r\n");
      out.write("                <td class=\"Descriprion\">\r\n");
      out.write("                    <h2>Birthday &#9;</h2>\r\n");
      out.write("                </td>\r\n");
      out.write("                <td class=\"Value\">\r\n");
      out.write("                    ");
      out.print(student.getBday());
      out.write("\r\n");
      out.write("                </td>\r\n");
      out.write("                <td>\r\n");
      out.write("                    <input type=\"number\" hidden name=\"studentID\" value=\"");
      out.print(student.getId());
      out.write("\" />\r\n");
      out.write("                    <input type=\"submit\" name=\"editBDay\" value=\"Edit Birth Day\" class=\"button\" />\r\n");
      out.write("                </td>\r\n");
      out.write("            </form>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("                    <hr />\r\n");
      out.write("                </tr>\r\n");
      out.write("</table>\r\n");
      out.write("      <table>\r\n");
      out.write("\r\n");
      out.write("        <tr>\r\n");
      out.write("            <form mathod=\"get\" action=\"editAddress\">\r\n");
      out.write("                <td class=\"Descriprion\">\r\n");
      out.write("                    <h3>Address</h3>\r\n");
      out.write("                </td>\r\n");
      out.write("                <td class=\"Value\">\r\n");
      out.write("                </td>\r\n");
      out.write("                <td>\r\n");
      out.write("                    <input type=\"number\" hidden name=\"addressID\" value=\"");
      out.print(student.getAddress());
      out.write("\" />\r\n");
      out.write("                    <input type=\"submit\" name=\"editAddress\" value=\"Edit Address\" class=\"button\"/>\r\n");
      out.write("                </td>\r\n");
      out.write("            </form>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("            <td class=\"Descriprion\">\r\n");
      out.write("                City:&#9;\r\n");
      out.write("            </td>\r\n");
      out.write("            <td class=\"Value\">\r\n");
      out.write("                <p>");
      out.print(student.getAddress().getCity());
      out.write("</p>\r\n");
      out.write("            </td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("            <td class=\"Descriprion\">\r\n");
      out.write("                Street : &#9;\r\n");
      out.write("            </td>\r\n");
      out.write("            <td class=\"Value\">\r\n");
      out.write("                <p>");
      out.print(student.getAddress().getStreet());
      out.write("</p>\r\n");
      out.write("            </td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("            <td class=\"Descriprion\">\r\n");
      out.write("                House / Flat: &#9;\r\n");
      out.write("            </td>\r\n");
      out.write("            <td class=\"Value\">\r\n");
      out.write("                <p>");
      out.print(student.getAddress().getHouse());
      out.write(' ');
      out.write('/');
      out.write(' ');
      out.print(student.getAddress().getFlat());
      out.write("</p>\r\n");
      out.write("            </td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("                    <hr/>\r\n");
      out.write("                </tr>\r\n");
      out.write("        </table>\r\n");
      out.write("        <table>\r\n");
      out.write("        <br />\r\n");
      out.write("        <form mathod=\"get\" action=\"editPhone\">\r\n");
      out.write("            <td class=\"Descriprion\">\r\n");
      out.write("                <h2>Phone</h2>\r\n");
      out.write("            </td>\r\n");
      out.write("            <td class=\"Value\">\r\n");
      out.write("                <p>");
      out.print(student.getPhone().getPhone());
      out.write("</p>\r\n");
      out.write("            </td>\r\n");
      out.write("            <td>\r\n");
      out.write("                <input type=\"number\" hidden name=\"phoneID\" value=\"");
      out.print(student.getPhone());
      out.write("\" />\r\n");
      out.write("                <input type=\"submit\" name=\"editPhone\" value=\"Edit Phone\" class=\"button\"/>\r\n");
      out.write("            </td>\r\n");
      out.write("            </tr>\r\n");
      out.write("        </form>\r\n");
      out.write("        <tr>\r\n");
      out.write("            <hr/>\r\n");
      out.write("        </tr>\r\n");
      out.write("    </table>\r\n");
      out.write("    ");
}catch(Exception e){
                        e.printStackTrace();
                }
      out.write("\r\n");
      out.write("</main>\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("</html>");
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
