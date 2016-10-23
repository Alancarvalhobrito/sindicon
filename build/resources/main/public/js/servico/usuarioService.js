angular.module('usuarioService', ['ngResource'])
    .factory('usuarioProxy', ['$resource', function ($resource) {

        var port = ':8080';
        var serverURL = 'http://localhost' + port;

        return $resource(serverURL + '/usuario/', {}, {
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
    .service('usuarioService', ['usuarioProxy', function (usuarioProxy) {
        var self = this;

        self.getUsuario = function (usuario, successCallback, error) {
            return usuarioProxy.query({}, function (data) {
                console.log(data);
            }, function (err) {
                console.log("error" + err);
            });
        };

        self.createUsuario = function (usuario, successCallback, error) {
            usuarioProxy.save(usuario, successCallback, error);
        };

        self.updateUsuario = function (usuario, successCallback, error) {
            usuarioProxy.update(usuario, successCallback, error);
        };

        self.removeUsuario = function (usuarioId) {
            usuarioProxy.delete({
                id: usuarioId
            });
        }
    }]);