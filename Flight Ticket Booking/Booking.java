package FlightBookingApplication;
import java.sql.*;
import java.util.*;

public class Booking {
	static Scanner scan=new Scanner(System.in);
	static Booking book=new Booking();
	static Flightdetails ft=new Flightdetails();
	public static void main(String[] args)throws Exception{

		book.menu();
	}public void menu() {
		System.out.println("Select your option user or Admin\n1 Admin\n2 User");
		int option=scan.nextInt();
		switch(option){
		case 1:
			book.adminmenu();
			break;
		case 2:
			book.usermenu();
		}
	}private void adminmenu() {
		System.out.println("Select the Option \n1 Passanger Details\n2 Ticket Details\n3 Flight Details\n4 back to menu\nselect your options");
		int option=scan.nextInt();
		switch(option) {
		case 1:
			book.passangerDetails();
			break;
		case 2:
			book.ticketDetails();
			break;
		case 3:
			ft.admin();
			break;	
		case 4:
			book.menu();
		}
	}
	public void ticketDetails() {
		System.out.println("Ticket Details");
		try {
			DatabaseConnection db=new DatabaseConnection();
			Statement st=db.dbConnection();
			ResultSet res=st.executeQuery("select * from Ticket");
			System.out.println("p.Id\tp.name\tFlight Name\tp.bordingPoint\tp.landing point\tE");
			while(res.next()) {
				System.out.println(res.getInt(1)+"\t"+res.getString(2)+"\t"+res.getString(3)+"\t"+res.getString(4)+"\t"+res.getString(5)+"\t"+res.getString(6));
			}
		}
		catch(Exception e){
          e.printStackTrace();
		}
		book.adminmenu();
	}
	public void usermenu(){
		System.out.println("\n1 ticket Booking\n 2 ticket cancel");
		int option=scan.nextInt();
		switch(option) {
		case 1:
			book.bookingTicket();
			break;
		case 2:
			book.cancelTisket();
			break;	
		}
		book.operation();
	}

	private void cancelTisket() {


	}
	public void operation(){
		System.out.println("Select the Option \n1 FlightDetails\n2 \n3 back to menu\nselect your options");
		int option=scan.nextInt();
		switch(option) {
		case 1:
			ft.flightDetails();
			break;
		case 2:
			book.bookingTicket();
			break;
		case 3:
			book.menu();
		}
	}

	public void bookingTicket() {
		try {
			DatabaseConnection ar=new DatabaseConnection();
			Statement st=ar.dbConnection();
			boolean isValid=true;
			while(isValid) {
				ft.flightDetails();
				System.out.println("Passanger name");
				String pName=scan.next();
				System.out.println("Select your bording point");
				String bordingPoint=scan.next();
				System.out.println("Select your end poind");
				String landingPoint=scan.next();

				ResultSet rset=st.executeQuery("select * from FlightDetails");
				while(rset.next()) {
					System.out.println(rset.getString(3));
					if(rset.getString(3).equals(bordingPoint)){
						System.out.println("Select your flight");
						String fName=scan.next();
						int Trate=2000;
						System.out.println("Enter the mailId");
						String mailId=scan.next();
						int rs=st.executeUpdate("insert into Ticket(Pname,Fname,point,end,rate) values('"+pName+"','"+fName+"','"+bordingPoint+"','"+landingPoint+"',"+Trate+")");
						rs=st.executeUpdate("insert into PassangerInfo(Pname,mailId,bordingPoint,landingPoint) values('"+pName+"','"+mailId+"','"+bordingPoint+"','"+landingPoint+"')");
						System.out.println("--------IRATC   ------------\npassanger Name: "+pName+"\nFlight Name: "+fName+"\n bording point  "+bordingPoint+"\n"+landingPoint);
						System.out.println("To you continue\n1 yes\n2 no");
						int option=scan.nextInt();
						switch(option) {
						case 1:
							break;
						case 2:
							isValid=false;
						}
					}else {
						System.out.println("Flight not Avilable");
						break;
					}
				}
			}
		}
		catch(Exception e) {
		}
	}public void passangerDetails() {
		try {
			DatabaseConnection ar=new DatabaseConnection();
			Statement st=ar.dbConnection();	
			ResultSet rs=st.executeQuery("select * from PassangerInfo");
			System.out.println("Passanger Info\nP.Id\tP.name\tmailId\tbordingPoint\tlandingPoint");
			while(rs.next()) {
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getInt(5));
			}
		}
		catch(Exception e) {
		}
		book.operation();
	}
}