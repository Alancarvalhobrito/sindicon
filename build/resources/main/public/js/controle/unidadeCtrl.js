angular.module('unidadeCtrl', [])
    .controller('unidadeController', ['$scope', '$state', 'unidadeService', 'moradorService',function ($scope, $state, unidadeService,moradorService) {
        $scope.unidades = unidadeService.getUnidade();
        $scope.moradores = moradorService.getMorador();
        $scope.addUnidade = function () {
            $scope.submitted = true;
            console.log($scope.unidade);

            unidadeService.createUnidade($scope.unidade, function () {
                console.log(unidadeService.getUnidade());
            });
            $scope.unidade = {};
            $scope.submitted = false;
        };

        $scope.deleteUnidade = function (unidade) {
            unidadeService.removeUnidade(unidade, function (data) {
                $scope.unidades = unidadeService.getUnidade();
            });

            $scope.unidades = unidadeService.getUnidade();
        }

        $scope.getCurrentUnidade = function (dataUnidade) {
            $scope.isEdit = true;
            var data = dataUnidade;
            $scope.unidade = data;
        }

        $scope.editUnidade = function () {
            unidadeService.updateUnidade($scope.unidade, function (data) {
                console.log(unidadeService.getUnidade());
            });

            $scope.setEdit();
            $scope.unidade = {};
        }
        $scope.setEdit = function () {
            $scope.isEdit = false;
        }
    }]);
