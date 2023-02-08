// Moran Arzi 200244945
//Almog Fadida 315544437


package Resource_Allocation;
import java.util.Scanner;

public class main {
	
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		
		int numPro ,numRes;
		
		int num;
		
		System.out.println("Enter number of process");	
		numPro = sc.nextInt(); 
		
		System.out.println("Enter number of resources");	
		numRes = sc.nextInt(); 
		
		int[][] Allocation = new int[numPro][numRes];
		int[][] MaxDemand = new int[numPro][numRes];
		int[] Available = new int[numRes];
		
		String str = sc.nextLine();
		
		//Create Allocation Matrix
		
		for(int i = 0; i < numPro; i++) {
			System.out.println("Enter Allocation Row " + i);
			str = sc.nextLine();
			for(int j = 0; j < numRes; j++) {
				
				Allocation[i][j] = Character.getNumericValue(str.charAt(j));
			}
		}
		
		//Create MaxDemand Matrix
		
		for(int i = 0; i < numPro; i++) {
			System.out.println("Enter MaxDemand Row " + i );
			str = sc.nextLine();
			for(int j = 0; j < numRes; j++) {
					
				MaxDemand[i][j] = Character.getNumericValue(str.charAt(j));
			}
		}
		
		//Create Available Matrix
		
		System.out.println("Enter Available");
		str = sc.nextLine();
		
		for(int i = 0; i < numRes; i++) {
		
			Available[i] = Character.getNumericValue(str.charAt(i));
		}
			
		//Create Need Matrix
		
		int[][] Need = CreateNeed(Allocation , MaxDemand);
		
		
		//Enter Resource A - E
		System.out.println("Enter Resource index");
		int index = sc.nextInt();
		
		
		isSafe(Need, Allocation, Available); //Print if safe , and if not print the process that in the deadlock
		
		MinResources(Need , Allocation , Available , index); //Print the minimum amount of resource needed to run the program without deadlock
		
		sc.close();
	}
	
	
	public static int[][] CreateNeed(int[][] Allocation , int[][] MaxDemand){ //The function create the need matrix
		
		int[][] Need = new int[Allocation.length][Allocation[0].length];
		
		for(int i = 0; i < MaxDemand.length; i++) {
			for(int j = 0; j < MaxDemand[i].length; j++) {
				
				Need[i][j] = MaxDemand[i][j] - Allocation[i][j]; // We subtract the amount of resource already given to the process
				
			}
		}
		
		return Need;
		
	}
	
	
	public static void isSafe(int[][] Need ,int[][]  Allocation ,int[] Available ) {//This function will check if the program safe
		
		boolean[] Done = new boolean[Need.length];
		
		int Check = 0; 
		
		for(int i = 0; i < Need.length; i++) { //This array will check what process already run 
			Done[i] = false;					//for example i = 0 will represent if P1 run or not
		}
		
		int change; //This will allow us to check if another process succeeded to run by telling us if there was a change in the amount of false processes
					//so if there wasn't a change then we might encounter a deadlock or every processes run successfully
	
		do {		
			change = checkChange(Done);
		
			for(int i = 0; i < Need.length; i++) {
				if(Done[i] == false) { //If the process didn't run
					
					for(int j = 0; j < Need[i].length; j++) {
						
						if(Available[j] >= Need[i][j]) { //Check if there is enough of the resource to run
							Check++; //This will help us to see that every needed resource the the process needed to run is available
						}		
					}
			
					if(Check == Need[i].length) { //If the process have all the needed resources to run 
						
						Done[i] = true; //We say the process successfully run
				
						for(int j = 0; j < Allocation[i].length; j++) { //Because the process run successfully he release the resources he got
							Available[j] +=  Allocation[i][j]; //We add the amount of Allocated resource the process got to the available amount
						}
					}
			
					Check = 0;
				}
			}
		
		} while(checkAllFalse(Done) && (checkChange(Done) != change));//If we didn't run all the processes and there was a change in the amount of processes that was able to run
																	//Then we are not in done checking everyone and we yet to encounter a deadlock 				
		
		if(!(checkAllFalse(Done))) { //If all the Processes are true
			System.out.println("The progrem is safe");
		}
		
		else {
			
			System.out.println("The program is in deadlock by:");
			
			for(int i = 0; i < Done.length; i++) {
				if(Done[i] == false)
					System.out.print("P" + (i+1) +"  "); //The Processes that didn't run and are in deadlock
			}
			
			System.out.println();
		}
	}
	
	
	
	
	public static void MinResources(int[][] Need ,int[][] Allocation , int[] Available , int index) {//This function print the amount of minimum resource needed to run all the processes
				
		Available[index] = 0;
		
		boolean[] Done = new boolean[Need.length];
		
		int Check = 0; 
		
		for(int i = 0; i < Need.length; i++) { //This array will check what process already run 
			Done[i] = false;					//for example i = 0 will represent if P1 run or not
		}
		
		int change;
		
	
		do {	
			
			change = checkChange(Done);
			
			for(int i = 0; i < Need.length; i++) {
				if(Done[i] == false) { //If the process didn't run
					
					for(int j = 0; j < Need[i].length; j++) {
						
						if(Available[j] >= Need[i][j]) { //Check if there is enough of the resource to run
							Check++; //This will help us to see that every needed resource the the process needed to run is available
							
						}		
					}
			
					if(Check == Need[i].length) { //If the process have all the needed resources to run 
						
						Done[i] = true; //We say the process successfully run
				
						for(int j = 0; j < Allocation[i].length; j++) { //Because the process run successfully he release the resources he got
							Available[j] +=  Allocation[i][j]; //We add the amount of Allocated resource the process got to the available amount
						}
						
					}
			
					Check = 0;
				}
			}
			
			if(change == checkChange(Done))//Until we reach a deadlock
				Available[index]++; 
			
			
		} while(checkAllFalse(Done));//If we didn't run all the processes and there was a change in the amount of processes that was able to run
		
		int minAvi = Available[index];
		int sumCh = 0;
		
		
		for(int i = 0; i < Allocation.length; i++) { //The amount of the character already allocated
			sumCh += Allocation[i][index];
		}
		
		minAvi -= sumCh; //We subtract the amount of allocation we got from released process
		
		String str = "ABCDE";
		System.out.println("The min amount of resource " + str.charAt(index) + " needed: "+ minAvi);
		
	}
	
	
	public static boolean checkAllFalse(boolean[] Done) {
		
		for(int i = 0; i < Done.length; i++) { //Check if one of the process still hasn't run
			if(Done[i] == false)
				return true;
		}
		
		return false;
		
	}
	
	public static int checkChange(boolean[] Done) {
	
		int change = 0;
	
		for(int i = 0; i < Done.length; i++) { //Check if the amount of process that didn't run changed
			if(Done[i] == false) {
				change += (i + 1);
			}
		}
		
		return change;
		
	}
	

}




