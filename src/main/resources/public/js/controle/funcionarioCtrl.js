angular.module('funcionarioCtrl', [])
    .controller('funcionarioController', ['$scope', '$state', 'funcionarioService', 'enderecoService', function ($scope, $state, funcionarioService, enderecoService) {
        $scope.funcionarios = funcionarioService.getFuncionario();
        $scope.enderecos = enderecoService.getEndereco();

        $scope.addFuncionario = function (funcionario) {
            $scope.submitted = true;
            if ($scope.funcionarioForm.$invalid) {
                $scope.message = false;
                return;
            }
            console.log($scope.funcionario);
            funcionarioService.createFuncionario($scope.funcionario, function () {
                console.log(funcionarioService.getFuncionario());
                $scope.funcionarios = funcionarioService.getFuncionario();
                $scope.enderecos = enderecoService.getEndereco();
            });

            $scope.message = true;
            $scope.funcionario = {};
            $scope.submitted = false;
            $scope.back = function () {
                $scope.message = false;
            };
        };

        $scope.deleteFuncionario = function (funcionario) {
            funcionarioService.removeFuncionario(funcionario, function (data) {
                $scope.funcionarios = funcionarioService.getFuncionario();
            });
            $scope.funcionarios = funcionarioService.getFuncionario();
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
