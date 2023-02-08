//Almog Fadida, ID 315544437. Moran Arzi, ID 200244945

package socket_client;

import java.util.Scanner;

public class ClientDriver {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter first argument:");
		int argA = scanner.nextInt();
		System.out.println("Enter second argument:");
		int argB = scanner.nextInt();
		scanner.close();
		SumClient client = new SumClient(argA, argB);
		client.start();
		try {
			client.join();
		} catch (InterruptedException e) {}
	}
}

