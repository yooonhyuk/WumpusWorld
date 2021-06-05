
package Wumpus_World;

import java.util.Random;
import java.util.Scanner;

public class AI_1 {

	static Sensor S = new Sensor();
	static Scanner sc = new Scanner(System.in);		
	static int ad =0 , revive =0 , turn_rd = 0 , act_point , temp_revive ,  depth1, depth2 , width1 , width2 , result1, result2 , home = 0 , character;
	static char [][]map;
	static char [][]agent_map;
	static char temp1;
	static int count = 0;
	static int num1 = 0;
	static Random rd= new Random();
	static ArrayStack depth = new ArrayStack(100);
	static ArrayStack width = new ArrayStack(100);
	
	
	
	
	
	 static void start(char array[][])   {
		 
		 character = rd.nextInt(2);
		 if(character ==0) {
			 System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<Normal mode>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		 }
		 else System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<Coward mode>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		 depth.push(4);
		 width.push(1);
		 map = new char [6][6]; 
		 map[4][1] = 'O';
		 agent_map = new char [6][6];
		 for(int i = 0 ; i < 6 ; i ++) {
			 for(int j = 0; j < 6 ; j ++) {
				 agent_map[i][j] = '?';
			 }
		 }
		 agent_map[4][1] = 'V';
		 	Function.print();
			Function.Display(array);
			Function.print();
			Function.Display_1(agent_map);
		 
		 
		 
		 while(Act.end != 1) {
			 
			turn_rd = rd.nextInt(4); 
	
			
			
if(home == 1) {
	
	while(depth.top != 0) {
				
		Function.go_to_previous(array, map);
		
		 	Sensor.Breeze(array);
			Sensor.Stench(array);
			
		 
		
		 if(Act.depth == 4 && Act.width == 1 ) {
			 Act.Climb(array);
			 break;
		 }
		 Function.print();


	 	}//while
				
				
				
			
				
			}//if
			
			
			
			
			
else {	

	
		
		

	Function.print();
	map[4][1] = 'O';
		
		
			
			
			
			
			
			
	
	
			Function.check(array , agent_map , map);
			Function.check_P(array, agent_map, map);
			Function.check_W(array, agent_map, map);
			if(character == 1) {
			Function.coward(array);}
			
			Sensor.sensor[0] = " ";
			Sensor.sensor[1] = " "; 
			Act.Go_Foward(array);
			if(Sensor.glitter != 0 && AI_1.temp1 != 'P' && AI_1.temp1 != 'W') {
				if(AI_1.temp1 == '0') {
					agent_map[Act.depth][Act.width] = '0';
					map[Act.depth][Act.width] = 'O';
					Function.back(array);
					Sensor.Bump(array);
					Function.move(array , agent_map , map);					
					Function.print();		
					depth.pop();
					width.pop();
					AI_1.temp1 = ' ';
				}
				
				else {System.out.println("글리터");
				Function.go_to_previous(array, map);	
				Function.move(array , agent_map , map);
				}
				}
			map[Act.depth][Act.width] = 'O';
			depth.push(Act.depth);
			width.push(Act.width);
			agent_map[Act.depth][Act.width] = 'V';
			
			
			if(AI_1.temp1 == '0') {
				int cnt = 0;
				depth.pop();
				width.pop();
				agent_map[Act.depth][Act.width] = '0';
				map[Act.depth][Act.width] = 'O';
				Function.back(array);
				Sensor.Bump(array);
				if(cnt == 0) {
					Function.move(array , agent_map , map);
				cnt += 1;
				}
				else {Act.turn_right(array); cnt -= 1;} 
				
				Function.print();
				
		
			}
			
		
		if(AI_1.temp1 == 'W') {
			Function.dead(array , agent_map , map);
		}
		else if(AI_1.temp1 == 'P') {
			Function.dead(array, agent_map , map);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		Function.clear(array, agent_map);
			
			
}
			
			
		

			
		
			
			
		Function.print();
		Function.Display(array);
		Function.print();
		Function.Display_1(agent_map);	
		Function.print();
		Sensor.Stench(array);	
		Sensor.Breeze(array);
		Sensor.Glitter(array);				
		 count += 1;	

		 
		 
		 Function.print();
		
		 
		 if(count > 70) {
			System.out.printf("Game Fail");
			break;	
			
		}

			

		 }// AI_start while
		 
		 

	 }  //method 
	
								
		
	
	
	
}//class 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

