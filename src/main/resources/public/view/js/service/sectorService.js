angular.module('sectorService', ['ngResource'])

// Factory that handles api methods
.factory('sectorProxy', ['$resource',
    function($resource) {

        var port = ':8080';
        var serverURL = 'http://localhost'+port;

        return $resource(serverURL+'/sector/', {}, {
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
                params: {
                    id: '@id'
                },
                isArray: true
            }
        });
    }
])

.service('sectorService', ['sectorProxy', function(sectorProxy) {
    var self = this;

    self.getsector = function(sector, successCallback, error) {
        return sectorProxy.query({}, function(data) {
          }, function(err) {
            console.log("error" + err);
        });
    };

    self.createsector = function(sector, successCallback, error) {
        sectorProxy.save(sector, successCallback, error);
    };

    self.updatesector = function(sector, successCallback, error) {
        sectorProxy.update(sector, successCallback, error);
    };

    self.removesector = function(sector) {
        sectorProxy.delete({
            });
    }
}]);
