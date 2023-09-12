angular.module('phonebook-front').controller('modifyContactsController', function ($scope, $http) {
    const contextPath = 'http://localhost:5555/core/api/v1';


    $scope.clientId = "";
    $scope.clientName = "";
    $scope.sendClientId = "";
    $scope.loadClient = function () {
        $http.get(contextPath + '/clients/' + $scope.sendClientId)
            .then(function (response) {
                $scope.clientId = response.data.id;
                $scope.clientName = response.data.name;

                // $scope.loadClientById = response.data;

            });
    }







});