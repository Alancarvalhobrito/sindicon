angular.module('moradorCtrl', [])
    .controller('moradorController', ['$scope', '$state', 'moradorService', 'unidadeService', 'blocoService', function ($scope, $state, moradorService, unidadeService, blocoService) {
        $scope.moradores = moradorService.getMorador();
        $scope.unidades = unidadeService.getUnidade();
        $scope.blocos = blocoService.getBloco();

        $scope.addMorador = function () {
            $scope.submitted = true;
            if ($scope.moradorForm.$invalid) {
                $scope.message = false;
                return;
            }
            console.log($scope.morador);

            moradorService.createMorador($scope.morador, function () {
                console.log(moradorService.getMorador());
            });
            $scope.message = true;
            $scope.morador = {};
            $scope.submitted = false;
            $scope.back = function () {
                $scope.message = false;
            };
        };

        $scope.deleteMorador = function (morador) {
            moradorService.removeMorador(morador, function (data) {
                $scope.moradores = moradorService.getMorador();
            });
            $scope.moradores = moradorService.getMorador();
        };

        $scope.getCurrentMorador = function (dataMorador) {
            $scope.isEdit = true;
            var data = dataMorador;
            $scope.morador = data;
        };

        $scope.editMorador = function () {
            moradorService.updateMorador($scope.morador, function (data) {
                console.log(moradorService.getMorador());
            });

            $scope.setEdit();
            $scope.morador = {};
        };
        $scope.setEdit = function () {
            $scope.isEdit = false;
        };
    }]);
