angular.module('usuarioCtrl', [])
    .controller('usuarioController', ['$scope', '$state', 'usuarioService', function ($scope, $state, usuarioService) {
        $scope.usuarios = usuarioService.getUsuario();

        $scope.addUsuario = function () {
            $scope.submitted = true;
            console.log($scope.usuario);

            usuarioService.createUsuario($scope.usuario, function () {
                console.log(usuarioService.getUsuario());
            });
            $scope.usuario = {};
            $scope.submitted = false;
        };

        $scope.deleteUsuario = function (usuario) {
            usuarioService.removeUsuario(usuario, function (data) {
                $scope.usuarios = usuarioService.getUsuario();
            });

            $scope.usuarios = usuarioService.getUsuario();
        }

        $scope.getCurrentUsuario = function (dataUsuario) {
            $scope.isEdit = true;
            var data = dataUsuario;
            $scope.usuario = data;
        }

        $scope.editUsuario = function () {
            usuarioService.updateUsuario($scope.usuario, function (data) {
                console.log(usuarioService.getUsuario());
            });

            $scope.setEdit();
            $scope.usuario = {};
        }
        $scope.setEdit = function () {
            $scope.isEdit = false;
        }
    }]);