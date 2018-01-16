(function() {
	var app = angular.module('app', ['ui.router', 'ngAnimate', 'ui.bootstrap', 'ngResource', 'navcontroller','app.controllers', 'app.services','ui.grid.pagination',
		 'ui.grid','ui.grid.exporter', 'ui.grid.importer','ui.grid.selection','ngCookies'])

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
	 app.run(run);
	app.run(function($rootScope){
		$rootScope.loginflag=false;
		$rootScope.pages = [
			{
				name: 'Home',
				url: '#/'
			},
			{
				name: 'Login',
				url: '#/login'
			},{
				name: 'Register',
				url: '#/register'
			}
		];
		console.log('sinide app run',$rootScope.loginflag);
	});

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
	    
	     .state('login', {
             url:'/login',
	    	 controller: 'LoginController',
             templateUrl: viewsPrefix +'login.view.html',
             controllerAs: 'vm'
            
         })
         .state('logout', {
             url:'/login',
	    	 controller: 'LoginController',
             templateUrl: viewsPrefix +'login.view.html',
             controllerAs: 'vm'
            
         })

	     .state('register', {
	    	 
	    	 url:'/register',
             controller: 'RegisterController',
             templateUrl: viewsPrefix +'register.view.html',
             controllerAs: 'vm'
             
         })
         .state('export', {
             url:'/projections',
	    	 controller: 'ExportController',
           //  templateUrl: viewsPrefix +'login.view.html',
             controllerAs: 'vm'
            
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
	         .state('importproj',{
	        url:'/projects/import',
	        templateUrl: viewsPrefix + 'importproj.html',
	        controller:'ProjImportController'
	    })
	    
	      .state('viewproject',{
	        url:'/projects/viewprojectdata',
	        templateUrl: viewsPrefix + 'viewproj.html',
	        controller:'ViewProjController'
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
	
	    run.$inject = ['$rootScope', '$location', '$cookies', '$http'];
    function run($rootScope, $location, $cookies, $http) {
    	
    	
    	
		$rootScope.pages = [
		
			{
				name: 'Login',
				url: '#/login'
			},{
				name: 'Register',
				url: '#/register'
			}
		];
		
    	
        // keep user logged in after page refresh
        $rootScope.globals = $cookies.getObject('globals') || {};
        if ($rootScope.globals.currentUser) {
            $http.defaults.headers.common['Authorization'] = 'Basic ' + $rootScope.globals.currentUser.authdata;
        $rootScope.pages=$rootScope.globals.currentUser.pages;
         
        }

        $rootScope.$on('$locationChangeStart', function (event, next, current) {
            // redirect to login page if not logged in and trying to access a restricted page
            var restrictedPage = $.inArray($location.path(), ['/login', '/register']) === -1;
            var loggedIn = $rootScope.globals.currentUser;
            
            if(loggedIn)
            	{
            	console.log('inside loggedinif condition in appjs');
            
          
           $rootScope.pages=$rootScope.globals.currentUser.pages;
            	}
    
            if (restrictedPage && !loggedIn) {
                $location.path('/login');
            }
        });
    }
	

}());
