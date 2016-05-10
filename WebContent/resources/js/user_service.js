'use strict';

App.factory('User', [ '$resource', function($resource) {
	// $resource() function returns an object of resource class
	var message = $resource('http://localhost:8080/www/user1/:name', {
		name : '@name'
	},// Handy for update & delete. id will be set with id of instance
	{
		update : {
			method : 'PUT' // To send the HTTP Put request when calling this
		// custom update method.
		}

	});
	return message;
} ]);