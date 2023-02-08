import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class main {

	public static void main(String[] args) {
		
		Semaphore sem = new Semaphore(0);
		System.out.println(sem.availablePermits());
		while(true) {
		int rand = (int) (Math.random() * 9) + 2;
		
		System.out.println(rand);
		}
	}

}
