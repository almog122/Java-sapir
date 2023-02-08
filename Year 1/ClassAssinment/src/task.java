//Igor Zhivilko ID: 306570946 Almog Fadida ID: 315544437 Moran Arzi ID: 200244945

import java.util.Scanner;
public class task {
	
	public static Scanner sc = new Scanner (System.in);
	
	public static void main(String[] args) {
		
		int chooise;
		
		final int CHOOISE_1 = 1;
		final int CHOOISE_2 = 2;
		final int CHOOISE_3 = 3;
		final int CHOOISE_4 = 4;
		final int CHOOISE_5 = 5;
		
		Menu();
		
		chooise = sc.nextInt();
		
		while(chooise != 6)
		{
			switch(chooise)
			{
				case CHOOISE_1:
				{
					Menu();
					chooise = sc.nextInt();
					break;
				}
			
				case CHOOISE_2 :
				{
					matrix();
					Menu();
					chooise = sc.nextInt();
					break;
				}
				
				case CHOOISE_3 :
				{
					rictangle();
					Menu();
					chooise = sc.nextInt();
					break;
				}
				
				case CHOOISE_4 :
				{
					factorial();
					Menu();
					chooise = sc.nextInt();
					break;
				}	
				
				case CHOOISE_5 :
				{
					manVsMachine();
					Menu();
					chooise = sc.nextInt();
					break;
				}
				
			}
		}
		exit();
		sc.close();
	}

	public static void Menu()
	{
		System.out.println("--------------------------------------- Welcome to the Menu ---------------------------------------");
		System.out.println("Here are your options :");
		System.out.println("Choose 1 to display the menu again");
		System.out.println("Choose 2 to draw an identity matrix");
		System.out.println("Choose 3 to draw a rictangle");
		System.out.println("Choose 4 to caculate factorial");
		System.out.println("Choose 5 to play against machine");
		System.out.println("Choose 6 to exit the programe");
	}
	
	public static void matrix()
	{
		final int UPPER_BORDER , LOWER_BORDER , MATRIX_0 , MATRIX_1;
		int userInput, i, j;
		
		UPPER_BORDER = 15;
		LOWER_BORDER = 0;
		MATRIX_0 = 0;
		MATRIX_1 = 1;
		
		
		System.out.println("Enter matrix size");
		userInput = sc.nextInt();
		
		if(userInput > UPPER_BORDER || userInput < LOWER_BORDER)
			System.out.println("Invalid Input");
		else
		{
				for(i = 0; i < userInput; i++)
			{
					for(j = 0; j < userInput; j++)
					{
						if(i == j)
							System.out.print(MATRIX_1);
						else
							System.out.print(MATRIX_0);
					}
					System.out.println();
			}
		}
	}	
	
	public static void rictangle()
	{
		final int UPPER_BORDER, LOWER_BORDER;
		int rictangleLength, i , j;
		
		UPPER_BORDER = 12;
		LOWER_BORDER = 1;
		
		System.out.println("Eneter side length");
		rictangleLength = sc.nextInt();
		
		if(rictangleLength > UPPER_BORDER || rictangleLength < LOWER_BORDER)
			System.out.println("Invalid Input");
		else
		{
			for(i = 1; i <= rictangleLength; i++)
			{
				for(j = 1; j <= i; j++)
				{
					System.out.print("*");
				}
			
				System.out.println();
			}
		
		}
	}
	
	public static void factorial()
	{
		final int UPPER_BORDER, LOWER_BORDER , ZERO;
		int factorialInput, sum, i;
		
		UPPER_BORDER = 55;
		LOWER_BORDER = 0;
		ZERO = 0;
		sum = 1;
		
		System.out.println("Enter a number");
		factorialInput = sc.nextInt();
		
		if(factorialInput > UPPER_BORDER || factorialInput < LOWER_BORDER)
			System.out.println("Invalid Input");
		else
		{
			if(factorialInput == ZERO)
			{
				sum = 0;
				System.out.println("The factorial of " + factorialInput + " is " + sum);
			}
			else 
			{
				for(i = 1; i <= factorialInput; i++)
				{
					sum *= i;
				}
				System.out.println("The factorial of " + factorialInput + " is " + sum);
			}
		}
	}
	
	public static void manVsMachine()
	{
		final int UPPER_BORDER, LOWER_BORDER, TRIES , ONE;
		int manlInput, randomMachine, num;
		
		UPPER_BORDER = 12;
		LOWER_BORDER = 1;
		ONE = 1;
		TRIES = 15;
		num = 0;
		
		System.out.println("Enter a number");
		manlInput = sc.nextInt();
		
		if(manlInput > UPPER_BORDER || manlInput < LOWER_BORDER)
			System.out.println("Invalid Input");
		else
		{
			do
			{
				randomMachine = (int) (Math.random() * UPPER_BORDER + ONE);
				++num;
			}while(num < TRIES && randomMachine != manlInput );
			
			if(randomMachine == manlInput)
				System.out.println("The number " + manlInput + " got dicovered after " + num + " TRIES" );
			
			else
				System.out.println("The number " + manlInput + " was not dicovered after " + num + " TRIES" );
		}
	}
	
	public static void exit()
	{
		System.out.println("--------------------------------------- Have a nice day ---------------------------------------");
	}





}
	
	

