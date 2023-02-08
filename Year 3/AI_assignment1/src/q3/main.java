package q3;
import java.util.Scanner;

//Moran Arzi 200244945
//Almog Fadida 315544437

public class main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String problem;
		
		System.out.println("Enter the problem");
		problem = sc.nextLine();
		
		char[] ch = new char[7];
		
		for(int i = 0; i < ch.length; i++) {
			ch[i] = problem.charAt(i);
		}
		
		AstarAlgoritm A = new AstarAlgoritm(ch);
		
		A.squareProblem();
		
	}

}
