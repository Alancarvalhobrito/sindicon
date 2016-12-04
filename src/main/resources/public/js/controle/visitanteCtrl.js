angular.module('visitanteCtrl', [])
    .controller('visitanteController', ['$scope', '$state', 'visitanteService', 'unidadeService', 'blocoService', function ($scope, $state, visitanteService, unidadeService, blocoService) {
        $scope.visitantes = visitanteService.getVisitante();
        $scope.unidades = unidadeService.getUnidade();
        $scope.blocos = blocoService.getBloco();

        $scope.addVisitante = function () {
            $scope.submitted = true;
            if ($scope.visitanteForm.$invalid) {
                $scope.message = false;
                return;
            }
            console.log($scope.visitante);

            visitanteService.createVisitante($scope.visitante, function () {
                console.log(visitanteService.getVisitante());
            });
            $scope.message = true;
            $scope.visitante = {};
            $scope.submitted = false;
            $scope.back = function () {
                $scope.message = false;
            };
        };

        $scope.deleteVisitante = function (visitante) {
            visitanteService.removeVisitante(visitante, function (data) {
                $scope.visitantes = visitanteService.getVisitante();
            });
            $scope.visitantes = visitanteService.getVisitante();
        };

        $scope.getCurrentVisitante = function (dataVisitante) {
            $scope.isEdit = true;
            var data = dataVisitante;
            $scope.visitante = data;
        };

        $scope.editVisitante = function () {
            visitanteService.updateVisitante($scope.visitante, function (data) {
                console.log(visitanteService.getVisitante());
            });

            $scope.setEdit();
            $scope.visitante = {};
        };
        $scope.setEdit = function () {
            $scope.isEdit = false;
        };
    }]);