<%@page import="com.fortuneforall.member.domain.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%
 	Member m = (Member)request.getAttribute("member");
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	
	<!-- 합쳐지고 최소화된 최신 CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	
	<!-- 부가적인 테마 -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
	
	<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
	<style>
		form {
			text-align: center;
		}
	</style>
</head>


<body>
<%@ include file="/jsp/common/top.jsp" %>  
  <div class="container">
  	<div class="jumbotron">
   	 <h1 style="text-align:center;">모두의 운세</h1>
	<form action="/FortuneForAll/com.fortuneforall.common.controller/commonbirthfortunecontroller">
	<br><br><br>
	<font size="5" >생년월일을 입력하세요</font><br>
	 <c:choose>
	<c:when test="${empty login}">
      <input type="text" name="date" value="yyyy-mm-dd">
	</c:when>	
	<c:otherwise>
      <input type="text" name="date" value="${member.userBirth}">
	</c:otherwise>	
	</c:choose>
	<br>
	<br><br><br><br>
	<p align="center">
	<button name="info" value="${member.userGender}-${member.userCalender}">결과 확인</button>
	</p>
	</form>
 	</div>
  </div>
</body>
</html>