<head>
<style type="text/css">

#customers {
    font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
    border-collapse: collapse;
    width: 100%;
}

#customers td, #customers th {
    border: 1px solid #ddd;
    padding: 8px;
}

#customers tr:nth-child(even){background-color: #f2f2f2;}

#customers tr:hover {background-color: #ddd;}

#customers th {
	cursor:pointer;
    padding-top: 12px;
    padding-bottom: 12px;
    text-align: left;
    background-color: #e5e237;
    color: white;
}
.sort-icon {
    font-size: 9px;
    margin-left: 5px;
}

</style>
<title>Movie List</title>
<script src="js/dirPagination.js"></script>
</head>
<body>
<div class="bs-component" style="overflow-x:auto;" data-ng-controller="GetCtrl">
<pre>

</pre>
	<table id="customers">
	  <tr >
	    <th data-ng-click="sort('title')">Title
	    <span class="glyphicon sort-icon" data-ng-show="sortKey=='title'" data-ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span>
	    </th>
	    <th data-ng-click="sort('language')">Language
	    <span class="glyphicon sort-icon" data-ng-show="sortKey=='language'" data-ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span>		
	    </th>
	    <th data-ng-click="sort('duration')">Duration
	    <span class="glyphicon sort-icon" data-ng-show="sortKey=='duration'" data-ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span>
	    </th>
	    <th data-ng-click="sort('rating')">Rating
	    <span class="glyphicon sort-icon" data-ng-show="sortKey=='rating'" data-ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span>
	    </th>
	    <th data-ng-click="sort('director_Name')">Director
	    <span class="glyphicon sort-icon" data-ng-show="sortKey=='director_Name'" data-ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span>
	    </th>
	  </tr>
	  <tr dir-paginate="x in Film|orderBy:sortKey:reverse|itemsPerPage:500">
		<td>{{x.title}}</td>
		<td>{{x.language}}</td>
		<td>{{x.duration}}</td>
		<td>{{x.rating}}</td>
		<td>{{x.director_Name}}</td>
	  </tr>
	</table>
<dir-pagination-controls
       max-size="10"
       direction-links="true"
       boundary-links="true" >
</dir-pagination-controls>
</div>
</body>




	