angular.module('appRouters', [])
    .config(['$stateProvider', '$urlRouterProvider', function ($stateProvider) {

        $stateProvider
            .state('morador', {
                url: '/morador',
                templateUrl: 'paginas/morador.html',
                controller: 'moradorController'
            })

            .state('teste', {
            url: '/teste',
            templateUrl: 'paginas/teste.html',
            controller: 'listaController'
        });
    }]);
