import java.io.IOException;
import java.io.PrintWriter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OracleDBInterface extends HttpServlet {
       
	private static final long serialVersionUID = 1L;
	public OracleDBInterface() {
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Customer details
		if(request.getParameter("CustomerDetailsSubmit")!=null && request.getParameter("CustomerDetailsSubmit").toString().equalsIgnoreCase("Get Customer Details")) {
			PrintWriter pw = response.getWriter();
			Connection connection = jdbcConnection();
			try {
				Statement stmt = connection.createStatement();
				String query = "Select Cust_ID, First_Name, Last_Name, Email, Phone_Number, DateofBirth, Addr  from S22_S003_15_Customer";
				System.out.println(query);
				ResultSet rs = stmt.executeQuery(query);
				pw.println("Customer Details");
				while(rs.next())
				{	
					pw.println("Customer Id: "+rs.getString("Cust_ID")+",	 First Name: " +rs.getString("First_Name")+",	 Last Name : " +rs.getString("Last_Name")+",	 Email : " +rs.getString("Email")+",	 Phone_Number: " +rs.getString("Phone_Number")+",	 DateofBirth : " +rs.getString("DateofBirth")+",	 Addr : " +rs.getString("Addr"));
			        String newline = System.lineSeparator();
			        System.out.println(newline);
				}

			}catch (Exception e) {
				System.out.println("error in accessing the relation");
				e.printStackTrace();
				return;
			}
		}
		//Product details
		else if(request.getParameter("PRODUCT_DETAILS")!=null && request.getParameter("PRODUCT_DETAILS").toString().equalsIgnoreCase("Get Product Details")) {
			PrintWriter pw = response.getWriter();
			Connection connection = jdbcConnection();
			try {
				Statement stmt = connection.createStatement();
				String query = "select Product_ID, Category_ID, Brand, Model, Quantity, Purchase_Cost, Selling_Cost, Category_Name, Product_Name, Supplier_ID FROM S22_S003_15_PRODUCT";
				System.out.println(query);
				pw.println("Product Details");
				ResultSet rs = stmt.executeQuery(query);
				while(rs.next())
					{
					pw.println("Product ID "+rs.getString("Product_ID")+",	 Category ID : " +rs.getString("Category_ID")+",	 Brand : " +rs.getString("Brand")+",	 Quantity : " +rs.getString("Quantity")+",	 Purchase_Cost : " +rs.getString("Purchase_Cost")+",  Selling Cost : " +rs.getString("Selling_Cost")+", Product Name: "+rs.getString("Product_Name")+", Category Name : " +rs.getString("Category_Name"));
					pw.println("\n");
					}
				}
			catch (Exception e) {
				System.out.println("error in accessing the relation");
				e.printStackTrace();
				return;
			}
		}



		else if(request.getParameter("SALES_DETAILS")!=null && request.getParameter("SALES_DETAILS").toString().equalsIgnoreCase("Get Sales Details")) {
			PrintWriter pw = response.getWriter();
			Connection connection = jdbcConnection();
			try {
				Statement stmt = connection.createStatement();
				String query = "select Purchase_ID, Cust_ID, Purchase_Date, Prod_ID, Category_ID, Quantity, Prod_Amt, License_Num, Emp_ID, Access_ID FROM S22_S003_15_SALES_HISTORY";
				System.out.println(query);
				ResultSet rs = stmt.executeQuery(query);
				pw.println("PRODUCT DETAILS");
				while(rs.next())
					{
					pw.println("Purchase ID "+rs.getString("Purchase_ID")+",	 Customer ID : " +rs.getString("Cust_ID")+",	 Purchase Date : " +rs.getString("Purchase_Date")+",	 Product ID : " +rs.getString("Prod_ID")+",	 Category ID : " +rs.getString("Category_ID")+",  Quantity : " +rs.getString("Quantity")+", Product Amount: "+rs.getString("Prod_Amt")+", License_Num : " +rs.getString("License_Num")+", EMP ID : " +rs.getString("Emp_ID")+", Access_ID : " +rs.getString("Access_ID"));
					pw.println("\n");
					}
				}
			catch (Exception e) {
				System.out.println("error in accessing the relation");
				e.printStackTrace();
				return;
			}
		}

		
		//business button 1
		else if(request.getParameter("CUSTOMER_DETAILS")!=null && request.getParameter("CUSTOMER_DETAILS").toString().equalsIgnoreCase("Get Customer Details")) {
			PrintWriter pw = response.getWriter();
			Connection connection = jdbcConnection();
			String purchno = request.getParameter("purch_no");
			try {
				Statement stmt = connection.createStatement();
				String query = "SELECT First_Name,Last_Name,Email FROM S22_S003_15_CUSTOMER WHERE Cust_ID IN(SELECT S.Cust_ID FROM S22_S003_15_SALES_HISTORY S GROUP BY S.Cust_ID HAVING COUNT(S.Cust_ID) > '"+purchno+"')";
				System.out.println(query);
				ResultSet rs = stmt.executeQuery(query);
				pw.println("Getting Customer Details who have done purchase :");
				while(rs.next())
				{
					pw.println("FIRST NAME: "+rs.getString("First_Name")+",	 Last_Name : " +rs.getString("Last_Name")+",	 Email : " +rs.getString("Email"));
					pw.println("\n");
				}
			}catch (Exception e) {
				System.out.println("error in accessing the relation");
				e.printStackTrace();
				return;
			}
		}
		//business button 2
		
		else if(request.getParameter("Supplier_DETAILS")!=null && request.getParameter("Supplier_DETAILS").toString().equalsIgnoreCase("Get Supplier Details")) {
			PrintWriter pw = response.getWriter();
			Connection connection = jdbcConnection();
			String cat_name = request.getParameter("cat_name");
			try {
				Statement stmt = connection.createStatement();
				String query = "SELECT p1.Brand, p1.Model, s1.Supplier_ID, s1.Supplier_Name ,count(Model) FROM S22_S003_15_SUPPLIER s1, S22_S003_15_PRODUCT p1 WHERE s1.Supplier_ID = p1.Supplier_ID and p1.Category_Name='"+cat_name+"' GROUP BY p1.Brand, p1.Model, s1.Supplier_ID, s1.Supplier_Name ";
				System.out.println(query);
				ResultSet rs = stmt.executeQuery(query);
				while(rs.next())
				{	
					pw.println("Brand: "+rs.getString("Brand")+",	 Model: " +rs.getString("Model")+",	 Supplier ID : " +rs.getString("Supplier_ID")+",	 Supplier Name : " +rs.getString("Supplier_Name")+",	 Count(model) : " +rs.getString("count(Model)"));
					pw.println("\n");
				}
				
			
				
			}
			catch (Exception e) {
				System.out.println("error in accessing the relation");
				e.printStackTrace();
				return;
			}
			
		}




		//business button 3
		else if(request.getParameter("category")!=null && request.getParameter("category").toString().equalsIgnoreCase("Get category Count")) {
			PrintWriter pw = response.getWriter();
			Connection connection = jdbcConnection();
			try {
				Statement stmt = connection.createStatement();
				String query = "SELECT Purchase_ID,Cust_ID,Purchase_Date,Prod_ID,Category_ID,Quantity,COUNT(Quantity) OVER (PARTITION BY Category_ID) AS TOTAL_CATEGORY_PURCHASED_BY_A_CUSTOMER FROM S22_S003_15_SALES_HISTORY ORDER BY Category_ID OFFSET 0 ROWS FETCH NEXT 10 ROWS ONLY";
				System.out.println(query);
				ResultSet rs = stmt.executeQuery(query);
				pw.println("Displaying the count of catergory purchased by a customer");
				while(rs.next())
				{
					pw.println("Purchase Id: "+rs.getString("Purchase_ID")+",	 CUSTOMER ID : " +rs.getString("Cust_ID")+",	 Purchase_Date : " +rs.getString("Purchase_Date")+",	 Product ID : " +rs.getString("Prod_ID")+",	 Category ID : " +rs.getString("Category_ID")+",	 Quantity : " +rs.getString("Quantity")+"TOTAL_CATEGORY_PURCHASED_BY_A_CUSTOMER:"+rs.getString("TOTAL_CATEGORY_PURCHASED_BY_A_CUSTOMER"));
					pw.println("\n");
				}
			}catch (Exception e) {
				System.out.println("error in accessing the relation");
				e.printStackTrace();
				return;
			}
		}
		//Business button 4
		
		else if(request.getParameter("category_details")!=null && request.getParameter("category_details").toString().equalsIgnoreCase("Get customer details")) {
			PrintWriter pw = response.getWriter();
			String category_name = request.getParameter("cate_name"); 
			Connection connection = jdbcConnection();
			try {
				Statement stmt = connection.createStatement();
				String query = "SELECT Purchase_ID,Cust_ID,Purchase_Date,Prod_ID,Category_ID,Quantity,COUNT(Quantity) OVER (PARTITION BY Category_ID) AS TOTAL_CATEGORY_PURCHASED_BY_A_CUSTOMER FROM S22_S003_15_SALES_HISTORY WHERE Cust_ID = '"+category_name+"' ORDER BY Category_ID";
				System.out.println(query);
				ResultSet rs = stmt.executeQuery(query);
				pw.println("Displaying the count of catergory purchased by a customer");
				while(rs.next())
				{
					pw.println("Purchase Id: "+rs.getString("Purchase_ID")+",	 CUSTOMER ID : " +rs.getString("Cust_ID")+",	 Purchase_Date : " +rs.getString("Purchase_Date")+",	 Product ID : " +rs.getString("Prod_ID")+",	 Category ID : " +rs.getString("Category_ID")+",	 Quantity : " +rs.getString("Quantity")+"TOTAL_CATEGORY_PURCHASED_BY_A_CUSTOMER:"+rs.getString("TOTAL_CATEGORY_PURCHASED_BY_A_CUSTOMER"));
					pw.println("\n");
				}
			}catch (Exception e) {
				System.out.println("error in accessing the relation");
				e.printStackTrace();
				return;
			}
		}
		
		//Business button 5(ROLL UP)
		
		else if(request.getParameter("rollup")!=null && request.getParameter("rollup").toString().equalsIgnoreCase("Get details")) {
			PrintWriter pw = response.getWriter();
			Connection connection = jdbcConnection();
			try {
				Statement stmt = connection.createStatement();
				String query = "SELECT p.Brand,p.Model,count(p.Model) as model_count from S22_S003_15_PRODUCT p , S22_S003_15_SALES_HISTORY s where p.Product_ID = s.Prod_ID  group by rollup( p.Brand , p.Model)";
				System.out.println(query);
				ResultSet rs = stmt.executeQuery(query);
				pw.println("Rollup function for PRODUCT and SALES_HISTORY");
				while(rs.next())
				{	
					pw.println("Brand "+rs.getString("Brand")+",	 Model : " +rs.getString("Model") +",	 Count(model) : " +rs.getString("model_count"));
					pw.println("\n");
				}
			}catch (Exception e) {
				System.out.println("error in accessing the relation");
				e.printStackTrace();
				return;
			}
		}


	}
	
	//update query
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("SubmitCredits")!=null && request.getParameter("SubmitCredits").toString().equalsIgnoreCase("Update Quantity")) {
			PrintWriter pw = response.getWriter();
			Connection connection = jdbcConnection();
			
			String purchid = request.getParameter("purch_id");
			String quant = request.getParameter("Quantity");
	
			try {
				Statement stmt = connection.createStatement();
				String updateQuery = "UPDATE S22_S003_15_SALES_HISTORY SET Quantity = '"+quant+"' Where Purchase_ID = '"+purchid+"'";
				System.out.println(updateQuery);
				stmt.executeUpdate(updateQuery);
				pw.println("The Quantity for Purchase Id - '"+purchid+"' is updated to '"+quant+"'");
				stmt.close();
				connection.close();
			} catch (SQLException e) {
	
				System.out.println("error in accessing the relation");
				e.printStackTrace();
				return;
	
			}
		}
		
		else if(request.getParameter("SubmitCredentials")!=null && request.getParameter("SubmitCredentials").toString().equalsIgnoreCase("Update Cost")) {
			PrintWriter pw = response.getWriter();
			Connection connection = jdbcConnection();
			
			String prodid = request.getParameter("prod_id");
			String cost = request.getParameter("COST");
	
			try {
				Statement stmt = connection.createStatement();
				String updateQuery = "UPDATE  S22_S003_15_PRODUCT set Purchase_Cost = '"+cost+"' where Product_ID = '"+prodid+"'";
				System.out.println(updateQuery);
				stmt.executeUpdate(updateQuery);
				pw.println("The Purchase for Product Id - '"+prodid+"' is updated to '"+cost+"'");
				stmt.close();
				connection.close();
			} catch (SQLException e) {
	
				System.out.println("error in accessing the relation");
				e.printStackTrace();
				return;
	
			}
		}
	}



	public static Connection jdbcConnection() {

		System.out.println("-------- Oracle JDBC Connection Testing ------");

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");

		} catch (ClassNotFoundException e) {

			System.out.println("Where is your Oracle JDBC Driver?");
			e.printStackTrace();
			return null;

		}

		System.out.println("Oracle JDBC Driver Registered!");

		Connection connection = null;

		try {

			connection = DriverManager.getConnection("jdbc:oracle:thin:@acaddbprod-2.uta.edu:1523/pcse1p.data.uta.edu",
					"sxt0297", "Sujitchintu6528");
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return null;

		}

		if (connection != null) {

			System.out.println("You made it, take control of your database now!\n");
			return connection;
		} else {
			System.out.println("Failed to make connection!");
		}
		return null;

	}

}