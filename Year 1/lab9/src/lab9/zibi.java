package lab9;
import java.util.Scanner;

public class zibi {
	public static Scanner sc = new Scanner (System.in);
	public static void main(String[] args) {
		int num1,num2,num3,num4;
		double radius;
		radius = 3.25;
		num1=4;
		num2=2;
		num3=2;
		num4=5;
		System.out.println(circleSum(radius));
		
		
	}
	public static boolean squares(int num1, int num2, int num3)
	{
		int check1, check2;
		
		check1 = (int) Math.pow(num1, 2); 
		check2 = (int) Math.pow(num2, 2);
		
		if(num2 == check1 && num3 == check2)
		{
			return true;
		}
		else
			return false;
	}
	public static boolean checkRectangle(int side1, int side2, int side3, int side4)
	{
		final int ZERO;
		
		ZERO = 0;
		
		if(side1 < ZERO || side2 < ZERO|| side3 < ZERO|| side4 < ZERO)
			return false;
		
		else
		{
			
			if(side1 == side2 && side3 == side4 || side1 == side3 && side2 == side4 || side1 == side4 && side2 == side3)
				return true;
			
			else
				return false;
		}
	}
	public static double circleSum(double radius){
		
		final int PARAMETER;
		double circleArea, circlePerimeter;
		
		PARAMETER = 2;
		
		circleArea =  Math.PI * Math.pow(radius, PARAMETER);
		circlePerimeter = PARAMETER * radius * Math.PI;
		
		return circleArea + circlePerimeter;
		
		
		
	}
	

}
