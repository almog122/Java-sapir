//Igor Zhivilko ID: 306570946 Almog Fadida ID: 315544437 Moran Arzi ID: 200244945
import java.util.Scanner;
public class Exe3 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		
		final int BOOM;
		int inputNum, i, checkForBoom;
		
		BOOM = 7;
		checkForBoom = 0;
		
		System.out.println("Enter a number : ");
		inputNum = sc.nextInt();
		
		for(i = 1; i <= inputNum; i++)
			{
			checkForBoom = i % BOOM;
			
			if(checkForBoom == 0)
				System.out.print("BOOM!");
			else
			System.out.print(" " + i + " ");
			}
		
		sc.close();
	}

}
