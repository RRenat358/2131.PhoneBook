angular.module('phonebook-front').controller('modifyContactsController', function ($scope, $http) {
    const contextPath = 'http://localhost:5555/core/api/v1';


    $scope.clientId = "";
    $scope.clientName = "";
    $scope.sendClientId = "";



/*
    $scope.loadClient = function () {
        if ($scope.sendClientId > 0) {
            $http.get(contextPath + '/clients/' + $scope.sendClientId)
                .then(function (response) {
                    $scope.clientId = response.data.id;
                    $scope.clientName = response.data.name;

                    $scope.loadAllEmailByClientId();
                    $scope.loadAllPhoneByClientId();
                    $scope.sendClientId = "";
                });
        }
    }
*/

    $scope.loadClient = function () {
        if ($scope.sendClientId > 0) {
            $http.get(contextPath + '/clients/' + $scope.sendClientId)
                .then(function (response) {
                    console.log("==============");
                    console.log(response.status);
                    console.log("==============");

                    $scope.clientId = response.data.id;
                    $scope.clientName = response.data.name;
                    $scope.loadAllEmailByClientId();
                    $scope.loadAllPhoneByClientId();
                    $scope.sendClientId = "";


                });
        }
    }



/*
    $scope.loadClient = function () {
        if ($scope.sendClientId > 0) {
            $http.get(contextPath + '/clients/' + $scope.sendClientId)
                .then(function (response) {
            if (response.statusCode > 299) {
                console.log("==============");
                console.log(">299");
                console.log(response.statusCode);
                console.log("==============");
            }
            if (response.statusCode < 300) {
                $scope.clientId = response.data.id;
                $scope.clientName = response.data.name;
                console.log("==============");
                console.log("[" + $scope.clientId + "]");
                console.log("[" + $scope.clientName + "]");
                // console.log($scope.response.data);
                // console.log($scope.response.data.name);
                // console.log($scope.response.data.id);
                console.log("==============");

                $scope.loadAllEmailByClientId();
                $scope.loadAllPhoneByClientId();
                $scope.sendClientId = "";
            }


/*
        .then(function (response) {
                    $scope.clientId = response.data.id;
                    $scope.clientName = response.data.name;
                    console.log("==============");
                    console.log("[" + $scope.clientId + "]");
                    console.log("[" + $scope.clientName + "]");
                    // console.log($scope.response.data);
                    // console.log($scope.response.data.name);
                    // console.log($scope.response.data.id);
                    console.log("==============");

                    $scope.loadAllEmailByClientId();
                    $scope.loadAllPhoneByClientId();
                    $scope.sendClientId = "";
                });
*/
    /*
                }).on('error', function(e) {
                console.error(e);
            });

        }
    }
*/

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

    //============================================================

    $scope.isClientName = function () {
        if ($scope.clientName !== "") {
            return true;
        } else {
            return false;
        }
    };


    $scope.saveEmailByClientId = function () {
        // console.log($scope.newProduct);
        $http.post(contextPath + '/clients/' + $scope.clientId + '/email/' + $scope.address)
            .then(function (response) {
                $scope.loadAllEmailByClientId();
                $scope.address = "";
            });
    }

    $scope.savePhoneByClientId = function () {
        // console.log($scope.newProduct);
        $http.post(contextPath + '/clients/' + $scope.clientId + '/phone/' + $scope.number)
            .then(function (response) {
                $scope.loadAllPhoneByClientId();
                $scope.number = "";
            });
    }



});