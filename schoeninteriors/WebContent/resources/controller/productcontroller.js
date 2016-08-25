var app = angular.module('myApp', []);
app.controller('myCtrl', function($scope, $http) {
	$http.get("/schoeninteriros/viewProduct").then(function(response) {
		$scope.products = response.data;
	});
});
