angular.module('visitanteService', ['ngResource'])
    .factory('visitanteProxy', ['$resource', function ($resource) {

        var port = ':8080';
        var serverURL = 'http://localhost' + port;

        return $resource(serverURL + '/visitante/', {}, {
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
    .service('visitanteService', ['visitanteProxy', function (visitanteProxy) {
        var self = this;

        self.getVisitante = function (visitante, successCallback, error) {
            return visitanteProxy.query({}, function (data) {
                console.log(data);
            }, function (err) {
                console.log("error" + err);
            });
        };

        self.createVisitante = function (visitante, successCallback, error) {
            visitanteProxy.save(visitante, successCallback, error);
        };

        self.updateVisitante = function (visitante, successCallback, error) {
            visitanteProxy.update(visitante, successCallback, error);
        };

        self.removeVisitante = function (visitanteId) {
            visitanteProxy.delete({
                id: visitanteId
            });
        }
    }]);