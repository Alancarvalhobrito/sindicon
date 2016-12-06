angular.module('enderecoCtrl', [])
    .controller('enderecoController', ['$scope', '$state', 'enderecoService', 'pessoaService', function ($scope, $state, enderecoService, pessoaService) {
        $scope.enderecos = enderecoService.getEndereco();
        $scope.pessoas = pessoaService.getPessoa();

        $scope.addEndereco = function (endereco) {
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
