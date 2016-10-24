angular.module('testeCtrl', [])
    .controller('listaController', ['$scope', '$state', function ($scope, $state) {
        $scope.testando = "Lista Telefonica";
        $scope.contatos = [
            {
                nome: "Thiago",
                telefone: "9898-9898"
            },
            {
                nome: "Amanda",
                telefone: "6565-6565"
            }
        ];
    }]);
