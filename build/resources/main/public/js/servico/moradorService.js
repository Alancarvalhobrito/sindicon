angular.module('moradorService', ['ngResource'])
    .factory('moradorProxy', ['$resource', function ($resource) {

        var port = ':8080';
        var serverURL = 'http://localhost'+port;

        return $resource(serverURL+'/morador/',{}, {
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
    .service('moradorService', ['moradorProxy', function (moradorProxy) {
        var self = this;

        self.getmorador = function (morador, successCallback, error) {
            return moradorProxy.query({}, function (data) {
                console.log(data);
            }, function (err) {
                console.log("error" + err);
            });
        };

        self.createmorador = function (morador, successCallback, error) {
            moradorProxy.save(morador, successCallback, error);
        };

        self.updatemorador = function (morador, successCallback, error) {
            moradorProxy.update(morador, successCallback, error);
        };

        self.removemorador = function (moradorId) {
            moradorProxy.delete({
                id: moradorId
            });
        }
    }]);
