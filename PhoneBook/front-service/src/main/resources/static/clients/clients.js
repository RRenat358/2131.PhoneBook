angular.module('phonebook-front').controller('clientsController', function ($scope, $http, $location) {
    const contextPath = 'http://localhost:5555/core/api/v1';


    $scope.loadClients = function () {
        $http.get(contextPath + '/clients')
            .then(function (response) {
                $scope.AllClients = response.data;
            });
    }



/*
    $scope.loadAllEmailByClientId = function (clientId) {
        $http.get(contextPath + '/clients/' + clientId)
            .then(function (response) {
                $scope.AllEmailByClientId = response.data;
            });
    }

    $scope.loadAllPhoneByClientId = function (clientId) {
        $http.get(contextPath + '/clients/' + clientId)
            .then(function (response) {
                $scope.AllPhoneByClientId = response.data;
            });
    }

*/

    $scope.loadAllEmailByClientId = function () {
        $http.get(contextPath + '/clients/' + 2 + '/email')
            .then(function (response) {
                $scope.AllEmailByClientId = response.data;
            });
    }

    $scope.loadAllPhoneByClientId = function () {
        $http.get(contextPath + '/clients/' + 2 + '/phone')
            .then(function (response) {
                $scope.AllPhoneByClientId = response.data;
            });
    }







    $scope.loadClients();
    $scope.loadAllEmailByClientId();
    $scope.loadAllPhoneByClientId();

});