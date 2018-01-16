angular
		.module('app.controllers', ['ngAnimate', 'ui.bootstrap'])
		.controller(
				'UserListController',
				function($scope, $state, popupService, $window, DBService, $q,
						$interval, deleteService,modelService) {

					// datagrid setup

					$scope.gridOptions = {
						exporterMenuCsv : true,
						enableGridMenu : true,
						paginationPageSizes : [ 25, 50, 75 ],
						paginationPageSize : 25,
						enableFiltering : true,
						columnDefs : [
								{
									name : 'rec_key'
								},
								{
									name : 'tower'
								},
								{
									name : 'project'
								},
								{
									name : 'service_line'
								},
								{
									name : 'sub_sp'
								},
								{
									name : 'project_type'
								},
								{
									name : 'won_number'
								},
								{
									name : 'won_type'
								},
								{
									name : 'rate'
								},
								{
									name : 'probability'
								},

								{
									name : 'brm_name'
								},
								{
									name : 'actions',
									displayName : 'Actions',
									cellTemplate : '<button id="editBtn" type="button" class="glyphicon glyphicon-pencil" ng-click="grid.appScope.masteredit(row.entity)"></button>'

								} 
								]
					};
// var obj={};
					
	// modelService.setentity(obj);
					$scope.gridOptions.data = DBService.query();
					
					// created for master data edit but not used

					$scope.masteredit = function(entity) {

						console.log(entity);
						
						modelService.setentity(entity);
						$scope.datavalue=modelService.getentity();
						
						console.log($scope.datavalue);
						$state.go('editmaster');
						


					};

				
					// delete query
					//
					// $scope.deleteuser = function(user) {
					// if (popupService.showPopup('Are you sure to delete?')) {
					//
					// deleteService.deleteUser(user).then(
					// function success(response) {
					//
					// $scope.userdata = DBService.query();
					// $state.go('projects');
					//
					// });
					//
					// }
					//
					// };

				})
				.controller('ProjCreateController',
				function($scope, $state, $stateParams, DBService,modelService) {
							  
					$scope.editvalue = new DBService(); // create new user
					// instance. Properties will be
					// set via ng-model on UI
					$scope.addproj = function() { // create a new user. Issues
													// a
						// POST to /api/v1/projects
						$scope.editvalue.$save(function() {
							
							var entity=$scope.editvalue;
							console.log(entity);
							modelService.setentity(entity);
							$state.go('viewproject'); // on success go back to the
													// list
							// i.e. projects state.
						});
					};
				})
				.controller('ViewProjController',
				function($scope, $state, $stateParams, DBService,modelService) {
					$scope.showSuccessAlert=true;
					$scope.create_project_message="Project Data Modified Successfully"
							  
					$scope.editvalue=modelService.getentity();
					
					
					$scope.editproject = function() {

						
						$state.go('editmaster');
						


					};
				})
				
					.controller('ProjImportController',
				function($scope,$http, $state, $stateParams, importService,$interval) {
						$scope.data = [];
						  $scope.gridOptions = {
						    enableGridMenu: true,
						    data: 'data',
						    importerDataAddCallback: function ( grid, newObjects ) {
						    	
						      $scope.data = $scope.data.concat( newObjects );
						      
						      importService.importservice($scope.data)
						      
						      .then(function successCallback(response) {
						    	  $scope.success_message="That's Quick !! Successfully Imported Data";
						    	  $scope.showSuccessAlert = true;
						    	  
						      });
						      
						      
						
						      console.log($scope.data);
				
						    },
						    onRegisterApi: function(gridApi){
						      $scope.gridApi = gridApi;
						    }
						    }
				})
				

				
				.controller('EditMasterController',
				function($scope,$state, $stateParams, DBService,modelService) {
					console.log('inside edit master controller');
	// debugger;
					$scope.editvalue=modelService.getentity();
					
					console.log('test format for debug options');
					
					
					$scope.updatemaster = function(){
						modelService.setentity($scope.editvalue);
						console.log($scope.editvalue);
						$scope.editvalue.$update(function(){
							$state.go('viewproject');
						});
						
					};
// $scope.userdata = DBService.get({
// id : $stateParams.id
// }); // Get a single user.Issues a GET to
						// /api/v1/projects/:id
				})
				
				
				.controller('UserViewController',
				function($scope, $stateParams, DBService) {
					$scope.userdata = DBService.get({
						id : $stateParams.id
					}); // Get a single user.Issues a GET to
						// /api/v1/projects/:id
				})
				.controller('ProjectionController',
				function($scope, $state, popupService, $window, DBService1, $q,
						$interval, deleteService,modelService) {
		
					// datagrid setup
		
					$scope.gridProjection = {
						exporterMenuCsv : true,
						enableGridMenu : true,
						paginationPageSizes : [ 25, 50, 75 ],
						paginationPageSize : 25,
						enableFiltering : true,
						columnDefs : [
								{
									name : 'tower'
								},
								{
									name : 'project'
								},
								{
									name : 'won_number'
								},
								{
									name : 'won_type'
								},
								{
									name : 'month'
								},
								{
									name : 'year'
								},
								{
									name : 'resource_count'
								},
								{
									name : 'revenue'
								},
								{
									name : 'actions',
									displayName : 'Actions',
									cellTemplate : '<button id="editBtn" type="button" class="glyphicon glyphicon-pencil" ng-click="grid.appScope.projectionedit(row.entity)">EDIT</button>'
		
							} 
								]
					};
		
					$scope.gridProjection.data = DBService1.query();
					
					$scope.projectionedit = function(entity) {

						console.log(entity);
						
						modelService.setentity(entity);
						$scope.datavalue=modelService.getentity();
						
						console.log($scope.datavalue);
						$state.go('editprojection');
						


					};
					
		
				})
				.controller('ExportController',
				function($scope,$state, $stateParams, exportService) {
					exportService.exportservice()
					
				
				      .then(function successCallback(response) {
				    	  
				    	   var blob = new Blob([response], {type: "application/vnd.ms-excel"});
				    	   
				    	    var objectUrl = URL.createObjectURL(blob);
				    	    console.log(blob);
				    	    window.open(objectUrl);
				    	  $scope.success_message="That's Quick !! Successfully Exported Data";
				    	  $scope.showSuccessAlert = true;
				    	  $state.go('projection');
				    	  
				      });
				})
				
				
				.controller('EditProjectionController',
				function($scope,$state, $stateParams, DBService1,modelService) {
					console.log('inside edit projection controller');
	// debugger;
					$scope.projectionValue=modelService.getentity();
					
					console.log('test format for debug options');
					console.log($scope.projectionValue);
					
					$scope.editprojection = function(){
						
						$scope.projectionValue.$update(function(){
							$state.go('projection');
						});
						
					};
// $scope.userdata = DBService.get({
// id : $stateParams.id
// }); // Get a single user.Issues a GET to
						// /api/v1/projects/:id
				})
				
				.controller('ProjectionCreateController', 
				function($scope,DBService1,DBService,$state, $stateParams) {

					$scope.selected={};
  
  
			  $scope.projectList= DBService.query();
				  DBService.query().$promise.then(function(data) {
					  $scope.projectList = data;
					  console.log($scope.projectList[2].project);
				  return data;
			});
	  
	 
				  console.log($scope.projectList);
  
				  console.log('VALUE RETURN FROM HTML PAGE');
  
				  $scope.selected.proc = new DBService1();
  
				  $scope.addprojection = function() { 
					  
					  $scope.insertProj = $scope.selected.proc;
					  console.log($scope.insertProj);
					  
				console.log('Entered Projection Insert Round2');
				DBService1.save($scope.insertProj,function(){
					$state.go('projection'); 
				});
	/*			$scope.selected.proc.$save(function() {
					$state.go('projection'); 
		});*/
	};
			
})
				
				;
