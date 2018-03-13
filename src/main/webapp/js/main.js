var app = angular.module('tutorialWebApp', ['ngRoute','angularUtils.directives.dirPagination','ngSanitize']);
app.config(['$routeProvider', function ($routeProvider) {
  $routeProvider

    .when("/", {templateUrl: "partials/home.jsp", controller: "PageCtrl"})
    .when("/home",{templateUrl: "partials/home.jsp", controller: "PageCtrl"})
    .when("/about", {templateUrl: "partials/about.jsp", controller: "PageCtrl"})
    .when("/actors", {templateUrl: "partials/SearchFilms.html", controller: "PageCtrl"})
    .when("/delete", {templateUrl: "partials/DeleteFilm.html", controller: "PageCtrl"})
    .when("/update", {templateUrl: "partials/UpdateFilm.html", controller: "PageCtrl"})
    .when("/insert", {templateUrl: "partials/InsertFilm.html", controller: "PageCtrl"})
  .when("/NoOfMovies", {templateUrl: "partials/MovieCount.html", controller: "PageCtrl"});
}]);
app.controller('PageCtrl', function () {
  console.log("Page Controller reporting for duty.");
  
});

app.controller('GetCtrl',['$scope', '$http',function($scope, $http) {
  
	$http.get("http://localhost:8080/KevinBaconDb/webapi/FilmList")
      .then(function (response) {
        $scope.Film = response.data.films;
      });
	$scope.sort = function(keyname){
        $scope.sortKey = keyname;   //set the sortKey to the param passed
        $scope.reverse = !$scope.reverse; //if true make it false and vice versa
    };
}]);
app.controller('SearchCtrl',['$scope', '$http',function($scope, $http) {
	
    $scope.getFilmID =function(x)
      {
		var url="http://localhost:8080/KevinBaconDb/webapi/FilmList/"+'"'+x+'"';
		$http.get(url)
	      .then(function (response) {
	        $scope.Film = response.data.films;
	      });
	 };
	   $scope.getFilmTitle =function(x)
	      {
			var url="http://localhost:8080/KevinBaconDb/webapi/FilmList/Title/"+'"'+x+'"';
			$http.get(url)
		      .then(function (response) {
		        $scope.Film1 = response.data.films;
		      });
		 };
}]);
app.controller('DeleteCtrl',['$scope', '$http',function($scope, $http) {
    $scope.deleteFilm=function(x){
		$http.get("http://localhost:8080/KevinBaconDb/webapi/FilmList/Delete/"+'"'+x+'"')
	      .then(function (response) {
	    	   var res= JSON.stringify(response.data.message);
	        alert(res);
	      });
	};
}]);
app.controller('UpdateCtrl',['$scope', '$http',function($scope, $http) {  
	$scope.UpdateFilm=function(x,y){
		   //alert(x+","+y);
		   //alert("http://localhost:8080/KevinBaconDb/webapi/FilmList/Update/"+'"'+x+'"/'+'"'+y+'"');
			$http.get("http://localhost:8080/KevinBaconDb/webapi/FilmList/Update/"+'"'+x+'"/'+'"'+y+'"')
		      .then(function (response) {
		    	   var res= JSON.stringify(response.data.message);
		        alert(res);
		      });
		};
}]);
app.controller('ActorCtrl',['$scope', '$http',function($scope, $http) {
	  
	$http.get("http://localhost:8080/KevinBaconDb/webapi/FilmList/Actors")
      .then(function (response) {
        $scope.actors = response.data.actors;
      });
	var url;
	$scope.seturl=function(x,y){
		url="http://localhost:8080/KevinBaconDb/webapi/FilmList/MovieCount/"+x+"/"+y;
		console.log(url);
	    google.charts.load('current', {'packages':['corechart']});

	    // Set a callback to run when the Google Visualization API is loaded.
	    google.charts.setOnLoadCallback(drawChart);
	};
    // Load the Visualization API and the corechart package.


    function drawChart() {
      // Create the data table.
      var data = new google.visualization.DataTable();
      
      var jsonData = $.ajax({
          url: url,
          dataType: "json",
          async: false
          }).responseText;
      jsonData=JSON.parse(jsonData);

      var data = new google.visualization.DataTable();
      data.addColumn('string', 'Year');
      data.addColumn('number', 'Number of Movies');

     for (var i = 0; i < jsonData.actors.length; i++) {
         data.addRow([jsonData.count[i].year, jsonData.count[i].no_of_movies]);

      }   
      // Set chart options
      var options = {'title':'Numbers of Movies an actor appeared in,in an year',
              		legend: { position: 'bottom' }
      };

      // Instantiate and draw our chart, passing in some options.
      var chart = new google.visualization.LineChart(document.getElementById('chart_div'));
      chart.draw(data, options);
    }
}]);
app.controller('HomeCtrl',['$scope', '$http',function($scope, $http) {
	$http.get("http://localhost:8080/KevinBaconDb/webapi/FilmList/Actors")
    .then(function (response) {
      $scope.actor1 = response.data.actors;
      $scope.actor2 = response.data.actors;
    });
	var x;
	$scope.getX=function(a)
	{
		console.log("In X");
		x=a;
	};
	$scope.getY=function(b)
	{
		console.log("In y");
		y=b;
		$scope.getLink(x,y);
	};
	$scope.getLink=function(x,y){
		console.log("In getLink"+x+","+y);
		$http.get("http://localhost:8080/KevinBaconDb/webapi/FilmList/KBDegree/"+x+"/"+y)
		      .then(function (response) {
		    	  $scope.links = response.data.str;
		      });
		};
}]);
