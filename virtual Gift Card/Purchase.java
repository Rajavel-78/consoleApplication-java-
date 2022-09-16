
class Purchase{
  private int bill_id;
  private int card_id;
  private int purchase_amount;
   public Purchase(int bill_id,int card_id,int purchase_amount){
   this.bill_id=bill_id;
   this.card_id=card_id;
   this.purchase_amount=purchase_amount;
   }
   public int getBill()
   {
   	return bill_id;
   }
   public int getCard()
   {
   	return card_id;
   }
   public int getPurchase(){
   	return purchase_amount;
   }	
}