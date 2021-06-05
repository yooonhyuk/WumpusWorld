package Wumpus_World;

public class Act {
	
	 static int depth = 4 , width = 1 , angle = 90 , clear =0 ,	end = 0 , arrow =3;
	 static int kill = 0;
	 
	 static void Grab(char array[][]) {
		System.out.println("-----Grab-----");
		 clear += 1;

		 
		 
		 }
	 static void Climb(char array[][]) {
		 
		
			 if(depth == 4 && width ==1 && clear == 1 )
			 System.out.println("-----Climb-----");
			 System.out.println("Game clear");
			end =1;
			
		 }
	 

	 
	 
	 
	 
	 
	 static void Go_Foward(char array[][]) {
		
		 if(angle == 90) {
			 
			 array[depth][width] = ' ';
			 width += 1;
			 AI_1.temp1 = array[depth][width];
			if(array[depth][width] == 'G') {
				array[depth][width] = 'C';
				Sensor.glitter = 0;
				Function.Display(array);
			} 
			else array[depth][width] = '→';
			 }
		 else if (angle == 180) {
			 array[depth][width] = ' ';
			 depth += 1; 
			 AI_1.temp1 = array[depth][width];
			 if(array[depth][width] == 'G') {
					array[depth][width] = 'C';
					Sensor.glitter = 0;
					Function.Display(array);
				}
			 else array[depth][width] = '↓';
		 }
		 else if (angle == 270) {
			 array[depth][width] = ' ';
			 width -= 1;
			 AI_1.temp1 = array[depth][width];
			 if(array[depth][width] == 'G') {
					array[depth][width] = 'C';
					Sensor.glitter = 0;
					Function.Display(array);
				}
			 else array[depth][width] = '←';
		 }
		 else if (angle == 0 ) {
			 array[depth][width] = ' ';
			 depth -= 1;
			 AI_1.temp1 = array[depth][width];
			 if(array[depth][width] == 'G') {
					array[depth][width] = 'C';
					Sensor.glitter = 0;
					Function.Display(array);
				}
			 else array[depth][width] = '↑';
			
		 }
		 System.out.println("Go Foward");
		 //AI_1.depth.push(Act.depth);
		// AI_1.width.push(Act.width);
		 
	 }
	 
	 static void turn_right(char array[][]) {
		 angle += 90;
		 System.out.println("Turn right! Angle is " + angle);
		 if(angle == 180) {
			 array[depth][width] = '↓';
		 }
		 else if(angle ==270) {
			 array[depth][width] = '←';
		 }
		 else if(angle == 360 || angle == 0) {
			 array[depth][width] = '↑';
			 angle = 0;
		 }
		 else if(angle == 90) {
			 array[depth][width] = '→';
		 }
		 
	 }
	 static void turn_left(char array[][]) {
		 if(angle > 0) {
		 angle -= 90;
		 }
		 else {
			 angle += 270;	
		 }
		 System.out.println("Turn left! Angle is " + angle);
		 if(angle == 180) {
			 array[depth][width] = '↓';
		 }
		 else if(angle ==270) {
			 array[depth][width] = '←';
		 }
		 else if(angle == 0) {
			 array[depth][width] = '↑';
			 angle = 0;
		 }
		 else if(angle == 90) {
			 array[depth][width] = '→';
		 }
		 
	 }
		
	 
	static void shoot(char array[][]){
		
		if(arrow > 0) {
		int temp3 =0, temp4 = 0;
		if(array[depth][width] == '→') {
			
			
				for(int j = 1; j<5 ; j++) {
					if(temp4 ==-1) {
						break;
					} 
					if(array[depth][j] == 'W') {
						temp3 = j;
						if(temp3 > width) {
							array[depth][temp3] ='D';
							System.out.println("Shoot!");
							Sensor.Scream();
							temp4 = -1;
						}
						
					}
					
				}
			}
			
		
		
		
		else if(array[depth][width] == '←') {
			
			for(int i =1 ; i <5  ; i++) {
					if(temp4 ==-1) {
						break;
					} 
					if(array[depth][i] == 'W') {
						temp3 = i;
						if(temp3 < width) {
							array[depth][temp3] ='D';
							System.out.println("Shoot!");
							Sensor.Scream();
							temp4 = -1;
						}
						
					}
					
				}
			
			
		}
		else if(array[depth][width] == '↑') {
			
			for(int i = 5 ; i > 0  ; i--) {
					if(temp4 ==-1) {
						break;
					}
					if(array[i][width] == 'W') {
						temp3 = i;
						if(temp3 < depth) {
							array[temp3][width] ='D';
							System.out.println("Shoot!");
							Sensor.Scream();
							temp4 = -1;
				}
				
			}
			
		}
	}
	


		else if(array[depth][width] == '↓') {
			
			for(int i =5 ; i > 0  ; i--) {
				
					if(temp4 ==-1) {
						break;
			} 
					if(array[i][width] == 'W') {
						temp3 = i;
						if(temp3 > depth) {
							array[temp3][width] ='D';
							System.out.println("Shoot!");
							Sensor.Scream();
							temp4 = -1;
				}	
				
			}
			
		}
	}
		Sensor.Stench(array);
		if(Sensor.sensor[0] == " " ) {
			kill += 1;	
		}
	
		Act.arrow -= 1;}
		else {System.out.println("Not enough arrow");}
		System.out.println("Empty arrow: " + Act.arrow);

		System.out.println("Wumpus kill: " + kill);
}


	}
	 
	 
	 
	

