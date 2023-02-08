package lab9;
import java.util.Scanner;
public class zibi2 {
	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);
		
		int num = 1256;
		System.out.println(recIsAscendingDigitsNum(num));
		int [] array = {5,9,4,3,7,4,5};
		
		System.out.println(recSumMinMaxArr(array));
		
		int num1 = 53988;
		
		System.out.println(recSumEvenDigits(num1));
		
		char[] charArray = {'H','e','l','l','o'};
		
		System.out.println(recCountCharsInArray(charArray, 'm'));
		
		
		int n = 4;
		
		retungle(n);
		
		System.out.println();
		
		hourglass(n);
		
		input.close();
	}
	public static boolean recIsAscendingDigitsNum(int num)
	{
		return recIsAscendingDigitsNum(num ,num/10);
	}
	
	public static boolean recIsAscendingDigitsNum(int num, int numAfterDivision10)
	{
		if(numAfterDivision10 > 10)
		{
			if(num % 10 > numAfterDivision10 % 10)
				return recIsAscendingDigitsNum(numAfterDivision10);
		}

		if(num % 10 > numAfterDivision10 % 10)
			return true;
		
		return false;
	}


	public static int recSumMinMaxArr(int[] array)
	{
		return recSumMinMaxArr(array, 0 , array[0], array[1]);
	}
	
	public static int recSumMinMaxArr(int[] array, int index , int arrayBigest, int arraySmallest)
	{
		if(index == array.length - 1)
		{
			return arrayBigest + arraySmallest;
		}
		
		if(arrayBigest < Math.max(array[index], array[index + 1]))
			arrayBigest = Math.max(array[index], array[index + 1]) ;
		
		if(arraySmallest > Math.min(array[index], array[index + 1]))
			arraySmallest = Math.min(array[index], array[index + 1]);
		
		return recSumMinMaxArr(array , index + 1, arrayBigest , arraySmallest);
		
	}
	
	public static int recSumEvenDigits(int num)
	{
		return recSumEvenDigits(num , 0);
	}
	
	
	public static int recSumEvenDigits(int num , int sumOfEven)
	{		
		if(num % 2 == 0)
			sumOfEven += num % 10;
		
		if(num == 0)
			return sumOfEven;
		
		else
			return recSumEvenDigits(num/10 , sumOfEven); 
	}
	
	//
	public static int recCountCharsInArray(char[] charArray, char ch)
	{
		return recCountCharsInArray(charArray , ch , 0 , 0);
	}
	
	public static int recCountCharsInArray(char[] charArray, char ch, int count, int index)
	{
		if(index < charArray.length)
		{
			if(charArray[index] == ch)
				count++;
			
			return recCountCharsInArray(charArray, ch, count, index + 1);
		}
		
		return count;
	}
	
	public static void retungle(int n)
	{
		for(int i = 0; i < n; i++)
		{
			System.out.print("*");
		}
		
		System.out.println();
		
		if(n > 0)
			retungle(n - 1);
	}
	
//	
//	
//	public static void hourglass(int n , int i)
//	{
//		if(i > 0)
//		{
//			for(int j = 0; j < i; j++)
//			{
//				System.out.print("*");
//			}
//			
//			System.out.println();
//			 
//			hourglass(n , i - 1);
//		}
//		else
//			retungle(n);
//		
//	}
	
	public static void hourglass(int n)
	{
		for(int j = 0; j < n; j++)
		{
			System.out.print("*");			
		}
		
		if(n > 0)
		{
			if( n > 1)
				System.out.println();
			hourglass(n - 1);
		}
		
		for(int j = 0; j < n; j++)
		{
			System.out.print("*");			
		}
		
		System.out.println();
		
	}
}
