package Wumpus_World;

import java.util.Random;





public class World  {
	static int NUM1 , NUM2 , num3 , num4 , num5;
			
	 
		
	
		
		


	public static void main(String[]args) throws InterruptedException{
		 Random random = new Random();
		 while(true) {
				num3 = random.nextInt(3) + 1;
				num4 = random.nextInt(3) + 1;
				if(num3 == 4 && num4 ==1) {
					continue;
				}
				else if (num3 == 3 && num4 == 1) {
					continue;
				}
				else if (num3 == 4 && num4 ==2 )
				{
					continue;
				}
				else break;
				}
				
		 
		 
		 
		 
	
		 char[][] array = new char[6][6];
			for(int i = 0 ; i < 6 ; i++) {
				
				for(int j = 0 ; j < 6 ; j++) {
					NUM1 = random.nextInt(99);
					NUM2 = random.nextInt(99);
					if(i == 0 || j == 5 || i == 5 || j ==0) {
						array[i][j] = '0';
					}
					else if(NUM2 <= 15) {array[i][j] = 'W';}
					else if(NUM1 <= 15) { array[i][j] = 'P';} 
					else {array[i][j] = ' ';}
					if(i == 4 && j ==1) {array[i][j] = ' ';}
					}
					
					
				}
			
			
			array[4][1] ='→';
			array[4][2] =' ';
			array[3][1] =' ';

			array[num3][num4] = 'G';
			
			num5 = random.nextInt(1);
		
			AI_1.start(array);
			/*if(num5 == 1) {
					AI_1.start(array);
}
			else AI_2.start(array);
	*/
	
	
	
	
	}
	
	
	
	
	
	
	
	}

