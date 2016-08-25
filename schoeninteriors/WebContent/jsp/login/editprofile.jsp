 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<link rel="stylesheet" type="text/css" href="resources/css/style.css" />
<script src="resources/js/angular.min.js"></script>
<script src="resources/js/prefixfree.min.js"></script>
<script src="resources/controller/editprofilecontroller.js"></script>

</head>

<body ng-app="editprofileapp" ng-controller="editctrl">

	<div class="body"></div>
	<div class="grad"></div>
	<div class="header">
		<div>
			Schoen<span>Interiors</span>
		</div>
	</div>
	<br>
	<div class="login">
		<p>${information}</p>
		<p class="error">${error}</p>
		<p class="error" ng-if="error != null" ng-repeat="error in errors">{{error}}</p>
		<form action="/schoeninteriros/updateProfile" method="post" name="myform">
			<input type="text" placeholder="username" name="username" title="username" ng-model="user.username" disabled="disabled">
			<input type="text" placeholder="name" name="name" title="name" ng-model="user.name">
				<input type="text" placeholder="address" name="address" title="address" ng-model="user.address" value="userData.address">
			<input type="text" placeholder="email" name="email" title="email" ng-model="user.email" value="userData.email">
			<input type="text" placeholder="phone" name="phone" title="phone" ng-model="user.phone" value="userData.phone">
			<input type="password" placeholder="password" name="password" title="password" ng-model="user.password">
			<input type="password" placeholder="re-password" name="reUserPass" title="re-password" ng-model="user.reUserPass">
			<input type="button" value="Update" ng-click="validate(user)"><br /> <br/><a
				href="/schoeninteriros/welcome" class="text" />Home</a>
		</form>
	</div>
	<script
		src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>





</body>
</html>