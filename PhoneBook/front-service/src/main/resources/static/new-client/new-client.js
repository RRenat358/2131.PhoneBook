angular.module('phonebook-front').controller('newClientController', function ($scope, $http) {
    const contextPath = 'http://localhost:5555/core/api/v1';




    //============================================================
    $scope.saveNewClient = function () {
        // console.log($scope.newProduct);
        $http.post(contextPath + '/clients', $scope.newClient)
            .then(function (response) {
                $scope.loadClient = response.data;
            });
    }




});