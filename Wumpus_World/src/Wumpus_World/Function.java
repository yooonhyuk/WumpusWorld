package Wumpus_World;

import java.util.Random;

public class Function {
	static int temp = 0;
	
	static Random rd= new Random();
	private static int turn_rd;
	
	
	
	static void coward(char array[][]) {
		
		
		if(Sensor.sensor[0] == "W") {
			System.out.println("--------------Cowrd-------------------");
			while(true) {
				Act.shoot(array);
				if(Sensor.sensor[0] ==" " || Act.arrow == 0) {
					break;
				}
				Act.turn_left(array);
			}
		}
		
	}
	
	
	
	static void go_to_previous(char array[][] , char map[][]) {
		AI_1.depth1 = AI_1.depth.peek(); AI_1.depth.pop(); AI_1.depth2 = AI_1.depth.peek();
		AI_1.width1 = AI_1.width.peek(); AI_1.width.pop(); AI_1.width2 = AI_1.width.peek();
		
		
		AI_1.result1 = AI_1.depth2 - AI_1.depth1;
		AI_1.result2 = AI_1.width2 - AI_1.width1;
		
		 
		 switch(AI_1.result1) {
		 case 1: 
			 
			 if(Act.angle == 0) {
				 Act.turn_right(array);
				 Act.turn_right(array);
				 Act.Go_Foward(array); Function.Display(array);
				 
				 
			 }
			 else if(Act.angle == 90) {
				 Act.turn_right(array);
				 Act.Go_Foward(array); Function.Display(array);
				 
			 }
			 else if(Act.angle ==180) {
				 
				
				 Act.Go_Foward(array); Function.Display(array);
				 
			 }
			 else if(Act.angle ==270) {
				 Act.turn_left(array);
				 Act.Go_Foward(array); Function.Display(array);
				 
			 }						 
			 break;
		 
		 
		 
		 case -1:
			 
			 if(Act.angle == 0) {
				 Act.Go_Foward(array); Function.Display(array);
				 
			 }
			 else if(Act.angle == 90) {
				 Act.turn_left(array);
				 Act.Go_Foward(array); Function.Display(array);
				 
			 }
			 else if(Act.angle ==180) {
				 Act.turn_left(array);
				 Act.turn_left(array);
				 Act.Go_Foward(array); Function.Display(array);
				 
			 }
			 else if(Act.angle ==270) {
				 Act.turn_right(array);
				 Act.Go_Foward(array); Function.Display(array);
				 
			 }
			 map[Act.depth][Act.width] ='O';
			 break;
		 }//switch1
		 
		
		 
		 
		 switch(AI_1.result2) {
		 case 1:
			 
			 if(Act.angle == 0) {
				 Act.turn_right(array);
				 Act.Go_Foward(array); Function.Display(array);
				 
			 }
			 else if(Act.angle == 90) {
				
				 Act.Go_Foward(array); Function.Display(array);
				 
			 }
			 else if(Act.angle ==180) {
				 
				 Act.turn_left(array);
				 Act.Go_Foward(array); Function.Display(array);
				 
			 }
			 else if(Act.angle ==270) {
				 Act.turn_right(array);
				 Act.turn_right(array);
				 Act.Go_Foward(array); Function.Display(array);
				 
			 }
			 		 				 								 									 
			 break;
		 case -1:
			 
			 if(Act.angle == 0) {
				 Act.turn_left(array);							 
				 Act.Go_Foward(array); Function.Display(array);
				 
			 }
			 else if(Act.angle == 90) {
				 Act.turn_left(array);
				 Act.turn_left(array);
				 Act.Go_Foward(array); Function.Display(array);
				 
			 }
			 else if(Act.angle ==180) {
				 Act.turn_right(array);							
				 Act.Go_Foward(array); Function.Display(array);
				 
			 }
			 else if(Act.angle ==270) {						
				 Act.Go_Foward(array); Function.Display(array);
				 
			 }
			
			 break;
		 }//switch2
	}
	
	
	
	
	
	
	static void clear(char array[][] , char agent_map[][]) {
		if(array[Act.depth][Act.width] == 'C') {
			 if(Act.angle ==0) {
			 array[Act.depth][Act.width] = Function.angle(Act.angle);
			 Act.Grab(array);
			
			 }
		
			 else if(Act.angle == 90) {
				 array[Act.depth][Act.width] = Function.angle(Act.angle);
				 Act.Grab(array);
				 
			 }
			 else if(Act.angle == 180) {
				 array[Act.depth][Act.width] = Function.angle(Act.angle);
				 Act.Grab(array);
				 
			 }
			 else if(Act.angle == 270) {
				 array[Act.depth][Act.width] = Function.angle(Act.angle);
				 Act.Grab(array);
				
			 }
			  AI_1.home = 1;
			 }
	}
	
	
	static void check(char array[][] , char agent_map[][] , char map[][]) {
		
		if(agent_map[Act.depth+1][Act.width] == 'W' || agent_map[Act.depth-1][Act.width] == 
		 		'W' || agent_map[Act.depth][Act.width+1] == 'W' || agent_map[Act.depth][Act.width-1] == 'W' && Act.arrow >= 0) {
			
		loop:
		for(int i = 0; i< 6 ; i++) {
			for (int j = 0 ; j < 6; j++) {
				if(agent_map[Act.depth][j] == 'W') {
					temp = j;
					if(Act.width < j) {
						if(Act.angle == 0) {
							Act.turn_right(array);
							Act.shoot(array);
							break loop;
						}
						else if(Act.angle == 90) {
							Act.shoot(array);
							break loop;
						}
						else if(Act.angle == 180) {
							Act.turn_left(array);
							Act.shoot(array);
							break loop;
						}
					}
					else if(Act.width >j) {
						if(Act.angle == 0) {
							Act.turn_left(array);
							Act.shoot(array);
							break loop;
						}
						else if(Act.angle == 180) {
							Act.turn_right(array);
							Act.shoot(array);
							break loop;
						}
						else if(Act.angle == 270) {
							Act.shoot(array);
							break loop;
						}
					}
					
				}
			}
		}
		agent_map[Act.depth][temp] = 'V';
		loop1:
			for(int i = 0; i< 6 ; i++) {
				for (int j = 0 ; j < 6; j++) {
					if(agent_map[i][Act.width] == 'W') {
						temp = i;
						if(Act.depth < i) {
							if(Act.angle == 180) {
							
								Act.shoot(array);
								break loop1;
							}
							else if(Act.angle == 90) {
								Act.turn_right(array);
								Act.shoot(array);
								break loop1;
							}
							else if(Act.angle == 270) {
								Act.turn_left(array);
								Act.shoot(array);
								break loop1;
							}
						}
						else if(Act.depth > i) {
							if(Act.angle == 0) {
								Act.shoot(array);
								break loop1;
							}														
							else if(Act.angle == 90) {
								Act.turn_left(array);
								Act.shoot(array);
								break loop1;
							}
							else if(Act.angle == 270) {
								Act.turn_right(array);
								Act.shoot(array);
								break loop1;
							}
						
					}
				}
			}
			}
		agent_map[temp][Act.width] = 'V';
		
		} 
		else if(Act.arrow < 0) move(array ,  agent_map , map);
	
	} //method check
	

	static void check_P(char array[][] , char agent_map[][] , char map[][]) {
		int cnt = 0;
		
		
		if(agent_map[Act.depth+1][Act.width] == 'P') {
			map[Act.depth+1][Act.width] = 'O';
			cnt += 1;
		}
		if(agent_map[Act.depth-1][Act.width] == 'P') {
			map[Act.depth-1][Act.width] = 'O';
			cnt += 1;
		}
		if(agent_map[Act.depth][Act.width-1] == 'P') {
			map[Act.depth][Act.width-1] = 'O';
			cnt += 1;
		}
		if(agent_map[Act.depth][Act.width+1] == 'P') {
			map[Act.depth][Act.width+1] = 'O';
			cnt += 1;
		}
		if(agent_map[Act.depth+1][Act.width] == '0') {
			map[Act.depth+1][Act.width] = 'O';
			 
		}
		 if(agent_map[Act.depth-1][Act.width] == '0') {
			map[Act.depth-1][Act.width] = 'O';
			
		}
		 if(agent_map[Act.depth][Act.width-1] == '0') {
			map[Act.depth][Act.width-1] = 'O';
			 
		}
		 if(agent_map[Act.depth][Act.width+1] == '0') {
			map[Act.depth][Act.width+1] = 'O';
			 
		}
		if(cnt > 0) {
		move(array , agent_map , map);
		}
		}
	
	
	static void check_W(char array[][] , char agent_map[][] , char map[][]) {
		
		int cnt = 0;
		
		if(Act.arrow == 0) {
		
		if(agent_map[Act.depth+1][Act.width] == 'W') {
			map[Act.depth+1][Act.width] = 'O';
			cnt += 1;
		}
		if(agent_map[Act.depth-1][Act.width] == 'W') {
			map[Act.depth-1][Act.width] = 'O';
			cnt += 1;
		}
		if(agent_map[Act.depth][Act.width-1] == 'W') {
			map[Act.depth][Act.width-1] = 'O';
			cnt += 1;
		}
		if(agent_map[Act.depth][Act.width+1] == 'W') {
			map[Act.depth][Act.width+1] = 'O';
			cnt += 1;
		}		
		if(cnt > 0) {
		move(array , agent_map , map);
		}
		
		}
		}
	
	
	
	
	
	
	
	
	
	
	static void dead(char array[][] , char agent_map[][] , char map[][]) {
		array[Act.depth][Act.width] = 'X';
		if(AI_1.temp1 == 'W') {			
		agent_map[Act.depth][Act.width] = 'W';
		}
		else agent_map[Act.depth][Act.width] = 'P';
		Function.print();
		Function.Display(array);
		System.out.println("You die 처음 격자에서 부활합니다.");
		 AI_1.temp_revive += 1;
		 AI_1.revive += 1;
		System.out.println("현재 살아난 횟수: " +  AI_1.revive);
		if(AI_1.temp1 == 'W') {
		array[Act.depth][Act.width] = 'W';
		}
		else array[Act.depth][Act.width] = 'P';
		Act.depth = 4;
		Act.width = 1;
		Act.angle = 90;
		Function.print();
		//Function.Display(array);
		array[Act.depth][Act.width] = Function.angle(Act.angle);					
		System.out.println();
		//Function.Display_1(agent_map);																	 					 									
		AI_1.depth.clear();
		AI_1.width.clear();
		AI_1.depth.push(4);
		AI_1.width.push(1);
		for(int i = 0 ; i < 6; i++) {
			for(int j = 0 ; j < 6 ; j++) {
				map[i][j] = ' ';
			}
		}
		Sensor.glitter =0;
	}
	
	
	
	
	
	static void back(char array[][]) {
		if(Act.angle == 0) {
			System.out.println("벽입니다. \n이전 격자로 돌아갑니다.");
			array[Act.depth][Act.width] = '0';
			Act.depth += 1;
			array[Act.depth][Act.width] = Function.angle(Act.angle);
			Display(array);
		}
		else if (Act.angle == 90) {
			System.out.println("벽입니다. \n이전 격자로 돌아갑니다.");
			array[Act.depth][Act.width] = '0';
			Act.width -= 1;
			array[Act.depth][Act.width] = Function.angle(Act.angle);
			Display(array);
		}
		else if (Act.angle == 180) {
			System.out.println("벽입니다. \n이전 격자로 돌아갑니다.");
			array[Act.depth][Act.width] = '0';
			Act.depth -= 1;
			array[Act.depth][Act.width] = Function.angle(Act.angle);			
			Display(array);
		}
		else if (Act.angle == 270 || Act.angle == 360) {
			System.out.println("벽입니다. \n이전 격자로 돌아갑니다.");
			array[Act.depth][Act.width] = '0';
			Act.width += 1;
			array[Act.depth][Act.width] = Function.angle(Act.angle);
			Display(array);
		}
	}
	
	
	static void Display(char array[][]){
		System.out.println("Main Grid");
		for(int i = 0 ; i < 6 ; i++) {					
						for(int j = 0 ; j < 6 ; j++) {
							System.out.print(array[i][j] + " " );			
						}
						System.out.println();
						
					}} 
	static void Display_1(char array[][]){
		System.out.println("Agent Grid");
		for(int i = 0 ; i < 6 ; i++) {					
						for(int j = 0 ; j < 6 ; j++) {
							System.out.print(array[i][j] + " " );			
						}
						System.out.println();
						
					}} 
	static void Display_2(char array[][]){
		System.out.println("Maping Grid");
		for(int i = 0 ; i < 6 ; i++) {					
						for(int j = 0 ; j < 6 ; j++) {
							System.out.print(array[i][j] + " " );			
						}
						System.out.println();
						
					}} 

	

	


	static char angle(int angle) {
		
		if(Act.angle == 0) {
			return '↑';
		}
		else if(Act.angle == 90) {
			return '→';
		}
		else if(Act.angle == 180) {
			return '↓';
		}
		else if(Act.angle == 270) {
			return '←';
		}
		
		return 0;
		
		
	}
	
	static void move(char array[][] , char agent_map[][] , char map[][]) {
		int cnt = 0;
		int end = 0;
		if(map[Act.depth+1][Act.width] == 'O' && map[Act.depth-1][Act.width] == 
		 		'O' && map[Act.depth][Act.width+1] == 'O' && map[Act.depth][Act.width-1] == 'O') {
		 	if(cnt != 1) {
		 		go_to_previous(array , map);
		 		cnt++;
		 	}
		 	else {Act.turn_right(array); cnt = 0;}
					 
		 	}//if문
		else {
		
			
			
			while(end == 0) {
			turn_rd = rd.nextInt(4);
			switch(turn_rd) {
			case 0:
				if(agent_map[Act.depth -1][Act.width] == 'P' || agent_map[Act.depth-1][Act.width] == '0') {
					break;
				}
				else if(map[Act.depth -1][Act.width] == 'O') {
					break;
				}
				else if(Act.angle == 0  ) {
				
						  
						 end =1;
				 }
				 else if(Act.angle == 90  ) {
					
					 Act.turn_left(array);
					  
					 end =1;
					 
				 }
				 else if(Act.angle ==180 ) {
					
					 Act.turn_left(array);
					 Act.turn_left(array);
					  
					 end =1;
					 	
				 }
				 else if(Act.angle ==270 ) {
					 
					 
						 Act.turn_right(array);
						 
						 end =1;			 					 	
				 }
				 break;
			case 1:
				if(agent_map[Act.depth ][Act.width + 1] == 'P' || agent_map[Act.depth][Act.width + 1] == '0') {
					break;
				}
				else if(map[Act.depth ][Act.width + 1] == 'O') {
					break;
				}	
				else if(Act.angle == 0 ) {
						Act.turn_right(array);
						  ;end =1;

				 }
				 else if(Act.angle == 90) {
					
					
					  end =1;
						 
					 
				 }
				 else if(Act.angle ==180 ) {
					
					  Act.turn_right(array);
					  end =1;
						
					 	
				 }
				 else if(Act.angle ==270 ) {
					 
					 Act.turn_left(array);
					 Act.turn_left(array);
							end =1;
					 						 					 	
				 }
				 break;	
			case 2:
				if(agent_map[Act.depth + 1][Act.width] == 'P' || agent_map[Act.depth + 1][Act.width] == '0') {
					break;
				}
				else if(map[Act.depth +1][Act.width] == 'O') {
					break;
				}
				else if(Act.angle == 0 ) {
						Act.turn_left(array);
						Act.turn_left(array);
						 	end =1;

				 }
				 else if(Act.angle == 90  ) {
					
					 Act.turn_right(array);
					  	end =1;
						 
					 
				 }
				 else if(Act.angle ==180 ) {
					
		
					 	end =1;
						
					 	
				 }
				 else if(Act.angle ==270 ) {
					 
					Act.turn_right(array);
						
						  	end =1;
					 						 					 	
				 }
				 break;	
			case 3:
				if(agent_map[Act.depth ][Act.width - 1] == 'P' || agent_map[Act.depth][Act.width - 1] == '0') {
					break;
				}
				else if(map[Act.depth ][Act.width -1] == 'O') {

					break;
				}
				else if(Act.angle == 0 ) {
						Act.turn_left(array);						
						  	end =1;

				 }
				 else if(Act.angle == 90 ) {
					
					 Act.turn_right(array);
					 Act.turn_right(array);
					  	end =1;
						 
					 
				 }
				 else if(Act.angle ==180  ) {
					
					 Act.turn_right(array);
						end =1;
						
					 	
				 }
				 else if(Act.angle ==270 ) {								
						 	end =1;
					 						 					 	
				 }
				 break;
				 
		} //switch
			}//while
		map[Act.depth][Act.width] = 'O';
		
		}//else 문
		
}//method


static void print() {
	System.out.println();
	System.out.println();
	System.out.println();
}
}