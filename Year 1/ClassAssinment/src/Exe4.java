//Igor Zhivilko ID: 306570946 Almog Fadida ID: 315544437 Moran Arzi ID: 200244945

import java.util.Scanner;
public class Exe4 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		
		final int CHOISE_2, CHOISE_3, ZERO, THREE, TEN, TWO;
		int enterNum, choise , countDigits, remainder, sumPow;
		
		TWO = 2;
		TEN = 10;
		THREE = 3;
		ZERO = 0;
		final int CHOISE_1 = 1;
		CHOISE_2 = 2;
		CHOISE_3 = 3;
		countDigits = 0;
		sumPow = 0;
		
		do 
			{
			System.out.println("Enter a postive number only ");
			enterNum = sc.nextInt();
			}
		while(enterNum < ZERO);
		
		System.out.println("choose '1' - Checks to see if the number you get is divisible by 3 no remainder");
		System.out.println("chose '2' - Calculate how many digits must be numbered");
		System.out.println("choose '3' - Calculate sum of squares of the digits");
		choise = sc.nextInt();
		
		switch(choise)
			{
			case CHOISE_1 :
				if(enterNum % THREE == ZERO)
					System.out.println("Can be divided by 3 with no remainder");
				else
					System.out.println("Cannot be divided by 3 with no remainder");
				break;
			
			case 2 :
				while(enterNum != ZERO) 
				{
					countDigits ++;
					remainder = enterNum % TEN;
					enterNum = (enterNum - remainder) / TEN;
				}
				System.out.println("Number of digits = " + countDigits);	
				break;
				
			case 3 :
				while(enterNum != ZERO) 
				{
					remainder = enterNum % TEN;
					sumPow += Math.pow(remainder, TWO);
					enterNum = (enterNum - remainder) / TEN;
				}
				System.out.println("sum of squares of the digits = " + sumPow);	
				break;
			
			default :
				System.out.println("invalid choise");
			}		
			
				
		
		
		
		sc.close();
	}

}
