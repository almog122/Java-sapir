//Igor Zhivilko ID: 306570946 Almog Fadida ID: 315544437 Moran Arzi ID: 200244945
import java.util.Scanner;

public class Assignment8 {
	
	public static Scanner sc = new Scanner (System.in);

	public static void main(String[] args) {
		
		int chooise, num1, num2 ,num3 , side1, side2, side3, side4, factorialM, factorialN, factorialK;
		double radius;
		
		final int CHOOISE_1 = 1;
		final int CHOOISE_2 = 2;
		final int CHOOISE_3 = 3;
		final int CHOOISE_4 = 4;
		final int CHOOISE_5 = 5;
		
		Menu();
		
		chooise = sc.nextInt();
		
		while(chooise != CHOOISE_5)
		{
			switch(chooise)
			{
				case CHOOISE_1:
				{
					System.out.println("Enter three numbers : ");
					num1 = sc.nextInt();
					num2 = sc.nextInt();
					num3 = sc.nextInt();
					
					System.out.println(squares(num1, num2, num3));
					System.out.println();
					
					Menu();
					
					chooise = sc.nextInt();
					
					break;
				}
			
				case CHOOISE_2 :
				{
					System.out.println("Enter four sides : ");
					side1 = sc.nextInt();
					side2 = sc.nextInt();
					side3 = sc.nextInt();
					side4 = sc.nextInt();
					
					System.out.println(checkRectangle(side1, side2, side3, side4));
					System.out.println();
					
					Menu();
					
					chooise = sc.nextInt();
					
					break;
				}
				
				case CHOOISE_3 :
				{
					System.out.println("Enter a radius : ");
					radius = sc.nextDouble();
					
					System.out.println(circleSum (radius)); 
					System.out.println();
					
					Menu();
					
					chooise = sc.nextInt();
					
					break;
				}
				
				case CHOOISE_4 :
				{
					System.out.println("Enter 3 numbers : ");
					factorialM = sc.nextInt();
					factorialN = sc.nextInt();
					factorialK = sc.nextInt();
					
					factAVG (factorialM, factorialN, factorialK);
					System.out.println();
					
					Menu();
					
					chooise = sc.nextInt();
					
					break;
				}	
			}
		}
		
		System.out.println("Good Bye");
		sc.close();
	}
	
   //Ex.1
	
	public static boolean squares(int num1, int num2, int num3){
		
		final int POW;
		int check1, check2;
		
		POW = 2;
		
		check1 = (int) Math.pow(num1, POW); 
		check2 = (int) Math.pow(num2, POW);
		
		if(num2 == check1 && num3 == check2)
		{
			return true;
		}
		else
			return false;
	}
	
   //Ex.2
	
	public static boolean checkRectangle(int side1, int side2, int side3, int side4){
		
		final int LOWER_BORDER;
		
		LOWER_BORDER = 0;
		
		if(side1 < LOWER_BORDER || side2 < LOWER_BORDER|| side3 < LOWER_BORDER|| side4 < LOWER_BORDER)
			return false;
		
		else
		{
			
			if(side1 == side2 && side3 == side4 || side1 == side3 && side2 == side4 || side1 == side4 && side2 == side3)
				return true;
			
			else
				return false;
		}
	}
	
   //Ex.3
	
	public static double circleSum(double radius){
		
		final int PARAMETER;
		double circleArea, circlePerimeter;
		
		PARAMETER = 2;
		
		circleArea =  Math.PI * Math.pow(radius, PARAMETER);
		circlePerimeter = PARAMETER * radius * Math.PI;
		
		return circleArea + circlePerimeter;
	}
	
   //Ex.4
	
	public static double factAVG(int m, int n, int k) {
		
		final int AMOUNT_OF_VARIABLE;
		int i;
		double factorialM, factorialN, factorialK;
		
		AMOUNT_OF_VARIABLE = 3;
		
		factorialM =1;
		factorialN =1;
		factorialK =1;
		
		for(i = 1; i <= m; i++)
		{
			factorialM *= i;
		}
		
		for(i = 1; i <= n; i++)
		{
			factorialN *= i;
		}
		
		for(i = 1; i <= k; i++)
		{
			factorialK *= i;
		}
		
		return (factorialM + factorialN + factorialK) / AMOUNT_OF_VARIABLE;
	}
	
	public static void Menu()
	{
		System.out.println("       Welcome to the Menu ");
		System.out.println("      Here are your options :");
		System.out.println("Choose '1' to check if the current number is the sqrt of the previous number");
		System.out.println("Choose '2' to check if the sides entered can make a rectangle");
		System.out.println("Choose '3' to caculate the sum of the area and perimeter of the circle");
		System.out.println("Choose '4' to caculate the factorial of 3 number and return thier averaged");
	}
	
	
	
	
	
	
	
	
	
	
	
}
