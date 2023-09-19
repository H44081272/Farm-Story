package hw5;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;


public class hw5 {

	public static void main(String args[]) throws FileNotFoundException {
		
		
		
		Scanner input = new Scanner(System.in);
		Scanner input1 = new Scanner(System.in);
		Scanner input2 = new Scanner(System.in);
	    //指令陣列
		String[] hint;
		//販賣果實的價格每顆增加1 元
		int vs=0;
		//種植以及填土並鬆土所消耗的體力增加 5
		int rs=0;
		//所有工具售價減少 10 元
	    int ts=0;
		
		//已購買物品
		ArrayList asset = new ArrayList();
		//太陽草
		ArrayList<Integer> sungrassland= new ArrayList<Integer>();
		//星辰花
		ArrayList<Integer> starflowerland= new ArrayList<Integer>();
		//田地編號
		int landnum;
		//植物
		Plant[] plant=new Plant[9];
		Plant plant1=new Plant();
	    plant[0]=plant1;
		Plant plant2=new Plant();
		plant[1]=plant2;
		Plant plant3=new Plant();
		plant[2]=plant3;
		Plant plant4=new Plant();
		plant[3]=plant4;
		Plant plant5=new Plant();
		plant[4]=plant5;
		Plant plant6=new Plant();
		plant[5]=plant6;
		Plant plant7=new Plant();
		plant[6]=plant7;
		Plant plant8=new Plant();
		plant[7]=plant8;
		Plant plant9=new Plant();
		plant[8]=plant9;

	    
		//土壤
		Soil[] soil=new Soil[9];
		Soil soil1=new Soil();
		soil[0]=soil1;
		Soil soil2=new Soil();
		soil[1]=soil2;
		Soil soil3=new Soil();
		soil[2]=soil3;
		Soil soil4=new Soil();
		soil[3]=soil4;
		Soil soil5=new Soil();
		soil[4]=soil5;
		Soil soil6=new Soil();
		soil[5]=soil6;
		Soil soil7=new Soil();
		soil[6]=soil7;
		Soil soil8=new Soil();
		soil[7]=soil8;
		Soil soil9=new Soil();
		soil[8]=soil9;
 		//植物
		String[] planttype=new String[9];
		//土壤
		String[] soiltype=new String[9];
		//物品在陣列中位置
		int index=0;
		//內部迴圈
		boolean reback = true;
		//外部迴圈
		boolean back = true;
		//工具
		Wateringcan wateringcan = new Wateringcan();
		Hoe hoe = new Hoe();
		Sickle sickle = new Sickle();
		// 種子
		Wseed wseed = new Wseed();
		Mseed mseed = new Mseed();
		// 土壤
		Sand sand = new Sand();
		Clay clay = new Clay();
		Loam loam = new Loam();
		Magicdust magicdust=new Magicdust();
		//植物
	    Watermelon watermelon=new Watermelon(vs);
		Mulberry mulberry=new Mulberry(vs);
		//功能型植物
		Sungrass sungrass=new Sungrass();
		Starflower starflower=new Starflower();
		//太陽草影響範圍	   
		boolean a1=true,a2=true,a3=true,a4=true,a5=true,a6=true,a7=true,a8=true,a9=true;
		//星辰花影響範圍	   
		boolean b1=true,b2=true,b3=true,b4=true,b5=true,b6=true,b7=true,b8=true,b9=true;
		
		
		//農場天數
	    int day = 0;
	    
     
		System.out.println("歡迎來到農場物語");
		System.out.print("請輸入玩家名稱:");
		String playername = input.next();
		Player user = new Player();
		
		//角色
		boolean roleloop=true;
		String role;
		
	 do {
		System.out.print("請選擇角色:");
		role= input2.next();
		if(role.equals("botanist")) {
			//體力上限變為 90。
			user.setEnergy(90);
			roleloop=false;
		}else if(role.equals("merchant")){
			//所有工具售價減少 10 元
			ts=-10;
			//販賣果實的價格每顆增加1 元
			vs=1;
			//種植以及填土並鬆土 所消耗的體力增加 5
			rs=5;
			roleloop=false;
		}else if(role.equals("hercules")) {
			//種植以及填土並鬆土所消耗的體力減少 5
			rs=-5;
			roleloop=false;
		}else {
			System.out.println("輸入錯誤,請重新輸入");
			roleloop=true;
		}
	 }while(roleloop);
		
		
		
		    //讀取資料
			Scanner reader = new Scanner(new FileInputStream("environment\\environment.txt"));
			
			//陣列長度
			int length=0;
			
			//讀取資料長度
			while(reader.hasNextLine()){
				String str;
				str = reader.nextLine();
				length++;
			}
			
		    //儲存環境資料的陣列
			String[] environment=new String[length];
			
			//資料一一存進陣列
			Scanner reader1 = new Scanner(new FileInputStream("environment\\environment.txt"));
			int t=0;
			while(reader1.hasNextLine()){ 
			String str;
			str = reader1.nextLine();
			environment[t]=str;
			t++;	
			}
			
			
			
			
		
		
		//外部
		do {
			
			//Day加一
			day++;
			
			
			
			for(int i=0;i<9;i++) {
			
			
			//如果植物已生長,且未衰敗,未成熟
			if(plant[i].getAnotherday()!=0&&plant[i].getNodecay()==true&&plant[i].getNomature()==true) {
				//植物天數加一
				plant[i].newAnotherday();
				//植物已生長天數
				plant[i].newGrowday();
				//土壤無養分
				soil[i].newSoilbroken(true);
				//功能型植物存活天數減一
				plant[i].deductLiveday(plant[i]);
				//存活天數為0,功能型植物死亡
	            if(plant[i].getLiveday()==0) {
	            	plant[i].setDecay();	
				}
			 }
			
			}
			//內部迴圈
			back=true;
			
			
			System.out.println("體力:" + user.getEnergy() + '\t' + "金錢:" + user.getMoney() + '\t' + "Day:" + day);
			
			
			
			
			//依據環境判斷濕度
			for(int i=0;i<9;i++) {
			 if ("Sunny".equals(environment[day-1])) {
				 soil[i].deductHumidity(15);
			 }
			 else if ("Storm".equals(environment[day-1])) {
				 soil[i].addHumidity(10);
			 }
			 else if ("Normal".equals(environment[day-1])) {
				 soil[i].deductHumidity(5);
			 }
			 else if ("Rainy".equals(environment[day-1])) {
				 soil[i].addHumidity(5);
			 }
			 
			}
	         
	        //內部
			do {
				
				//指令
				try {
				String test = input1.nextLine();
				hint = test.split(" ");
				
				

				switch (hint[0]) {

				// 對植物澆水
				case "water":
				//土地編號
				landnum=Integer.parseInt(hint[1]);
				boolean h=1<=landnum&&landnum<=9;	
				
				if(h==true) {
					
					//體力不足
					if(user.getEnergy()<10) {
					  System.out.println("體力不足,無法執行指令");
					  break;
					}
					boolean a= asset.contains(wateringcan);
					boolean n=false;
                    
					//有植物
					if(planttype[landnum-1]!=null){
						n=true;
					}
					boolean y=a&&n;
					//符合條件
					if(y==true) {
					// 扣體力
					user.deductEnergy(10);
					// 扣耐久度
					wateringcan.use();
					// 土壤濕度+5
					soil[landnum-1].addHumidity(5);
					}
					else if(a==false&&n==true) 
					{
					  System.out.println("請先購買澆水器");
					}
					else if(a==true&&n==false) 
					{
					  System.out.println("請先種植植物");
					}
					else if(a==false&&n==false) 
					{
					  System.out.println("請先購買澆水器");
					  System.out.println("請先種植植物");
					}
					else {
					  System.out.println("土地上所種植的植物與指令不符,澆水失敗");
					}
					
				}else {
					System.out.println("輸入錯誤,請重新輸入");
				}
				
				  break;
				
				// 填土並鬆土
				case "fill":
				boolean q=hint[3].equals("sand")||hint[3].equals("clay")||hint[3].equals("loam")||hint[3].equals("magicdust");
				//土地編號
				landnum=Integer.parseInt(hint[4]);
				boolean z=1<=landnum&&landnum<=9;
		
				 if(hint[1].equals("and")&&hint[2].equals("loosen")&&q==true&&z==true) {
					 
					 
					//體力不足
					if(user.getEnergy()<5) {
					  System.out.println("體力不足,無法執行指令");
					  break;
					}
					
					boolean b= asset.contains(hoe);
					boolean c=asset.contains(sand)||asset.contains(clay)||asset.contains(loam)||asset.contains(magicdust);
					boolean u=b&&c;
					
					//已成熟
					if(plant[landnum-1].getMatureday()<=0) {
						System.out.println("植物已成熟,無法填土並鬆土");
						break;
					//生長中
					}else if(plant[landnum-1].getGrowday()!=0&&plant[landnum-1].getNodecay()){
						System.out.println("植物生長中,無法填土並鬆土");
						break;
					}
					
					//未種植植物或植物衰敗
					boolean w=plant[landnum-1].getDecay()>5||plant[landnum-1].getAnotherday()==0;
					if(u==true&&w==true) {
						
					//植物衰敗	
					if(plant[landnum-1].getDecay()>5) {
						plant[landnum-1].initialDecay();
						planttype[landnum-1]=null;
					}
					
				    //砂土
					if ("sand".equals(hint[3])) {
						index = asset.indexOf(sand);
						if(index==-1) {
						  System.out.println("請先購買砂土");
						  break;
						}
						asset.remove(index);
						soiltype[landnum-1] = "sand";
						// 扣體力
						user.deductEnergy(5+rs);
						// 扣耐久度
						hoe.use();
						//土壤溼度初始值
						soil[landnum-1].initialHumidity();
						//土壤有養分
						soil[landnum-1].newSoilbroken(false);
					//黏土
					} else if ("clay".equals(hint[3])) {
						index = asset.indexOf(clay);
						if(index==-1) {
						  System.out.println("請先購買黏土");
						  break;
					    }
						asset.remove(index);
						soiltype[landnum-1] = "clay";
						// 扣體力
						user.deductEnergy(5+rs);
						// 扣耐久度
						hoe.use();
						//土壤溼度初始值
						soil[landnum-1].initialHumidity();
						//土壤有養分
						soil[landnum-1].newSoilbroken(false);
					//壤土
					} else if ("loam".equals(hint[3])) {
						index = asset.indexOf(loam);
						if(index==-1) {
					      System.out.println("請先購買壤土");
						  break;
						}
						asset.remove(index);
						soiltype[landnum-1] = "loam";
						// 扣體力
						user.deductEnergy(5+rs);
						// 扣耐久度
						hoe.use();
						//土壤溼度初始值
						soil[landnum-1].initialHumidity();
						//土壤有養分
						soil[landnum-1].newSoilbroken(false);
					//魔法土
					}else if ("magicdust".equals(hint[3])) {
						index = asset.indexOf(magicdust);
						if(index==-1) {
						  System.out.println("請先購買魔法土");
						  break;
					    }
						asset.remove(index);
						soiltype[landnum-1] = "magicdust";
						// 扣體力
						user.deductEnergy(5+rs);
						// 扣耐久度
						hoe.use();
						//土壤溼度初始值
						soil[landnum-1].initialHumidity();
						//土壤有養分
						soil[landnum-1].newSoilbroken(false);
					}
				
					//依據環境判斷濕度
					 if ("Sunny".equals(environment[day-1])) {
						 soil[landnum-1].deductHumidity(15);
					 }
					 else if ("Storm".equals(environment[day-1])) {
						 soil[landnum-1].addHumidity(10);
					 }
					 else if ("Normal".equals(environment[day-1])) {
						 soil[landnum-1].deductHumidity(5);
					 }
					 else if ("Rainy".equals(environment[day-1])) {
						 soil[landnum-1].addHumidity(5);
					 }
					 
					 //植物恢復沒被影響過
					 if(landnum==1){
						 a1=true;
						 b1=true;
					 }else if(landnum==2) {
						 a2=true;
						 b2=true;
					 }else if(landnum==3) {
						 a3=true;
						 b3=true;
					 }else if(landnum==4) {
						 a4=true;
						 b4=true;
					 }else if(landnum==5) {
						 a5=true;
						 b5=true;
					 }else if(landnum==6) {
						 a6=true;
						 b6=true;
					 }else if(landnum==7) {
						 a7=true;
						 b7=true;
					 }else if(landnum==8) {
						 a8=true;
						 b8=true;
					 }else if(landnum==9) {
						 a9=true;
						 b9=true;
					 }
					 
					 
				}else if(b==false&&c==true){
					System.out.println("請先購買鋤頭");
					
				}else if(b==true&&c==false){
					System.out.println("請先購買未使用的土壤");
					
				}else if(b==false&&c==false){  
					System.out.println("請先購買鋤頭");
					System.out.println("請先購買未使用的土壤");
					
				}
				
					
				}else{	
				  System.out.println("輸入錯誤,請重新輸入");
				}
				  break;
				
				// 種植
				case "plant":
				//土地編號
				landnum=Integer.parseInt(hint[2]);
				boolean n= 1<=landnum&&landnum<=9;
				boolean kn="magicdust".equals(soiltype[landnum-1]);
				boolean cd=hint[1].equals("watermelon")||hint[1].equals("mulberry");
				boolean sf=hint[1].equals("sungrass")||hint[1].equals("starflower");
				
				//沒有土壤
				if(soiltype[landnum-1]==null){
					System.out.println("沒有土壤,無法種植");
					break;
				}
				//種植賺錢型作物,土地上是魔法土
				if(cd==true&&n==true&&kn==true) {
					System.out.println("請種植功能型植物");
					break;
				}
				//種植功能型作物,土地上不是魔法土
				if(sf==true&&n==true&&kn==false) {
					System.out.println("請種植賺錢型植物");
					break;
				}
				
				//種植賺錢型作物,土地上不是魔法土或種植功能型作物,土地上是魔法土
				if(cd==true&&n==true&&kn==false||sf==true&&n==true&&kn==true) {
					
				
					//體力不足
					if(user.getEnergy()<15) {
					  System.out.println("體力不足,無法執行指令");
					  break;
					}
					boolean d= asset.contains(wseed);
					boolean x=asset.contains(mseed);
					boolean r=asset.contains(sungrass);
					boolean s=asset.contains(starflower);
					//已成熟
					if(plant[landnum-1].getMatureday()<0) {
						System.out.println("植物已成熟,請採收");
						break;
					//已衰敗
					}else if(plant[landnum-1].getDecay()>5) {
						System.out.println("植物衰敗,無法種植");
						break;
					}//土裡有植物
					else if(planttype[landnum-1]!=null){
						System.out.println("植物生長中,無法種植");
						break;
					//土壤無養分
					}else if(soil[landnum-1].getSoilbroken()==true){
						System.out.println("土壤無養分,無法種植,請更換新土");
						break;
					}

				//種植西瓜有西瓜種子
				if("watermelon".equals(hint[1])&&d==true) {
					index = asset.indexOf(wseed);
					asset.remove(index);
					// 扣體力
					user.deductEnergy(15+rs);
					//指向新的watermelon
					watermelon=new Watermelon(vs);
					//plant指向watermelon
					plant[landnum-1]=new Watermelon(vs);
				    watermelon=(Watermelon) plant[landnum-1];
					planttype[landnum-1]="watermelon";
					//角色-植物學家
					if("botanist".equals(role)) {
					  //賺錢型植物的預計產果數量增加 1 顆
					  plant[landnum-1].addFruit(plant[landnum-1]);
					}
					//植物天數
					plant[landnum-1].initialAnotherday(1);
					//衰敗天數
					plant[landnum-1].initialDecay();
					//黏土
					if(soiltype[landnum-1]=="clay"){
						plant[landnum-1].deductPlantday(plant[landnum-1]);
						plant[landnum-1].deductFruit(plant[landnum-1]);
					}//壤土	
					else if(soiltype[landnum-1]=="loam") {
					  plant[landnum-1].addPlantday(plant[landnum-1]);
					  plant[landnum-1].addFruit(plant[landnum-1]);
					}
					
					break;
				//種植桑樹有桑樹種子
				}else if("mulberry".equals(hint[1])&&x==true) {
					index = asset.indexOf(mseed);
					asset.remove(index);
					// 扣體力
					user.deductEnergy(15+rs);
					//指向新的mulberry
					mulberry=new Mulberry(vs);
					//plant指向mulberry
					plant[landnum-1]=new Mulberry(vs);
					mulberry=(Mulberry) plant[landnum-1];
					planttype[landnum-1]="mulberry";
					//角色-植物學家
					if(role.equals("botanist")) {
					  //賺錢型植物的預計產果數量增加 1 顆
					  plant[landnum-1].addFruit(plant[landnum-1]);
					}
					//植物天數
					plant[landnum-1].initialAnotherday(1);
					//衰敗天數
					plant[landnum-1].initialDecay();
					//黏土
					if(soiltype[landnum-1]=="clay") {
						plant[landnum-1].deductPlantday(plant[landnum-1]);
						plant[landnum-1].deductFruit(plant[landnum-1]);
					}//壤土	
					else if(soiltype[landnum-1]=="loam") {
					  plant[landnum-1].addPlantday(plant[landnum-1]);
					  plant[landnum-1].addFruit(plant[landnum-1]);
					}
					
					break;
				//種植太陽草有太陽草種子
				}else if("sungrass".equals(hint[1])&&r==true) {	
					index = asset.indexOf(sungrass);
					asset.remove(index);
					// 扣體力
					user.deductEnergy(15+rs);
					//指向新的sungrass
					sungrass=new Sungrass();
					//plant指向sungrass
					plant[landnum-1]=new Sungrass();
					sungrass=(Sungrass) plant[landnum-1];
					planttype[landnum-1]="sungrass";
					//角色-植物學家
					if(role.equals("botanist")) {
					  //功能型植物的存活天數增加 1 天
					  plant[landnum-1].addLiveday(plant[landnum-1]);
					}
					
					//植物天數
					plant[landnum-1].initialAnotherday(1);
					//衰敗天數
					plant[landnum-1].initialDecay();
					//添加種植太陽草的土地編號
					sungrassland.add(landnum);
					break;
				//種植星辰花有星辰花種子
				}else if("starflower".equals(hint[1])&&s==true) {	
						index = asset.indexOf(starflower);
						asset.remove(index);
						// 扣體力
						user.deductEnergy(15+rs);
						//指向新的starflower
						starflower=new Starflower();
						//plant指向starflower
						plant[landnum-1]=new Starflower();
						starflower=(Starflower) plant[landnum-1];
						planttype[landnum-1]="starflower";
						//角色-植物學家
						if(role.equals("botanist")) {
						   //功能型植物的存活天數增加 1 天
						   plant[landnum-1].addLiveday(plant[landnum-1]);
						}
						//植物天數
						plant[landnum-1].initialAnotherday(1);
						//衰敗天數
						plant[landnum-1].initialDecay();
						//添加種植星辰花的土地編號
						starflowerland.add(landnum);
						break;
				
				}else {
					System.out.println("請先購買植物種子");
					break;
				}
				 
				  
				
				}else {
					System.out.println("輸入錯誤,請重新輸入");
					break;
				}
				
				  
				// 收割果實
				case "reap":
				//土地編號
				landnum=Integer.parseInt(hint[4]);
				boolean p=1<=landnum&&landnum<=9;
				
				//土裡無植物
				if(planttype[landnum-1]==null) {
				  System.out.println("沒有植物,無法採收");
				  break;
				}
				
				//土裡為功能型植物
				if("sungrass".equals(planttype[landnum-1])||"starflower".equals(planttype[landnum-1])) {
				  System.out.println("功能型植物,無法採收");
				  break;
				}
				
				
				  //欲採收的植物與土地上植物相同
				  if(hint[1].equals("and")&&hint[2].equals("sell")&&hint[3].equals(planttype[landnum-1])&&p==true) {
					//體力不足
					if(user.getEnergy()<5) {
					  System.out.println("體力不足,無法執行指令");
					  break;
					}
					
					boolean f= asset.contains(sickle);
					
					//已衰敗
					if(plant[landnum-1].getDecay()>5) {
					  System.out.println("植物衰敗,無法採收");
					  break;
					}//未成熟
					else if(plant[landnum-1].getMatureday()>0){
						System.out.println("植物尚未成熟,無法採收");
						break;
					}
					
					//有鐮刀
					if(f==true) {
						// 扣體力
						user.deductEnergy(5);
						//加收穫金錢
                        user.addMoney(plant[landnum-1].getTotalprice());
                        //植物天數歸零
                        plant[landnum-1].initialAnotherday(0);
                        //土裡沒植物
                        planttype[landnum-1]=null;
                        //衰敗天數歸零
                        plant[landnum-1].initialDecay();
					}else if(f==false){
						System.out.println("請先購買鐮刀");
					}
				  }else{		
					  System.out.println("輸入錯誤,請重新輸入");
				  }
				  
					break;
				  
				// 購買
				case "buy":
					
					//澆水器
					if ("watering".equals(hint[1])&&"can".equals(hint[2])) {
						
					  //金錢不足
					  if(user.getMoney()<50) {
						 System.out.println("金錢不足,無法購買");
						 break;
					  }
						//工具玩家一次只能擁有一個
						boolean j= asset.contains(wateringcan);
						if(j==false) {
						asset.add(wateringcan);
						user.buy(50+ts);
						}else {
							System.out.println("已擁有,購買失敗");
						}
					//鋤頭
					} else if ("hoe".equals(hint[1])) {
						
					  //金錢不足
					  if(user.getMoney()<420) {
						  System.out.println("金錢不足,無法購買");
						  break;
						}
						//工具玩家一次只能擁有一個
						boolean ku= asset.contains(hoe);
						if(ku==false) {
						asset.add(hoe);
						user.buy(420+ts);
						}else {
							System.out.println("已擁有,購買失敗");
						}
					//鐮刀
					} else if ("sickle".equals(hint[1])) {
						
						//金錢不足
						if(user.getMoney()<210) {
							 System.out.println("金錢不足,無法購買");
							 break;
						  }
						//工具玩家一次只能擁有一個
						boolean i= asset.contains(sickle);
						if(i==false) {
						asset.add(sickle);
						user.buy(210+ts);
						}else {
							System.out.println("已擁有,購買失敗");
						}
					//西瓜種子
					} else if ("watermelon".equals(hint[1])) {
						//金錢不足
						if(user.getMoney()<10) {
							 System.out.println("金錢不足,無法購買");
							 break;
						 }
						asset.add(wseed);
						user.buy(10);
					//桑樹種子
					} else if ("mulberry".equals(hint[1])) {
						//金錢不足
						if(user.getMoney()<5) {
							 System.out.println("金錢不足,無法購買");
							 break;
						}
						asset.add(mseed);
						user.buy(5);
					//太陽草種子
					} else if ("sungrass".equals(hint[1])) {
						//金錢不足
						if(user.getMoney()<15) {
							 System.out.println("金錢不足,無法購買");
							 break;
						}
						asset.add(sungrass);
						user.buy(15);
					//星辰花種子
					} else if ("starflower".equals(hint[1])) {
						//金錢不足
						if(user.getMoney()<20) {
							 System.out.println("金錢不足,無法購買");
							 break;
						}
						asset.add(starflower);
						user.buy(20);
					//砂土
					} else if ("sand".equals(hint[1])) {
						//金錢不足
						if(user.getMoney()<15) {
							 System.out.println("金錢不足,無法購買");
							 break;
						 }
						asset.add(sand);
						user.buy(15);
					//黏土
					} else if ("clay".equals(hint[1])) {
						//金錢不足
						if(user.getMoney()<20) {
							 System.out.println("金錢不足,無法購買");
							 break;
						 }
						asset.add(clay);
						user.buy(20);
				    //壤土
					} else if ("loam".equals(hint[1])) {
						//金錢不足
						if(user.getMoney()<20) {
							 System.out.println("金錢不足,無法購買");
							 break;
						 }
						asset.add(loam);
						user.buy(20);
					//魔法土
					} else if ("magicdust".equals(hint[1])) {
						//金錢不足
						if(user.getMoney()<30) {
							 System.out.println("金錢不足,無法購買");
							 break;
						 }
						asset.add(magicdust);
						user.buy(30);
					
					}else {
					  System.out.println("輸入錯誤,請重新輸入");
					}

					break;
				// 檢查田地狀態
				case "check":
				//土地編號
				landnum=Integer.parseInt(hint[1]);
				boolean o=1<=landnum&&landnum<=9;
				//土地編號介於1~9
				  if(o==true) {
					//體力不足
					if(user.getEnergy()<5) {
					  System.out.println("體力不足,無法執行指令");
					  break;
					}
					//已成熟
					if(plant[landnum-1].getMatureday()<=0) {
						System.out.println("田地編號:"+landnum);
						System.out.println("植物已成熟,請採收");
						System.out.println("田地中目前種植:" + planttype[landnum-1]);
						System.out.println("土壤 :" + soiltype[landnum-1]);
						System.out.println("濕度 :"+soil[landnum-1].getHumidity());
						System.out.println("已生長天數  :"+plant[landnum-1].getGrowday()+"天");
						// 扣體力
						user.deductEnergy(5);
					//已衰敗
					}else if(plant[landnum-1].getDecay()>5) {
						System.out.println("田地編號:"+landnum);
						System.out.println("植物衰敗,請重新填土並鬆土");
						System.out.println("田地中目前種植:" + planttype[landnum-1]);
						System.out.println("土壤 :" + soiltype[landnum-1]);
						System.out.println("濕度 :"+soil[landnum-1].getHumidity());
						System.out.println("已生長天數  :"+plant[landnum-1].getGrowday()+"天");
						// 扣體力
						user.deductEnergy(5);
					}
					//土裡無植物
					else if(planttype[landnum-1]==null) {
						System.out.println("田地編號:"+landnum);
						System.out.println("目前無種植植物");
						System.out.println("土壤:" + soiltype[landnum-1]);
						System.out.println("濕度 :"+soil[landnum-1].getHumidity());
						// 扣體力
						user.deductEnergy(5);
					}
					else {
					System.out.println("田地編號:"+landnum);
					System.out.println("田地中目前種植:" +planttype[landnum-1]);
					System.out.println("土壤 :" + soiltype[landnum-1]);
					System.out.println("濕度 :"+soil[landnum-1].getHumidity());
					System.out.println("已生長天數  :"+plant[landnum-1].getGrowday()+"天");
					System.out.println("預期產出之果實量:" +plant[landnum-1].getFruit()+"顆");
					//賺錢型植物
					if("watermelon".equals(planttype[landnum-1])||"mulberry".equals(planttype[landnum-1])) {
						System.out.println("預期再過幾天會成熟:"+plant[landnum-1].getMatureday()+"天");
						if(plant[landnum-1].getMatureday()>0) {
							System.out.println("尚未結果");
						}else {
							System.out.println("已結果");
						}
					//功能型植物
					}else if("sungrass".equals(planttype[landnum-1])||"starflower".equals(planttype[landnum-1])){
						System.out.println("剩餘存活天數:" +plant[landnum-1].getLiveday()+"天");
					}
					// 扣體力
					user.deductEnergy(5);
					
					
					}
				  }else {
					  System.out.println("輸入錯誤,請重新輸入");
				  }
					break;
					
				// 睡覺指令
				case "sleep":
				//角色-力士睡覺時會恢復所有的體力
				if(role.equals("hercules")) {
					user.addEnergy(100);	
				}else {
					user.addEnergy(70);
				}
					
				back = false;
				break;
					
					
			        
			       
			    default:
				   System.out.println("輸入錯誤,請重新輸入");
				   break;
				  
				   
						
						
						
					}//switch
				
				//輸入錯誤
				}catch(Exception e){     
					System.out.println("輸入錯誤,請重新輸入");
				}			 
				
				//玩家體力歸零
		        if(user.getEnergy()==0) {
		        	//加體力
					user.addEnergy(70);
					back = false;
		        }
		        
		       //耐久度歸零時，該工具自動銷毀
		         if(wateringcan.getDurability()==0) {
						index = asset.indexOf(wateringcan);
						asset.remove(index);
		         }
		         else if(hoe.getDurability()==0) {
						index = asset.indexOf(hoe);
						asset.remove(index);
		         }
		         else if(sickle.getDurability()==0) {
						index = asset.indexOf(sickle);
						asset.remove(index);
		         } 
				
				
		        System.out.println("體力:" + user.getEnergy() + '\t' + "金錢:" + user.getMoney());
		         
			}while(back);//內部
				
			
			
			
			//太陽草影響範圍
			for(int i=0;i<sungrassland.size();i++) {
					
			//1
			if(sungrassland.get(i)==1) {
				 //2	
				 if("watermelon".equals(planttype[1])||"mulberry".equals(planttype[1])){
					 if(plant[1].getMatureday()>0&&a2==true) {
						plant[1].deductPlantday(plant[1]);
						a2=false;
				      }
				 }
				//4  
				if("watermelon".equals(planttype[3])||"mulberry".equals(planttype[3])) {
					if(plant[3].getMatureday()>0&&a4==true) {
						plant[3].deductPlantday(plant[3]);
						a4=false;
				     }
				}
			 //2
			 }else if(sungrassland.get(i)==2) {
				 //1
				 if("watermelon".equals(planttype[0])||"mulberry".equals(planttype[0])){
					 if(plant[0].getMatureday()>0&&a1==true) {
						plant[0].deductPlantday(plant[0]);
						a1=false;
				      }
				 }
				//3 
				if("watermelon".equals(planttype[2])||"mulberry".equals(planttype[2])) {
					if(plant[2].getMatureday()>0&&a3==true) {
						plant[2].deductPlantday(plant[2]);
						a3=false;
				     }
				}
			   //5
			   if("watermelon".equals(planttype[4])||"mulberry".equals(planttype[4])) {
					if(plant[4].getMatureday()>0&&a5==true) {
						plant[4].deductPlantday(plant[4]);
						a5=false;
				     }
			   }	
			//3
			}else if(sungrassland.get(i)==3) {
				   //2	
				   if("watermelon".equals(planttype[1])||"mulberry".equals(planttype[1])){
					 if(plant[1].getMatureday()>0&&a2==true) {
						plant[1].deductPlantday(plant[1]);
						a2=false;
				      }
				   }
					//6 
					if("watermelon".equals(planttype[5])||"mulberry".equals(planttype[5])) {
						if(plant[5].getMatureday()>0&&a6==true) {
							plant[5].deductPlantday(plant[5]);
							a6=false;
					     }
					}
			//4
			}else if(sungrassland.get(i)==4) {
				  //1
				  if("watermelon".equals(planttype[0])||"mulberry".equals(planttype[0])){
					 if(plant[0].getMatureday()>0&&a1==true) {
						plant[0].deductPlantday(plant[0]);
						a1=false;
				      }
				  }
				  //5
				  if("watermelon".equals(planttype[4])||"mulberry".equals(planttype[4])) {
						if(plant[4].getMatureday()>0&&a5==true) {
							 plant[4].deductPlantday(plant[4]);
							 a5=false;
				        }
				  }
				  //7
				  if("watermelon".equals(planttype[6])||"mulberry".equals(planttype[6])) {
						if(plant[6].getMatureday()>0&&a7==true) {
							 plant[6].deductPlantday(plant[6]);
							 a7=false;
				        } 
				  }
			//5
			}else if(sungrassland.get(i)==5) {
				   //2	
				   if("watermelon".equals(planttype[1])||"mulberry".equals(planttype[1])){
					 if(plant[1].getMatureday()>0&&a2==true) {
						plant[1].deductPlantday(plant[1]);
						a2=false;
				      }
				   }
					//4  
					if("watermelon".equals(planttype[3])||"mulberry".equals(planttype[3])) {
						if(plant[3].getMatureday()>0&&a4==true) {
							plant[3].deductPlantday(plant[3]);
							a4=false;
					     }
					}
					//6 
					if("watermelon".equals(planttype[5])||"mulberry".equals(planttype[5])) {
						if(plant[5].getMatureday()>0&&a6==true) {
							plant[5].deductPlantday(plant[5]);
							a6=false;
					     } 
					}
					//8
					if("watermelon".equals(planttype[7])||"mulberry".equals(planttype[7])) {
						if(plant[7].getMatureday()>0&&a8==true) {
							plant[7].deductPlantday(plant[7]);
							a8=false;
					     } 
					}
			//6
			}else if(sungrassland.get(i)==6) {
				  //3 
			      if("watermelon".equals(planttype[2])||"mulberry".equals(planttype[2])) {
				    if(plant[2].getMatureday()>0&&a3==true) {
					  plant[2].deductPlantday(plant[2]);
					  a3=false;
			          }
			      }
				  //5
				  if("watermelon".equals(planttype[4])||"mulberry".equals(planttype[4])) {
						if(plant[4].getMatureday()>0&&a5==true) {
							 plant[4].deductPlantday(plant[4]);
							 a5=false;
				        }
				  }
				  //9
				  if("watermelon".equals(planttype[8])||"mulberry".equals(planttype[8])) {
						if(plant[8].getMatureday()>0&&a9==true) {
							plant[8].deductPlantday(plant[8]);
							a9=false;
						} 
				  }
			//7
			}else if(sungrassland.get(i)==7) {
				  //4  
			      if("watermelon".equals(planttype[3])||"mulberry".equals(planttype[3])) {
				    if(plant[3].getMatureday()>0&&a4==true) {
					   plant[3].deductPlantday(plant[3]);
					   a4=false;
			         }
			      }
				  //8
				 if("watermelon".equals(planttype[7])||"mulberry".equals(planttype[7])) {
						if(plant[7].getMatureday()>0&&a8==true) {
							plant[7].deductPlantday(plant[7]);
							a8=false;
					     } 
				 }
			//8
			}else if(sungrassland.get(i)==8) {
				//5
			    if("watermelon".equals(planttype[4])||"mulberry".equals(planttype[4])) {
					if(plant[4].getMatureday()>0&&a5==true) {
						 plant[4].deductPlantday(plant[4]);
						 a5=false;
			        }
			     }
				 //7
				if("watermelon".equals(planttype[6])||"mulberry".equals(planttype[6])) {
						if(plant[6].getMatureday()>0&&a7==true) {
							 plant[6].deductPlantday(plant[6]);
							 a7=false;
				        } 
				 }
				 //9
				 if("watermelon".equals(planttype[8])||"mulberry".equals(planttype[8])) {
						if(plant[8].getMatureday()>0&&a9==true) {
							plant[8].deductPlantday(plant[8]);
							a9=false;
						} 
				 }
			//9
			}else if(sungrassland.get(i)==9) {
				//6 
			    if("watermelon".equals(planttype[5])||"mulberry".equals(planttype[5])) {
				   if(plant[5].getMatureday()>0&&a6==true) {
					  plant[5].deductPlantday(plant[5]);
					  a6=false;
			        } 
			    }
				 //8
				 if("watermelon".equals(planttype[7])||"mulberry".equals(planttype[7])) {
						if(plant[7].getMatureday()>0&&a8==true) {
							plant[7].deductPlantday(plant[7]);
							a8=false;
					     } 
				 }
			}
			
		}
			
			//星辰花影響範圍
			for(int g=0;g<starflowerland.size();g++) {
								
				//1
				if(starflowerland.get(g)==1) {
						//2	
						if("watermelon".equals(planttype[1])||"mulberry".equals(planttype[1])){
							if(plant[1].getMatureday()>0&&b2==true) {
								plant[1].addFruit(plant[1]);
								b2=false;
							  }
						 }
						//4  
						if("watermelon".equals(planttype[3])||"mulberry".equals(planttype[3])) {
							if(plant[3].getMatureday()>0&&b4==true) {
								plant[3].addFruit(plant[3]);
								b4=false;
							  }
				        }
				 //2
				}else if(starflowerland.get(g)==2) {
						 //1
						 if("watermelon".equals(planttype[0])||"mulberry".equals(planttype[0])){
							 if(plant[0].getMatureday()>0&&b1==true) {
								 plant[0].addFruit(plant[0]);
								 b1=false;
							  }
						 }
						  //3 
						 if("watermelon".equals(planttype[2])||"mulberry".equals(planttype[2])) {
							  if(plant[2].getMatureday()>0&&b3==true) {
									plant[2].addFruit(plant[2]);
									b3=false;
							     }
						 }
						  //5
						 if("watermelon".equals(planttype[4])||"mulberry".equals(planttype[4])) {
								if(plant[4].getMatureday()>0&&b5==true) {
									plant[4].addFruit(plant[4]);
									b5=false;
							     }
						 }
				  //3
				  }else if(starflowerland.get(g)==3) {
						//2	
					    if("watermelon".equals(planttype[1])||"mulberry".equals(planttype[1])){
							   if(plant[1].getMatureday()>0&&b2==true) {
									plant[1].addFruit(plant[1]);
									b2=false;
							      }
					    }
						//6 
						if("watermelon".equals(planttype[5])||"mulberry".equals(planttype[5])) {
								if(plant[5].getMatureday()>0&&b6==true) {
										plant[5].addFruit(plant[5]);
										b6=false;
								     }
						}
					//4
					}else if(starflowerland.get(g)==4) {
						     //1
						     if("watermelon".equals(planttype[0])||"mulberry".equals(planttype[0])){
								 if(plant[0].getMatureday()>0&&b1==true) {
									plant[0].addFruit(plant[0]);
									b1=false;
							      }
						      }
							  //5
							  if("watermelon".equals(planttype[4])||"mulberry".equals(planttype[4])) {
									if(plant[4].getMatureday()>0&&b5==true) {
										 plant[4].addFruit(plant[4]);
										 b5=false;
							        }
							  }
							  //7
							  if("watermelon".equals(planttype[6])||"mulberry".equals(planttype[6])) {
									if(plant[6].getMatureday()>0&&b7==true) {
										 plant[6].addFruit(plant[6]);
										 b7=false;
							        } 
							  }
					  //5
					  }else if(starflowerland.get(g)==5) {
							  //2	
							  if("watermelon".equals(planttype[1])||"mulberry".equals(planttype[1])){
								 if(plant[1].getMatureday()>0&&b2==true) {
									plant[1].addFruit(plant[1]);
									b2=false;
							      }
							  }
								//4  
							   if("watermelon".equals(planttype[3])||"mulberry".equals(planttype[3])) {
									if(plant[3].getMatureday()>0&&b4==true) {
										plant[3].addFruit(plant[3]);
										b4=false;
								     }
							   }
								//6 
								if("watermelon".equals(planttype[5])||"mulberry".equals(planttype[5])) {
									if(plant[5].getMatureday()>0&&b6==true) {
										plant[5].addFruit(plant[5]);
										b6=false;
								     } 
								}
								//8
								if("watermelon".equals(planttype[7])||"mulberry".equals(planttype[7])) {
									if(plant[7].getMatureday()>0&&b8==true) {
										plant[7].addFruit(plant[7]);
										b8=false;
								     } 
								}
						//6
						}else if(starflowerland.get(g)==6) {
							  //3 
						      if("watermelon".equals(planttype[2])||"mulberry".equals(planttype[2])) {
							    if(plant[2].getMatureday()>0&&b3==true) {
								  plant[2].addFruit(plant[2]);
								  b3=false;
						          }
						      }
							  //5
							  if("watermelon".equals(planttype[4])||"mulberry".equals(planttype[4])) {
									if(plant[4].getMatureday()>0&&b5==true) {
										 plant[4].addFruit(plant[4]);
										 b5=false;
							        }
							  }
							  //9
							  if("watermelon".equals(planttype[8])||"mulberry".equals(planttype[8])) {
									if(plant[8].getMatureday()>0&&b9==true) {
										plant[8].addFruit(plant[8]);
										b9=false;
									} 
							  }
						//7
						}else if(starflowerland.get(g)==7) {
							  //4  
						      if("watermelon".equals(planttype[3])||"mulberry".equals(planttype[3])) {
							    if(plant[3].getMatureday()>0&&b4==true) {
								   plant[3].addFruit(plant[3]);
								   b4=false;
						         }
						      }
							  //8
							  if("watermelon".equals(planttype[7])||"mulberry".equals(planttype[7])) {
									if(plant[7].getMatureday()>0&&b8==true) {
										plant[7].addFruit(plant[7]);
										b8=false;
								     } 
							  }
						//8
						}else if(starflowerland.get(g)==8) {
							//5
						    if("watermelon".equals(planttype[4])||"mulberry".equals(planttype[4])) {
								if(plant[4].getMatureday()>0&&b5==true) {
									 plant[4].addFruit(plant[4]);
									 b5=false;
						        }
						    }
							//7
							if("watermelon".equals(planttype[6])||"mulberry".equals(planttype[6])) {
									if(plant[6].getMatureday()>0&&b7==true) {
										 plant[6].addFruit(plant[6]);
										 b7=false;
							        }
							}
							 //9
							 if("watermelon".equals(planttype[8])||"mulberry".equals(planttype[8])) {
									if(plant[8].getMatureday()>0&&b9==true) {
										plant[8].addFruit(plant[8]);
										b9=false;
									} 
							 }
						//9
						}else if(starflowerland.get(g)==9) {
							//6 
						    if("watermelon".equals(planttype[5])||"mulberry".equals(planttype[5])) {
							   if(plant[5].getMatureday()>0&&b6==true) {
								  plant[5].addFruit(plant[5]);
								  b6=false;
						        }
						    }
							 //8
							 if("watermelon".equals(planttype[7])||"mulberry".equals(planttype[7])) {
									if(plant[7].getMatureday()>0&&b8==true) {
										plant[7].addFruit(plant[7]);
										b8=false;
								     }    
							 }
						}
					    
				  }
			
			//結算濕度
		for(int n=0;n<9;n++){	
			//土裡有植物
			if(planttype[n]!=null) {
				
				boolean w=soil[n].getHumidity()>25||soil[n].getHumidity()<15;
				boolean s=soil[n].getHumidity()>35||soil[n].getHumidity()<25;
				boolean yh=soil[n].getHumidity()>20||soil[n].getHumidity()<10;
				boolean ph=soil[n].getHumidity()>40||soil[n].getHumidity()<30;
				
				//西瓜
				if(planttype[n].equals("watermelon")) {
					
					//無衰敗,無成熟,濕度不符
					if(plant[n].getNodecay()==true&&plant[n].getNomature()==true&&w==true) {
						//衰敗天數加一
						plant[n].addDecay(plant[n]);
						//減產到0
						if(plant[n].getFruit()==0) {
						  plant[n].setDecay();
						}
						//已衰敗
						if(plant[n].getDecay()==6) {
							  System.out.println("植物衰敗"); 
						//減產量
						}else if(plant[n].getDecay()>3) {
							plant[n].deductFruit(plant[n]);
						}
					//衰敗天數歸零
					}else {
						plant[n].initialDecay();
					}
					
				//桑樹
				}else if(planttype[n].equals("mulberry")){
					
					//無衰敗,無成熟,濕度不符
					if(plant[n].getNodecay()==true&&plant[n].getNomature()==true&&s==true) {
						//衰敗天數加一
						plant[n].addDecay(plant[n]);
						//減產到0
						if(plant[n].getFruit()==0) {
						  plant[n].setDecay();
						}
						//已衰敗
						if(plant[n].getDecay()==6) {
							  System.out.println("植物衰敗");	  
						//減產量
						}else if(plant[n].getDecay()>3) {
							plant[n].deductFruit(plant[n]);
						}
					//衰敗天數歸零
					}else {
						plant[n].initialDecay();
					}
					 
				//太陽草	
				}else if(planttype[n].equals("sungrass")){
					
					//無衰敗,濕度不符
					if(plant[n].getNodecay()==true&&yh==true) {
						//存活天數減一
						plant[n].deductLiveday(plant[n]);
			        }
               //星辰花
			   }else if(planttype[n].equals("starflower")){
					
					//無衰敗,濕度不符
					if(plant[n].getNodecay()==true&&ph==true) {
						//存活天數減一
						plant[n].deductLiveday(plant[n]);
			        }
              
                
			   }
			
		   }
		}
			
			
			//玩家破產-環境變化之檔案已無下一天之內容
			if(length<day+1) {
				reback=false;
				System.out.println("環境變化之檔案已無下一天之內容,遊戲結束");	
			}
          
		  //土裡無土壤
		  boolean k=soiltype[0]==null&&soiltype[1]==null&&soiltype[2]==null&&soiltype[3]==null&&soiltype[4]==null&&soiltype[5]==null&&soiltype[6]==null&&soiltype[7]==null&&soiltype[8]==null;
		  //土裡無養分
		  boolean jk=soil[0].getSoilbroken()==true&&soil[1].getSoilbroken()==true&&soil[2].getSoilbroken()==true&&soil[3].getSoilbroken()==true&&soil[4].getSoilbroken()==true&&soil[5].getSoilbroken()==true&&soil[6].getSoilbroken()==true&&soil[7].getSoilbroken()==true&&soil[8].getSoilbroken()==true;
		  //土裡無植物
		  boolean ik=planttype[0]==null&&planttype[1]==null&&planttype[2]==null&&planttype[3]==null&&planttype[4]==null&&planttype[5]==null&&planttype[6]==null&&planttype[7]==null&&planttype[8]==null;
		  //土裡無土壤或土裡無養分
		  boolean op=k||jk;
		  //土裡植物皆衰敗
		  boolean die=plant[0].getNodecay()==false&&plant[1].getNodecay()==false&&plant[2].getNodecay()==false&&plant[3].getNodecay()==false&&plant[4].getNodecay()==false&&plant[5].getNodecay()==false&&plant[6].getNodecay()==false&&plant[7].getNodecay()==false&&plant[8].getNodecay()==false;
		  
		  
		  //玩家破產-沒有金錢且土裡無植物
          if(user.getMoney()==0&&ik==true) {
        	
        	//身上無種子
        	if(asset.contains(wseed)==false&&asset.contains(mseed)==false) {
            	reback=false;
            	System.out.println("玩家破產,遊戲結束");
            //身上無土壤且土裡無土壤或土裡無養分
        	}else if(asset.contains(sand)==false&&asset.contains(clay)==false&&asset.contains(loam)==false&&op==true) {
        	   reback=false;
        	   System.out.println("玩家破產,遊戲結束");
        	//身上無鋤頭且土裡無土壤或土裡無養分
        	}else if(asset.contains(hoe)==false&&op==true) {
         	    reback=false;
         	    System.out.println("玩家破產,遊戲結束");
         	//身上無鐮刀
        	}else if(asset.contains(sickle)==false) {
         	    reback=false;
         	    System.out.println("玩家破產,遊戲結束");
            }
         }
          
          //玩家破產-沒有金錢且土裡有植物
          if(user.getMoney()==0&&ik==false) {
        	  //已衰敗
        	  if(die==true) {
        		  reback=false;
           	      System.out.println("玩家破產,遊戲結束");
        	  //身上無鐮刀
        	  }else if(asset.contains(sickle)==false) {
           	      reback=false;
           	      System.out.println("玩家破產,遊戲結束");
        	  }
          }
        	
				
				
		}while(reback);
		
		System.out.println("玩家剩餘金錢:"+user.getMoney());
		System.out.println("存活天數:"+day);
		
	}
}
