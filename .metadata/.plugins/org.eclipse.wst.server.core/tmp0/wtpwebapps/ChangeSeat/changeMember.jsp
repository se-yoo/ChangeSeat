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
<title></title>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<link rel="stylesheet" href="changeStyle.css">
</head>
<body>
	<%
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
	%>
	<form>
		분단 수
		<input type="hidden" id="student" value="<%=stuCnt%>">
		<input type="hidden" id="studenteye" value="<%=stuEyesight%>">
		<input type="radio" name="bundan" value="2" id="2bundan" checked><label for="2bundan">2분단</label>
		<input type="radio" name="bundan" value="3" id="3bundan"><label for="3bundan">3분단</label>
		<input type="radio" name="bundan" value="4" id="4bundan"><label for="4bundan">4분단</label>
		<%
		for(int i=0;i<stuCnt;i++){%>
			<input type="hidden" id="num<%=i+1 %>" value="<%=stu.get(i).num%>">
			<input type="hidden" id="name<%=i+1 %>" value="<%=stu.get(i).name%>">
			<input type="hidden" id="eye<%=i+1 %>" value="<%=stu.get(i).eye%>">
		<%}%>
		<input type="button" value="자리바꾸기" id="bt">
	</form>
	<div id="tableBox">
		<table border="0" cellpadding="10" cellspacing="5">
			<%
				int a = 0;
				int row=stuCnt/4;
				if(stuCnt%4>0)row++;
				
				for (int i = 0; i < row; i++) {
			%>
			<tr>
				<%
					for (int j = 0; j < 5; j++) {
						if (j == 2) out.println("<td width='3%' class='empty'></td>");
						else{
							out.println("<td width='24%' class='desk'><b>"+stu.get(a).num+"</b>번&nbsp;&nbsp;&nbsp;<span>" + stu.get(a++).name + "</span></td>");
						}
						if(a==stuCnt)break;
					}
				%>
			</tr>
			<%
				}
			%>
		</table>
	</div>
</body>
<script>
$(document).on('click','#bt',function(){
		var cnt = document.getElementById("student").value;
		var eyeCnt= document.getElementById("studenteye").value;
		var bundan=$('input[name="bundan"]:checked').val();
		
		var eyeScope= (eyeCnt%(bundan*2)>0)? eyeScope=parseInt(eyeCnt/(bundan*2))+1 : eyeScope=parseInt(eyeCnt/(bundan*2));//시력 안좋은 사람들 범위(열)
		console.log(eyeScope);
		
		var info=new Array(cnt);
		
		for (i = 0; i < cnt; i++) {
			info[i]=new Array(3);
			info[i][0] = document.getElementById("num"+(i+1)).value;
			info[i][1] = document.getElementById("name"+(i+1)).value;
			info[i][2] = document.getElementById("eye"+(i+1)).value;
		}
		for (i = 0; i < 100; i++) {
			var randNum1 = Math.floor(Math.random() * cnt);
			var randNum2 = Math.floor(Math.random() * cnt);
			var tmp = info[randNum1];
			info[randNum1] = info[randNum2];
			info[randNum2] = tmp;
		}
		for(i=0;i<cnt;i++){
			if(info[i][2]=="true"){
				while(true){
					var randNum = Math.floor(Math.random() * (eyeScope*bundan*2));
					if(info[randNum][2]=="false"){
						var tmp = info[i];
						info[i] = info[randNum];
						info[randNum] = tmp;
						break;
					}
				}
			}
		}
		
		result = "<table border='0' cellpadding='10' cellspacing='5'>";
		var row = Math.ceil(cnt / (bundan*2));
		var a = 0;

		for (i = 0; i < row; i++) {
			result += "<tr>";
			for (j = 0; j < bundan*2+(bundan-1); j++) {
				if (a > cnt - 1) {
					result += "</tr>";
					break;
				}
				if (j % 3 == 2)
					result += "<td width='3%' class='empty'></td>";
				else
					result += "<td width='"+(100/(bundan*2)-1)+"%' class='desk'><b>"+info[a][0]+"</b>번&nbsp;&nbsp;&nbsp;<span>"
							+info[a++][1]+ "</span></td>";
			}
			result += "</tr>";
		}
		result += "</table>";
		document.getElementById("tableBox").innerHTML = result;
		if(row>6){
			$("table").css("height","700px");
			$("td").css("padding","0%");
		}
		if(bundan>2){
			$("table").css("width","1200px");
		}
	});
</script>
</html>