angular.module('phonebook-front').controller('newClientController', function ($scope, $http) {
    const contextPath = 'http://localhost:5555/core/api/v1';

    $scope.newClient = undefined;

    $scope.saveNewClient = function () {
        if ($scope.newClient === undefined || $scope.newClient.name === "") {
            return;
        }
        $http.post(contextPath + '/clients', $scope.newClient)
            .then(function (response) {
                $scope.loadClient = response.data;
                $scope.newClient.name = "";
            });
    }



});