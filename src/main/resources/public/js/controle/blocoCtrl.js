angular.module('blocoCtrl', [])
    .controller('blocoController', ['$scope', '$state', 'blocoService', function ($scope, $state, blocoService) {
        $scope.blocos = blocoService.getBloco();

        $scope.addBloco = function () {
            $scope.submitted = true;
            if ($scope.blocoForm.$invalid) {
                $scope.message = false;
                return;
            }
            console.log($scope.bloco);

            blocoService.createBloco($scope.bloco, function () {
                console.log(blocoService.getBloco());
                $scope.blocos = blocoService.getBloco();
            });
            $scope.message = true;
            $scope.bloco = {};
            $scope.submitted = false;
            $scope.back = function () {
                $scope.message = false;
            };
        };

        $scope.deleteBloco = function (bloco) {
            blocoService.removeBloco(bloco, function (data) {
                $scope.blocos = blocoService.getBloco();
            });
            $scope.blocos = blocoService.getBloco();
        };

        $scope.getCurrentBloco = function (dataBloco) {
            $scope.isEdit = true;
            var data = dataBloco;
            $scope.bloco = data;
        };

        $scope.editBloco = function () {
            blocoService.updateBloco($scope.bloco, function (data) {
                console.log(blocoService.getBloco());
                $scope.blocos = blocoService.getBloco();
            });

            $scope.setEdit();
            $scope.bloco = {};
        };
        $scope.setEdit = function () {
            $scope.isEdit = false;
        }
    }]);