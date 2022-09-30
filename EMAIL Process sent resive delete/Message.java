 class Message{
private String to;
private String subject;
private String message;
private String username;
private int id;
   Message(int id,String username,String to,String subject,String message){
     this.to=to;
     this.id=id;
     this.subject=subject;
     this.message=message;
     this.username=username;
  }public String getTo(){
  	return to;
  }public String getUsername(){
  	return username;
  }public int getId(){
    return id;
  }public String getSubject(){
    return subject;
  }public String getMessage(){
     return message;
  }public void setTo(String to){
     to=to;
  }public void setUsername(String username){
  	username=username;
  }public void subject(String subject){
  	subject=subject;
  }public void setId(int id){
    id=id;
  }public void setMessage(String message){
  	message=message;
  }
 public void display(){
 	System.out.println("       MassagaeId "+id+", From "+username+", To "+to+", subject "+subject+", Message "+message);
 }public void display1(){
 	System.out.println("          MassagaeId "+id+", From "+username+", To "+to+", subject "+subject+", Message "+message);
 }
}