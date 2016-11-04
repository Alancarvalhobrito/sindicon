angular.module('veiculoCtrl', [])
    .controller('veiculoController', ['$scope', '$state', 'veiculoService','moradorService', function ($scope, $state, veiculoService,moradorService) {
        $scope.veiculos = veiculoService.getVeiculo();
    $scope.moradores = moradorService.getMorador();
        $scope.addVeiculo = function () {
            $scope.submitted = true;
            console.log($scope.veiculo);

            veiculoService.createVeiculo($scope.veiculo, function () {
                console.log(veiculoService.getVeiculo());
            });
            $scope.veiculo = {};
            $scope.submitted = false;
        };

        $scope.deleteVeiculo = function (veiculo) {
            veiculoService.removeVeiculo(veiculo, function (data) {
                $scope.veiculos = veiculoService.getVeiculo();
            });

            $scope.veiculos = veiculoService.getVeiculo();
        }

        $scope.getCurrentVeiculo = function (dataVeiculo) {
            $scope.isEdit = true;
            var data = dataVeiculo;
            $scope.veiculo = data;
        }

        $scope.editVeiculo = function () {
            veiculoService.updateVeiculo($scope.veiculo, function (data) {
                console.log(veiculoService.getVeiculo());
            });

            $scope.setEdit();
            $scope.veiculo = {};
        }
        $scope.setEdit = function () {
            $scope.isEdit = false;
        }
    }]);
