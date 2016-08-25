<%@page import="com.schoeninteriros.model.Users"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="resources/js/angular.min.js"></script>
<script src="resources/controller/homecontroller.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body ng-app="myApp" ng-controller="myCtrl">
${sessionScope.user}
<input type="hidden" ng-model="user" value="${sessionScope.user}" name="user">
	<div ng-if="checkSession(user)">
		<a href="/schoeninteriros/login">Login</a> <a
			href="/schoeninteriros/signup">signup</a>
			<a
			href="/schoeninteriros/editProfilePage">Edit Profile</a>
			</div>
	</div>
</body>
</html>