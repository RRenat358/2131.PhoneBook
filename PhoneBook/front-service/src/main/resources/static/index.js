//============================================================
(function () {
    angular
        .module('phonebook-front', ['ngRoute', 'ngStorage'])
        .config(config);

    function config($routeProvider) {
        $routeProvider
            .when('/', {
                templateUrl: 'home/home.html',
                controller: 'homeController'
            })
            .when('/clients', {
                templateUrl: 'clients/clients.html',
                controller: 'clientsController'
            })
            .otherwise({
                redirectTo: '/'
            });
    }




})();


//============================================================
//============================================================
angular.module('phonebook-front').controller('indexController', function ($rootScope, $scope, $http, $location, $localStorage) {
    // const contextPath = 'http://localhost:8189/app/api/v1/';




});