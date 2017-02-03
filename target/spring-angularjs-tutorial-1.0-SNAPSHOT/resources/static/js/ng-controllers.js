//note: I am injecting the helloFac factory as an example
var ctrl = angular.module('controllers', []);

ctrl.controller('MyCtrl', ['$scope', 'helloFac', function($scope, helloFac) {
    $scope.mensaje=helloFac.sayHello('Angular developer');
}]);