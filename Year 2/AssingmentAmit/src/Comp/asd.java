package Comp;

import java.io.*;

public class asd
{

	public static void main(String[] args)
	{
			String str = "010";
			
			byte j =(byte) (((int)str.charAt(2)) * Math.pow(2, 2) + ((int)str.charAt(1)) * Math.pow(2, 1) + ((int)str.charAt(0)) * Math.pow(2, 0));
			byte i = 010;
			
			
			int foo = Integer.parseInt(str, 2);
			
			System.out.println(j);
			System.out.println(i);
			System.out.println(foo);
			
	}
}
