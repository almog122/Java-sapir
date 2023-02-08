package assing2;

import java.util.Scanner;


public class main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//create objects
		SharedResources ourRes = new SharedResources();
		Compounds ourComp = new Compounds(ourRes); //we'll send to our constructor so change according to it
		
		
		
		//get N cows from user
		System.out.println("Enter the number of cows you want in your farm");
		int n_cows = sc.nextInt();
		
		
		//create N Threads and send them the objects we created and make them start running
		
		CowThread[] cow = new CowThread[n_cows];
		
		for(int i=0; i<n_cows; i++) {
			
			cow[i] = new CowThread(ourComp,ourRes); //need to build
			
		}
		
		Thread[] c = new Thread[n_cows];
		
		for(int i=0; i<n_cows; i++) {
			
			c[i] = new Thread(cow[i]); //need to build
			c[i].start();
		}
		
		
		for(int i=0; i<n_cows; i++) {
			
			try {
				c[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		
		
		
		sc.close();
	}//end main function

} //end main class
