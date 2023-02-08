package q1_FizzBuzz;

public class FizzBuzz {
	private int n;
	
	//The amount of numbers used
	FizzBuzz (int n) {
		this.n = n;
	}
	
	//Start the game with the given number to reach
	public String[] StartGame() {
		String[] str = new String[n];
		
		for(int i=0; i < str.length; i++) {
			if ((i+1) % 3 == 0 && (i+1) % 5 == 0) {
				str[i] = "FizzBuzz, ";
			}
			else if ((i+1) % 3 == 0 ) {
				str[i] = "Fizz, ";
			}
			else if ((i+1) % 5 == 0) {
				str[i] = "Buzz, ";
			}
			else {
				str[i] = (i+1) + ", ";
			}
		}
		
		
		return str;
	}
	
	//Check that the length of two diffrent game is the same
	public boolean equalsLength(FizzBuzz fb2) {
		FizzBuzz fb = fb2;
		return this.n == fb.n;
	}
	
	//Check that the diffrent games has the same words and numbers used
	public boolean equalsStrArr(FizzBuzz fb2) {
		FizzBuzz fb = fb2;
		String str1 = "";
		String str2 = "";
		for (int i = 0; i < fb.getLength(); i++) {
			str1 += fb2.StartGame()[i];
			str2 += this.StartGame()[i];
		}
		return str1.equals(str2);
	}
	
	public int getLength() {return this.n;}


	
}
