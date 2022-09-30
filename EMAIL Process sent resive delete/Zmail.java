import java.util.*;
class Zmail{

	 Scanner scan=new Scanner(System.in);

	static ArrayList<HashMap>store=new ArrayList<HashMap>();
	static ArrayList<Message>store1=new ArrayList<Message>();
	static RajavelZmail call=new RajavelZmail();
	static int id=11110;
	static String username="";
    static Message storeData;
	public static void main(String[] args){
     HashMap<String,String>h=new HashMap<String,String>();
            h.put("username","a1@z.com");
            h.put("password","a1z");
            store.add(h);
             HashMap<String,String>h1=new HashMap<String,String>();
             //Message store_data=new Message("to","subject","message");
            
            h1.put("username","a2@z.com");
            h1.put("password","a2z");
            store.add(h1);
            
		    store1.add(new Message(1001,"a2@z.com","a1@z.com","hello1","a"));
            store1.add(new Message(1002,"a2@z.com","a1@z.com","hello2","b"));
            store1.add(new Message(1003,"a2@z.com","a1@z.com","hello3","c"));
            store1.add(new Message(1004,"a2@z.com","a1@z.com","hello3","d"));
            store1.add(new Message(1005,"a2@z.com","a1@z.com","hello4","v"));
            store1.add(new Message(1006,"a2@z.com","a1@z.com","hello5","d"));
            store1.add(new Message(2001,"a1@z.com","a2@z.com","hello","t"));
            store1.add(new Message(2002,"a1@z.com","a2@z.com","hello","t"));
            store1.add(new Message(2003,"a1@z.com","a2@z.com","hello","d"));
            store1.add(new Message(2004,"a1@z.com","a2@z.com","hello","d"));
            store1.add(new Message(2005,"a1@z.com","a2@z.com","hello","t"));
             call.logInMenu();
	}
		public void logInMenu(){
		System.out.println("--------ZMail Client--------");
		System.out.println("  1  New Account");
		System.out.println("  2  Login");
		System.out. println("  3  Exit");
		System.out.println("Select your option");
        int choise=scan.nextInt();
        switch(choise){
        	case 1:
        	    call.newAccount();
        	break;
        	case 2:
        	     call.logIn();
        	break;
        	case 3:
        	     call.exit();
        	break;
            default:
                 System.out.println("invalid option try again");
                 call.logInMenu();             
        }
    }
	
	public void newAccount()
    {
		System.out.println("Enter user Name (must be last 5letter @z.com)");
	     username=scan.next();
		boolean s=true;
		for(HashMap b: store)
        {
         	String a=String.valueOf(b.get("username"));
         	if(a.equals(username))
            {
                s=false;
         	}
         }
            if(s){
                if(username.endsWith("@z.com"))
                {   HashMap<String,String>h=new HashMap<String,String>();
                	System.out.println("Enter password");
		            String password=scan.next();
               	    h.put("username",username);
				    h.put("password",password);
				    store.add(h); 
                    System.out.println("Your Account has Been Created");
                    call.logInMenu();
                }else
                {
                  System.out.println("last must be @z.com");
                  call.logInMenu();
                }				
         	}
            else
            {
         		System.out.println(" ---username Allready Exite---");
         		System.out.println("     --------------------");
         		call.logInMenu();
         	}     
                System.out.println("     ----------------------");
	}  
    public void logIn()
    {    System.out.println("-----PLEASE LOG IN YOUR DETAILS-----");
         System.out.println("   1. Enter user Name");
          username=scan.next();
         System.out.println("   2. Enter password");
         String password=scan.next();
         for(HashMap b: store)
         {
         	String a=String.valueOf(b.get("username"));
         	String c=String.valueOf(b.get("password"));
         	  if((a.equals(username))&&(c.equals(password)))
              {
                call.userMenu();
              }
	}System.out.println("----username or password invalid----");
     call.logInMenu();
    }
	public void exit()
    {
		System.out.println("-------Thank You-------");
	}
	public void userMenu()
    {
         System.out.println("--------USER MENU--------");
         System.out.println("      1.Compose");
         System.out.println("      2.List Mails");
         System.out.println("      3.List Sent Mails");
         System.out.println("      4.Delete MAils");
         System.out.println("      5.Delete Sent Mails");
         System.out.println("      6.LogOut ");
         System.out.println();
         System.out.println("your choice  ");
         int option=scan.nextInt();
         switch(option){
         case 1:
              call.compose();
         break;
         case 2:
              call.listMails();
         break;
         case 3:
              call.listSentMails();
         break;
         case 4:
              call.deletMails();
         break;
         case 5:
              call.deletsentMail();
         break;
         case 6:
              call.logOut();
         break;
         default:
            System.out.println("Enter your option allow to 1 to 6");
         break;       
         }
     }
    public void compose()
    {  boolean isvalied=true;
        while(isvalied){
        System.out.println("-----SENT MAILS------");
        System.out.println("1.Message id  "+id);
        System.out.println("2.To");
        String to=scan.next();
        String[] a1=to.split(",");
        ArrayList<String>mm=new ArrayList<String>();
        boolean s=false;
        for(int i=0;i<a1.length;i++){          
            for(HashMap b: store)
            {
         	    String a=String.valueOf(b.get("username"));
         	    if(a1[i].contains(a))
                {   mm.add(a1[i]);
                    s=true;
                }
                
            }}
         	        if(s)
                    {      
                           System.out.println("3.Subject");
                           String subject=scan.next();
                           System.out.println("4.Message");
                           String message=scan.next();
                           System.out.println();
                           System.out.println("sent mails");
                           System.out.println("   -------------------------");
                           for(int i=0;i<mm.size();i++){
                            id+=1;
                         storeData=new Message(id,username,mm.get(i),subject,message);
                           store1.add(storeData);}
                            id+=1;
                           System.out.println("To you want back");
                           System.out.println("Enter key 1 and again message enter 2");
                           int option=scan.nextInt();
                    switch(option){
             	      case 1:
             	          call.userMenu();
             	      break;
                      case 2:
                          isvalied=true;
                          break;
             	      default:
             	          System.out.println("  press worng key");      
                    }
                
            }
                else
                {
                 	System.out.println(" this mail id is not avialble");
                    System.out.println(" To you want back");
                    System.out.println(" Enter key 1");
                    int option=scan.nextInt();
                       switch(option){
                     	  case 1:
                     	         call.userMenu();
                     	  break;
                     	  default:
                     	         System.out.println(" press worng key");      
                     }     
        }
    }}
    public void listMails()
    {       String name=username;
            System.out.println("--------List of Mails----------");
                    for(Message b:store1){
                String a=String.valueOf(b.getTo());
                if(a.contains(name)){
                    b.display1();
                }
              }     System.out.println("-------------------------");
                    System.out.println("To you want back");
                    System.out.println(" Enter key 1");
                    int option=scan.nextInt();
                        switch(option)
                        {
                 	      case 1:
                 	          call.userMenu();
                 	      break;
                 	      default:
                 	          System.out.println("press worng key");
                        }  
                    System.out.println("-------------------------"); 
                 }

    public void listSentMails()
    {       String name=username;
            System.out.println("-------LIST OF SENT MAILS--------");
              for(Message b:store1){
                String a=String.valueOf(b.getUsername());
                if(a.equals(name)){
                    b.display();
                }
              }
            System.out.println("-------------------------");
            System.out.println("To you want back");
            System.out.println(" Enter key 1");
            int option=scan.nextInt();
             switch(option)
             {
             	case 1:
             	      call.userMenu();
             	break;
             	default:
                	System.out.println("press worng key");

             }
             System.out.println("-------------------------");
    }
         public void deletMails()
         {    String  name=username;
                System.out.println("-------Delete Mails------");
             	System.out.println("---your Mails--");
             	for(Message b:store1){
                String a=String.valueOf(b.getTo());
                if(a.contains(name)){
                    b.display();
                }
              }System.out.println("Enter the MessageID to delete");
                   String idNumber=scan.next();
               int i=0;int num=0;
               for(Message b:store1){
                String a=String.valueOf(b.getId());
                if(idNumber.equals(a)){
                    num=i;
                }else{
                    i++;
                }
               }store1.remove(num);
             	System.out.println("To you want back");
                System.out.println(" Enter key 1");
                int option=scan.nextInt();
                 switch(option){
                 	case 1:
                 	      call.userMenu();
                 	break;
                 	default:
                 	System.out.println("press worng key");      
                 } System.out.println("-------------------------");
    }
    public void deletsentMail(){
         	System.out.println("-------Delete Mails------");
            String name=username;
            System.out.println("-------LIST OF SENT MAILS--------");
              for(Message b:store1){
                String a=String.valueOf(b.getUsername());
                if(a.equals(name)){
                    b.display();
                }
              }   System.out.println("Enter the MessageID to delete");
                   String idNumber=scan.next();
               int i=0;int num=0;
               for(Message b:store1){
                String a=String.valueOf(b.getId());
                if(idNumber.equals(a)){
                    num=i;
                }else{
                    i++;
                }
               }store1.remove(num);
                System.out.println("  To you want back");
             System.out.println("  Enter key 1");
             int option=scan.nextInt();
             switch(option){
             	case 1:
             	      call.userMenu();
             	break;
             	default:
             	System.out.println("  press worng key");      
             }System.out.println("-------------------------"); 
         }public void logOut(){
         	 	call.logInMenu();
         	 	 System.out.println("  To you want back");
             System.out.println(" Enter key 1");
             int option=scan.nextInt();
             switch(option){
             	case 1:
             	      call.userMenu();
             	break;
             	default:
             	System.out.println("  press worng key");      
             }System.out.println("-------------------------"); 		
         }
}