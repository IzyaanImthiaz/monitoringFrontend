<%@page import="com.maven.pafMonitor.Monitor"%>
<%@page import="com.maven.pafMonitor.MonitorRepository"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>


<html>
<head>
<meta charset="ISO-8859-1">
<title>MonitoringService details</title>
<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="Components/jquery-3.2.1.min.js"></script>
<script src="Components/monitor.js"></script>
</head>
<body>
<div class="container">
 <div class="row">
 <div class="col-8">
 <h1 class="m-3">Monitoring Service</h1>
 
 <form id="formItem" name="formItem" >
 Account Number:
<input id="accNo" name="accNo" type="text"
 class="form-control form-control-sm">
<br>Current Units:
<input id="curUnits" name="curUnits" type="text"
 class="form-control form-control-sm">
 
 
<br>
<input id="btnSave" name="btnSave" type="button" value="Save"
 class="btn btn-primary">
 <input type="hidden" id="hidItemIDSave"
 name="hidItemIDSave" value="">
</form>

<div id="alertSuccess" class="alert alert-success"></div>
<div id="alertError" class="alert alert-danger"></div>

 
<br>
<div id="divItemsGrid">
<%
MonitorRepository itemObj = new MonitorRepository();
 out.print(itemObj.getMonitors());
%>
</div>
 </div>
 </div>

 <br>
 <div class="row">
 <div class="col-12" id="colStudents">

 </div>
 </div>
</div>
</body>

</html>
