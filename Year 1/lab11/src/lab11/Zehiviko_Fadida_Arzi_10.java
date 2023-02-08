//Igor Zhivilko ID: 306570946 Almog Fadida ID: 315544437 Moran Arzi ID: 200244945
package lab11;
import java.util.Scanner;

public class Assignment10 {

	public static Scanner sc = new Scanner (System.in);
	
	public static void main(String[] args) {
		
		int userAscendingNum , userSumEven ,userSizeTriangular, userSizeHourglass, userArrayNumSize, userArrayCharSize;		
		char userChar;
		
		//Ex 1
		//This program gets a number from the user and check if the numbers within the number given is ascending
		
		System.out.println("Enter a number to check ascending of numbers within it : ");
		userAscendingNum = sc.nextInt();
		
		System.out.println("the numbers withing the number " + userAscendingNum + " ascending ? : " + recIsAscendingDigitsNum(userAscendingNum));
		
		//Ex 2
		//This program gets integer array from the user and return the sum of the biggest number and the smallest number in the array 
		
		System.out.println("Enter array size : ");
		userArrayNumSize = sc.nextInt();
		
		int[] userArrayNum = new int[userArrayNumSize];
		
		System.out.println("Enter array numbers : ");
		for(int i = 0; i < userArrayNumSize; i++)
		{
		userArrayNum [i] = sc.nextInt();
		}
		
		System.out.println();
		System.out.print("User Array {");
		for(int i = 0; i < userArrayNumSize; i++)
		{
			if(i != userArrayNumSize - 1)	
				System.out.print(userArrayNum[i] + ",");
			
			else
				System.out.print(userArrayNum[i]);
		}
		
		System.out.print("} the sum of max number and min number in the array : " + recSumMinMaxArr(userArrayNum) + "\n");
		
		//Ex 3
		//This program gets a number from the user and return the sum of the even numbers within it
		
		System.out.println("Enter a number to sum the even numbers within the number : ");
		userSumEven = sc.nextInt();
		
		System.out.println(userSumEven + " the sum of even number is : " + recSumEvenDigits(userSumEven));
		
		// Ex 4
		//This program gets an char array and a character from the user and return the amount of time the character appeared in the array
		
		System.out.println("Enter char array size : ");
		userArrayCharSize = sc.nextInt();
		
		char[] userArrayChar = new char[userArrayCharSize];
		
		System.out.println("Enter char to check in array : ");
		userChar = sc.next().charAt(0);
		
		System.out.println("Enter char array characters :");
		for(int i = 0; i < userArrayCharSize; i++)
		{
			userArrayChar[i] = sc.next().charAt(0);
		}
		
		System.out.println();
		System.out.print("User Array {");
		for(int i = 0; i < userArrayCharSize; i++)
		{
			if(i != userArrayCharSize - 1)	
				System.out.print(userArrayChar[i] + ",");
			
			else
				System.out.print(userArrayChar[i]);
		}
		System.out.print("} the character " + userChar + " show up in the array " + recCountCharsInArray(userArrayChar , userChar) + " times \n");
		
		//Ex 5
		//This program gets a triangular size from the user and print a triangular that size using *
		
		System.out.println("Enter retungle size : ");
		userSizeTriangular = sc.nextInt();
		
		System.out.println("Retungle size : " + userSizeTriangular );
		reDrawTriangular(userSizeTriangular);
		
		//This program gets a hourglass size from the user and print a hourglass that size using *
		
		System.out.println("Enter hourglass size : ");
		userSizeHourglass =sc.nextInt();
		
		System.out.println("Hourglass size : " + userSizeHourglass );
		reDrawHourglass(userSizeHourglass);
		
		sc.close();
	}

	//Ex. 1
	//This recursion function gets a number and check if the numbers within the number given is ascending
	
	public static boolean recIsAscendingDigitsNum(int num)
	{
		return recIsAscendingDigitsNum(num ,num / 10); //The recurshion case gets the number and the number divided by 10 
	}
	
	public static boolean recIsAscendingDigitsNum(int num, int numAfterDivisionBy10)
	{
		if(numAfterDivisionBy10 > 10)
		{
			if(num % 10 > numAfterDivisionBy10)
				return recIsAscendingDigitsNum(numAfterDivisionBy10);
			
		}
		if(num % 10 > numAfterDivisionBy10 % 10)
			return true;
		
		return false;
	}
	
	//Ex 2.
	//This recursion function gets and array and return the sum of the max number and the minimum number in the array
	
	public static int recSumMinMaxArr(int[] array)
	{
		return recSumMinMaxArr(array, 0 , array[0], array[1]);
	}
	
	public static int recSumMinMaxArr(int[] array, int index , int arrayBiggest, int arraySmallest)
	{
		if(index == array.length - 1)
		{
			return arrayBiggest + arraySmallest;
		}
		
		if(arrayBiggest < Math.max(array[index], array[index + 1]))
			arrayBiggest = Math.max(array[index], array[index + 1]) ;
		
		if(arraySmallest > Math.min(array[index], array[index + 1]))
			arraySmallest = Math.min(array[index], array[index + 1]);
		
		return recSumMinMaxArr(array , index + 1, arrayBiggest , arraySmallest);
	}
	
	//Ex 3.
	//This recursion function gets a number and return the sum of the even numbers within the number
	
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
			return recSumEvenDigits(num/10, sumOfEven); 
	}
	
	//Ex 4.
	//This recursion function gets a array of char and a character and count the amount of time the character appeared in the array
	
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
	
	//Ex 5.
	//This recursion function gets a size and print a triangular in that size using *
	
	public static void reDrawTriangular(int triangleSize)
	{
		for(int i = 0; i < triangleSize; i++)
		{
			System.out.print("*");
		}
		
		System.out.println();
		
		if(triangleSize > 0)
			reDrawTriangular(triangleSize - 1);
	}
	
	//This recursion function gets a size and print a hourglass in that size using *
	
	public static void reDrawHourglass(int hourglassSize)
	{
		for(int j = 0; j < hourglassSize; j++)
		{
			System.out.print("*");			
		}
		
		if(hourglassSize > 0)
		{
			if( hourglassSize > 1)
				System.out.println();
			
			reDrawHourglass(hourglassSize - 1);
		}
		
		for(int j = 0; j < hourglassSize; j++)
		{
			System.out.print("*");			
		}
		
		System.out.println();
		
	}
	
} // end of class
