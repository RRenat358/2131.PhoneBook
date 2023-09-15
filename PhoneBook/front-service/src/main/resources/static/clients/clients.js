angular.module('phonebook-front').controller('clientsController', function ($scope, $http, $location) {
    const contextPath = 'http://localhost:5555/core/api/v1';

    $scope.clientId = "";
    $scope.clientName = "";
    $scope.AllEmailByClientId = "";
    $scope.AllPhoneByClientId = "";



    $scope.loadClients = function () {
        $http.get(contextPath + '/clients')
            .then(function (response) {
                $scope.AllClients = response.data;
            });
    }

    $scope.sendClientDetailsAndLoadAllContacts = function (sendClientId, sendClientName) {
        $scope.clientId = sendClientId;
        $scope.clientName = sendClientName;
        if ($scope.clientId > 0) {
            $scope.loadAllEmailByClientId();
            $scope.loadAllPhoneByClientId();
        }
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

    $scope.deleteClientById = function (clientIdForDel) {
        $http.delete(contextPath + '/clients/' + clientIdForDel)
            .then(function (response) {
                $scope.loadClients();
                // $scope.clientId.clear.data;
                // $scope.clientName.clear.data;
                // $scope.AllEmailByClientId.clear.data;
                // $scope.AllPhoneByClientId.clear.data;


            });
    }




    $scope.loadClients();

});