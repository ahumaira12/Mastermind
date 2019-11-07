package chapterFour;

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
		
		int target= digit1+(10*digit2)+(100*digit3)+(1000*digit4);

		System.out.println(target);
		
				
		for (int i=0;i<10;i++)
		{
			int g= guess();

			s="";
			int pluscount=0;
			int minuscount=0;
			
			int g1= g%10;
			int r= g/10;
			int g2= r%10;
			int r2= r/10;
			int g3=r2%10;
			int r3= r2/10;
			int g4= r3%10;
		
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
			
			for(int j=0;j<pluscount;j++)
			{
				s+="+";
				
			}
					
			for(int k=0;k<minuscount;k++)
			{
				s+="-";
				
			}
			
			System.out.println(s);
			
			if(checkWin(s)==true)
			{
				System.out.println("CORRECT!");
				break;
			}
			else
			{
				count++;
			}
				
		}
		
	if(count==10)
	{
		System.out.println("YOU LOSE");
	}
	
}
		
	
	public static boolean checkWin(String x)
	{
		if(x.equals("++++"))
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
		System.out.print("Enter your guess: ");
		int guess= scn.nextInt();
		
		return guess;
	}
	
	
	
}
