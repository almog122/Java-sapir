package q1_FizzBuzz;

import junit.framework.*;

public class FizzBuzzTest extends TestCase {
	
	//Check that the Fizz location are indeed Fizz
	public void testFizzBuzzModThree() {
		FizzBuzz fb = new FizzBuzz(7);
		for(int i = 0; i < fb.getLength(); i++) {
			if((i+1) % 3 == 0)
				assertEquals("Fizz, ", fb.StartGame()[i]);
		}
	}
	
	//Check that the Buzz location are indeed Buzz
	public void testFizzBuzzModFive() {
		FizzBuzz fb = new FizzBuzz(11);
		for(int i = 0; i < fb.getLength(); i++) {
			if((i+1) % 5 == 0)
				assertEquals("Buzz, ", fb.StartGame()[i]);
		}
	}
	
	//Check that the FizzBuzz location are indeed FizzBuzz
	public void testFizzBuzzModThreeFive() {
		FizzBuzz fb = new FizzBuzz(15);
		for(int i = 0; i < fb.getLength(); i++) {
			if((i+1) % 5 == 0 &&(i+1) % 3 == 0)
				assertEquals("FizzBuzz, ", fb.StartGame()[i]);
		}
	}
	
	//Check that the two games has the same legnth
	public void testSizeEquality() {
		FizzBuzz fb1 = new FizzBuzz(6);
		FizzBuzz fb2 = new FizzBuzz(6);
		assertTrue(fb1.equalsLength(fb2));
	}
	
	//Check that the two games are the same
	public void testStringArrEquality() {
		FizzBuzz fb1 = new FizzBuzz(7);
		FizzBuzz fb2 = new FizzBuzz(7);
		assertTrue(fb1.equalsStrArr(fb2));
	}


}
