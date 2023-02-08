import java.util.Scanner;
public class test {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
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
		
		for(i = 1; i < userInput; i++)
		{
			for(j = 1; j < userInput; i++)
			{
				if(i == j)
					System.out.print(MATRIX_1);
				
				else
					System.out.print(MATRIX_0);
			}
		System.out.println();
		
		}
		sc.close();
	}

}
