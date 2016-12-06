angular.module('funcionarioCtrl', [])
    .controller('funcionarioController', ['$scope', '$state', 'funcionarioService', 'enderecoService', function ($scope, $state, funcionarioService, enderecoService) {
        $scope.funcionarios = funcionarioService.getFuncionario();
        $scope.enderecos = enderecoService.getEndereco();

        $scope.addFuncionario = function (funcionario) {

        $scope.getCurrentEndereco(funcionario);
                      $scope.submitted = true;
              enderecoService.createEndereco($scope.endereco, function () {
                  console.log(enderecoService.getEndereco());
              });
              $scope.endereco = {};
              $scope.submitted = false;
          }
            $scope.submitted = true;

            funcionarioService.createFuncionario($scope.funcionario, function () {
                console.log(funcionarioService.getFuncionario());

            });
                $scope.message = true;
            $scope.funcionario = {};
            $scope.endereco = {};
            $scope.submitted = false;
            $scope.back = function () {
                $scope.message = false;
            };
            $scope.deleteFuncionario = function (funcionario) {
            funcionarioService.removeFuncionario(funcionario, function (data) {
                $scope.funcionarios = funcionarioService.getFuncionario();
            });
            $scope.funcionarios = funcionarioService.getFuncionario();
        };
        $scope.getCurrentEndereco = function (dataFuncionario) {
            $scope.isEdit = true;
            var data = dataFuncionario.endereco;
            $scope.endereco = data;
        };
        $scope.getCurrentFuncionario = function (dataFuncionario) {
            $scope.isEdit = true;
            var data = dataFuncionario;
            $scope.funcionario = data;
        };

        $scope.editFuncionario = function () {
            funcionarioService.updateFuncionario($scope.funcionario, function (data) {
                console.log(funcionarioService.getFuncionario());
                $scope.funcionarios = funcionarioService.getFuncionario();
                $scope.enderecos = enderecoService.getEndereco();
            });

            $scope.setEdit();
            $scope.funcionario = {};
        };
        $scope.setEdit = function () {
            $scope.isEdit = false;
        };
    }]);
