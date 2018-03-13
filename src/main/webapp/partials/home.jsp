<html>
<head>
<title>Kevin Bacon's Six Degree of Seperation</title>
<script src="js/main.js"></script>
<style type="text/css">
	ol {
	    background: #ff9999;
	    font-size: 40px;
	    padding: 30px;
	}
	
	ul {
	    background: #3399ff;
	    padding: 20px;
	}
	
	ol li {
	    background: #ffe5e5;
	    padding: 15px;
	    margin-left: 35px;
	}
	
	ul li {
	    background: #cce5ff;
	    margin: 5px;
	}
	p{
		background-color: lightgrey;
	    width: 50px;
	    border: 25px solid green;
	    padding: 25px;
	    margin: 25px;
	    font-size: 40px;
	    text-align: center; 
	}
</style>
</head>
<body>
<div data-ng-controller="HomeCtrl">
<pre>

</pre>
	<font size="4">Actor1:</font>
	<select id="first-choice" data-ng-model="actor1.repeatSelect">
		         	<option value="" disabled selected>Select your option</option>
		         	<option data-ng-repeat="a in actor1" value="{{a.name}}" data-ng-click="getX(a.name)">{{a.name}}</option>
		         </select><pre>  </pre>
	<font size="4">Actor2:</font>
	<select id="second-choice" data-ng-model="actor3.repeatSelect">
		         	<option value="" disabled selected>Select your option</option>
		         	<option data-ng-repeat="b in actor2" value="{{b.name}}" data-ng-click="getY(b.name)">{{b.name}}</option>
		         </select>
	<br>
	<br>
	<input type="submit" value="Submit" data-ng-click="showDiv = ! showDiv">
	<div data-ng-show="showDiv">
		<div data-ng-bind-html="links"></div>
	</div>
</div>
</body>
</html>