angular.module('acessoService', ['ngResource'])
    .factory('acessoProxy', ['$resource', function ($resource) {

        var port = ':8080';
        var serverURL = 'http://localhost' + port;

        return $resource(serverURL + '/acesso/', {}, {
            save: {
                method: 'POST',
                isArray: false
            },
            update: {
                method: 'PUT',
                isArray: false
            },
            delete: {
                method: 'DELETE',
                params: {
                    id: '@id'
                },
                isArray: false
            },
            query: {
                method: 'GET',

                isArray: true
            }
        });

    }])
    .service('acessoService', ['acessoProxy', function (acessoProxy) {
        var self = this;

        self.getAcesso = function (acesso, successCallback, error) {
            return acessoProxy.query({}, function (data) {
                console.log(data);
            }, function (err) {
                console.log("error" + err);
            });
        };

        self.createAcesso = function (acesso, successCallback, error) {
            acessoProxy.save(acesso, successCallback, error);
        };

        self.updateAcesso = function (acesso, successCallback, error) {
            acessoProxy.update(acesso, successCallback, error);
        };

        self.removeAcesso = function (acessoId) {
            acessoProxy.delete({
                id: acessoId
            });
        }
    }]);