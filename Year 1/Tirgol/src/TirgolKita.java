import java.util.Scanner;
public class TirgolKita {

	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int[] n = { 3 ,4 ,5, 6};
		
		System.out.println(sumArray(n));
		
		int num = 1234;
		
		System.out.println(recEven(num));
		
		System.out.println(recReverse(num , 0));
		
//		int[][] array = new int[3][3];
//		
//		for(int i = 0; i < array.length; i++)
//		{
//			for(int j = 0; j < array[i].length; j++)
//			{
//				array[i][j] = sc.nextInt();
//			}
//			
//		}	
		
		String[] strArray = {"hello " ," momo m o", "trio"};
		
		acronymsString(strArray);
//		reverseString (strArray);
		
	}

	public static int sumArray(int[] array)
	{
		return sumArray(array , 0 , 0);
	}
	
	public static int sumArray(int[] array , int i , int sum)
	{
		if(i < array.length)
			return sumArray(array , i + 1, sum + array[i]);
		
		return sum;
		
	}
	
	public static void maxMin(int[][] array)
	{
		int[] arrayBiggest = new int[array.length];
		int count, row, collumn;
		
		row = 0;
		collumn = 0;
		count = 0;
		
		for(int i = 0; i < array.length; i++)
		{
			for(int j = 0; j < array[i].length; j++)
			{
				arrayBiggest[i] = Math.max(arrayBiggest[i], array[i][j]);
			}
		}
		
		for(int i = 0; i < array.length; i++)
		{
			for(int j = 0; j < array[i].length; j++)
			{
				if(arrayBiggest[i] < array[i][j])
					count ++;
				
				if(arrayBiggest[i] == array[i][j])
				{
					row = i;
					collumn = j;		
				}
				
				if(count == array[i].length - 1)
					System.out.println( "In the row " + row + " and collumn " + collumn + " the number is " + arrayBiggest[i]);
				
			}
			count = 0;
		}
		
		
		
		
	}
	
	public static int recReverse(int n , int reverseN)
	{
		if(n > 0)
		{
			return recReverse(n/ 10, (reverseN + n % 10) * 10);
		}
		
		return reverseN / 10 ;
	}
	
	public static void acronymsString(String[] strArray)
	{
		for(int i = 0; i < strArray.length; i++)
		{
			System.out.println(strArray[i].trim().charAt(0) + "." + strArray[i].trim().charAt(strArray[i].trim().length() - 1));
		}
	}
	
	public static void reverseString(String[] strArray)
	{
		
		for(int i = 0; i < strArray.length; i++)
		{
			String trrimedStr = strArray[i].trim();
			
			for(int j = strArray[i].length() - 1; j >= 0; j--)
			{
				System.out.print(trrimedStr.charAt(j));
			}
			
			System.out.println();
			
		}
	}
	
	public static int countEquel(int[][] mat1, int[][] mat2)
	{
		int count;
		
		count = 0;
	
		for(int i = 0; i < mat1.length; i++)
		{
			for(int j = 0; j < mat1[i].length; j++)
			{
				if(mat1[i][j] == mat2[i][j])
					count++;
			}
		}
		
		return count;
	}
	
	public static int recEven(int num)
	{
		if(num != 0)
		{
			num -= num % 10;
			return recEven(num/10);
		}
		
		return num;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
