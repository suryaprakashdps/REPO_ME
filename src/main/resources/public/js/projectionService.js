angular.module('app.services').factory('DBService1', function($resource) {
  return $resource('/api/v1/projection',{}, {
    'update': {
      method: 'PUT'
    }
  });
}).service('popupService',function($window){
    this.showPopup=function(message){
        return $window.confirm(message);
    }
}).service('deleteService',['$http',function($http){
	
	this.deleteUser = function deleteUser(id) {
	    return $http({
	        method : 'DELETE',
	        url : '/api/v1/projection/' + id
	    })
	}
	
	}]).service('modelService',[function(){
		
		var entity={};

		  var setentity = function(newObj) {
		      entity=newObj;
		  };

		  var getentity = function(){
		      return entity;
		  };

		  return {
			  setentity: setentity,
			  getentity: getentity
		  };
		
	}]);

