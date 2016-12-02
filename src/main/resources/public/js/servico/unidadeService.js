angular.module('unidadeService', ['ngResource'])
    .factory('unidadeProxy', ['$resource', function ($resource) {

        var port = ':8080';
        var serverURL = 'http://localhost' + port;

        return $resource(serverURL + '/unidade/', {}, {
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
    .service('unidadeService', ['unidadeProxy', function (unidadeProxy) {
        var self = this;

        self.getUnidade = function (unidade, successCallback, error) {
            return unidadeProxy.query({}, function (data) {
                console.log(data);
            }, function (err) {
                console.log("error" + err);
            });
        };

        self.createUnidade = function (unidade, successCallback, error) {
            unidadeProxy.save(unidade, successCallback, error);
        };

        self.updateUnidade = function (unidade, successCallback, error) {
            unidadeProxy.update(unidade, successCallback, error);
        };


        self.removeUnidade = function(idUnidade, successCallback, error) {
            unidadeProxy.delete({id: idUnidade}, successCallback, error);
        }
    }]);
