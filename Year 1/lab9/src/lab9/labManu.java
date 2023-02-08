package lab9;

import java.util.Scanner;
public class labManu {

	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String args[]) 
	{
		int choise ;
		double userBase, userExponent, userNum1, userNum2;
		
		do
		{
			choise = munaAndInput();
			
			switch(choise)
			{
				case 1 :
					System.out.println("Result is " + power(3.5 , 1.5));
					
					break;
				
				case 2 :
					System.out.println("Enter base");
					userBase = sc.nextDouble();
					System.out.println("Enter exponent");
					userExponent = sc.nextDouble();
					System.out.println("Result is " + power(userBase , userExponent));
					
					break;
				
				case 3 :
					System.out.println("Enter first num");
					userNum1 = sc.nextDouble();
					System.out.println("Enter first num");
					userNum2 = sc.nextDouble();
					System.out.printf("max is %.6f " , max(userNum1, userNum2));
					
					break;
			}
		} while(choise != 4);
		
		System.out.println("Exit");	
		
		sc.close();
	}

	public static int munaAndInput()
	{
		int num;
		
		System.out.println("Welcome to the menu");
		System.out.println("Here are your options");
		System.out.println("1. how much is 3.5^1.5");
		System.out.println("2. calculate power");
		System.out.println("3. find max");
		System.out.println("4. Exit");
		
		num = sc.nextInt();
		
		return num;
	}
	
	public static double power(double num1 , double num2)
	{
		double num = Math.pow(num1, num2);
		
		return num;
	}
	
	public static double max(double num1 , double num2)
	{	
		return num1 > num2 ? num1 : num2;	
	}
	
	
	
	
}
