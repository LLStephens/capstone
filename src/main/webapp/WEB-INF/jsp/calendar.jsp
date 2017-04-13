<!DOCTYPE html>
<html>
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
<style type="text/css" media="screen">
    html, body{
        margin:0px;
        padding:0px;
        height:100%;
        overflow:hidden;
    }   
</style>
<div id="scheduler_here" class="dhx_cal_container" style='width:100%; height:100%;'>
    <div class="dhx_cal_navline">
        <div class="dhx_cal_prev_button">&nbsp;</div>
        <div class="dhx_cal_next_button">&nbsp;</div>
        <div class="dhx_cal_today_button"></div>
        <div class="dhx_cal_date"></div>
        <div class="dhx_cal_tab" name="day_tab" style="right:204px;"></div>
        <div class="dhx_cal_tab" name="week_tab" style="right:140px;"></div>
        <div class="dhx_cal_tab" name="month_tab" style="right:76px;"></div>
    </div>
    <div class="dhx_cal_header"></div>
    <div class="dhx_cal_data"></div> 
scheduler.init('scheduler_here', new Date(),"month");
     
</div>
</body>
</html>