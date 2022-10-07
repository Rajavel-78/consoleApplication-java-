import java.util.*;
class Batting{
	static int balls=0;
	static Scanner scan=new Scanner(System.in);
	static ArrayList<HashMap>arr=new ArrayList<HashMap>();
 
	public static void main(String[] args)
	{   
		Batting bat=new Batting();
	    bat.choseOver(); 
	}
	public void batting(ArrayList<String> teams,int overs){
       int innings=0;
       int extra_run=0;
       int ball=overs*6;
       int copy=ball;
       int team1score=0;
       int totalscore=0;
       int num=0;
      while(innings<2)
      { 
      	LinkedHashMap<String,Boweling>boweling_details=new LinkedHashMap<String,Boweling>();
	      LinkedHashMap<String,Score>score_details=new LinkedHashMap<String,Score>();      
			System.out.println("Enter the player name");
			String player1_name=scan.next();
			score_details.put(player1_name,new Score(0,0,0,0,0));
			System.out.println("Enter the  player name");
			String player2_name=scan.next();
			score_details.put(player2_name,new Score(0,0,0,0,0));
			System.out.println("Enter the bowler name");
			String bowler_name=scan.next();
			boweling_details.put(bowler_name,new Boweling(0,0,0));
	      boolean isValied=true;
	      int wicket=0;
	        while(ball>balls&&wicket<=9)
	        { 
	        	//boweling speed random choice speed;
	        	int ball_speed=(int)(Math.random()*90)+65;
	        	String ball_type="";
	        	if(ball_speed<120){
                 ball_type="slower";
	        	}else{
	        		ball_type="fast";
	        	}
	        	if(balls%6==0&&balls!=0&&num!=1){
	        		System.out.println("Boweler nmae");
	        		bowler_name=scan.next();
	        		if(boweling_details.containsKey(bowler_name)){}
	        		else{
	        		boweling_details.put(bowler_name,new Boweling(0,0,0));}
	        	} 
	        	num=0;
				int point=(int)Math.ceil(Math.random()*11);
				if(isValied){
					if(point==4){
						totalscore+=4;
						balls++;
						System.out.println((balls/6)+"."+(balls%6)+" :: "+bowler_name+" to bowel "+ball_speed+" kph "+ball_type+" " +player1_name+" short four");
						score_details.replace(player1_name,new Score(score_details.get(player1_name).getScore()+4,score_details.get(player1_name).getBalls()+1,score_details.get(player1_name).getFours()+1,score_details.get(player1_name).getSix(),0));
					   boweling_details.put(bowler_name,new Boweling(boweling_details.get(bowler_name).getOver()+1,boweling_details.get(bowler_name).getRuns()+4,boweling_details.get(bowler_name).getWicket()));
					   if(balls%6==0){
					   	isValied=false;
					   }
					}else if(point==6){
						balls++;
						totalscore+=6;
						int distance=(int)Math.ceil(Math.random()*23)+80;
						System.out.println((balls/6)+"."+(balls%6)+" ::"+bowler_name+" to bowel "+ball_speed+" kph "+ball_type+" "+player1_name+" hit "+(distance)+" meter six");
	            	    score_details.replace(player1_name,new Score(score_details.get(player1_name).getScore()+6,score_details.get(player1_name).getBalls()+1,score_details.get(player1_name).getFours(),score_details.get(player1_name).getSix()+1,0));                 
					       boweling_details.put(bowler_name,new Boweling(boweling_details.get(bowler_name).getOver()+1,boweling_details.get(bowler_name).getRuns()+6,boweling_details.get(bowler_name).getWicket()));
					       if(balls%6==0){
					   	isValied=false;
					   }
					}else if(point==2){
						balls++;
						totalscore+=2;
						System.out.println((balls/6)+"."+(balls%6)+" :: "+bowler_name+" to bowel "+ball_speed+" kph "+ball_type+" "+player1_name+" short two run");
						score_details.replace(player1_name,new Score(score_details.get(player1_name).getScore()+2,score_details.get(player1_name).getBalls()+1,score_details.get(player1_name).getFours(),score_details.get(player1_name).getSix(),0));
					   boweling_details.put(bowler_name,new Boweling(boweling_details.get(bowler_name).getOver()+1,boweling_details.get(bowler_name).getRuns()+2,boweling_details.get(bowler_name).getWicket()));
					   if(balls%6==0){
					   	isValied=false;
					   }
					}else if(point==1||point==3){
						balls++;
						totalscore+=point;
						System.out.println((balls/6)+"."+(balls%6)+" :: "+bowler_name+" to bowel "+ball_speed+" kph "+ball_type+" "+player1_name+" short the "+point+" run");
						score_details.replace(player1_name,new Score(score_details.get(player1_name).getScore()+point,score_details.get(player1_name).getBalls()+1,score_details.get(player1_name).getFours(),score_details.get(player1_name).getSix(),0));
					    boweling_details.put(bowler_name,new Boweling(boweling_details.get(bowler_name).getOver()+1,boweling_details.get(bowler_name).getRuns()+point,boweling_details.get(bowler_name).getWicket()));
					   if(balls%6==0)
					   {
					      isValied=true;
					   }else{
					   	isValied=false;
					   }
					}else if(point==8||point==9||point==11){
						balls++;
						System.out.println((balls/6)+"."+(balls%6)+" :: "+bowler_name+" to bowel "+ball_speed+" kph "+ball_type+" "+"Dot balls");
						score_details.replace(player1_name,new Score(score_details.get(player1_name).getScore(),score_details.get(player1_name).getBalls()+1,score_details.get(player1_name).getFours(),score_details.get(player1_name).getSix(),0));
						 boweling_details.put(bowler_name,new Boweling(boweling_details.get(bowler_name).getOver()+1,boweling_details.get(bowler_name).getRuns(),boweling_details.get(bowler_name).getWicket()));
						if(balls%6!=0)
					   {
					      isValied=true;
					   }else{
					   	isValied=false;
					   }
					}else if(point==10){
						extra_run+=1;
						balls++;
						System.out.println((balls/6)+"."+(balls%6)+" :: "+bowler_name+" to bowel "+ball_speed+" kph "+ball_type+" "+" wide Ball");
					   balls--;
					   num=1;
					}
					else if(point==7){
						balls++;
						wicket+=1;
						score_details.replace(player1_name,new Score(score_details.get(player1_name).getScore(),score_details.get(player1_name).getBalls()+1,score_details.get(player1_name).getFours(),score_details.get(player1_name).getSix(),1));
						 boweling_details.put(bowler_name,new Boweling(boweling_details.get(bowler_name).getOver()+1,boweling_details.get(bowler_name).getRuns(),boweling_details.get(bowler_name).getWicket()+1));
						if(balls%6==0){
					   	isValied=false;
					   }
					   if(balls==ball||wicket==10){}
					   	else{
					   
						System.out.println("-------------------------------");
						System.out.println((balls/6)+"."+(balls%6)+" ::"+bowler_name+" to bowel "+ball_speed+" kph "+ball_type+" "+player1_name+" is out\n score is");
						System.out.println("run\tballs\tfours\tsix");
						System.out.println("-------------------------------");
						score_details.get(player1_name).display();
					   System.out.println();
					   System.out.println("next player name");
						player1_name=scan.next();
						score_details.put(player1_name,new Score(0,0,0,0,0));
	              }  				
					}
		 		}
		 		else{
	                 if(point==4){
	                    balls++;
	                    totalscore+=4;

						System.out.println((balls/6)+"."+(balls%6)+" :: "+bowler_name+" to bowel "+ball_speed+" kph "+ball_type+" "+player2_name+" short four");
						score_details.replace(player2_name,new Score(score_details.get(player2_name).getScore()+4,score_details.get(player2_name).getBalls()+1,score_details.get(player2_name).getFours()+1,score_details.get(player2_name).getSix(),0));
					   boweling_details.put(bowler_name,new Boweling(boweling_details.get(bowler_name).getOver()+1,boweling_details.get(bowler_name).getRuns()+4,boweling_details.get(bowler_name).getWicket()));
					   if(balls%6==0){
					   	isValied=true;
					   }
					}else if(point==6){
						balls++;
						totalscore+=6;
						int distance=(int)Math.ceil(Math.random()*23)+70;
						System.out.println((balls/6)+"."+(balls%6)+" :: "+bowler_name+" to bowel "+ball_speed+" kph "+ball_type+" "+player2_name+" hit "+(distance)+" meter six");
	            	    score_details.replace(player2_name,new Score(score_details.get(player2_name).getScore()+6,score_details.get(player2_name).getBalls()+1,score_details.get(player2_name).getFours(),score_details.get(player2_name).getSix()+1,0));                 
					       boweling_details.put(bowler_name,new Boweling(boweling_details.get(bowler_name).getOver()+1,boweling_details.get(bowler_name).getRuns()+6,boweling_details.get(bowler_name).getWicket()));
					       if(balls%6==0){
					   	isValied=true;
					   }
					}else if(point==2){
						balls++;
						totalscore+=2;
						System.out.println((balls/6)+"."+(balls%6)+" :: "+bowler_name+" to bowel "+ball_speed+" kph "+ball_type+" "+player2_name+" short two run");
						score_details.replace(player2_name,new Score(score_details.get(player2_name).getScore()+2,score_details.get(player2_name).getBalls()+1,score_details.get(player2_name).getFours(),score_details.get(player2_name).getSix(),0));
					   boweling_details.put(bowler_name,new Boweling(boweling_details.get(bowler_name).getOver()+1,boweling_details.get(bowler_name).getRuns()+2,boweling_details.get(bowler_name).getWicket()));
					  if(balls%6==0){
					   	isValied=true;
					   }
					}
					else if(point==1||point==3){
						balls++;
						totalscore+=point;
						System.out.println((balls/6)+"."+(balls%6)+" :: "+bowler_name+" to bowel "+ball_speed+" kph "+ball_type+" "+player2_name+" short one run");
						score_details.replace(player2_name,new Score(score_details.get(player2_name).getScore()+point,score_details.get(player2_name).getBalls()+1,score_details.get(player2_name).getFours(),score_details.get(player2_name).getSix(),0));
					    boweling_details.put(bowler_name,new Boweling(boweling_details.get(bowler_name).getOver()+1,boweling_details.get(bowler_name).getRuns()+point,boweling_details.get(bowler_name).getWicket()));
					   if(balls%6==0)
					   {
					      isValied=true;
					   }else{
					   	isValied=false;
					   }
					}else if(point==8||point==9||point==11){
						balls++;
						System.out.println((balls/6)+"."+(balls%6)+" :: "+bowler_name+" to bowel "+ball_speed+" kph "+ball_type+" "+"Dot balls");
	               score_details.replace(player2_name,new Score(score_details.get(player2_name).getScore(),score_details.get(player2_name).getBalls()+1,score_details.get(player2_name).getFours(),score_details.get(player2_name).getSix(),0));
						 boweling_details.put(bowler_name,new Boweling(boweling_details.get(bowler_name).getOver()+1,boweling_details.get(bowler_name).getRuns(),boweling_details.get(bowler_name).getWicket()));
						if(balls%6==0)
					   {
					      isValied=true;
					   }else{
					   	isValied=false;
					   }
					}else if(point==10){
	                extra_run+=1;
	                balls++;
	                System.out.println((balls/6)+"."+(balls%6)+" :: "+bowler_name+" to bowel "+ball_speed+" kph "+ball_type+" "+"Ball is Wide");
	                balls--;
	                num=1;
					}
					else if(point==7){
						balls++;
						wicket+=1;
						score_details.replace(player2_name,new Score(score_details.get(player2_name).getScore(),score_details.get(player2_name).getBalls()+1,score_details.get(player2_name).getFours(),score_details.get(player2_name).getSix(),1));
	                boweling_details.put(bowler_name,new Boweling(boweling_details.get(bowler_name).getOver()+1,boweling_details.get(bowler_name).getRuns(),boweling_details.get(bowler_name).getWicket()+1));
	               if(balls%6==0)
	               {
					   	isValied=true;
					   }
					   if(balls==ball||wicket==10){}
					   else
					   {
							System.out.println("----------------------------------");
							System.out.println((balls/6)+"."+(balls%6)+" :: "+bowler_name+" to bowel "+ball_speed+" kph "+ball_type+" "+player2_name+" is out\nscore is");
							System.out.println("run\tballs\tfours\tsix");
							System.out.println("-----------------------------------");
							score_details.get(player2_name).display();
							System.out.println();
							System.out.println("Next player name");
							player2_name=scan.next();
							score_details.put(player2_name,new Score(0,0,0,0,0));	
					  }
					}
		 		}
		 		if(innings==1&&team1score<totalscore){
		 			System.out.println("----------------------------------------------------");
	        		System.out.println("-----"+teams.get(1) +" win by "+Math.abs(11-wicket)+" wicket-----------");
	        		System.out.println("----------------------------------------------------");
	        		break;
	        	}
	       }
	        System.out.println("------------------------------------------------------------");
	        System.out.println("-----------------"+teams.get(innings)+"  "+" BATTING     SCORECARD   -------------------\n");
	        System.out.println("Player\t\tscore\tballs\tfours\tsix\tst.rate\n");
	        for(Map.Entry<String,Score>j:score_details.entrySet())
	        {  
	        	  if(j.getValue().getOut()==1){
	        	    System.out.print(j.getKey()+"\t\t");	 
	        	  }
	        	  else
	        	  {
	           System.out.print(j.getKey()+"*"+"\t\t");
	           }
	           j.getValue().display();
	           if(j.getValue().getBalls()==0){
	           	 System.out.print("\t"+0+"\n");
	           }
	           else{
	              System.out.printf("\t"+"%.2f",((float)j.getValue().getScore()/(float)j.getValue().getBalls())*100);
	              System.out.println();
	          }
	        }
	        arr.add(score_details);
	        System.out.println("\nTotal = "+(totalscore+extra_run)+"/"+wicket+"\tovers "+(balls/6)+"."+(balls%6));
	        System.out.println("Extra "+extra_run+"\n\n");
           System.out.println("---------------BOWLING SCORECARD--------------\nPlayers\t"+"RUNS\t"+"overs\t"+"wicket\t"+"Eco.Rate");   
		     for(Map.Entry<String,Boweling>k:boweling_details.entrySet()){
		     	System.out.print(k.getKey()+"\t");
		     	k.getValue().display();
		     }
		     extra_run=0;
		ball=copy;
		balls=0;
		if(innings==1&&team1score>totalscore){
			System.out.println("-----------------------");
			System.out.println("-------"+teams.get(0)+" WIN by "+Math.abs(totalscore-team1score+1)+" Run------");
			System.out.println("-----------------------");
		}
		if(innings==1&&team1score==totalscore){
			System.out.println("_____Match Draw__");
		}
		innings++;
		team1score=totalscore;
		totalscore=0;
		if(innings<2){
		System.out.println("\n-------"+innings +" "+teams.get(innings)+" BATTING-------\n");	
	}
	}
	}public  void tass(int overs){
		System.out.println("-------^CRICKET GAME^----------");
		ArrayList<String>teams=new ArrayList<String>();
		System.out.println("Enter the TEAM  Name");
		String team1=scan.next();
		System.out.println("Enter the TEAM  Name");
		String team2=scan.next();
		System.out.println("ASK FOR "+team1+" TASK\n1 HEAD\n2 TAIL");
		int ask=scan.nextInt();
		int num=(int)Math.ceil(Math.random()*2);
		if(num==1){
           System.out.println("--- HEAD ---");
		}else{
			System.out.println("---- TAIL-----");
		}
		if(num==ask){
			System.out.println(team1 +"  OWN THE TASK\nChoise\n1.BAt\n2.Bowl");
			int choice=scan.nextInt();
			if(choice==1){
				System.out.println(team1 +" selected to bat first");
				teams.add(team1);
				teams.add(team2);
			}else{
				System.out.println(team1+"  selected to Bowl first");
				teams.add(team2);
				teams.add(team1);
			}
		}else{
			System.out.println(team2 +" WON THE TASK");
			System.out.println("Choise\n1.BAt\n2.Bowl");
			int choice=scan.nextInt();
			if(choice==1){
				System.out.println(team2+" selected to bat first");
				teams.add(team2);
				teams.add(team1);
			}else{
				System.out.println(team2+" selected to Bowl first");
				teams.add(team1);
				teams.add(team2);
			}
		}Batting bat=new Batting();
		int over=overs;
		bat.batting(teams,over);
	}public void choseOver(){
		  System.out.println("\n---GAME OF CRICKET---\n-----------------------\n");
        System.out.println("1  T 20 MATCH\n2  ONDAY MATCH\n3  TEN OVER MATCH\n3  TEN OVER MATCH\n4  2 OVER Match");
        System.out.println("----------------\n-Selecct the options-");
        int choseOvers=scan.nextInt();
        Batting bat=new Batting();
        switch(choseOvers){
        case 1:
        	      bat.tass(20);
        break;
        case 2: 
        	     bat.tass(50);
        break;
        case 3:
              bat.tass(10);
        break;
        case 4:
              bat.tass(2);
        break;                 
        }
	}
}