package invoice;
import java.sql.*;
import java.util.Scanner;
public class User{
	static Booking book=new Booking();
	static User user=new User();
	Scanner scan=new Scanner(System.in);
	public  void usermenu() {
		System.out.println("1 order the iteams\n2 cancel the iteam");
		int option=scan.nextInt();
		switch(option) {
		case 1:
			user.order();
			break;
		case 2:
			user.cancelOrder();
			break;
		case 3:
			book.operation();
		}
	}public void order() {
		System.out.println("To Order the List");
		try {
			DatabaseConnection connection=new DatabaseConnection();
			Statement st=connection.dbconnection();
			System.out.println("Products details");
			ResultSet result=st.executeQuery("select * from Stock where quandity>0");
			while(result.next()) {
				System.out.println(result.getString(2)+"\t"+result.getInt(3));
			}
			System.out.println("Order the product");
			String productName=scan.next();
			System.out.println("product count");
			int productCount=scan.nextInt();
			result=st.executeQuery("select * from Stock");
			boolean isValied=true;
			while(result.next()){
				if(productName.equals(result.getString(2))&&productCount<result.getInt(3)){
					int uptate=st.executeUpdate("update Stock set quandity="+(result.getInt(3)-productCount)+" where Pname='"+productName+"'");
					isValied=false;
					break;
				}
			}if(isValied){
				System.out.println("onely "+result.getInt(3)+" stock");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}user.usermenu();
	}
	public void cancelOrder() {
		System.out.println("Cancel the Order \n1 enter your Id");
		int option=scan.nextInt();
		switch(option){
		case 1:
			System.out.println("");
		}	
	}
}