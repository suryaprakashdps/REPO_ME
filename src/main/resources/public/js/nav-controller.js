angular.module('navcontroller',[])
	.controller('nav', function($scope,$rootScope, $state) {
		$scope.title = 'TCS REPO';

		// returns true if the current router url matches the passed in url
		// so views can set 'active' on links easily
		$scope.isUrl = function(url) {
			if (url === '#') return false;
			return ('#' + $state.$current.url.source + '/').indexOf(url + '/') === 0;
	
	
		};
		
		

//		var flag=$rootScope.loginflag;
//		console.log("rootscope in nav controller",flag);
//		if(flag){
//			$scope.pages = [
//				{
//					name: 'Home',
//					url: '#/'
//				},
//				{
//					name: 'Project',
//					url: '#/projects'
//				},{
//					name: 'Projection',
//					url: '#/projection'
//				}
//			]
//
//		} else{
//
//			$scope.pages = [
//				{
//					name: 'Home',
//					url: '#/'
//				},
//				{
//					name: 'Login',
//					url: '#/login'
//				},{
//					name: 'Register',
//					url: '#/register'
//				}
//			]
//		}
		
		
	});
