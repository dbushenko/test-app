var mainApp = angular.module('mainApp', [
    'angular-websocket',
    'ngRoute',
    'appCtrl'
])
    .config(function(WebSocketProvider){
	WebSocketProvider
	    .prefix('')
	    .uri("ws://127.0.0.1:8080");
    });;
