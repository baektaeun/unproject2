<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date"%>    
<%
	String title = (String)request.getAttribute("title");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<link rel="stylesheet" type="text/css" href="fotune.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
	<link href="assets/css/bootstrap-responsive.css" rel="stylesheet">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
</head>
<body>
<header class="w3-container w3-center w3-padding-32"> 
  <h1 style="bold"><a href="fortuneMain.jsp" >Fortune For All</a></h1>
   <p>Welcome to the Fortune After Board of <span class="w3-tag">Fortune Cafe</span></p>
</header>

<table class="table">
	<thead>
	<tr>
		<th>No</th>
		<th>Title</th>
		<th>Writer</th>
		<th>Date</th>
	</tr>
	</thead>
	<tbody>
	<tr>
	<%
		
	%>
		<td>1</td>
		<td><a href="data.jsp">hihi</a></td>
		<td>범구님</td>
		<td>2017-08-24</td>
		
	</tr>
	</tbody>
	
</table>
	<p align="right">
	<button type="button" onclick="location.href='data.jsp'">Write</button>
	</p>	
	<p align="center">
	<select name="search">
		<option value="1">Writer</option>
 		<option value="2">Title</option>
 		<option value="3">Content</option>
	</select>
	<input type="text">
	<button type="button">확인</button>
	</p>
	
	<div class="text-center">
		<ul class="pagination">
			<li><a href="#"><</a></li>
			<li><a href="#">1</a></li>
			<li><a href="#">2</a></li>
			<li><a href="#">3</a></li>
			<li><a href="#">4</a></li>
			<li><a href="#">5</a></li>
			<li><a href="#">></a></li>
		</ul>
	</div>
</head>
<body>

</body>
</html>