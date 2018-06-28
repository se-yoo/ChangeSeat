<%@page import="java.util.ArrayList"%>
<%@page import="java.io.File"%>
<%@page import="java.util.StringTokenizer"%>
<%@page import="java.io.FileReader"%>
<%@page import="java.io.BufferedReader"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta content="text/html; charset=UTF-8">
<link rel="stylesheet" href="infoStyle.css">
<title></title>
</head>
<body>
	<%
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
	%>


	<%
		} else {
			stuCnt = 20;
		}
	%>
	<div id="container">
		<button id="minusButton" onclick="minusStu()">-</button>
		<div class="value" id="cntDiv"><%=stuCnt%></div>
		<button id="plusButton" onclick="plusStu()">+</button>

		<input type="button" value="save" onclick="save()">
	</div>
	<form method="post" action="update.jsp" name="info">
		<div id="container2">
			<input type="hidden" id="stuCnt" name="stuCnt" value="<%=stuCnt%>">
			<%
				for (int i = 0; i < stuCnt; i++) {
			%>
			<div class="one" id="div<%=(i + 1)%>">
				<%
					if (isExists) {
				%>
				<span><%=(i + 1)%></span>번<input type="text" size="7"
					name="name<%=(i + 1)%>" class="n" value="<%=stu.get(i).name%>">
				<%
					if (stu.get(i).isNow) {
				%>
				<input type="checkbox" name="now" id="n<%=(i + 1)%>"
					value="<%=(i + 1)%>" class="che" checked><label
					for="n<%=(i + 1)%>">자퇴 및 전학</label>
				<%
					} else {
				%><input type="checkbox" name="now" id="n<%=(i + 1)%>"
					value="<%=(i + 1)%>" class="che"><label
					for="n<%=(i + 1)%>">자퇴 및 전학</label>
				<%
					}
					if (stu.get(i).eye) {
				%><input type="checkbox" name="eye"
					id="e<%=(i + 1)%>" value="<%=(i + 1)%>" class="che" checked><label
					for="e<%=(i + 1)%>">시력 안좋음</label>
				<%
					} else {
				%><input type="checkbox" name="eye" id="e<%=(i + 1)%>"
					value="<%=(i + 1)%>" class="che"><label for="e<%=(i + 1)%>">시력
					안좋음</label>
				<%
					}
						} else {
				%>
				<span><%=(i + 1)%></span>번<input type="text" size="7"
					name="name<%=(i + 1)%>" class="n" placeholder="이름"> <input
					type="checkbox" name="now" id="n<%=(i + 1)%>" value="<%=(i + 1)%>"
					class="che"><label for="n<%=(i + 1)%>">자퇴 및 전학</label> <input
					type="checkbox" name="eye" id="e<%=(i + 1)%>" value="<%=(i + 1)%>"
					class="che"><label for="e<%=(i + 1)%>">시력 안좋음</label><%
					}%>
			</div>
			<%
				}
			%>
		</div>
	</form>
</body>
<script>
	function minusStu() {
		var c = document.getElementById("cntDiv").innerHTML;
		c = parseInt(c, 10) - 1;
		if (c < 2) {
			alert("최소 두명의 학생이 있어야 합니다");
		} else {
			document.getElementById("cntDiv").innerHTML = c;
			document.getElementById("stuCnt").value = c;

			var container = document.getElementById("container2");
			container.removeChild(document.getElementById("div" + (c + 1)));
		}
	}
	function plusStu() {
		var c = document.getElementById("cntDiv").innerHTML;
		c = parseInt(c, 10) + 1;
		if (c > 40) {
			alert("최대 40명의 학생까지 가능합니다");
		} else {
			document.getElementById("cntDiv").innerHTML = c;
			document.getElementById("stuCnt").value = c;

			var div = document.createElement("div");
			div.className = "one";
			div.id = "div" + c;
			div.innerHTML = "<span>"
					+ c
					+ "</span>번<input type='text' size='7' name='name"+c+"' class='n' placeholder='이름'>"
					+ "<input type='checkbox' name='now' id='n"+c+"' value='"+c+"' class='che'><label for='n"+c+"'>자퇴 및 전학</label>"
					+ "<input type='checkbox' name='eye' id='n"+c+"' value='"+c+"' class='che'><label for='e"+c+"'>시력 안좋음</label>";

			var container = document.getElementById("container2");
			container.appendChild(div);
		}
	}
	function save() {
		document.info.submit();
	}
</script>