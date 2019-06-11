angular
	.module('LevelsBeyond')
	.filter('DataFilter', function()
	{

		return function dataeFilter(issues) {
			var now = new Date();
			var from = now.getTime()/1000;
			var to = from - 604800;

			var result = []

			angular.forEach(issues, function(issue){
				if (Date.parse(issue.created_at)/1000 < from &&
					Date.parse(issue.created_at)/1000 > to)
				{
					result.push(issue)
				}
			});

			return result;
		};

	});
