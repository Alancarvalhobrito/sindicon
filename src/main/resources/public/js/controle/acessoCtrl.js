angular.module('acessoCtrl', [])
    .controller('acessoController', ['$scope', '$state', 'acessoService', function ($scope, $state, acessoService) {
        $scope.acessos = acessoService.getAcesso();

        $scope.addAcesso = function () {
            $scope.submitted = true;
            $scope.acesso = {};
            console.log($scope.acesso);

            acessoService.createAcesso($scope.acesso, function () {
                console.log(acessoService.getAcesso());
            });
            $scope.acesso = {};
            $scope.submitted = false;
        };

        $scope.deleteAcesso = function (acesso) {
            acessoService.removeAcesso(acesso, function (data) {
                $scope.acessos = acessoService.getAcesso();
            });

            $scope.acessos = acessoService.getAcesso();
        }

        $scope.getCurrentAcesso = function (dataAcesso) {
            $scope.isEdit = true;
            var data = dataAcesso;
            $scope.acesso = data;
        }

        $scope.editAcesso = function () {
            acessoService.updateAcesso($scope.acesso, function (data) {
                console.log(acessoService.getAcesso());
            });

            $scope.setEdit();
            $scope.acesso = {};
        }
        $scope.setEdit = function () {
            $scope.isEdit = false;
        }
    }]);