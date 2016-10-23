angular.module('enderecoCtrl', [])
    .controller('enderecoController', ['$scope', '$state', 'enderecoService', function ($scope, $state, enderecoService) {
        $scope.enderecos = enderecoService.getEndereco();

        $scope.addEndereco = function () {
            $scope.submitted = true;
            console.log($scope.endereco);

            enderecoService.createEndereco($scope.endereco, function () {
                console.log(enderecoService.getEndereco());
            });
            $scope.endereco = {};
            $scope.submitted = false;
        };

        $scope.deleteEndereco = function (endereco) {
            enderecoService.removeEndereco(endereco, function (data) {
                $scope.enderecos = enderecoService.getEndereco();
            });

            $scope.enderecos = enderecoService.getEndereco();
        }

        $scope.getCurrentEndereco = function (dataEndereco) {
            $scope.isEdit = true;
            var data = dataEndereco;
            $scope.endereco = data;
        }

        $scope.editEndereco = function () {
            enderecoService.updateEndereco($scope.endereco, function (data) {
                console.log(enderecoService.getEndereco());
            });

            $scope.setEdit();
            $scope.endereco = {};
        }
        $scope.setEdit = function () {
            $scope.isEdit = false;
        }
    }]);