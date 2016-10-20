angular.module('moradorCtrl', [])
    .controller('moradorController', ['$scope', '$state', 'moradorService', function ($scope, $state, moradorService) {
        $scope.moradores = moradorService.getMorador();

        $scope.addMorador = function () {
            $scope.submitted = true;
            console.log($scope.morador);

            moradorService.createMorador($scope.morador, function () {
                console.log(moradorService.getMorador());
            });
            $scope.morador = {};
            $scope.submitted = false;
        };

        $scope.deleteMorador = function (morador) {
            moradorService.removeMorador(morador, function (data) {
                $scope.moradores = moradorService.getMorador();
            });

            $scope.moradores = moradorService.getMorador();
        }

        $scope.getCurrentMorador = function (dataMorador) {
            $scope.isEdit = true;
            var data = dataMorador;
            $scope.morador = data;
        }

        $scope.editMorador = function () {
            moradorService.updateMorador($scope.morador, function (data) {
                console.log(moradorService.getMorador());
            });

            $scope.setEdit();
            $scope.morador = {};
        }
        $scope.setEdit = function () {
            $scope.isEdit = false;
        }
    }]);