package hw5;

public class Plant {
	
	//箇璸挡狦ぱ计
	protected int plantday=100;
	//箇璸狦龟玻秖
	protected int fruit;
	//狦龟基
	protected int plantprice;
	//从ぱ计
	private int anotherday=0;
	//从ネぱ计
	private int growday=0;
	//癐毖ぱ计
	private int decay=0;
	//箇璸Θ剪ぱ计
	private int matureday=plantday-anotherday;
	//ゼ癐毖
	private boolean nodecay=0<=decay&&decay<6;
	//ゼΘ剪
	private boolean nomature=0<matureday;

	
	//ぱ计
    protected int liveday=-1;
    
    public void deductLiveday(Plant plant) {
   	     liveday-=1;
	}
    public void addLiveday(Plant plant) {
  	     liveday+=1;
	}
    public int getLiveday() {
  	     return liveday;
	}
    public void addDecay(Plant plant) {
    	decay+=1;
	}
    public void setDecay() {
    	decay=6;
	}
	
	public void deductPlantday(Plant plant) {
		plantday-=3;
	}
	public void deductFruit(Plant plant) {
		fruit-=1;
	}
	public void addPlantday(Plant plant) {
		plantday+=3;
	}
	public void addFruit(Plant plant) {
		fruit+=1;
	}
	
	public int getPlantday() {
		return plantday;
	}
	
	public int getFruit() {
		return fruit;
	}
	
	
	public int getTotalprice() {
		return fruit*plantprice;
	}
	
	public int getAnotherday() {
		return anotherday;
	}
	
	public int getGrowday() {
		return growday;
	}
	
	public int getDecay() {
		return decay;
	}
	
	public int getMatureday() {
		return  matureday=plantday-anotherday;
	}
	
	public boolean getNodecay() {
		return nodecay;
	}
	
	public boolean getNomature() {
		return nomature;
	}
	
	public void newGrowday() {
	  growday=anotherday-1;	
	}
	
	public void newMatureday() {
	  matureday=plantday-anotherday;
	}
	
	public void newAnotherday() {
	  anotherday=anotherday+1;
	}
	
	public void initialDecay() {
		decay=0;
	}
	
	public void initialAnotherday(int i) {
		anotherday=i;
	}
}



