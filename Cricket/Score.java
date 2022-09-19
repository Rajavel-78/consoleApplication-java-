

class Score{
private	int score;
private	int fours;
private	int six;
private	int balls;
private int out;
      public Score(int score,int balls,int fours,int six,int out)
      {
        this.score=score;
        this.fours=fours;
        this.six=six;
        this.balls=balls;
        this.out=out;
      }
      public int getScore(){
        return score;
      }	public int getFours(){
        return fours;
      }public int getSix(){
        return six;
      }public int getBalls(){
      	return balls;
      }
      public int getOut(){
        return out;
      }
      public  void display(){
      	System.out.print(score+"\t"+balls+"\t"+fours+"\t"+six);
      }
}