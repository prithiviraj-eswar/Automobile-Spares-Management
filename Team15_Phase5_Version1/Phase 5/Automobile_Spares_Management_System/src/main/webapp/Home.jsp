<!DOCTYPE html>
<html>
	<head>
		<title>Automobile spares inventory management system</title>
		<title>Bootstrap Example</title>
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
				<h2 style="float: left;border: 2px solid black;">Automobile spares inventory management system</h2>
			</div>
		</div>
		<div style="height:500px">
			<div style="margin-left: 15px;">
				<P>
				<strong>PLEASE SELECT AN OPTION</strong>:
				</P>
				<p>		
					<FORM action="OracleDBInterface" NAME="form1" METHOD="GET">
					<br>
					<button type="button" onclick="location.href = 'Customer_Details.jsp';" class="btn btn-info btn-primary" Name="Customer" value="Customer_DETAILS">Customer Details</button>
			        <br>
			        <br>
			        <button type="button" onclick="location.href = 'Product_Detail.jsp';" class="btn btn-info btn-primary" Name="Product" value="PRODUCT_DETAILS">Product Details</button>
			        <br>	
			        <br>
					<button type="button" onclick="location.href = 'Sales_History.jsp';" class="btn btn-info btn-primary" Name="SALES" value="SALES_DETAILS">Sales History Details</button>
			        <br>
			        <br>
					<button type="button" onclick="location.href = 'Business.jsp';" class="btn btn-info btn-primary" Name="BUISNESS" value="BUISNESS">Business</button>
					</FORM>
				</p>	
			</div>
		</div>
		<div style="height:100px">
		</div>		
	</body>
</html>