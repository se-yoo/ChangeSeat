/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.5
 * Generated at: 2018-06-28 13:25:57 UTC
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

public final class changeMember_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<title></title>\r\n");
      out.write("<script  src=\"http://code.jquery.com/jquery-latest.min.js\"></script>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"changeStyle.css\">\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t");

	String id = (String) session.getAttribute("id");
	
	class Student {
		int num;
		String name=" ";
		boolean isNow;
		boolean eye;

		Student(int num,String name, boolean isNow, boolean eye) {
			this.num=num;
			this.name = name;
			this.isNow = isNow;
			this.eye = eye;
		}
	}
	ArrayList<Student> stu = new ArrayList<Student>();

	int stuCnt = 0;
	int stuEyesight=0;

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
			int size=stuCnt;
			for (int i = 0; i < size; i++) {
				String n = parse.nextToken();
				boolean a = Boolean.parseBoolean(parse.nextToken());
				boolean b = Boolean.parseBoolean(parse.nextToken());
				if(!a){
					stu.add(new Student(i+1,n, a, b));//자퇴&전학갔으면 포함 안시키게
					if(b)stuEyesight++;
				}else{
					stuCnt--;//전학&자퇴면 전체 인원수도 줄어들게
				}
			}
		} catch (Exception e) {
			
		}
	}else{
		out.println("<script>alert('먼저 반 정보를 설정해주세요')</script>");
		out.println("<meta http-equiv='refresh' content='0; url=info.jsp'>");
	}
	
      out.write("\r\n");
      out.write("\t<form>\r\n");
      out.write("\t\t분단 수\r\n");
      out.write("\t\t<input type=\"hidden\" id=\"student\" value=\"");
      out.print(stuCnt);
      out.write("\">\r\n");
      out.write("\t\t<input type=\"hidden\" id=\"studenteye\" value=\"");
      out.print(stuEyesight);
      out.write("\">\r\n");
      out.write("\t\t<input type=\"radio\" name=\"bundan\" value=\"2\" id=\"2bundan\" checked><label for=\"2bundan\">2분단</label>\r\n");
      out.write("\t\t<input type=\"radio\" name=\"bundan\" value=\"3\" id=\"3bundan\"><label for=\"3bundan\">3분단</label>\r\n");
      out.write("\t\t<input type=\"radio\" name=\"bundan\" value=\"4\" id=\"4bundan\"><label for=\"4bundan\">4분단</label>\r\n");
      out.write("\t\t");

		for(int i=0;i<stuCnt;i++){
      out.write("\r\n");
      out.write("\t\t\t<input type=\"hidden\" id=\"num");
      out.print(i+1 );
      out.write("\" value=\"");
      out.print(stu.get(i).num);
      out.write("\">\r\n");
      out.write("\t\t\t<input type=\"hidden\" id=\"name");
      out.print(i+1 );
      out.write("\" value=\"");
      out.print(stu.get(i).name);
      out.write("\">\r\n");
      out.write("\t\t\t<input type=\"hidden\" id=\"eye");
      out.print(i+1 );
      out.write("\" value=\"");
      out.print(stu.get(i).eye);
      out.write("\">\r\n");
      out.write("\t\t");
}
      out.write("\r\n");
      out.write("\t\t<input type=\"button\" value=\"자리바꾸기\" id=\"bt\">\r\n");
      out.write("\t</form>\r\n");
      out.write("\t<div id=\"tableBox\">\r\n");
      out.write("\t\t<table border=\"0\" cellpadding=\"10\" cellspacing=\"5\">\r\n");
      out.write("\t\t\t");

				int a = 0;
				int row=stuCnt/4;
				if(stuCnt%4>0)row++;
				
				for (int i = 0; i < row; i++) {
			
      out.write("\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t");

					for (int j = 0; j < 5; j++) {
						if (j == 2) out.println("<td width='3%' class='empty'></td>");
						else{
							out.println("<td width='24%' class='desk'><b>"+stu.get(a).num+"</b>번&nbsp;&nbsp;&nbsp;<span>" + stu.get(a++).name + "</span></td>");
						}
						if(a==stuCnt)break;
					}
				
      out.write("\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t");

				}
			
      out.write("\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t</div>\r\n");
      out.write("</body>\r\n");
      out.write("<script>\r\n");
      out.write("$(document).on('click','#bt',function(){\r\n");
      out.write("\t\tvar cnt = document.getElementById(\"student\").value;\r\n");
      out.write("\t\tvar eyeCnt= document.getElementById(\"studenteye\").value;\r\n");
      out.write("\t\tvar bundan=$('input[name=\"bundan\"]:checked').val();\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tvar eyeScope= (eyeCnt%(bundan*2)>0)? eyeScope=parseInt(eyeCnt/(bundan*2))+1 : eyeScope=parseInt(eyeCnt/(bundan*2));//시력 안좋은 사람들 범위(열)\r\n");
      out.write("\t\tconsole.log(eyeScope);\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tvar info=new Array(cnt);\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tfor (i = 0; i < cnt; i++) {\r\n");
      out.write("\t\t\tinfo[i]=new Array(3);\r\n");
      out.write("\t\t\tinfo[i][0] = document.getElementById(\"num\"+(i+1)).value;\r\n");
      out.write("\t\t\tinfo[i][1] = document.getElementById(\"name\"+(i+1)).value;\r\n");
      out.write("\t\t\tinfo[i][2] = document.getElementById(\"eye\"+(i+1)).value;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tfor (i = 0; i < 100; i++) {\r\n");
      out.write("\t\t\tvar randNum1 = Math.floor(Math.random() * cnt);\r\n");
      out.write("\t\t\tvar randNum2 = Math.floor(Math.random() * cnt);\r\n");
      out.write("\t\t\tvar tmp = info[randNum1];\r\n");
      out.write("\t\t\tinfo[randNum1] = info[randNum2];\r\n");
      out.write("\t\t\tinfo[randNum2] = tmp;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tfor(i=0;i<cnt;i++){\r\n");
      out.write("\t\t\tif(info[i][2]==\"true\"){\r\n");
      out.write("\t\t\t\twhile(true){\r\n");
      out.write("\t\t\t\t\tvar randNum = Math.floor(Math.random() * (eyeScope*bundan*2));\r\n");
      out.write("\t\t\t\t\tif(info[randNum][2]==\"false\"){\r\n");
      out.write("\t\t\t\t\t\tvar tmp = info[i];\r\n");
      out.write("\t\t\t\t\t\tinfo[i] = info[randNum];\r\n");
      out.write("\t\t\t\t\t\tinfo[randNum] = tmp;\r\n");
      out.write("\t\t\t\t\t\tbreak;\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tresult = \"<table border='0' cellpadding='10' cellspacing='5'>\";\r\n");
      out.write("\t\tvar row = Math.ceil(cnt / (bundan*2));\r\n");
      out.write("\t\tvar a = 0;\r\n");
      out.write("\r\n");
      out.write("\t\tfor (i = 0; i < row; i++) {\r\n");
      out.write("\t\t\tresult += \"<tr>\";\r\n");
      out.write("\t\t\tfor (j = 0; j < bundan*2+(bundan-1); j++) {\r\n");
      out.write("\t\t\t\tif (a > cnt - 1) {\r\n");
      out.write("\t\t\t\t\tresult += \"</tr>\";\r\n");
      out.write("\t\t\t\t\tbreak;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\tif (j % 3 == 2)\r\n");
      out.write("\t\t\t\t\tresult += \"<td width='3%' class='empty'></td>\";\r\n");
      out.write("\t\t\t\telse\r\n");
      out.write("\t\t\t\t\tresult += \"<td width='\"+(100/(bundan*2)-1)+\"%' class='desk'><b>\"+info[a][0]+\"</b>번&nbsp;&nbsp;&nbsp;<span>\"\r\n");
      out.write("\t\t\t\t\t\t\t+info[a++][1]+ \"</span></td>\";\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tresult += \"</tr>\";\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tresult += \"</table>\";\r\n");
      out.write("\t\tdocument.getElementById(\"tableBox\").innerHTML = result;\r\n");
      out.write("\t\tif(row>6){\r\n");
      out.write("\t\t\t$(\"table\").css(\"height\",\"700px\");\r\n");
      out.write("\t\t\t$(\"td\").css(\"padding\",\"0%\");\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif(bundan>2){\r\n");
      out.write("\t\t\t$(\"table\").css(\"width\",\"1200px\");\r\n");
      out.write("\t\t}\r\n");
      out.write("\t});\r\n");
      out.write("</script>\r\n");
      out.write("</html>");
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
