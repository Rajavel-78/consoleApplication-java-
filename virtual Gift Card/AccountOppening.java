
/*this class is giftcard class and maintain the gift card details and create the gift card*/
class AccountOppening{
  private int card_id;
  private int deposite_amount;
  private int card_type;
  private int card_pin;
  private String card_status;
  public AccountOppening(int card_id,int deposite_amount,int card_pin,int card_type,String card_status){
  	this.card_id=card_id;
  	this.deposite_amount=deposite_amount;
  	this.card_pin=card_pin;
  	this.card_type=card_type;
  	this.card_status=card_status;
  }
   public int getcard_id(){
  	return card_id;
  }public int getdeposite_amount(){
  	return deposite_amount;
  }public int getcard_pin(){
  	return card_pin;
  }public int getcard_type(){
  	return card_type;
  }public String getcard_status(){
  	return card_status;
  }
  public void setcard_status(String card_status){
  	this.card_status=card_status;
  }
  public void display(){
  System.out.print("    "+card_id+"     "+deposite_amount+"    "+card_pin+"   "+card_status);
  }
}