angular.module('homeCtrl', [])
    .controller('homeController', ['$scope', '$state', 'visitanteService', 'unidadeService', 'veiculoService', 'moradorService', 'usuarioService', 'acessoService', 'blocoService', function ($scope, $state, visitanteService, unidadeService, veiculoService, moradorService, usuarioService, acessoService, blocoService) {
        $scope.visitantes = visitanteService.getVisitante();
        $scope.unidades = unidadeService.getUnidade();
        $scope.veiculos = veiculoService.getVeiculo();
        $scope.moradores = moradorService.getMorador();
        $scope.usuarios = usuarioService.getUsuario();
        $scope.acessos = acessoService.getAcesso();
        $scope.unidades = unidadeService.getUnidade();
        $scope.moradores = moradorService.getMorador();
        $scope.blocos = blocoService.getBloco();
    }]);
