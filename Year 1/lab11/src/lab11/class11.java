package lab11;
import java.util.Scanner;
public class class11 {

	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		
		

	}

	/*public static boolean isMagicSquare(int array[][])
	{
		int i,j;
		
		int[] checkRow = new int[array.length];
		int[] checkCol = new int[array.length];
		int[] checkLine = new int[array.length];
		
		for(i = 0; i < array.length; i++)
		{
			for(j = 0; j < array.length; j++)
			{
				checkRow[i] += array[i][j]; 
			}
		}
		
		for(i = 0; i < array.length; i++)
		{
			for(j = 0; j < array.length; j++)
			{
				checkCol[i] += array[j][i]; 
			}
		}
		
		for(i = 0; i < array.length; i++)
		{
			for(j = 0; j < array.length; j++)
			{
				if(i == j) 
					checkLine[i] += j;
			}
		}
	
	
	
	
	}*/
	
	public static int[] shumbleArray(int array[])
	{
		
		return shumbleArray(array, 0);
				
	}
	
	public static int[] shumbleArray(int array[] , int num)
	{
			if(num < array.length / 2)
			{
				int temp = array[num];
				array[num] = array[array.length - num - 1];
				array[array.length - num - 1] = temp;
				
			}
	
}
}