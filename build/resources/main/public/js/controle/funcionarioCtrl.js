angular.module('funcionarioCtrl', [])
    .controller('funcionarioController', ['$scope', '$state', 'funcionarioService', 'enderecoService', function ($scope, $state, funcionarioService, enderecoService) {
        $scope.funcionarios = funcionarioService.getFuncionario();
        $scope.enderecos = enderecoService.getEndereco();

        $scope.addFuncionario = function (funcionario) {
            $scope.submitted = true;
            console.log($scope.funcionario);

            funcionarioService.createFuncionario($scope.funcionario, function () {
                console.log(funcionarioService.getFuncionario());
            });
            $scope.funcionario = {};
            $scope.submitted = false;
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
