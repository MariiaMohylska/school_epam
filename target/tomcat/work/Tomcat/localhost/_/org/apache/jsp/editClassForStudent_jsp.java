/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2020-07-17 10:22:36 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class editClassForStudent_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("                     <!DOCTYPE web-app\r\n");
      out.write("                             PUBLIC \"-//Sun Microsystems, Inc.//DTD Web Application 2.3//EN\" \"http://java.sun.com/dtd/web-app_2_3.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<title>Change Class</title>\r\n");
      out.write("<link href=\"css/style.css\" rel=\"stylesheet\" type=\"text/css\" media=\"all\"/>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1\">\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("<meta name=\"keywords\" content=\"Easy Contact Form  Responsive, Login form web template, Sign up Web Templates, Flat Web Templates, Login signup Responsive web template, Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design\" />\r\n");
      out.write("<!--web-fonts-->\r\n");
      out.write("<link href='//fonts.googleapis.com/css?family=Ubuntu:400,300,300italic,400italic,500,500italic,700,700italic' rel='stylesheet' type='text/css'>\r\n");
      out.write("<style>\r\n");
      out.write(" body{\r\n");
      out.write("        background-color: #5bb9b8;\r\n");
      out.write("        font-color: black;\r\n");
      out.write("     }\r\n");
      out.write("     table{\r\n");
      out.write("     background-color:#89d4e9;\r\n");
      out.write("     box-shadow: 0px 0px 50px 2px #488d8c;\r\n");
      out.write("     margin:auto;\r\n");
      out.write("     padding:3%;\r\n");
      out.write("      border-radius: 7px;\r\n");
      out.write("     }\r\n");
      out.write("     input{\r\n");
      out.write("       width:100%;\r\n");
      out.write("       background:#c8f4f4;\r\n");
      out.write("       border:2px solid #79c9c9;\r\n");
      out.write("     }\r\n");
      out.write("    .button {\r\n");
      out.write("    \tbackground-color:#5bb9b8;\r\n");
      out.write("            \tborder-radius:28px;\r\n");
      out.write("            \tborder:1px solid #89d4e9;\r\n");
      out.write("            \tdisplay:inline-block;\r\n");
      out.write("            \tcursor:pointer;\r\n");
      out.write("            \tcolor:#ffffff;\r\n");
      out.write("            \tfont-family:Arial;\r\n");
      out.write("            \tfont-size:17px;\r\n");
      out.write("            \tpadding:10px;\r\n");
      out.write("    }\r\n");
      out.write("    .button:hover {\r\n");
      out.write("    \tbackground-color:#5bb9a4;\r\n");
      out.write("      </style>\r\n");
      out.write("</head>\r\n");
      out.write("                     <body>\r\n");
      out.write("                     <table>\r\n");
      out.write("                        <form method=\"post\" action=\"editClassForStudent\">\r\n");
      out.write("                        <tr>\r\n");
      out.write("                        <td>\r\n");
      out.write("                        <p>Enter new class:</p>\r\n");
      out.write("                        </td>\r\n");
      out.write("                        <td>\r\n");
      out.write("                             <p>\r\n");
      out.write("                                <input type=\"text\" name=\"classNumber\">\r\n");
      out.write("                             </p>\r\n");
      out.write("                         </td>\r\n");
      out.write("                             <br/>\r\n");
      out.write("                        </tr>\r\n");
      out.write("                        <tr>\r\n");
      out.write("                        <td>\r\n");
      out.write("                        </td>\r\n");
      out.write("                        <td>\r\n");
      out.write("                             <input type=\"submit\" value=\"Edit\" class=\"button\">\r\n");
      out.write("                             </td>\r\n");
      out.write("                             </tr>\r\n");
      out.write("                        </form>\r\n");
      out.write("\r\n");
      out.write("</table>\r\n");
      out.write("                     </body>\r\n");
      out.write("\r\n");
      out.write("                     </html>");
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
