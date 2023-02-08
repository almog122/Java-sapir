package assign2_1;

public class Main {

	public static void main(String[] args) {
		
		Matrix myMat  = new Matrix (3, 100); //3 = ourRow, 100 = ourCol
		myMat.fill();
		myMat.calc();
		System.out.println(myMat.getMatrixSum()); //print result of sidratit
		myMat.setMatrixSum(0);
		
		//creating Threads = to see makbilit result
		
		MatrixCounter m1 = new MatrixCounter (0, myMat);
		MatrixCounter m2 = new MatrixCounter (1, myMat);
		MatrixCounter m3 = new MatrixCounter (2, myMat);
		
		Thread t1 = new Thread(m1);
		Thread t2 = new Thread(m2);
		Thread t3 = new Thread(m3);
		
		t1.start();
		t2.start();
		t3.start();
		
		//wait until all threads will be done and then print final result
		try {
			t1.join();
			t2.join();
			t3.join();
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(myMat.getMatrixSum()); //print result of makbilit
		
	} //end main function

} //end class Main
