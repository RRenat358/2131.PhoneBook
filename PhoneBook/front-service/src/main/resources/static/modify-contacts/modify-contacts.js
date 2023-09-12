angular.module('phonebook-front').controller('modifyContactsController', function ($scope, $http) {
    const contextPath = 'http://localhost:5555/core/api/v1';


    $scope.clientId = "";
    $scope.clientName = "";
    $scope.sendClientId = "";
    $scope.loadClient = function () {
        if ($scope.sendClientId > 0) {
            $http.get(contextPath + '/clients/' + $scope.sendClientId)
                .then(function (response) {
                    $scope.clientId = response.data.id;
                    $scope.clientName = response.data.name;

                    // $scope.loadClientById = response.data;

                    $scope.loadAllEmailByClientId();
                    $scope.loadAllPhoneByClientId();

                });
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


});