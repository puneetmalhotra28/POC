var app = angular.module('myApp1', []);
app.controller('myCtrl1', function($scope, $http) {

	$scope.errors = [];
	$scope.user = {};
	
	$scope.validate = function(user){
		$scope.errors =[];
		if($scope.isEmpty(user.password)){
			$scope.errors.push("Password can't be empty");
		}
		if($scope.isEmpty(user.name)){
			$scope.errors.push("Name can't be empty");
		}
		if($scope.isEmpty(user.username)){
			$scope.errors.push("Username can't be empty");
		}
		if($scope.isEmpty(user.email)){
			$scope.errors.push("email can't be empty");
		}
		if($scope.isEmpty(user.reUserPass)){
			$scope.errors.push("Re-Password can't be empty");
		}else{
			if(user.password != user.reUserPass){
				$scope.errors.push("Password and Re-Password must be same");
			}
		}
		if($scope.isEmpty(user.phone)){
			$scope.errors.push("Phone can't be empty");
		}
		if($scope.errors.length != 0){
			return;
		}
		document.forms['myform'].submit();
	}
	
	$scope.isEmpty = function(string){
		if(string == "" || string == null || angular.isUndefined(string)){
			return true;
		}
		return false;
	}
});
