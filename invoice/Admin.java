package invoice;
import java.sql.*;
import java.util.Scanner;
public class Admin{
	static Booking book=new Booking();
	Scanner scan=new Scanner(System.in); 
	static  Admin clint=new Admin();

	private  void clintMenu(){
		System.out.println("------Admin_Option-----\n1 addStocks\n2 remove stock\n3 Back To Menu");
		int option=scan.nextInt();
		switch(option){
		case 1:
			clint.addStock();
			break;
		case 2:
			clint.removeStock();
			break;
		case 3:
			clint.adminOperation();
			break;	
		}
	}
	private void addStock() {
		try {
			DatabaseConnection connection=new DatabaseConnection();
			Statement st=connection.dbconnection();
			System.out.println("Enter the stock details\n1 ProductName");
			String productName=scan.next();
			System.out.println("Product Quantity");
			int productQuentity=scan.nextInt();
			System.out.println("product Price");
			int productPrice=scan.nextInt();
			int rs=st.executeUpdate("insert into Stock(Pname,quandity,rate) values('"+productName+"',"+productQuentity+","+productPrice+")");
			System.out.println("product added sucessfully\n1 To you want more add");
			int option=scan.nextInt();
			if(option==1) {
				clint.addStock();
			}else {
				clint.clintMenu();
			}	
		}catch(Exception e) {
			e.printStackTrace();
		}		
	}private void removeStock() {
		try {
			DatabaseConnection connection=new DatabaseConnection();
			Statement st=connection.dbconnection();
			System.out.println("Enter the stock details\n1 ProductName");
			String productName=scan.next();
			ResultSet rt=st.executeQuery("select * from Stock");
			while(rt.next()){
				if(productName.equals(rt.getString(1))){
					int uq=st.executeUpdate("delete from Stock where Pname='"+productName+"'");
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		clint.clintMenu();
	}
	public void adminOperation(){
		Admin clint=new Admin();
		System.out.println("1 admin menu\n 2 back to menu");
		int opetion=scan.nextInt();
		switch(opetion) {
		case 1:
			clint.clintMenu();
		case 2:
			book.operation();
		}
	}
}