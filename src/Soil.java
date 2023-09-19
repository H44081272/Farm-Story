package hw5;

public class Soil {

	protected int humidity = 20;
	//¤gÄ[¦³¾i¤À
	private boolean soilbroken=false;
	
	
	
	public void addHumidity(int l) {
		humidity += l;
	}
    
	public void deductHumidity(int k) {
		humidity -= k;
	}
	
	public void initialHumidity() {
		humidity = 20;
	}
    
	public int getHumidity() {
		if(humidity>100) 
		{
		  humidity=100;
		}
		else if(humidity<0)
		{
		  humidity=0;
		}
		return  humidity;
	}
	
	public boolean getSoilbroken() {
		return  soilbroken;
	}
	
	public void newSoilbroken(boolean i) {
		 soilbroken=i;
	}
	
	}
  
  

