
import java.util.Scanner;


public class main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//create objects
		Compounds ourComp = new Compounds(); //we'll send to our constructor so change according to it
		SharedResources ourRes = new SharedResources(); //same here
		
		
		//get N cows from user
		System.out.println("Enter the number of cows you want in your farm");
		int n_cows = sc.nextInt();
		
		
		//create N Threads and send them the objects we created and make them start running
		for(int i=0; i<n_cows; i++) {
			
			Thread cow = new Thread(ourComp, ourRes); //need to build
			cow.start();
		}
		
		
		
		
		
		/*       maybe need join?
		//wait until all threads will be done and then print final result
				try {
					t1.join();
					t2.join();
					t3.join();
				}catch (InterruptedException e) {
					e.printStackTrace();
				}
		*/
		
		
		sc.close();
	}//end main function

} //end main class
