angular.module('blocoService', ['ngResource'])
    .factory('blocoProxy', ['$resource', function ($resource) {

        var port = ':8080';
        var serverURL = 'http://localhost' + port;

        return $resource(serverURL + '/bloco/', {}, {
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
    .service('blocoService', ['blocoProxy', function (blocoProxy) {
        var self = this;

        self.getBloco = function (bloco, successCallback, error) {
            return blocoProxy.query({}, function (data) {
                console.log(data);
            }, function (err) {
                console.log("error" + err);
            });
        };

        self.createBloco = function (bloco, successCallback, error) {
            blocoProxy.save(bloco, successCallback, error);
        };

        self.updateBloco = function (bloco, successCallback, error) {
            blocoProxy.update(bloco, successCallback, error);
        };

        self.removeBloco = function (blocoId) {
            blocoProxy.delete({
                id: blocoId
            });
        }
    }]);
