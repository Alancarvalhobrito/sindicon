angular.module('funcionarioService', ['ngResource'])
    .factory('funcionarioProxy', ['$resource', function ($resource) {

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
    .service('funcionarioService', ['funcionarioProxy', function (funcionarioProxy) {
        var self = this;

        self.getFuncionario = function (funcionario, successCallback, error) {
            return funcionarioProxy.query({}, function (data) {
                console.log(data);
            }, function (err) {
                console.log("error" + err);
            });
        };

        self.createFuncionario = function (funcionario, successCallback, error) {
            funcionarioProxy.save(funcionario, successCallback, error);
        };

        self.updateFuncionario = function (funcionario, successCallback, error) {
            funcionarioProxy.update(funcionario, successCallback, error);
        };

        self.removeFuncionario = function(idFuncionario, successCallback, error) {
                funcionarioProxy.delete({id: idFuncionario}, successCallback, error);
            }
    }]);
