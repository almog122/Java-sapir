import java.util.Scanner;
public class testsa 
{
	public static Scanner sc = new Scanner (System.in);
	
	public static void main(String [] args)
	{
		final int UPPER_BORDER, LOWER_BORDER, TRIES;
		int manlInput, randomMachine, num;
		
		UPPER_BORDER = 12;
		LOWER_BORDER = 1;
		TRIES = 15;
		num = 1;
		
		System.out.println("Enter a number");
		manlInput = sc.nextInt();
		
		if(manlInput > UPPER_BORDER || manlInput < LOWER_BORDER)
			System.out.println("Invalid Input");
		else
		{
			do
			{
				randomMachine = (int) (Math.random() * 12 + 1);
				num ++;
				System.out.println(randomMachine);
			}while(num <= TRIES && randomMachine != manlInput );
			
			if(randomMachine == manlInput)
				System.out.println("The number " + manlInput + " got dicovered after " + num + " TRIES" );
			
			else
				System.out.println("The number " + manlInput + " was not dicovered after " + num + " TRIES" );
		}
		sc.close();
	
		
	}
}