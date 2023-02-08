package lab9;

import java.util.Scanner;

public class class10 {
	
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int i;
		
		//int[] array = new int[5];
		
		int[] array = userInput();
		
		printArray(array);
		
		int[][] arr1 = {{1,3,2} , {5,6,7} , {4,1,2}};
		int[][] arr2 = {{1,3,2} , {5,6,7} , {4,1,2}};
		
	}
	
	public static int[] userInput()
	{
		int i;
		
		int[] userArray = new int[5];		
		
		System.out.println("Enter numbers for Array : ");
		
		for(i = 0; i < userArray.length; i++)
		{
			userArray[i] = sc.nextInt();
		}
		
		return userArray;
	}
	
	public static void printArray(int[] array)
	{
		int i, max, min;
		
		min = array[0];
		max = array[0];
		
		for(i = 0; i < array.length; i++)
		{
			System.out.println((i + 1) + ".  " + array[i]);
			
			if(min < array[i])
				min = array[i];
			
			if(max > array[i])
				max = array[i];
			
		}
		
		System.out.println("max is : " + max);
		System.out.println("min is : " + min);
		
		
	}
	
	public static int[][] copy2DArray(int[][] array)
	{
		
		int[][] array2 = new int[3][3];
		
		int i,j;
		
		for(i = 0; i < array2.length; i++)
		{
			for(j = 0; j < array2.length; j++)
				array2[i][j] = array[i][j];
		}
		return array2;
	}
	
	public static int[][] map()
	{
		int[][] array = new int[13][13];
		
		int i, j, one;
		
		one = 1;
		
		for(i = 0; i < array.length; i++)
		{
			for(j = 0; j < array[i].length; j++)
			{
				array[i][j] = (i + 1) *(j + 1);
				
			}
		}
		
		return array;
		
	}
	
	
	
	
	
	
	
	
	
}
