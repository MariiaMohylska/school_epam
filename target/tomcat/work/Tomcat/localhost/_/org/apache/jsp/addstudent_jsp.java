/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2020-07-14 03:09:39 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class addstudent_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE web-app\r\n");
      out.write("        PUBLIC \"-//Sun Microsystems, Inc.//DTD Web Application 2.3//EN\" \"http://java.sun.com/dtd/web-app_2_3.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("   <form method=\"post\" action=\"addStudent\">\r\n");
      out.write("   <table>\r\n");
      out.write("        <tr>\r\n");
      out.write("             <td>\r\n");
      out.write("                 Personal file Number:&#9;\r\n");
      out.write("             </td>\r\n");
      out.write("             <td>\r\n");
      out.write("                 <input type=\"text\" name=\"personalFile\">\r\n");
      out.write("             </td>\r\n");
      out.write("         </tr>\r\n");
      out.write("         <tr>\r\n");
      out.write("             <td>\r\n");
      out.write("                 Entry date : &#9;\r\n");
      out.write("              </td>\r\n");
      out.write("              <td>\r\n");
      out.write("                 <input type=\"date\" name=\"entryDate\">\r\n");
      out.write("             </td>\r\n");
      out.write("         </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("           <td>\r\n");
      out.write("                Surname: &#9;\r\n");
      out.write("            </td>\r\n");
      out.write("            <td>\r\n");
      out.write("                <input type=\"text\" name=\"surname\">\r\n");
      out.write("            </td>\r\n");
      out.write("         </tr>\r\n");
      out.write("       <tr>\r\n");
      out.write("          <td>\r\n");
      out.write("                Name: &#9;\r\n");
      out.write("          </td>\r\n");
      out.write("          <td>\r\n");
      out.write("                <input type=\"text\" name=\"name\">\r\n");
      out.write("          </td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("          <td>\r\n");
      out.write("                Father name: &#9;\r\n");
      out.write("          </td>\r\n");
      out.write("          <td>\r\n");
      out.write("                <input type=\"text\" name=\"fatherName\">\r\n");
      out.write("          </td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("          <td>\r\n");
      out.write("                Birth Date: &#9;\r\n");
      out.write("          </td>\r\n");
      out.write("          <td>\r\n");
      out.write("                <input type=\"date\" name=\"bDay\">\r\n");
      out.write("          </td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("          <td>\r\n");
      out.write("                Phone number: &#9;\r\n");
      out.write("          </td>\r\n");
      out.write("          <td>\r\n");
      out.write("                <input type=\"tel\" name=\"phone\">\r\n");
      out.write("          </td>\r\n");
      out.write("        </tr>\r\n");
      out.write("         <tr>\r\n");
      out.write("          <td>\r\n");
      out.write("                City: &#9;\r\n");
      out.write("          </td>\r\n");
      out.write("          <td>\r\n");
      out.write("                <input type=\"text\" name=\"city\">\r\n");
      out.write("          </td>\r\n");
      out.write("        </tr>\r\n");
      out.write("         <tr>\r\n");
      out.write("          <td>\r\n");
      out.write("                Street: &#9;\r\n");
      out.write("          </td>\r\n");
      out.write("          <td>\r\n");
      out.write("                <input type=\"text\" name=\"street\">\r\n");
      out.write("          </td>\r\n");
      out.write("        </tr>\r\n");
      out.write("         <tr>\r\n");
      out.write("          <td>\r\n");
      out.write("                House: &#9;\r\n");
      out.write("          </td>\r\n");
      out.write("          <td>\r\n");
      out.write("                <input type=\"text\" name=\"house\">\r\n");
      out.write("          </td>\r\n");
      out.write("        </tr>\r\n");
      out.write("         <tr>\r\n");
      out.write("          <td>\r\n");
      out.write("                Flat: &#9;\r\n");
      out.write("          </td>\r\n");
      out.write("          <td>\r\n");
      out.write("                <input type=\"text\" name=\"flat\">\r\n");
      out.write("          </td>\r\n");
      out.write("        </tr>\r\n");
      out.write("\r\n");
      out.write("        </table>\r\n");
      out.write("        <input type=\"submit\" value=\"Add\">\r\n");
      out.write("\r\n");
      out.write("   </form>\r\n");
      out.write("\r\n");
      out.write("\r\n");
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