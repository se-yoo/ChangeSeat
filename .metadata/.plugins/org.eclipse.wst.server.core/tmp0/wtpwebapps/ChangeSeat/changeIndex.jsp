<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta content="text/html; charset=UTF-8">
<title></title>
 <link rel="stylesheet" href="changeIndexStyle.css">
</head>
<body>
	<h1 class="header">
    	자리바꾸기
  	</h1>
  	<%
  		String id = (String)session.getAttribute("id");
  		if(id==null){
  	%>
  	<div id="logout">
  		<p>현재는 <span>비회원</span> 상태입니다.<br>더 많은 서비스를 원하신다면</p><br>
  		<a href="login.jsp"><button>LOGIN</button></a>
  	</div>
  		<%}else{%>
  	<div id="login">
  		<p><span><%= id %></span>님의 학급의 자리를 변경해보세요!</p><br>
  		<a href="change.jsp"><button>CHANGE</button></a><br><br>
  		<a href="logout.jsp" class="logoutLink">LOGOUT</a>
  	</div>	
  	<%}
  	%>
</body>
</html>