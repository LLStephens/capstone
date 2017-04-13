<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>jQuery UI Datepicker - Default functionality</title>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  
<script type="text/javascript" src="js/locales/en-US-POSIX.min.js"></script>
<script type="text/javascript" src="js/datepicker.min.js"></script>
<input class="form-control" id="date" type="text" placeholder="M/d/y" title="format : M/d/y"/>
							
  <script>
/*   $( function() {
    $( "#datepicker" ).datepicker();
  } );
 
  function myFunction() {
      document.getElementById("myDate").value = "2014-02-09";
  }
  var x = document.getElementById("myDate").value;
  <input type="hidden" name="something" value="thevalue" /> */
  
  $(document).ready(function() {
	$('#date').datepicker({
		daysOfWeekDisabled: [6],
		inputFormat: ["M/d/y"],
	});
});
  </script>
</head>
<body>
 
<p>Date: <input type="text" id="datepicker"></p>
 
 
</body>
</html> 