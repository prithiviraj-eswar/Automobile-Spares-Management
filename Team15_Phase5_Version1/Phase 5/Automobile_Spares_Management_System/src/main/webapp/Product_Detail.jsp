<!DOCTYPE html>
<html>
	<head>
		<title>Automobile spares inventory management system</title>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	</head>
	<style>
		body {
		  background-color: rgb(2,0,36);
		}
	</style>
	<body style="background: linear-gradient(90deg, rgba(2,0,36,1) 0%, rgba(63,7,81,0.3900910706079307) 1%, rgba(9,121,56,0.4433123591233369) 82%, rgba(0,212,255,1) 100%)">
		<div style="height:100px">
			<div style="margin-left: 15px;">
				<h2 style="float: left;border: 2px solid black;cursor: pointer;" onclick="location.href = 'Home.jsp';">Automobile spares inventory management system</h2>
			</div>
		</div>
		<div style="height:500px">
			<div style="margin-left: 15px;">
				<br>
				<strong>Get all the Product details</strong>:
				<br>
			
				<FORM action="OracleDBInterface" NAME="form1" METHOD="GET">
					<INPUT TYPE="submit" Name="PRODUCT_DETAILS" value="Get Product Details">
				</FORM>	
				<br>
				<strong>Update the Purchase cost for a specific Product ID</strong>
				<br>
				<FORM action="OracleDBInterface" NAME="form2" METHOD="Post">
					Enter Product  Id : <INPUT TYPE="Text" NAME="prod_id"> <br>
					<br> Enter New PurchaseCost  : <INPUT TYPE="Text" NAME="COST"> <br>
					<INPUT TYPE="submit" Name="SubmitCredentials" value="Update Cost">
				</FORM>	
				<br>
			</div>
		</div>
		<div style="height:100px">
		</div>		
	</body>
</html>