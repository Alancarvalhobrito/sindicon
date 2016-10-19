angular.module('moradorCtrl', [])
    .controller('moradorController', ['$scope', '$state', 'moradorService', function ($scope, $state, moradorService) {
        $scope.moradores = moradorService.getmorador();
        $scope.moradores = moradorService.getmorador();

        $scope.addmorador = function () {
            $scope.submitted = true;
            console.log($scope.morador);

            moradorService.createmorador($scope.morador, function () {
                console.log(moradorService.getmorador());
            });
            $scope.morador = {};
            $scope.submitted = false;
        };

        $scope.deletemorador = function (morador) {
            moradorService.removemorador(morador, function (data) {
                $scope.moradores = moradorService.getmorador();
            });

            $scope.moradores = moradorService.getmorador();
        }

        $scope.getCurrentmorador = function (datamorador) {
            $scope.isEdit = true;
            var data = datamorador;
            $scope.morador = data;
        }

        $scope.editmorador = function () {
            moradorService.updatemorador($scope.morador, function (data) {
                console.log(moradorService.getmorador());
            });

            $scope.setEdit();
            $scope.morador = {};
        }
        $scope.setEdit = function () {
            $scope.isEdit = false;
        }
    }]);