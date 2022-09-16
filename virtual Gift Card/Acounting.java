import java.util.*;
class Acounting
{
				static Scanner scan=new Scanner(System.in);
				static int cu_id=4;
				static int card_id=1003;
				static int bill_no=1;
				static HashMap<Integer,Integer>bankAccount_details=new HashMap<Integer,Integer>();
			  static HashMap<Integer,AccountOppening>gift_card=new HashMap<Integer,AccountOppening>();
			  static ArrayList<Purchase>purchase_list=new ArrayList<Purchase>(); 
   public static void main(String[] args)
   {
   	bankAccount_details.put(1,10000);
   	bankAccount_details.put(2,20000);
   	bankAccount_details.put(3,50000);
   	gift_card.put(1001,new AccountOppening(1,2000,7845,50,"Blocked"));
   	gift_card.put(1002,new AccountOppening(1,2000,7845,50,"Active"));
   	gift_card.put(1002,new AccountOppening(3,50000,7845,500,"Active"));
    logInMenu();
   }
   public static void logInMenu()
   {
   	   System.out.println("--------------Welcome to Bank-----------");
   		 System.out.println("1 Creat Bank Account");
   		 System.out.println("2 By Gift card");
   		 System.out.println("3 gift_cardView");
   		 System.out.println("4 bank_AccountView");
   		 System.out.println("5 buy gifts");
   		 System.out.println("6 card block/unblock");
   		 System.out.println("7 Purchase iteam details");
   		 System.out.println("8 close giftcard");
   		 System.out.println("------------------------");
   		 System.out.println("----Enter your Option---");
   		 int option=scan.nextInt();
   		 switch(option)
   		 {
        case 1:
        	    bankAccount();
        break;
        case 2:
        			creatGiftCard();
        break;				    
        case 3:
       	     gift_cardView();
        break;
        case 4:
        	   accountDetails();
        break;
        case 5:
             buyGift();
        break;
        case 6:
        	   cardBlockUnblock();
        break;
        case 7:
             purchaseDetails();
        break;
        case 8:
             closeGiftCard();
        break;               	   
   		 }
   	}   	
   	public static void bankAccount()
   	{
   		  System.out.println("1 Already Account deposite amount");
   		  System.out.println("2 new Account");
   		  System.out.println("Enter your option");
   		  int option=scan.nextInt();
   		  switch(option)
   		  {
   		  case 1:
			   		 System.out.println("Enter your customer_id");
			   		 int  cu_id1=scan.nextInt();
			   		 System.out.println("How much amount to deposite");
			   		 int dep_amount=scan.nextInt();
			   		 bankAccount_details.replace(cu_id1,dep_amount+bankAccount_details.get(cu_id1));
             logInMenu();
	   		break;
	   	  case 2:
	   	  	   System.out.println("Enter your deposite Amount");
			   		  int deposite_Amount=scan.nextInt();
			   		  bankAccount_details.put(cu_id,deposite_Amount);
			   		  cu_id++;
			   		  logInMenu();
			  break; 		  
   	}
   }
   public static void accountDetails()
   {
         System.out.println("------BankAccount deatils-------");
   		    System.out.println("|Cu_id        balance|");
   		  	for(Map.Entry j:bankAccount_details.entrySet())
   		  	{
   		  	    System.out.println("|"+j.getKey()+"          "+j.getValue());
   		    }
   		  logInMenu();
   	}
    public static void creatGiftCard()
    {
    	System.out.println("Enter your customer_id");
    	int cu_id1=scan.nextInt();
      boolean isValied=false;
      	if(bankAccount_details.containsKey(cu_id1))
      	{
      		isValied=true;
      	}
      
      if(isValied)
      {
      		System.out.println("buy gift card Amount");
      		int amount=scan.nextInt();
          System.out.println("Enter your pin");
      		int pin=scan.nextInt();
      		if(bankAccount_details.get(cu_id1)>amount)
      		{
		      		gift_card.put(card_id,new AccountOppening(cu_id1,amount,pin,0,"Active"));
		      		int total_amount=bankAccount_details.get(cu_id1)-amount;
		      		bankAccount_details.replace(cu_id1,total_amount);
		      		card_id++;
		      		System.out.println("\n----Gift card will be created sucessfully----\n");
      	  }
      	  else
      	  {
              System.out.println("Account blance is low "+bankAccount_details.get(cu_id1));
      	  }
      }
      else
      {
        	System.out.println("incorret the customer_id please log in correct Id");
        	logInMenu();
      }
        logInMenu();
    }
    public static void gift_cardView()
    {
    	System.out.println("-----------Gift cards deatils-------");
    	System.out.println("card_id  cu_id  Amount  pin    status   Cardtype");
    	for(Map.Entry<Integer,AccountOppening> j:gift_card.entrySet())
    	{
    		AccountOppening a=j.getValue();
    		System.out.print(j.getKey()+"  ");
    		a.display();
    		if(a.getcard_type()>=200)
    		{
    			System.out.print("    GOLD");
    		}
    		else{
    			System.out.print("    Silver");
    		}
    		System.out.println("");
    	}
    	logInMenu();
    }
    public static void buyGift()
    {
    	System.out.println("1 Enter your customer_id\n");
    	int cu_id1=scan.nextInt();
    	System.out.println("2 Enter your card_id\n");
    	int card1_id=scan.nextInt();
    	System.out.println("3 Enter your pin\n");
    	int pin=scan.nextInt();
    	if(gift_card.get(card1_id).getcard_status().equals("Active"))
    	{
	    	for(Map.Entry<Integer,AccountOppening> j:gift_card.entrySet())
	    	{
	    		AccountOppening a=j.getValue();
	    		 if(a.getcard_pin()==pin&&card1_id==j.getKey())
	    		 {
	    		 	System.out.println("Purchase Amount");
	    		 	int purchase_Amount=scan.nextInt();
		    		 	if(a.getdeposite_amount()>purchase_Amount)
		    		 	{  
		    		 		int rewardPoint=0;
		    		 		if(purchase_Amount>=500)
		    		 		{
                  rewardPoint+=50; 
		    		 		}
		    		 			gift_card.replace(card1_id,new AccountOppening(cu_id1,a.getdeposite_amount()-purchase_Amount,pin,a.getcard_type()+rewardPoint,"Active"));
		    		 			purchase_list.add(new Purchase(bill_no,card1_id,purchase_Amount));
		    		 			bill_no++;
		    		 			System.out.println("your welcome Gift card purchase sucessfully");
		    		 	}
		    		 	else
		    		 	{
		    		 			System.out.println("Amount Exited your amount is currently : "+a.getdeposite_amount());
		    		 	}
	    		 }
	      } 
     }
     else
     {
     			System.out.println("\n---!..SORRY````--Your card is Blocked---\n");
     } 
     logInMenu();
    }
    public static void cardBlockUnblock()
    {
    	System.out.println("Enter the card_id");
    	int card1_id=scan.nextInt();
    	System.out.println("1 card block");
    	System.out.println("2 card unblock");
    	System.out.println("Enter your option");
      int option=scan.nextInt();
      switch(option)
      {
      case 1:
      	    gift_card.get(card1_id).setcard_status("Block");
      	    System.out.println("\n---your card is blocked---\n");
      break;
      case 2:
      	  gift_card.get(card1_id).setcard_status("Active");
      	  System.out.println("\n---your card is unblocked---\n");
      break;
      }
      logInMenu();
    }
    public static void purchaseDetails()
    {
    	  System.out.println("Bill Id  CARD ID   PURCHASE AMOUNT");
    	  if(purchase_list.size()==0)
    	  {
          System.out.println("\n---details not found---\n");
    	  }
    	  else
    	  { 
	    		for(Purchase i:purchase_list)
	    		{
	    			System.out.println(i.getBill()+"        "+i.getCard()+"         "+i.getPurchase());
	    		}
    	}
    	logInMenu();
    }public static void closeGiftCard(){
    	System.out.println("Enter your customer_id");
    	int cu_id1=scan.nextInt();
    	System.out.println("Enter your card_id");
    	int card1_id=scan.nextInt();
    	System.out.println("Enter your card pin");
    	int pin=scan.nextInt();
    	if(bankAccount_details.containsKey(cu_id1)){
           if(gift_card.containsKey(card1_id)&&gift_card.get(card1_id).getcard_pin()==pin){
               int a=gift_card.get(card1_id).getdeposite_amount();
               gift_card.remove(card1_id);
               bankAccount_details.replace(cu_id1,bankAccount_details.get(cu_id1)+a);
              System.out.println("----Your Card will be closed && Amount created in your Account----");
           }   
    	}else{
    		System.out.println("------customer_id is not found plese enter correct customer_id-------");
    	}
    	logInMenu();
    }
}