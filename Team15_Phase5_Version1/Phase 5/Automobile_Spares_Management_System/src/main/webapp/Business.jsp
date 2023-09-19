<!DOCTYPE html>
<html>
	<head>
		<title>Auto Spare Parts</title>
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
				<h2 style="float: left;border: 2px solid black;cursor: pointer;" onclick="location.href = 'Home.jsp';">Auto Spare Parts</h2>
			</div>
		</div>
		<div style="height:500px">
			<div style="margin-left: 15px;">
				
				
		
				<br>
				<strong>Getting Customer Details who have done purchase </strong>:
				<br>
			
				<FORM action="OracleDBInterface" NAME="form1" METHOD="GET">
					<INPUT TYPE="submit" Name="CUSTOMER_DETAILS" value="Get Customer Details">
					Enter No of Purchase : <INPUT TYPE="Text" NAME="purch_no"> <br>
				</FORM>
				
				<br>
				<strong>-- Grouping brand models by luxury and getting their respective suppliers and model counts</strong>:
				<br>
			
				<FORM action="OracleDBInterface" NAME="form1" METHOD="GET">
					<INPUT TYPE="submit" Name="Supplier_DETAILS" value="Get Supplier Details">
					Enter the name of Category : <INPUT TYPE="Text" NAME="cat_name"> <br>
				</FORM>
				
				
				<br>
				<strong>Displaying the count of category purchase by a specific customer</strong>:
				<br>
			
				<FORM action="OracleDBInterface" NAME="form1" METHOD="GET">
					<INPUT TYPE="submit" Name="category_details" value="Get customer details">
					Enter the CUSTOMER ID : <INPUT TYPE="Text" NAME="cate_name"> <br>
				</FORM>
				
								
				<br>
				<strong>Rollup function for PRODUCT and SALES_HISTORY</strong>:
				<br>
			
				<FORM action="OracleDBInterface" NAME="form1" METHOD="GET">
				<INPUT TYPE="submit" Name="rollup" value="Get details">
				</FORM>
				
				<br>
				<strong>Fetching first 10 rows of customer purchasing for a category </strong>:
				<br>
			
				<FORM action="OracleDBInterface" NAME="form1" METHOD="GET">
					<INPUT TYPE="submit" Name="category" value="Get category Count">
				</FORM>				
			</div>
		</div>
		<div style="height:100px">
		</div>		
	</body>
</html>