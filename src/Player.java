package hw5;

public class Player {

	private int energy = 100;
	private int money = 2000;
	boolean x=false;
    
	//角色-植物學家
	public void setEnergy(int a) {
		 energy=a;
		 x=true;
	}
	
	public int getEnergy() {
	   //體力上限變為 90
       if(x==true) {
    	  if(energy>90) {
    	    energy=90;
    	 }
       }else if(energy>100) {
		  energy=100;
		}
		return energy;
	}

	public int getMoney() {
		return money;
	}

	public void buy(int a) {
		money -= a;
	}

	public void deductEnergy(int i) {
		energy -= i;
	}
    
	public void addEnergy(int i) {
		energy += i;
	}
	
	public void addMoney(int i) {
		money += i;
	}
}
