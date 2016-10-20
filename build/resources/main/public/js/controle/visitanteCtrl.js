angular.module('visitanteCtrl', [])
    .controller('visitanteController', ['$scope', '$state', 'visitanteService', function ($scope, $state, visitanteService) {
        $scope.visitantes = visitanteService.getVisitante();

        $scope.addVisitante = function () {
            $scope.submitted = true;
            console.log($scope.visitante);

            visitanteService.createVisitante($scope.visitante, function () {
                console.log(visitanteService.getVisitante());
            });
            $scope.visitante = {};
            $scope.submitted = false;
        };

        $scope.deleteVisitante = function (visitante) {
            visitanteService.removeVisitante(visitante, function (data) {
                $scope.visitantes = visitanteService.getVisitante();
            });

            $scope.visitantes = visitanteService.getVisitante();
        }

        $scope.getCurrentVisitante = function (dataVisitante) {
            $scope.isEdit = true;
            var data = dataVisitante;
            $scope.visitante = data;
        }

        $scope.editVisitante = function () {
            visitanteService.updateVisitante($scope.visitante, function (data) {
                console.log(visitanteService.getVisitante());
            });

            $scope.setEdit();
            $scope.visitante = {};
        }
        $scope.setEdit = function () {
            $scope.isEdit = false;
        }
    }]);