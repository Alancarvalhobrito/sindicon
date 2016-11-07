angular.module('funcionarioCtrl', [])
    .controller('funcionarioController', ['$scope', '$state', 'funcionarioService', function ($scope, $state, funcionarioService) {
        $scope.funcionarios = funcionarioService.getFuncionario();

        $scope.addFuncionario = function () {
            $scope.submitted = true;
            console.log($scope.funcionario);

            funcionarioService.createFuncionario($scope.funcionario, function () {
                console.log(funcionarioService.getFuncionario());
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
        }

        $scope.getCurrentFuncionario = function (dataFuncionario) {
            $scope.isEdit = true;
            var data = dataFuncionario;
            $scope.funcionario = data;
        }

        $scope.editFuncionario = function () {
            funcionarioService.updateFuncionario($scope.funcionario, function (data) {
                console.log(funcionarioService.getFuncionario());
            });

            $scope.setEdit();
            $scope.funcionario = {};
        }
        $scope.setEdit = function () {
            $scope.isEdit = false;
        }
    }]);