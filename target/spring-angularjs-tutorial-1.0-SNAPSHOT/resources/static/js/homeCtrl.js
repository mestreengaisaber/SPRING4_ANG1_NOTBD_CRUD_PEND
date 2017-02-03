var app = angular.module("app", []);
 
app.constant('CONFIG', {
	APIURL: "/films",
	HOMEPATH: "#/home",
})


app.controller('homeCtrl', ['$scope','CONFIG', function($scope, CONFIG)
{
    console.log(CONFIG.APIURL);
        //todas las variables tienen que estar en el ambito del scope .
    var vm = this;
    vm.test = CONFIG.APIURL;
        //$scope.test=CONFIG.APIURL;
}]);


