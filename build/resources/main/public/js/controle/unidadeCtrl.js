var app = angular.module('unidadeCtrl', [])
app.controller('unidadeController', ['$scope', '$state', 'unidadeService', 'moradorService', 'blocoService', function ($scope, $state, unidadeService, moradorService, blocoService) {
    $scope.unidades = unidadeService.getUnidade();
    $scope.moradores = moradorService.getMorador();
    $scope.blocos = blocoService.getBloco();

    $scope.addUnidade = function () {
        $scope.submitted = true;
        if ($scope.unidadeForm.$invalid) {
            $scope.message = false;
            return;
        }
        console.log($scope.unidade);

        unidadeService.createUnidade($scope.unidade, function () {
            console.log(unidadeService.getUnidade());
            $scope.unidades = unidadeService.getUnidade();
            $scope.blocos = blocoService.getBloco();
        });
        $scope.message = true;
        $scope.unidade = {};
        $scope.submitted = false;
        $scope.back = function () {
            $scope.message = false;
        };
    };

    $scope.deleteUnidade = function (unidade) {
        unidadeService.removeUnidade(unidade, function (data) {
            $scope.unidades = unidadeService.getUnidade();
        });
        $scope.unidades = unidadeService.getUnidade();
    };
    $scope.getCurrentUnidade = function (dataUnidade) {
        $scope.isEdit = true;
        var data = dataUnidade;
        $scope.unidade = data;
    };

    $scope.editUnidade = function () {
        unidadeService.updateUnidade($scope.unidade, function (data) {
            console.log(unidadeService.getUnidade());
            $scope.unidades = unidadeService.getUnidade();
            $scope.blocos = blocoService.getBloco();
        });

        $scope.setEdit();
        $scope.unidade = {};
    };
    $scope.setEdit = function () {
        $scope.isEdit = true;
    };
}]);
app.filter('secondDropdown', function () {
    return function (secondSelect, firstSelect) {
        var filtered = [];
        if (firstSelect === null) {
            return filtered;
        }
        ;
        angular.forEach(secondSelect, function (s2) {
            if (s2.bloco.idBloco == firstSelect) {
                filtered.push(s2);
            }
            ;
        });
        return filtered;
    };
});
