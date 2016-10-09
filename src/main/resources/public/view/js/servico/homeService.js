angular.module('homeService', ['ngResource'])

    //Service
    .service('homeService', ['homeProxy', function (homeProxy) {
        var self = this;

        self.gethome = function (home, successCallback, error) {
            return homeProxy.query({}, function (data) {
                console.log(data);
            }, function (err) {
                console.log("error" + err);
            });
        };

        self.createhome = function (home, successCallback, error) {
            homeProxy.save(home, successCallback, error);
        };

        self.updatehome = function (home, successCallback, error) {
            homeProxy.update(home, successCallback, error);
        };

        self.removehome = function (homeId) {
            homeProxy.delete({
                id: homeId
            });
        }
    }])

    // Factory
    .factory('homeProxy', ['$resource',
        function ($resource) {

            var port = ':8080';
            var serverURL = 'http://localhost' + port;

            return $resource(serverURL + '/home/', {}, {
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
    ]);