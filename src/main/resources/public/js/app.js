(function() {
	var app = angular.module('app', ['ui.router', 'navController', 'ngAnimate', 'ui.bootstrap', 'ngResource', 'app.controllers', 'app.services','ui.grid.pagination',
		 'ui.grid','ui.grid.exporter', 'ui.grid.selection'])

	// define for requirejs loaded modules
	define('app', [], function() { return app; });

	// function for dynamic load with requirejs of a javascript module for use with a view
	// in the state definition call add property `resolve: req('/views/ui.js')`
	// or `resolve: req(['/views/ui.js'])`
	// or `resolve: req('views/ui')`
	function req(deps) {
		if (typeof deps === 'string') deps = [deps];
		return {
			deps: function ($q, $rootScope) {
				var deferred = $q.defer();
				require(deps, function() {
					$rootScope.$apply(function () {
						deferred.resolve();
					});
					deferred.resolve();
				});
				return deferred.promise;
			}
		}
	}

	app.config(function($stateProvider, $urlRouterProvider, $controllerProvider){
		var origController = app.controller
		app.controller = function (name, constructor){
			$controllerProvider.register(name, constructor);
			return origController.apply(this, arguments);
		}

		var viewsPrefix = 'views/';

		// For any unmatched url, send to /
		$urlRouterProvider.otherwise("/")

		$stateProvider
			// you can set this to no template if you just want to use the html in the page
			.state('home', {
				url: "/",
				templateUrl: viewsPrefix + "home.html",
				data: {
					pageTitle: 'Home'
				}
			})
			.state('projects',{
	        url:'/projects',
	        templateUrl: viewsPrefix + 'viewall.html',
	        controller:'UserListController'
	    }).state('viewuser',{
	       url:'/projects/:id/view',
	       templateUrl: viewsPrefix + 'User.html',
	       controller:'UserViewController'
	    })
	    .state('editmaster',{
	       url:'/projects/edit',
	       templateUrl: viewsPrefix + 'editmaster.html',
	       controller:'EditMasterController'
	    })
	    
	    .state('addproj',{
	        url:'/projects/new',
	        templateUrl: viewsPrefix + 'Proj-add.html',
	        controller:'ProjCreateController'
	    })
	       .state('projection',{
	        url:'/projection',
	        templateUrl: viewsPrefix + 'projection.html',
	        controller:'ProjectionController'
	    })
	    .state('editprojection',{
	       url:'/projection/edit',
	       templateUrl: viewsPrefix + 'editProjection.html',
	       controller:'EditProjectionController'
	    })
	    
	    .state('addprojection',{
	        url:'/projection/new',
	        templateUrl: viewsPrefix + 'addProjection.html',
	        controller:'ProjectionCreateController'
	    })
	})
	.directive('updateTitle', ['$rootScope', '$timeout',
		function($rootScope, $timeout) {
			return {
				link: function(scope, element) {
					var listener = function(event, toState) {
						var title = 'Project Name';
						if (toState.data && toState.data.pageTitle) title = toState.data.pageTitle + ' - ' + title;
						$timeout(function() {
							element.text(title);
						}, 0, false);
					};

					$rootScope.$on('$stateChangeSuccess', listener);
				}
			};
		}
	]);
}());
