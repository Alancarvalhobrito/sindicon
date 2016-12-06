angular.module('pessoaCtrl', [])
    .controller('pessoaController', ['$scope', '$state', 'pessoaService', 'enderecoService', function ($scope, $state, pessoaService, enderecoService) {
        $scope.pessoas = pessoaService.getPessoa();
        $scope.enderecos = enderecoService.getEndereco();
        $scope.addPessoa = function () {
            $scope.submitted = true;
            console.log($scope.pessoa);

            pessoaService.createPessoa($scope.pessoa, function () {
                console.log(pessoaService.getPessoa());
            });
            $scope.pessoa = {};
            $scope.submitted = false;
        };

        $scope.deletePessoa = function (pessoa) {
            pessoaService.removePessoa(pessoa, function (data) {
                $scope.pessoas = pessoaService.getPessoa();
            });

            $scope.pessoas = pessoaService.getPessoa();
        }

        $scope.getCurrentPessoa = function (dataPessoa) {
            $scope.isEdit = true;
            var data = dataPessoa;
            $scope.pessoa = data;
        }

        $scope.editPessoa = function () {
            pessoaService.updatePessoa($scope.pessoa, function (data) {
                console.log(pessoaService.getPessoa());
            });

            $scope.setEdit();
            $scope.pessoa = {};
        }
        $scope.setEdit = function () {
            $scope.isEdit = false;
        }
    }]);
