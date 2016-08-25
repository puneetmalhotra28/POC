<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="../../resources/js/angular.min.js"></script>
<script src="../../resources/controller/productcontroller.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body ng-app="myApp" ng-controller="myCtrl">
	<a href="/schoeninteriros/welcome">Home</a>
	<div ng-repeat="product in products">
		Product Name: {{product.productName}} <br /> 
		Product price: {{product.price}}
	</div>
</body>
</html>