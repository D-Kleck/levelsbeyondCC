angular
	.module('LevelsBeyond')
	.factory('AngularIssues', function($http)
	{
		function getIssues(page)
		{

			return $http.get('https://api.github.com/repos/angular/angular/issues?page='+page);
		}
		return {
			getIssues: getIssues
		}

	});