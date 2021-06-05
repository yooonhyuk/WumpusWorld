package Wumpus_World;

	


	

	public class Sensor extends Act {
		public  static int stench =0;
		public static int glitter = 0;
		static String[] sensor = new String[3];
		
		
	 static void Stench(char array[][]) {
		 	if(array[Act.depth+1][Act.width] == 'W' || array[Act.depth-1][Act.width] == 'W' || array[Act.depth][Act.width+1] == 'W' || array[Act.depth][Act.width-1] == 'W'  )
			
		 	{System.out.println("-----Stench-----");
		 	stench = 1;
		 	sensor[0] = "W";
		 	}
		 	else sensor[0] = " ";

		 
	 }
	 static void Breeze(char array[][]) {
		 if(array[Act.depth+1][Act.width] == 'P' || array[Act.depth-1][Act.width] == 'P' || array[Act.depth][Act.width+1] == 'P' || array[Act.depth][Act.width-1] == 'P'  )
		 {System.out.println("-----Breeze-----");}
		 }
	 static void Glitter(char array[][]) {
		 if(array[Act.depth+1][Act.width] == 'G' || array[Act.depth-1][Act.width] == 'G' || array[Act.depth][Act.width+1] == 'G' || array[Act.depth][Act.width-1] == 'G'  )
			 {System.out.println("-----Glitter-----");
		 	glitter = 1;
		 	
			 }
	 	}
	 static void Bump(char array[][]) {
		 if(array[Act.depth+1][Act.width] == '0' || array[Act.depth-1][Act.width] == '0' || array[Act.depth][Act.width+1] == '0' || array[Act.depth][Act.width-1] == '0'  )
			 {System.out.println("-----Bump-----");}
		 
	 }
	 static void Scream() {
		 {System.out.println("-----Scream-----");
		 sensor[1] = "S";}

	 }
	
	
	
}


