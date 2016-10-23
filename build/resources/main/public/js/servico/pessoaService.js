angular.module('pessoaService', ['ngResource'])
    .factory('pessoaProxy', ['$resource', function ($resource) {

        var port = ':8080';
        var serverURL = 'http://localhost' + port;

        return $resource(serverURL + '/pessoa/', {}, {
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
    .service('pessoaService', ['pessoaProxy', function (pessoaProxy) {
        var self = this;

        self.getPessoa = function (pessoa, successCallback, error) {
            return pessoaProxy.query({}, function (data) {
                console.log(data);
            }, function (err) {
                console.log("error" + err);
            });
        };

        self.createPessoa = function (pessoa, successCallback, error) {
            pessoaProxy.save(pessoa, successCallback, error);
        };

        self.updatePessoa = function (pessoa, successCallback, error) {
            pessoaProxy.update(pessoa, successCallback, error);
        };

        self.removePessoa = function (pessoaId) {
            pessoaProxy.delete({
                id: pessoaId
            });
        }
    }]);