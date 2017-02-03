
/*var moduloConstante = angular.module("cons", [cons]);
 
moduloConstante.constant('CONFIG', {
	APIURL: "/films",
	HOMEPATH: "#/home",
})*/


var factories = angular.module("factories", []);

factories.factory('helloFac', function() {
    return {
        sayHello: function(text){
            return 'Hello ' + text;
        }
    }
});