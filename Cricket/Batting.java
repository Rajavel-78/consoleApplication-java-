import java.util.*;
class Batting{
	static int balls=0;
	static Scanner scan=new Scanner(System.in);
	static ArrayList<HashMap>arr=new ArrayList<HashMap>();
	
	public static void main(String[] args)
	{   Batting bat=new Batting();
	    bat.tass(); 
	}
	public void batting(ArrayList<String> teams){
      int innings=0;
      int extra_run=0;
       System.out.println("Enter the Over");
       int ball=scan.nextInt()*6;
       int copy=ball;
       int team1score=0;
       int totalscore=0;
      while(innings<2){ 
      LinkedHashMap<String,Score>score_details=new LinkedHashMap<String,Score>();      
		System.out.println("Enter the 1st player name");
		String player1_name=scan.next();
		score_details.put(player1_name,new Score(0,0,0,0,0));
		System.out.println("Enter the 2nd player name");
		String player2_name=scan.next();
		score_details.put(player2_name,new Score(0,0,0,0,0));
        boolean isValied=true;
        int wicket=0;
        while(ball>balls&&wicket<=9){
			int point=(int)Math.ceil(Math.random()*11);
			if(isValied){
				if(point==4){
					totalscore+=4;
					balls++;
					System.out.println(player1_name+" short four");
					score_details.replace(player1_name,new Score(score_details.get(player1_name).getScore()+4,score_details.get(player1_name).getBalls()+1,score_details.get(player1_name).getFours()+1,score_details.get(player1_name).getSix(),0));
				   if(balls%6==0){
				   	isValied=false;
				   }
				}else if(point==6){
					balls++;
					totalscore+=6;
					int distance=(int)Math.ceil(Math.random());
					System.out.println(player1_name+" hit"+(distance)+" meter six");
            	    score_details.replace(player1_name,new Score(score_details.get(player1_name).getScore()+6,score_details.get(player1_name).getBalls()+1,score_details.get(player1_name).getFours(),score_details.get(player1_name).getSix()+1,0));                 
				       if(balls%6==0){
				   	isValied=false;
				   }
				}else if(point==2){
					balls++;
					totalscore+=2;
					System.out.println(player1_name+" short two run");
					score_details.replace(player1_name,new Score(score_details.get(player1_name).getScore()+2,score_details.get(player1_name).getBalls()+1,score_details.get(player1_name).getFours(),score_details.get(player1_name).getSix(),0));
				   if(balls%6==0){
				   	isValied=false;
				   }
				}else if(point==1||point==3){
					balls++;
					totalscore+=point;
					System.out.println(player1_name+" short the "+point+" run");
					score_details.replace(player1_name,new Score(score_details.get(player1_name).getScore()+point,score_details.get(player1_name).getBalls()+1,score_details.get(player1_name).getFours(),score_details.get(player1_name).getSix(),0));
				   if(balls%6==0)
				   {
				      isValied=true;
				   }else{
				   	isValied=false;
				   }
				}else if(point==8||point==9||point==11){
					balls++;
					System.out.println("Dot balls");
					score_details.replace(player1_name,new Score(score_details.get(player1_name).getScore(),score_details.get(player1_name).getBalls()+1,score_details.get(player1_name).getFours(),score_details.get(player1_name).getSix(),0));
					if(balls%6!=0)
				   {
				      isValied=true;
				   }else{
				   	isValied=false;
				   }
				}else if(point==10){
					extra_run+=1;
					System.out.println("wide Ball");
				}
				else if(point==7){
					balls++;
					wicket+=1;
					score_details.replace(player1_name,new Score(score_details.get(player1_name).getScore(),score_details.get(player1_name).getBalls()+1,score_details.get(player1_name).getFours(),score_details.get(player1_name).getSix(),1));
					if(balls%6==0){
				   	isValied=false;
				   }
				   if(balls==ball||wicket==10){}
				   	else{
				   
					
					System.out.println(player1_name+" is out\n score is");
					System.out.println("run\tballs\tfours\tsix");
					score_details.get(player1_name).display();
				   System.out.println();
					player1_name=scan.next();
					score_details.put(player1_name,new Score(0,0,0,0,0));
              }  				
				}
	 		}
	 		else{
                 if(point==4){
                    balls++;
                    totalscore+=4;

					System.out.println(player2_name+" short four");
					score_details.replace(player2_name,new Score(score_details.get(player2_name).getScore()+4,score_details.get(player2_name).getBalls()+1,score_details.get(player2_name).getFours()+1,score_details.get(player2_name).getSix(),0));
				   if(balls%6==0){
				   	isValied=true;
				   }
				}else if(point==6){
					balls++;
					totalscore+=6;
					int distance=(int)Math.ceil(Math.random());
					System.out.println(player2_name+" hit"+(distance)+" meter six");
            	    score_details.replace(player2_name,new Score(score_details.get(player2_name).getScore()+6,score_details.get(player2_name).getBalls()+1,score_details.get(player2_name).getFours(),score_details.get(player2_name).getSix()+1,0));                 
				       if(balls%6==0){
				   	isValied=true;
				   }
				}else if(point==2){
					balls++;
					totalscore+=2;
					System.out.println(player2_name+" short two run");
					score_details.replace(player2_name,new Score(score_details.get(player2_name).getScore()+2,score_details.get(player2_name).getBalls()+1,score_details.get(player2_name).getFours(),score_details.get(player2_name).getSix(),0));
				  if(balls%6==0){
				   	isValied=true;
				   }
				}
				else if(point==1||point==3){
					balls++;
					totalscore+=point;
					System.out.println(player2_name+" short four run");
					score_details.replace(player2_name,new Score(score_details.get(player2_name).getScore()+point,score_details.get(player2_name).getBalls()+1,score_details.get(player2_name).getFours(),score_details.get(player2_name).getSix(),0));
				   if(balls%6==0)
				   {
				      isValied=true;
				   }else{
				   	isValied=false;
				   }
				}else if(point==8||point==9||point==11){
					balls++;
					System.out.println("Dot balls");
               score_details.replace(player2_name,new Score(score_details.get(player2_name).getScore(),score_details.get(player2_name).getBalls()+1,score_details.get(player2_name).getFours(),score_details.get(player2_name).getSix(),0));
					if(balls%6==0)
				   {
				      isValied=true;
				   }else{
				   	isValied=false;
				   }
				}else if(point==10){
                extra_run+=1;
                System.out.println("Ball is Wide");
				}
				else if(point==7){
					balls++;
					wicket+=1;
					score_details.replace(player2_name,new Score(score_details.get(player2_name).getScore(),score_details.get(player2_name).getBalls()+1,score_details.get(player2_name).getFours(),score_details.get(player2_name).getSix(),1));
               if(balls%6==0)
               {
				   	isValied=true;
				   }
				   if(balls==ball||wicket==10){}
				   else
				   {
						
						System.out.println(player2_name+" is out\n score is");
						System.out.println("run\tballs\tfours\tsix");
						score_details.get(player2_name).display();
						System.out.println();
						player2_name=scan.next();
						score_details.put(player2_name,new Score(0,0,0,0,0));	
				  }
				}
	 		}
	 		if(innings==1&&team1score<totalscore){
        		System.out.println("-----"+teams.get(1) +"win-----------");
        		break;
        	}
	 		
       }
       
        System.out.println("-------------"+teams.get(innings)+" ScoreBord------------");
        System.out.println("Player\t\tscore\tballs\tfours\tsix\tst.rate");
        
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
           	 System.out.print("\t"+0);
           	 System.out.println();
           }
           else{
              System.out.print("\t"+(double)(j.getValue().getScore()/j.getValue().getBalls())*100);
              System.out.println();
              
          }
        }
        arr.add(score_details);
        System.out.println("\nTotal = "+(totalscore+extra_run)+"/"+wicket+"\tovers "+(balls/6)+"."+(balls%6));
        System.out.println("Extra "+extra_run);
	     extra_run=0;
	ball=copy;
	balls=0;
	if(innings==1&&team1score>totalscore){
		System.out.println("-----------------------");
		System.out.println("-------"+teams.get(0)+" WIN------");
		System.out.println("-----------------------");
	}
	if(innings==1&&team1score==totalscore){
		System.out.println("_____Match Draw__");
	}
	innings++;
	team1score=totalscore;
	totalscore=0;
	if(innings<2){
	System.out.println("-------"+teams.get(innings)+"-------");
	}
	}
	}public  void tass(){
		System.out.println("-------^CRICKET GAME^----------");
		ArrayList<String>teams=new ArrayList<String>();
		System.out.println("Enter the TEAM 1 Name");
		String team1=scan.next();
		System.out.println("Enter the TEAM 2 Name");
		String team2=scan.next();
		System.out.println("ASK FOR "+team1+" TASK");
		System.out.println("1 HEAD");
		System.out.println("2 TAIL");
		int ask=scan.nextInt();
		int num=(int)Math.ceil(Math.random()*2);
		if(num==ask){
			System.out.println(team1 +"  OWN THE TASK");
			System.out.println("Choise\n1.BAt\n 2.Bowl");
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
			System.out.println("Choise\n1.BAt\n 2.Bowl");
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
		bat.batting(teams);

	}
}
