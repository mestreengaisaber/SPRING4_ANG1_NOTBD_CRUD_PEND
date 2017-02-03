var app = angular.module('films', [ "ngResource" ]);

app.constant('CONFIG', {
	urlGETPOST: "/films",
	HOMEPATH: "#/home",
})

app.controller('FilmsController', [ '$scope', '$http','CONFIG',
               	function($scope, $http,CONFIG) {
                var vm = this;
                
                /*vm.model = {
                    title:null,    
                    year: null,
                    director: null
                };*/
             
                
		$scope.getFilms = function() {
                    //accedemos a la url /films de las constantes 
			$http.get(CONFIG.urlGETPOST).success(function(data) {
				$scope.films = data;
                                
			});
		}
		
		$scope.addFilm = function() {
                    vm.testee=$scope.model;
                    $http.post(CONFIG.urlGETPOST, vm.testee
				/*{
                               //angular.copy(model, $scope.model);
                               model: vm.model
					/*title : $scope.model.title,
					year : $scope.model.year,
					director : $scope.model.director
				}*/
			).success(function(data) {
                             console.log("data es"+$scope.data)
                            $scope.msg = 'Pelicula creada correctamente';
                            $scope.getFilms();
			}).error(function(data) {
                            $scope.msg = 'Se ha producido un error';
			});
		}

} ]);