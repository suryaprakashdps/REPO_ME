(function () {
    'use strict';

    angular
        .module('app')
        .controller('LoginController', LoginController);
 

    LoginController.$inject = ['$rootScope','$location','$window','AuthenticationService', 'FlashService'];
    function LoginController( $rootScope,$location,$window, AuthenticationService, FlashService) {
        var vm = this;

        vm.login = login;

        (function initController() {
            // reset login status
            AuthenticationService.ClearCredentials();
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
         //  $window.location.reload();
         //  $window.stop();
        })();

        function login() {
            vm.dataLoading = true;
            AuthenticationService.Login(vm.username, vm.password, function (response) {
                if (response.success) {
                    AuthenticationService.SetCredentials(vm.username, vm.password);
                    
                   
                    $location.path('/projects');
                } else {
                    FlashService.Error(response.message);
                    vm.dataLoading = false;
                }
            });
        };
    }

    
   

})();
