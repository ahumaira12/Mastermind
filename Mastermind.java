package stuff;

import java.util.Random;
import java.util.Scanner;

public class Mastermind {
		
		public static String s;
		public static int count=0;
		
		public static void main(String[]args)
		{
			int digit1= (int) (Math.random()*6)+1;  
			int digit2= (int) (Math.random()*6)+1; 
			int digit3= (int) (Math.random()*6)+1; 
			int digit4= (int) (Math.random()*6)+1; 
			
			int target= digit1+(10*digit2)+(100*digit3)+(1000*digit4); // a random 4-digit code is generated

			for (int i=0;i<10;i++) //the player has up to ten tries to guess
			{
				int g= guess(); //the player can enter their guess
				s="";
				int pluscount=0;
				int minuscount=0;
				
				//individual integers are extracted from the guess entered
				int g1= g%10;
				int r= g/10;
				int g2= r%10;
				int r2= r/10;
				int g3=r2%10;
				int r3= r2/10;
				int g4= r3%10;
			
				/*pluscount increases if a correct digit in the correct spot is entered
				 * minuscount increases if a correct digit in the wrong spot is entered
				 */
				
				if(g1==digit1)
				{
					pluscount++;
				}
				else if(g1==digit2||g1==digit3||g1==digit4)
				{
					minuscount++;
				}
				if(g2==digit2)
				{
					pluscount++;
				}
				else if(g2==digit1||g2==digit3||g2==digit4)
				{
					minuscount++;
				}
				
				if(g3==digit3)
				{
					pluscount++;
				}
				else if(g3==digit1||g3==digit2||g3==digit4)
				{
					minuscount++;
				}
				
				if(g4==digit4)
				{
					pluscount++;
				}
				else if(g4==digit1||g4==digit2||g4==digit3)
				{
					minuscount++;
				}
				for(int j=0;j<pluscount;j++) //pluses are printed first
				{
					s+="+";
					
				}	
				for(int k=0;k<minuscount;k++)//minuses are printed after pluses
				{
					s+="-";
					
				}
				
				System.out.println(s);
				if(checkWin(s)==true) 
				{
					System.out.println("CORRECT!"); //game ends if player wins
					break;
				}
				else
				{
					count++;
				}	
			}
		if(count==10)
			{
			System.out.println("YOU LOSE"); //if player is incorrect after 10 tries, they lose
		}
		
	}
		public static boolean checkWin(String x) 
		{
			if(x.equals("++++")) //if all digits are correct and in correct positions, the player wins
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		public static int guess()
		{
			Scanner scn= new Scanner(System.in);
			System.out.print("Enter your guess: "); //player can enter their guess for the code
			int guess= scn.nextInt();
			
			return guess;
		}
		
}
