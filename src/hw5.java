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
	    //���O�}�C
		String[] hint;
		//�c��G�ꪺ����C���W�[1 ��
		int vs=0;
		//�شӥH�ζ�g���P�g�Ү��Ӫ���O�W�[ 5
		int rs=0;
		//�Ҧ��u������� 10 ��
	    int ts=0;
		
		//�w�ʶR���~
		ArrayList asset = new ArrayList();
		//�Ӷ���
		ArrayList<Integer> sungrassland= new ArrayList<Integer>();
		//�P����
		ArrayList<Integer> starflowerland= new ArrayList<Integer>();
		//�Цa�s��
		int landnum;
		//�Ӫ�
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

	    
		//�g�[
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
 		//�Ӫ�
		String[] planttype=new String[9];
		//�g�[
		String[] soiltype=new String[9];
		//���~�b�}�C����m
		int index=0;
		//�����j��
		boolean reback = true;
		//�~���j��
		boolean back = true;
		//�u��
		Wateringcan wateringcan = new Wateringcan();
		Hoe hoe = new Hoe();
		Sickle sickle = new Sickle();
		// �ؤl
		Wseed wseed = new Wseed();
		Mseed mseed = new Mseed();
		// �g�[
		Sand sand = new Sand();
		Clay clay = new Clay();
		Loam loam = new Loam();
		Magicdust magicdust=new Magicdust();
		//�Ӫ�
	    Watermelon watermelon=new Watermelon(vs);
		Mulberry mulberry=new Mulberry(vs);
		//�\�૬�Ӫ�
		Sungrass sungrass=new Sungrass();
		Starflower starflower=new Starflower();
		//�Ӷ���v�T�d��	   
		boolean a1=true,a2=true,a3=true,a4=true,a5=true,a6=true,a7=true,a8=true,a9=true;
		//�P����v�T�d��	   
		boolean b1=true,b2=true,b3=true,b4=true,b5=true,b6=true,b7=true,b8=true,b9=true;
		
		
		//�A���Ѽ�
	    int day = 0;
	    
     
		System.out.println("�w��Ө�A�����y");
		System.out.print("�п�J���a�W��:");
		String playername = input.next();
		Player user = new Player();
		
		//����
		boolean roleloop=true;
		String role;
		
	 do {
		System.out.print("�п�ܨ���:");
		role= input2.next();
		if(role.equals("botanist")) {
			//��O�W���ܬ� 90�C
			user.setEnergy(90);
			roleloop=false;
		}else if(role.equals("merchant")){
			//�Ҧ��u������� 10 ��
			ts=-10;
			//�c��G�ꪺ����C���W�[1 ��
			vs=1;
			//�شӥH�ζ�g���P�g �Ү��Ӫ���O�W�[ 5
			rs=5;
			roleloop=false;
		}else if(role.equals("hercules")) {
			//�شӥH�ζ�g���P�g�Ү��Ӫ���O��� 5
			rs=-5;
			roleloop=false;
		}else {
			System.out.println("��J���~,�Э��s��J");
			roleloop=true;
		}
	 }while(roleloop);
		
		
		
		    //Ū�����
			Scanner reader = new Scanner(new FileInputStream("environment\\environment.txt"));
			
			//�}�C����
			int length=0;
			
			//Ū����ƪ���
			while(reader.hasNextLine()){
				String str;
				str = reader.nextLine();
				length++;
			}
			
		    //�x�s���Ҹ�ƪ��}�C
			String[] environment=new String[length];
			
			//��Ƥ@�@�s�i�}�C
			Scanner reader1 = new Scanner(new FileInputStream("environment\\environment.txt"));
			int t=0;
			while(reader1.hasNextLine()){ 
			String str;
			str = reader1.nextLine();
			environment[t]=str;
			t++;	
			}
			
			
			
			
		
		
		//�~��
		do {
			
			//Day�[�@
			day++;
			
			
			
			for(int i=0;i<9;i++) {
			
			
			//�p�G�Ӫ��w�ͪ�,�B���I��,������
			if(plant[i].getAnotherday()!=0&&plant[i].getNodecay()==true&&plant[i].getNomature()==true) {
				//�Ӫ��Ѽƥ[�@
				plant[i].newAnotherday();
				//�Ӫ��w�ͪ��Ѽ�
				plant[i].newGrowday();
				//�g�[�L�i��
				soil[i].newSoilbroken(true);
				//�\�૬�Ӫ��s���Ѽƴ�@
				plant[i].deductLiveday(plant[i]);
				//�s���ѼƬ�0,�\�૬�Ӫ����`
	            if(plant[i].getLiveday()==0) {
	            	plant[i].setDecay();	
				}
			 }
			
			}
			//�����j��
			back=true;
			
			
			System.out.println("��O:" + user.getEnergy() + '\t' + "����:" + user.getMoney() + '\t' + "Day:" + day);
			
			
			
			
			//�̾����ҧP�_���
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
	         
	        //����
			do {
				
				//���O
				try {
				String test = input1.nextLine();
				hint = test.split(" ");
				
				

				switch (hint[0]) {

				// ��Ӫ����
				case "water":
				//�g�a�s��
				landnum=Integer.parseInt(hint[1]);
				boolean h=1<=landnum&&landnum<=9;	
				
				if(h==true) {
					
					//��O����
					if(user.getEnergy()<10) {
					  System.out.println("��O����,�L�k������O");
					  break;
					}
					boolean a= asset.contains(wateringcan);
					boolean n=false;
                    
					//���Ӫ�
					if(planttype[landnum-1]!=null){
						n=true;
					}
					boolean y=a&&n;
					//�ŦX����
					if(y==true) {
					// ����O
					user.deductEnergy(10);
					// ���@�[��
					wateringcan.use();
					// �g�[���+5
					soil[landnum-1].addHumidity(5);
					}
					else if(a==false&&n==true) 
					{
					  System.out.println("�Х��ʶR�����");
					}
					else if(a==true&&n==false) 
					{
					  System.out.println("�Х��شӴӪ�");
					}
					else if(a==false&&n==false) 
					{
					  System.out.println("�Х��ʶR�����");
					  System.out.println("�Х��شӴӪ�");
					}
					else {
					  System.out.println("�g�a�W�ҺشӪ��Ӫ��P���O����,�������");
					}
					
				}else {
					System.out.println("��J���~,�Э��s��J");
				}
				
				  break;
				
				// ��g���P�g
				case "fill":
				boolean q=hint[3].equals("sand")||hint[3].equals("clay")||hint[3].equals("loam")||hint[3].equals("magicdust");
				//�g�a�s��
				landnum=Integer.parseInt(hint[4]);
				boolean z=1<=landnum&&landnum<=9;
		
				 if(hint[1].equals("and")&&hint[2].equals("loosen")&&q==true&&z==true) {
					 
					 
					//��O����
					if(user.getEnergy()<5) {
					  System.out.println("��O����,�L�k������O");
					  break;
					}
					
					boolean b= asset.contains(hoe);
					boolean c=asset.contains(sand)||asset.contains(clay)||asset.contains(loam)||asset.contains(magicdust);
					boolean u=b&&c;
					
					//�w����
					if(plant[landnum-1].getMatureday()<=0) {
						System.out.println("�Ӫ��w����,�L�k��g���P�g");
						break;
					//�ͪ���
					}else if(plant[landnum-1].getGrowday()!=0&&plant[landnum-1].getNodecay()){
						System.out.println("�Ӫ��ͪ���,�L�k��g���P�g");
						break;
					}
					
					//���شӴӪ��δӪ��I��
					boolean w=plant[landnum-1].getDecay()>5||plant[landnum-1].getAnotherday()==0;
					if(u==true&&w==true) {
						
					//�Ӫ��I��	
					if(plant[landnum-1].getDecay()>5) {
						plant[landnum-1].initialDecay();
						planttype[landnum-1]=null;
					}
					
				    //��g
					if ("sand".equals(hint[3])) {
						index = asset.indexOf(sand);
						if(index==-1) {
						  System.out.println("�Х��ʶR��g");
						  break;
						}
						asset.remove(index);
						soiltype[landnum-1] = "sand";
						// ����O
						user.deductEnergy(5+rs);
						// ���@�[��
						hoe.use();
						//�g�[�ëת�l��
						soil[landnum-1].initialHumidity();
						//�g�[���i��
						soil[landnum-1].newSoilbroken(false);
					//�H�g
					} else if ("clay".equals(hint[3])) {
						index = asset.indexOf(clay);
						if(index==-1) {
						  System.out.println("�Х��ʶR�H�g");
						  break;
					    }
						asset.remove(index);
						soiltype[landnum-1] = "clay";
						// ����O
						user.deductEnergy(5+rs);
						// ���@�[��
						hoe.use();
						//�g�[�ëת�l��
						soil[landnum-1].initialHumidity();
						//�g�[���i��
						soil[landnum-1].newSoilbroken(false);
					//�[�g
					} else if ("loam".equals(hint[3])) {
						index = asset.indexOf(loam);
						if(index==-1) {
					      System.out.println("�Х��ʶR�[�g");
						  break;
						}
						asset.remove(index);
						soiltype[landnum-1] = "loam";
						// ����O
						user.deductEnergy(5+rs);
						// ���@�[��
						hoe.use();
						//�g�[�ëת�l��
						soil[landnum-1].initialHumidity();
						//�g�[���i��
						soil[landnum-1].newSoilbroken(false);
					//�]�k�g
					}else if ("magicdust".equals(hint[3])) {
						index = asset.indexOf(magicdust);
						if(index==-1) {
						  System.out.println("�Х��ʶR�]�k�g");
						  break;
					    }
						asset.remove(index);
						soiltype[landnum-1] = "magicdust";
						// ����O
						user.deductEnergy(5+rs);
						// ���@�[��
						hoe.use();
						//�g�[�ëת�l��
						soil[landnum-1].initialHumidity();
						//�g�[���i��
						soil[landnum-1].newSoilbroken(false);
					}
				
					//�̾����ҧP�_���
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
					 
					 //�Ӫ���_�S�Q�v�T�L
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
					System.out.println("�Х��ʶR�S�Y");
					
				}else if(b==true&&c==false){
					System.out.println("�Х��ʶR���ϥΪ��g�[");
					
				}else if(b==false&&c==false){  
					System.out.println("�Х��ʶR�S�Y");
					System.out.println("�Х��ʶR���ϥΪ��g�[");
					
				}
				
					
				}else{	
				  System.out.println("��J���~,�Э��s��J");
				}
				  break;
				
				// �ش�
				case "plant":
				//�g�a�s��
				landnum=Integer.parseInt(hint[2]);
				boolean n= 1<=landnum&&landnum<=9;
				boolean kn="magicdust".equals(soiltype[landnum-1]);
				boolean cd=hint[1].equals("watermelon")||hint[1].equals("mulberry");
				boolean sf=hint[1].equals("sungrass")||hint[1].equals("starflower");
				
				//�S���g�[
				if(soiltype[landnum-1]==null){
					System.out.println("�S���g�[,�L�k�ش�");
					break;
				}
				//�ش��ȿ����@��,�g�a�W�O�]�k�g
				if(cd==true&&n==true&&kn==true) {
					System.out.println("�кشӥ\�૬�Ӫ�");
					break;
				}
				//�شӥ\�૬�@��,�g�a�W���O�]�k�g
				if(sf==true&&n==true&&kn==false) {
					System.out.println("�кش��ȿ����Ӫ�");
					break;
				}
				
				//�ش��ȿ����@��,�g�a�W���O�]�k�g�κشӥ\�૬�@��,�g�a�W�O�]�k�g
				if(cd==true&&n==true&&kn==false||sf==true&&n==true&&kn==true) {
					
				
					//��O����
					if(user.getEnergy()<15) {
					  System.out.println("��O����,�L�k������O");
					  break;
					}
					boolean d= asset.contains(wseed);
					boolean x=asset.contains(mseed);
					boolean r=asset.contains(sungrass);
					boolean s=asset.contains(starflower);
					//�w����
					if(plant[landnum-1].getMatureday()<0) {
						System.out.println("�Ӫ��w����,�бĦ�");
						break;
					//�w�I��
					}else if(plant[landnum-1].getDecay()>5) {
						System.out.println("�Ӫ��I��,�L�k�ش�");
						break;
					}//�g�̦��Ӫ�
					else if(planttype[landnum-1]!=null){
						System.out.println("�Ӫ��ͪ���,�L�k�ش�");
						break;
					//�g�[�L�i��
					}else if(soil[landnum-1].getSoilbroken()==true){
						System.out.println("�g�[�L�i��,�L�k�ش�,�Ч󴫷s�g");
						break;
					}

				//�شӦ�ʦ���ʺؤl
				if("watermelon".equals(hint[1])&&d==true) {
					index = asset.indexOf(wseed);
					asset.remove(index);
					// ����O
					user.deductEnergy(15+rs);
					//���V�s��watermelon
					watermelon=new Watermelon(vs);
					//plant���Vwatermelon
					plant[landnum-1]=new Watermelon(vs);
				    watermelon=(Watermelon) plant[landnum-1];
					planttype[landnum-1]="watermelon";
					//����-�Ӫ��Ǯa
					if("botanist".equals(role)) {
					  //�ȿ����Ӫ����w�p���G�ƶq�W�[ 1 ��
					  plant[landnum-1].addFruit(plant[landnum-1]);
					}
					//�Ӫ��Ѽ�
					plant[landnum-1].initialAnotherday(1);
					//�I�ѤѼ�
					plant[landnum-1].initialDecay();
					//�H�g
					if(soiltype[landnum-1]=="clay"){
						plant[landnum-1].deductPlantday(plant[landnum-1]);
						plant[landnum-1].deductFruit(plant[landnum-1]);
					}//�[�g	
					else if(soiltype[landnum-1]=="loam") {
					  plant[landnum-1].addPlantday(plant[landnum-1]);
					  plant[landnum-1].addFruit(plant[landnum-1]);
					}
					
					break;
				//�شӮ�𦳮��ؤl
				}else if("mulberry".equals(hint[1])&&x==true) {
					index = asset.indexOf(mseed);
					asset.remove(index);
					// ����O
					user.deductEnergy(15+rs);
					//���V�s��mulberry
					mulberry=new Mulberry(vs);
					//plant���Vmulberry
					plant[landnum-1]=new Mulberry(vs);
					mulberry=(Mulberry) plant[landnum-1];
					planttype[landnum-1]="mulberry";
					//����-�Ӫ��Ǯa
					if(role.equals("botanist")) {
					  //�ȿ����Ӫ����w�p���G�ƶq�W�[ 1 ��
					  plant[landnum-1].addFruit(plant[landnum-1]);
					}
					//�Ӫ��Ѽ�
					plant[landnum-1].initialAnotherday(1);
					//�I�ѤѼ�
					plant[landnum-1].initialDecay();
					//�H�g
					if(soiltype[landnum-1]=="clay") {
						plant[landnum-1].deductPlantday(plant[landnum-1]);
						plant[landnum-1].deductFruit(plant[landnum-1]);
					}//�[�g	
					else if(soiltype[landnum-1]=="loam") {
					  plant[landnum-1].addPlantday(plant[landnum-1]);
					  plant[landnum-1].addFruit(plant[landnum-1]);
					}
					
					break;
				//�شӤӶ��󦳤Ӷ���ؤl
				}else if("sungrass".equals(hint[1])&&r==true) {	
					index = asset.indexOf(sungrass);
					asset.remove(index);
					// ����O
					user.deductEnergy(15+rs);
					//���V�s��sungrass
					sungrass=new Sungrass();
					//plant���Vsungrass
					plant[landnum-1]=new Sungrass();
					sungrass=(Sungrass) plant[landnum-1];
					planttype[landnum-1]="sungrass";
					//����-�Ӫ��Ǯa
					if(role.equals("botanist")) {
					  //�\�૬�Ӫ����s���ѼƼW�[ 1 ��
					  plant[landnum-1].addLiveday(plant[landnum-1]);
					}
					
					//�Ӫ��Ѽ�
					plant[landnum-1].initialAnotherday(1);
					//�I�ѤѼ�
					plant[landnum-1].initialDecay();
					//�K�[�شӤӶ��󪺤g�a�s��
					sungrassland.add(landnum);
					break;
				//�شӬP���ᦳ�P����ؤl
				}else if("starflower".equals(hint[1])&&s==true) {	
						index = asset.indexOf(starflower);
						asset.remove(index);
						// ����O
						user.deductEnergy(15+rs);
						//���V�s��starflower
						starflower=new Starflower();
						//plant���Vstarflower
						plant[landnum-1]=new Starflower();
						starflower=(Starflower) plant[landnum-1];
						planttype[landnum-1]="starflower";
						//����-�Ӫ��Ǯa
						if(role.equals("botanist")) {
						   //�\�૬�Ӫ����s���ѼƼW�[ 1 ��
						   plant[landnum-1].addLiveday(plant[landnum-1]);
						}
						//�Ӫ��Ѽ�
						plant[landnum-1].initialAnotherday(1);
						//�I�ѤѼ�
						plant[landnum-1].initialDecay();
						//�K�[�شӬP���᪺�g�a�s��
						starflowerland.add(landnum);
						break;
				
				}else {
					System.out.println("�Х��ʶR�Ӫ��ؤl");
					break;
				}
				 
				  
				
				}else {
					System.out.println("��J���~,�Э��s��J");
					break;
				}
				
				  
				// ���ΪG��
				case "reap":
				//�g�a�s��
				landnum=Integer.parseInt(hint[4]);
				boolean p=1<=landnum&&landnum<=9;
				
				//�g�̵L�Ӫ�
				if(planttype[landnum-1]==null) {
				  System.out.println("�S���Ӫ�,�L�k�Ħ�");
				  break;
				}
				
				//�g�̬��\�૬�Ӫ�
				if("sungrass".equals(planttype[landnum-1])||"starflower".equals(planttype[landnum-1])) {
				  System.out.println("�\�૬�Ӫ�,�L�k�Ħ�");
				  break;
				}
				
				
				  //���Ħ����Ӫ��P�g�a�W�Ӫ��ۦP
				  if(hint[1].equals("and")&&hint[2].equals("sell")&&hint[3].equals(planttype[landnum-1])&&p==true) {
					//��O����
					if(user.getEnergy()<5) {
					  System.out.println("��O����,�L�k������O");
					  break;
					}
					
					boolean f= asset.contains(sickle);
					
					//�w�I��
					if(plant[landnum-1].getDecay()>5) {
					  System.out.println("�Ӫ��I��,�L�k�Ħ�");
					  break;
					}//������
					else if(plant[landnum-1].getMatureday()>0){
						System.out.println("�Ӫ��|������,�L�k�Ħ�");
						break;
					}
					
					//���I�M
					if(f==true) {
						// ����O
						user.deductEnergy(5);
						//�[��ì����
                        user.addMoney(plant[landnum-1].getTotalprice());
                        //�Ӫ��Ѽ��k�s
                        plant[landnum-1].initialAnotherday(0);
                        //�g�̨S�Ӫ�
                        planttype[landnum-1]=null;
                        //�I�ѤѼ��k�s
                        plant[landnum-1].initialDecay();
					}else if(f==false){
						System.out.println("�Х��ʶR�I�M");
					}
				  }else{		
					  System.out.println("��J���~,�Э��s��J");
				  }
				  
					break;
				  
				// �ʶR
				case "buy":
					
					//�����
					if ("watering".equals(hint[1])&&"can".equals(hint[2])) {
						
					  //��������
					  if(user.getMoney()<50) {
						 System.out.println("��������,�L�k�ʶR");
						 break;
					  }
						//�u�㪱�a�@���u��֦��@��
						boolean j= asset.contains(wateringcan);
						if(j==false) {
						asset.add(wateringcan);
						user.buy(50+ts);
						}else {
							System.out.println("�w�֦�,�ʶR����");
						}
					//�S�Y
					} else if ("hoe".equals(hint[1])) {
						
					  //��������
					  if(user.getMoney()<420) {
						  System.out.println("��������,�L�k�ʶR");
						  break;
						}
						//�u�㪱�a�@���u��֦��@��
						boolean ku= asset.contains(hoe);
						if(ku==false) {
						asset.add(hoe);
						user.buy(420+ts);
						}else {
							System.out.println("�w�֦�,�ʶR����");
						}
					//�I�M
					} else if ("sickle".equals(hint[1])) {
						
						//��������
						if(user.getMoney()<210) {
							 System.out.println("��������,�L�k�ʶR");
							 break;
						  }
						//�u�㪱�a�@���u��֦��@��
						boolean i= asset.contains(sickle);
						if(i==false) {
						asset.add(sickle);
						user.buy(210+ts);
						}else {
							System.out.println("�w�֦�,�ʶR����");
						}
					//��ʺؤl
					} else if ("watermelon".equals(hint[1])) {
						//��������
						if(user.getMoney()<10) {
							 System.out.println("��������,�L�k�ʶR");
							 break;
						 }
						asset.add(wseed);
						user.buy(10);
					//���ؤl
					} else if ("mulberry".equals(hint[1])) {
						//��������
						if(user.getMoney()<5) {
							 System.out.println("��������,�L�k�ʶR");
							 break;
						}
						asset.add(mseed);
						user.buy(5);
					//�Ӷ���ؤl
					} else if ("sungrass".equals(hint[1])) {
						//��������
						if(user.getMoney()<15) {
							 System.out.println("��������,�L�k�ʶR");
							 break;
						}
						asset.add(sungrass);
						user.buy(15);
					//�P����ؤl
					} else if ("starflower".equals(hint[1])) {
						//��������
						if(user.getMoney()<20) {
							 System.out.println("��������,�L�k�ʶR");
							 break;
						}
						asset.add(starflower);
						user.buy(20);
					//��g
					} else if ("sand".equals(hint[1])) {
						//��������
						if(user.getMoney()<15) {
							 System.out.println("��������,�L�k�ʶR");
							 break;
						 }
						asset.add(sand);
						user.buy(15);
					//�H�g
					} else if ("clay".equals(hint[1])) {
						//��������
						if(user.getMoney()<20) {
							 System.out.println("��������,�L�k�ʶR");
							 break;
						 }
						asset.add(clay);
						user.buy(20);
				    //�[�g
					} else if ("loam".equals(hint[1])) {
						//��������
						if(user.getMoney()<20) {
							 System.out.println("��������,�L�k�ʶR");
							 break;
						 }
						asset.add(loam);
						user.buy(20);
					//�]�k�g
					} else if ("magicdust".equals(hint[1])) {
						//��������
						if(user.getMoney()<30) {
							 System.out.println("��������,�L�k�ʶR");
							 break;
						 }
						asset.add(magicdust);
						user.buy(30);
					
					}else {
					  System.out.println("��J���~,�Э��s��J");
					}

					break;
				// �ˬd�Цa���A
				case "check":
				//�g�a�s��
				landnum=Integer.parseInt(hint[1]);
				boolean o=1<=landnum&&landnum<=9;
				//�g�a�s������1~9
				  if(o==true) {
					//��O����
					if(user.getEnergy()<5) {
					  System.out.println("��O����,�L�k������O");
					  break;
					}
					//�w����
					if(plant[landnum-1].getMatureday()<=0) {
						System.out.println("�Цa�s��:"+landnum);
						System.out.println("�Ӫ��w����,�бĦ�");
						System.out.println("�Цa���ثe�ش�:" + planttype[landnum-1]);
						System.out.println("�g�[ :" + soiltype[landnum-1]);
						System.out.println("��� :"+soil[landnum-1].getHumidity());
						System.out.println("�w�ͪ��Ѽ�  :"+plant[landnum-1].getGrowday()+"��");
						// ����O
						user.deductEnergy(5);
					//�w�I��
					}else if(plant[landnum-1].getDecay()>5) {
						System.out.println("�Цa�s��:"+landnum);
						System.out.println("�Ӫ��I��,�Э��s��g���P�g");
						System.out.println("�Цa���ثe�ش�:" + planttype[landnum-1]);
						System.out.println("�g�[ :" + soiltype[landnum-1]);
						System.out.println("��� :"+soil[landnum-1].getHumidity());
						System.out.println("�w�ͪ��Ѽ�  :"+plant[landnum-1].getGrowday()+"��");
						// ����O
						user.deductEnergy(5);
					}
					//�g�̵L�Ӫ�
					else if(planttype[landnum-1]==null) {
						System.out.println("�Цa�s��:"+landnum);
						System.out.println("�ثe�L�شӴӪ�");
						System.out.println("�g�[:" + soiltype[landnum-1]);
						System.out.println("��� :"+soil[landnum-1].getHumidity());
						// ����O
						user.deductEnergy(5);
					}
					else {
					System.out.println("�Цa�s��:"+landnum);
					System.out.println("�Цa���ثe�ش�:" +planttype[landnum-1]);
					System.out.println("�g�[ :" + soiltype[landnum-1]);
					System.out.println("��� :"+soil[landnum-1].getHumidity());
					System.out.println("�w�ͪ��Ѽ�  :"+plant[landnum-1].getGrowday()+"��");
					System.out.println("�w�����X���G��q:" +plant[landnum-1].getFruit()+"��");
					//�ȿ����Ӫ�
					if("watermelon".equals(planttype[landnum-1])||"mulberry".equals(planttype[landnum-1])) {
						System.out.println("�w���A�L�X�ѷ|����:"+plant[landnum-1].getMatureday()+"��");
						if(plant[landnum-1].getMatureday()>0) {
							System.out.println("�|�����G");
						}else {
							System.out.println("�w���G");
						}
					//�\�૬�Ӫ�
					}else if("sungrass".equals(planttype[landnum-1])||"starflower".equals(planttype[landnum-1])){
						System.out.println("�Ѿl�s���Ѽ�:" +plant[landnum-1].getLiveday()+"��");
					}
					// ����O
					user.deductEnergy(5);
					
					
					}
				  }else {
					  System.out.println("��J���~,�Э��s��J");
				  }
					break;
					
				// ��ı���O
				case "sleep":
				//����-�O�h��ı�ɷ|��_�Ҧ�����O
				if(role.equals("hercules")) {
					user.addEnergy(100);	
				}else {
					user.addEnergy(70);
				}
					
				back = false;
				break;
					
					
			        
			       
			    default:
				   System.out.println("��J���~,�Э��s��J");
				   break;
				  
				   
						
						
						
					}//switch
				
				//��J���~
				}catch(Exception e){     
					System.out.println("��J���~,�Э��s��J");
				}			 
				
				//���a��O�k�s
		        if(user.getEnergy()==0) {
		        	//�[��O
					user.addEnergy(70);
					back = false;
		        }
		        
		       //�@�[���k�s�ɡA�Ӥu��۰ʾP��
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
				
				
		        System.out.println("��O:" + user.getEnergy() + '\t' + "����:" + user.getMoney());
		         
			}while(back);//����
				
			
			
			
			//�Ӷ���v�T�d��
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
			
			//�P����v�T�d��
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
			
			//�������
		for(int n=0;n<9;n++){	
			//�g�̦��Ӫ�
			if(planttype[n]!=null) {
				
				boolean w=soil[n].getHumidity()>25||soil[n].getHumidity()<15;
				boolean s=soil[n].getHumidity()>35||soil[n].getHumidity()<25;
				boolean yh=soil[n].getHumidity()>20||soil[n].getHumidity()<10;
				boolean ph=soil[n].getHumidity()>40||soil[n].getHumidity()<30;
				
				//���
				if(planttype[n].equals("watermelon")) {
					
					//�L�I��,�L����,��פ���
					if(plant[n].getNodecay()==true&&plant[n].getNomature()==true&&w==true) {
						//�I�ѤѼƥ[�@
						plant[n].addDecay(plant[n]);
						//���0
						if(plant[n].getFruit()==0) {
						  plant[n].setDecay();
						}
						//�w�I��
						if(plant[n].getDecay()==6) {
							  System.out.println("�Ӫ��I��"); 
						//��q
						}else if(plant[n].getDecay()>3) {
							plant[n].deductFruit(plant[n]);
						}
					//�I�ѤѼ��k�s
					}else {
						plant[n].initialDecay();
					}
					
				//���
				}else if(planttype[n].equals("mulberry")){
					
					//�L�I��,�L����,��פ���
					if(plant[n].getNodecay()==true&&plant[n].getNomature()==true&&s==true) {
						//�I�ѤѼƥ[�@
						plant[n].addDecay(plant[n]);
						//���0
						if(plant[n].getFruit()==0) {
						  plant[n].setDecay();
						}
						//�w�I��
						if(plant[n].getDecay()==6) {
							  System.out.println("�Ӫ��I��");	  
						//��q
						}else if(plant[n].getDecay()>3) {
							plant[n].deductFruit(plant[n]);
						}
					//�I�ѤѼ��k�s
					}else {
						plant[n].initialDecay();
					}
					 
				//�Ӷ���	
				}else if(planttype[n].equals("sungrass")){
					
					//�L�I��,��פ���
					if(plant[n].getNodecay()==true&&yh==true) {
						//�s���Ѽƴ�@
						plant[n].deductLiveday(plant[n]);
			        }
               //�P����
			   }else if(planttype[n].equals("starflower")){
					
					//�L�I��,��פ���
					if(plant[n].getNodecay()==true&&ph==true) {
						//�s���Ѽƴ�@
						plant[n].deductLiveday(plant[n]);
			        }
              
                
			   }
			
		   }
		}
			
			
			//���a�}��-�����ܤƤ��ɮפw�L�U�@�Ѥ����e
			if(length<day+1) {
				reback=false;
				System.out.println("�����ܤƤ��ɮפw�L�U�@�Ѥ����e,�C������");	
			}
          
		  //�g�̵L�g�[
		  boolean k=soiltype[0]==null&&soiltype[1]==null&&soiltype[2]==null&&soiltype[3]==null&&soiltype[4]==null&&soiltype[5]==null&&soiltype[6]==null&&soiltype[7]==null&&soiltype[8]==null;
		  //�g�̵L�i��
		  boolean jk=soil[0].getSoilbroken()==true&&soil[1].getSoilbroken()==true&&soil[2].getSoilbroken()==true&&soil[3].getSoilbroken()==true&&soil[4].getSoilbroken()==true&&soil[5].getSoilbroken()==true&&soil[6].getSoilbroken()==true&&soil[7].getSoilbroken()==true&&soil[8].getSoilbroken()==true;
		  //�g�̵L�Ӫ�
		  boolean ik=planttype[0]==null&&planttype[1]==null&&planttype[2]==null&&planttype[3]==null&&planttype[4]==null&&planttype[5]==null&&planttype[6]==null&&planttype[7]==null&&planttype[8]==null;
		  //�g�̵L�g�[�Τg�̵L�i��
		  boolean op=k||jk;
		  //�g�̴Ӫ��ҰI��
		  boolean die=plant[0].getNodecay()==false&&plant[1].getNodecay()==false&&plant[2].getNodecay()==false&&plant[3].getNodecay()==false&&plant[4].getNodecay()==false&&plant[5].getNodecay()==false&&plant[6].getNodecay()==false&&plant[7].getNodecay()==false&&plant[8].getNodecay()==false;
		  
		  
		  //���a�}��-�S�������B�g�̵L�Ӫ�
          if(user.getMoney()==0&&ik==true) {
        	
        	//���W�L�ؤl
        	if(asset.contains(wseed)==false&&asset.contains(mseed)==false) {
            	reback=false;
            	System.out.println("���a�}��,�C������");
            //���W�L�g�[�B�g�̵L�g�[�Τg�̵L�i��
        	}else if(asset.contains(sand)==false&&asset.contains(clay)==false&&asset.contains(loam)==false&&op==true) {
        	   reback=false;
        	   System.out.println("���a�}��,�C������");
        	//���W�L�S�Y�B�g�̵L�g�[�Τg�̵L�i��
        	}else if(asset.contains(hoe)==false&&op==true) {
         	    reback=false;
         	    System.out.println("���a�}��,�C������");
         	//���W�L�I�M
        	}else if(asset.contains(sickle)==false) {
         	    reback=false;
         	    System.out.println("���a�}��,�C������");
            }
         }
          
          //���a�}��-�S�������B�g�̦��Ӫ�
          if(user.getMoney()==0&&ik==false) {
        	  //�w�I��
        	  if(die==true) {
        		  reback=false;
           	      System.out.println("���a�}��,�C������");
        	  //���W�L�I�M
        	  }else if(asset.contains(sickle)==false) {
           	      reback=false;
           	      System.out.println("���a�}��,�C������");
        	  }
          }
        	
				
				
		}while(reback);
		
		System.out.println("���a�Ѿl����:"+user.getMoney());
		System.out.println("�s���Ѽ�:"+day);
		
	}
}
