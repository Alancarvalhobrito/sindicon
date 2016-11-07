angular.module('homeCtrl', [])
    .controller('homeController', ['$scope', '$state', 'visitanteService', 'unidadeService', 'veiculoService', 'moradorService', 'usuarioService', 'acessoService', function ($scope, $state, visitanteService, unidadeService, veiculoService, moradorService, usuarioService, acessoService) {
        $scope.visitantes = visitanteService.getVisitante();
        $scope.unidades = unidadeService.getUnidade();
        $scope.veiculos = veiculoService.getVeiculo();
        $scope.moradores = moradorService.getMorador();
        $scope.usuarios = usuarioService.getUsuario();
        $scope.acessos = acessoService.getAcesso();
    }]);