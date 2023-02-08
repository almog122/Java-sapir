//Igor Zhivilko ID: 306570946 Almog Fadida ID: 315544437 Moran Arzi ID: 200244945

import java.util.Scanner;

public class Assignment11 {

	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		String str = new String();
		String subInStr = new String();
		int size;
		char ch;
		
		
		//Ex 1
		//This program gets two strings,string and the sub and returns the index of the first character in the substring
		
		System.out.println("Enter a strings for output index in string"); 
		
		System.out.println("Enter a string ");
		str = sc.nextLine();
		
		System.out.println("Enter a substring ");
		subInStr = sc.nextLine();
		
		System.out.println("The last location of the substring " + subInStr + " in the string " + str + " is : " + subInStringLastIndex(str , subInStr));
		
		System.out.println("Enter a strings for output -1"); //
		
		System.out.println("Enter a string ");
		str = sc.nextLine();
		
		System.out.println("Enter a substring ");
		subInStr = sc.nextLine();
		
		System.out.println("The last location of the substring " + subInStr + " in the string " + str + " is : " + subInStringLastIndex(str , subInStr));	
				
		//Ex 2
		//This program gets array of strings and checks whether the strings in the array are substring of the string after them
		
		System.out.println("Enter array for output true");
		
		System.out.println("Choose size of string array ");
		size = sc.nextInt();
		
		String[] strArray = new String[size];
		
		System.out.println("Enter string array");
		for(int i = 0; i < strArray.length; i++)
		{
			strArray[i] = sc.nextLine();
		}
		
		System.out.println();
		
		System.out.print("String array {");
		for(int i = 0; i < strArray.length; i++)
		{
			if(i  != strArray.length - 1 )
				System.out.print(strArray[i] + ", ");
			else
				System.out.print(strArray[i]);
		}
		System.out.print("} ");
		
		System.out.println("Is each string contained in the string followed by an array? : " + arrayIsSubStrings(strArray));
		
		System.out.println("Enter array for output false");
		
		System.out.println("Enter string array");
		for(int i = 0; i < strArray.length; i++)
		{
			strArray[i] = sc.nextLine();
		}
		
		System.out.println();
		
		System.out.print("String array {");
		for(int i = 0; i < strArray.length; i++)
		{
			if(i  != strArray.length - 1 )
				System.out.print(strArray[i] + ", ");
			else
				System.out.print(strArray[i]);
		}
		System.out.print("} ");
		
		System.out.println("Is each string contained in the string followed by an array? : " + arrayIsSubStrings(strArray));
		
		//Ex 3
		//This program gets a string and a character and return the amount of times the character appeared in the string.
		
		System.out.println("Enter a string ");
		str = sc.nextLine();
		
		System.out.println("Enter a character");
		ch = sc.next().charAt(0);
		
		System.out.println("The amount of times " + ch + " appeared in " + str + " is :" + countCharInString(str , ch));
		
		//Ex 4
		//This program gets a string and return : the number 1 if the string is a palindrome, the number -1 if its not 
		//And the number 0 if it is a palindrome without a middle character
		
		System.out.println("Enter a string for output 1");
		
		System.out.println("Enter a string ");
		str = sc.nextLine();
		
		System.out.println("Is " + str + " a palindrome? " + stringIsPalindrome(str));
		
		System.out.println("Enter a string for output 0");
		
		System.out.println("Enter a string ");
		str = sc.nextLine();
		
		System.out.println("Is " + str + " a palindrome? " + stringIsPalindrome(str));
		
		System.out.println("Enter a string for output -1");
		
		System.out.println("Enter a string ");
		str = sc.nextLine();
		
		System.out.println("Is " + str + " a palindrome? " + stringIsPalindrome(str));
		
		//Ex 5
		//This program gets a string and a character and return the amount of times the character appeared in the string. 
		
		System.out.println("Enter a string ");
		str = sc.nextLine();
		
		System.out.println("Enter a character");
		ch = sc.next().charAt(0);
		
		System.out.println("The amount of times " + ch + " appeared in " + str + " is :" + recCountCharsInString(str , ch));
		
		sc.close();
	}

	//Ex. 1
	//A function that gets two strings,string and the sub and returns the index of the first character in the substring
	
	public static int subInStringLastIndex(String str, String sub)
	{	
		for(int i = str.length() ; i > sub.length() - 1 ; i--)
		{
			if(sub.equals(str.substring(i - sub.length(), i))) //Check from the end of the string to the start to see the last substrings place
				return i - sub.length();
		}
		
		return -1;
	}
	
	//Ex 2.
	//A function that gets two strings and return true if the second string is a sub string of the first string and false if isn't.
	
	public static boolean stringIsSubString(String str, String sub) //Fun
	{
		for(int i = 0; i <= str.length() - sub.length(); i++)
		{
			if(sub.equals(str.substring(i, i + sub.length())));
				return true;
		}
		
		return false;
	}
	
	//A function that gets array of strings and checks whether the strings in the array are substring of the string after them
	
	public static boolean arrayIsSubStrings(String[] strArr)
	{
		int checkSubString;
		
		checkSubString = 0;
		
		for(int i = 0; i < strArr.length - 1; i++)
		{
			if(stringIsSubString(strArr[i + 1] , strArr[i])) // Count the amount of time the string is a sub string of the string after her
				checkSubString++;
		}
		
		if(checkSubString == strArr.length - 1) // Check if the amount of time is equal to the length of the array because if it is true
			return true;						// Then the array consist of string that are substring of the one after her
		
		return false;
		
	}
	
	//Ex 3
	//A function that gets a string and a character and return the amount of times the character appeared in the string.
	
	public static int countCharInString(String str , char ch)
	{
		int countChar;
		
		countChar = 0;
		
		for(int i = 0; i < str.length(); i++ ) // count if the character appeared in the string in the index i
		{
			if(str.charAt(i) == ch)
				countChar ++;
		}
		
		return countChar;
	}
	
	//Ex 4
	//A function that gets a string and return : the number 1 if the string is a palindrome, the number -1 if its not 
	//And the number 0 if it is a palindrome without a middle character
	
	public static int stringIsPalindrome(String str)
	{
		
		
		for(int i = 0; i < str.length() / 2; i++)
		{
			if(str.charAt(i) != str.charAt(str.length() - i - 1))
				return -1; // String not a palindrome
		}
		
		if(str.length() % 2 == 0) // Palindrome string without mid character
			return 0;
		
		return 1; // Palindrome string with mid character
	}
	
	//Ex 5
	//A recursion function that gets a string and a character and return the amount of times the character appeared in the string. 
	
	public static int recCountCharsInString(String str , char ch)
	{
		return recCountCharsInString(str ,ch , 0 , 0);
	}
	
	public static int recCountCharsInString(String str, char ch, int index , int countChar)
	{
		
		if(index < str.length()) //The stoping condition
		{
			if(str.charAt(index) == ch) 
				countChar++;
			
		return recCountCharsInString(str , ch , index + 1, countChar);	//The recursion advance the index and return the value of the countChar
		}
		
		return countChar;
	}
	
	
}//End of class
