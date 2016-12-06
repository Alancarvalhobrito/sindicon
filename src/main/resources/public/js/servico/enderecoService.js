angular.module('enderecoService', ['ngResource'])
    .factory('enderecoProxy', ['$resource', function ($resource) {

        var port = ':8080';
        var serverURL = 'http://localhost' + port;

        return $resource(serverURL + '/funcionario/', {}, {
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
    .service('enderecoService', ['enderecoProxy', function (enderecoProxy) {
        var self = this;

        self.getEndereco = function (endereco, successCallback, error) {
            return enderecoProxy.query({}, function (data) {
                console.log(data);
            }, function (err) {
                console.log("error" + err);
            });
        };

        self.createEndereco = function (endereco, successCallback, error) {
            enderecoProxy.save(endereco, successCallback, error);
        };

        self.updateEndereco = function (endereco, successCallback, error) {
            enderecoProxy.update(endereco, successCallback, error);
        };

        self.removeEndereco = function (enderecoId) {
            enderecoProxy.delete({
                id: enderecoId
            });
        }
    }]);
