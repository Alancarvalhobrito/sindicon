angular.module('veiculoService', ['ngResource'])
    .factory('veiculoProxy', ['$resource', function ($resource) {

        var port = ':8080';
        var serverURL = 'http://localhost' + port;

        return $resource(serverURL + '/veiculo/', {}, {
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
    .service('veiculoService', ['veiculoProxy', function (veiculoProxy) {
        var self = this;

        self.getVeiculo = function (veiculo, successCallback, error) {
            return veiculoProxy.query({}, function (data) {
                console.log(data);
            }, function (err) {
                console.log("error" + err);
            });
        };

        self.createVeiculo = function (veiculo, successCallback, error) {
            veiculoProxy.save(veiculo, successCallback, error);
        };

        self.updateVeiculo = function (veiculo, successCallback, error) {
            veiculoProxy.update(veiculo, successCallback, error);
        };

        self.removeVeiculo = function (veiculoId) {
            veiculoProxy.delete({
                id: veiculoId
            });
        }
    }]);