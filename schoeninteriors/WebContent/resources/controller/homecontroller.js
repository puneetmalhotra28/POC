var app = angular.module('myApp', []);
app.controller('myCtrl', function($scope, $http) {
	$scope.user = null;

	$scope.checkSession = function() {
		if (document.getElementById('user').value != null
				&& document.getElementById('user').value != "") {
			$scope.user = document.getElementById('user').value;
			return true;
		}
		return false;
	}
});
