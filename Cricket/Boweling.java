class Boweling{
	private String name;
	private int over;
	private int runs;
	private int wicket;

	public Boweling(int over,int runs,int wicket){
        this.name=name;
        this.over=over;
        this.runs=runs;
        this.wicket=wicket;
	}
	public String getName(){
		return name;
	}public int getOver(){
		return over;
	}public int getRuns(){
		return runs;
	}public int getWicket(){
		return wicket;
	}
	public void setName(){
		this.name=name;
	} public void setOver(){
		this.over=over;
	}public void setRuns(){
		this.runs=runs;
	}public void setWicket(){
		this.wicket=wicket;
	}
    public void display(){
    	         System.out.println(runs+"\t"+(over/6)+"."+(over%6)+"\t"+wicket+"\t"+((float)runs/(float)((float)over/6)));
    }
}