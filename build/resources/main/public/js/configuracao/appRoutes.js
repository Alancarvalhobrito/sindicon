angular.module('appRouters', [])
    .config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {

        $stateProvider
            .state('morador', {
                url: '/morador',
                templateUrl: 'paginas/morador.html',
                controller: 'moradorController'
            });
    }]);
