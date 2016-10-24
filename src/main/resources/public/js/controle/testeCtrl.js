angular.module('testeCtrl', [])
    .controller('listaController', ['$scope', '$state', function ($scope, $state) {
            // define some random object
            $scope.bigData = {};

            $scope.bigData.breakfast = false;
            $scope.bigData.lunch = false;
            $scope.bigData.dinner = false;

            // COLLAPSE =====================
            $scope.isCollapsed = false;
    }]);
