/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.5
 * Generated at: 2018-06-28 12:41:33 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import java.io.File;
import java.util.StringTokenizer;
import java.io.FileReader;
import java.io.BufferedReader;

public final class infoMember_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.util.StringTokenizer");
    _jspx_imports_classes.add("java.io.FileReader");
    _jspx_imports_classes.add("java.io.BufferedReader");
    _jspx_imports_classes.add("java.io.File");
    _jspx_imports_classes.add("java.util.ArrayList");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"infoStyle.css\">\r\n");
      out.write("<title></title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t");

		String id = (String) session.getAttribute("id");
		class Student {
			String name=" ";
			boolean isNow;
			boolean eye;

			Student(String name, boolean isNow, boolean eye) {
				this.name = name;
				this.isNow = isNow;
				this.eye = eye;
			}
		}
		ArrayList<Student> stu = new ArrayList<Student>();

		int stuCnt = 0;

		File file = new File(application.getRealPath("/WEB-INF/" + id + ".txt"));
		boolean isExists = file.exists();
		if (isExists) {
			try {
				String filePath = application.getRealPath("/WEB-INF/" + id + ".txt");
				BufferedReader reader = new BufferedReader(new FileReader(filePath));
				String csvStr = "";
				String tmpStr = "";

				do {
					tmpStr = reader.readLine();
					if (tmpStr != null) {
						csvStr += tmpStr + "/";
						stuCnt++;
					}
				} while (tmpStr != null);
				StringTokenizer parse = new StringTokenizer(csvStr, "/");
				for (int i = 0; i < stuCnt; i++) {
					String n = parse.nextToken();
					boolean a = Boolean.parseBoolean(parse.nextToken());
					boolean b = Boolean.parseBoolean(parse.nextToken());
					stu.add(new Student(n, a, b));
				}
			} catch (Exception e) {

			}
	
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t");

		} else {
			stuCnt = 20;
		}
	
      out.write("\r\n");
      out.write("\t<div id=\"container\">\r\n");
      out.write("\t\t<button id=\"minusButton\" onclick=\"minusStu()\">-</button>\r\n");
      out.write("\t\t<div class=\"value\" id=\"cntDiv\">");
      out.print(stuCnt);
      out.write("</div>\r\n");
      out.write("\t\t<button id=\"plusButton\" onclick=\"plusStu()\">+</button>\r\n");
      out.write("\r\n");
      out.write("\t\t<input type=\"button\" value=\"save\" onclick=\"save()\">\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<form method=\"post\" action=\"update.jsp\" name=\"info\">\r\n");
      out.write("\t\t<div id=\"container2\">\r\n");
      out.write("\t\t\t<input type=\"hidden\" id=\"stuCnt\" name=\"stuCnt\" value=\"");
      out.print(stuCnt);
      out.write("\">\r\n");
      out.write("\t\t\t");

				for (int i = 0; i < stuCnt; i++) {
			
      out.write("\r\n");
      out.write("\t\t\t<div class=\"one\" id=\"div");
      out.print((i + 1));
      out.write("\">\r\n");
      out.write("\t\t\t\t");

					if (isExists) {
				
      out.write("\r\n");
      out.write("\t\t\t\t<span>");
      out.print((i + 1));
      out.write("</span>번<input type=\"text\" size=\"7\"\r\n");
      out.write("\t\t\t\t\tname=\"name");
      out.print((i + 1));
      out.write("\" class=\"n\" value=\"");
      out.print(stu.get(i).name);
      out.write("\">\r\n");
      out.write("\t\t\t\t");

					if (stu.get(i).isNow) {
				
      out.write("\r\n");
      out.write("\t\t\t\t<input type=\"checkbox\" name=\"now\" id=\"n");
      out.print((i + 1));
      out.write("\"\r\n");
      out.write("\t\t\t\t\tvalue=\"");
      out.print((i + 1));
      out.write("\" class=\"che\" checked><label\r\n");
      out.write("\t\t\t\t\tfor=\"n");
      out.print((i + 1));
      out.write("\">자퇴 및 전학</label>\r\n");
      out.write("\t\t\t\t");

					} else {
				
      out.write("<input type=\"checkbox\" name=\"now\" id=\"n");
      out.print((i + 1));
      out.write("\"\r\n");
      out.write("\t\t\t\t\tvalue=\"");
      out.print((i + 1));
      out.write("\" class=\"che\"><label\r\n");
      out.write("\t\t\t\t\tfor=\"n");
      out.print((i + 1));
      out.write("\">자퇴 및 전학</label>\r\n");
      out.write("\t\t\t\t");

					}
					if (stu.get(i).eye) {
				
      out.write("<input type=\"checkbox\" name=\"eye\"\r\n");
      out.write("\t\t\t\t\tid=\"e");
      out.print((i + 1));
      out.write("\" value=\"");
      out.print((i + 1));
      out.write("\" class=\"che\" checked><label\r\n");
      out.write("\t\t\t\t\tfor=\"e");
      out.print((i + 1));
      out.write("\">시력 안좋음</label>\r\n");
      out.write("\t\t\t\t");

					} else {
				
      out.write("<input type=\"checkbox\" name=\"eye\" id=\"e");
      out.print((i + 1));
      out.write("\"\r\n");
      out.write("\t\t\t\t\tvalue=\"");
      out.print((i + 1));
      out.write("\" class=\"che\"><label for=\"e");
      out.print((i + 1));
      out.write("\">시력\r\n");
      out.write("\t\t\t\t\t안좋음</label>\r\n");
      out.write("\t\t\t\t");

					}
						} else {
				
      out.write("\r\n");
      out.write("\t\t\t\t<span>");
      out.print((i + 1));
      out.write("</span>번<input type=\"text\" size=\"7\"\r\n");
      out.write("\t\t\t\t\tname=\"name");
      out.print((i + 1));
      out.write("\" class=\"n\" placeholder=\"이름\"> <input\r\n");
      out.write("\t\t\t\t\ttype=\"checkbox\" name=\"now\" id=\"n");
      out.print((i + 1));
      out.write("\" value=\"");
      out.print((i + 1));
      out.write("\"\r\n");
      out.write("\t\t\t\t\tclass=\"che\"><label for=\"n");
      out.print((i + 1));
      out.write("\">자퇴 및 전학</label> <input\r\n");
      out.write("\t\t\t\t\ttype=\"checkbox\" name=\"eye\" id=\"e");
      out.print((i + 1));
      out.write("\" value=\"");
      out.print((i + 1));
      out.write("\"\r\n");
      out.write("\t\t\t\t\tclass=\"che\"><label for=\"e");
      out.print((i + 1));
      out.write("\">시력 안좋음</label>");

					}
      out.write("\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t");

				}
			
      out.write("\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</form>\r\n");
      out.write("</body>\r\n");
      out.write("<script>\r\n");
      out.write("\tfunction minusStu() {\r\n");
      out.write("\t\tvar c = document.getElementById(\"cntDiv\").innerHTML;\r\n");
      out.write("\t\tc = parseInt(c, 10) - 1;\r\n");
      out.write("\t\tif (c < 2) {\r\n");
      out.write("\t\t\talert(\"최소 두명의 학생이 있어야 합니다\");\r\n");
      out.write("\t\t} else {\r\n");
      out.write("\t\t\tdocument.getElementById(\"cntDiv\").innerHTML = c;\r\n");
      out.write("\t\t\tdocument.getElementById(\"stuCnt\").value = c;\r\n");
      out.write("\r\n");
      out.write("\t\t\tvar container = document.getElementById(\"container2\");\r\n");
      out.write("\t\t\tcontainer.removeChild(document.getElementById(\"div\" + (c + 1)));\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction plusStu() {\r\n");
      out.write("\t\tvar c = document.getElementById(\"cntDiv\").innerHTML;\r\n");
      out.write("\t\tc = parseInt(c, 10) + 1;\r\n");
      out.write("\t\tif (c > 40) {\r\n");
      out.write("\t\t\talert(\"최대 40명의 학생까지 가능합니다\");\r\n");
      out.write("\t\t} else {\r\n");
      out.write("\t\t\tdocument.getElementById(\"cntDiv\").innerHTML = c;\r\n");
      out.write("\t\t\tdocument.getElementById(\"stuCnt\").value = c;\r\n");
      out.write("\r\n");
      out.write("\t\t\tvar div = document.createElement(\"div\");\r\n");
      out.write("\t\t\tdiv.className = \"one\";\r\n");
      out.write("\t\t\tdiv.id = \"div\" + c;\r\n");
      out.write("\t\t\tdiv.innerHTML = \"<span>\"\r\n");
      out.write("\t\t\t\t\t+ c\r\n");
      out.write("\t\t\t\t\t+ \"</span>번<input type='text' size='7' name='name\"+c+\"' class='n' placeholder='이름'>\"\r\n");
      out.write("\t\t\t\t\t+ \"<input type='checkbox' name='now' id='n\"+c+\"' value='\"+c+\"' class='che'><label for='n\"+c+\"'>자퇴 및 전학</label>\"\r\n");
      out.write("\t\t\t\t\t+ \"<input type='checkbox' name='eye' id='n\"+c+\"' value='\"+c+\"' class='che'><label for='e\"+c+\"'>시력 안좋음</label>\";\r\n");
      out.write("\r\n");
      out.write("\t\t\tvar container = document.getElementById(\"container2\");\r\n");
      out.write("\t\t\tcontainer.appendChild(div);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction save() {\r\n");
      out.write("\t\tdocument.info.submit();\r\n");
      out.write("\t}\r\n");
      out.write("</script>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
