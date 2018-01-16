angular.module('app.services', []).factory('DBService', function($resource) {
  return $resource('/api/v1/projects',{}, {
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
	        url : '/api/v1/projects/' + id
	    })
	}
	
	}])
	
	.service('importService',['$http',function($http){
	
	this.importservice = function importservice(data) {
	    return $http({
	        method : 'POST',
	        url : '/api/v1/projects/import',
	        	data:data
	    })
	}
	
	}])
	
	.service('exportService',['$http',function($http){
	
	this.exportservice = function exportservice(data) {
	    return $http({
	        method : 'GET',
	        url : '/api/v1/export.xls',
	        	
	    })
	}
	
	}])
	
	.service('modelService',[function(){
		
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