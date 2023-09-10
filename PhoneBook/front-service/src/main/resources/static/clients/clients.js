angular.module('phonebook-front').controller('clientsController', function ($scope, $http, $location) {
    const contextPath = 'http://localhost:5555/core/api/v1';


    $scope.loadClients = function () {
        $http.get(contextPath + '/clients')
            .then(function (response) {
                $scope.AllClients = response.data;
            });
    }



    $scope.loadClients();

});