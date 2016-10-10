angular.module('homeCtrl', [])
    .controller('homeController', ['$scope', function ($scope) {
        $scope.date = '19/11/1993';

        $scope.clock = setInterval(function digital() {
            var date = new Date();
            var hour = date.getHours();
            var minute = date.getMinutes();
            var second = date.getSeconds();

            if (hour < 10) {
                hour = "0" + hour;
            }
            if (minute < 10) {
                minute = "0" + minute;
            }
            if (second < 10) {
                second = "0" + second;
            }
            document.getElementById("clock").innerHTML = hour + ":" + minute + ":" + second;
        },10);
    }]);