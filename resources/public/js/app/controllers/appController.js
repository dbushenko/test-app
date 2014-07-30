angular.module('appCtrl', [])
    .controller('AppCtrl',
		function ($rootScope, $scope, $http, $location, WebSocket) {

		    WebSocket.onopen(function() {
			WebSocket.send(JSON.stringify({'ping': 'pong'}));
		    });

		    
		});
