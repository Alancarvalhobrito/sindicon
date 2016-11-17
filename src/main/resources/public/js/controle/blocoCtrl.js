angular.module('blocoCtrl', [])
    .controller('blocoController', ['$scope', '$state', 'blocoService', 'unidadeService',function ($scope, $state, blocoService,unidadeService) {
        $scope.blocos = blocoService.getBloco();
        $scope.moradores = unidadeService.getUnidade();
        $scope.addBloco = function () {
            $scope.submitted = true;
            console.log($scope.bloco);

            blocoService.createBloco($scope.bloco, function () {
                console.log(blocoService.getBloco());
            });
            $scope.bloco = {};
            $scope.submitted = false;
        };

        $scope.deleteBloco = function (bloco) {
            blocoService.removeBloco(bloco, function (data) {
                $scope.blocos = blocoService.getBloco();
            });

            $scope.blocos = blocoService.getBloco();
        }

        $scope.getCurrentBloco = function (dataBloco) {
            $scope.isEdit = true;
            var data = dataBloco;
            $scope.bloco = data;
        }

        $scope.editBloco = function () {
            blocoService.updateBloco($scope.bloco, function (data) {
                console.log(blocoService.getBloco());
            });

            $scope.setEdit();
            $scope.bloco = {};
        }
        $scope.setEdit = function () {
            $scope.isEdit = false;
        }
    }]);
