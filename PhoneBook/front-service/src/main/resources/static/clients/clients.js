angular.module('phonebook-front').controller('clientsController', function ($scope, $http, $location) {
    const contextPath = 'http://localhost:5555/core/api/v1';


    $scope.loadClients = function () {
        $http.get(contextPath + '/clients')
            .then(function (response) {
                $scope.AllClients = response.data;
            });
    }


    $scope.clientId = 0;
    $scope.sendClientId = function (sendClientId) {
        $scope.clientId = sendClientId;
        $scope.loadAllEmailByClientId();
        $scope.loadAllPhoneByClientId();
    }

    $scope.loadAllEmailByClientId = function () {
        $http.get(contextPath + '/clients/' + $scope.clientId + '/email')
            .then(function (response) {
                $scope.AllEmailByClientId = response.data;
            });
    }

    $scope.loadAllPhoneByClientId = function () {
        $http.get(contextPath + '/clients/' + $scope.clientId + '/phone')
            .then(function (response) {
                $scope.AllPhoneByClientId = response.data;
            });
    }




    $scope.loadClients();
    $scope.loadAllEmailByClientId();
    $scope.loadAllPhoneByClientId();

});