package assign2_1;

public class MatrixCounter implements Runnable {
	
	
	private int row;
	private Matrix matrix;
	
	
	//constractor
	MatrixCounter(int row, Matrix matrix) { //or without public?
		
		this.row = row;
		this.matrix = matrix;
	}
	
	public void run() {
		
		int rowSum = 0;
		
		for(int i = 0; i < matrix.getOurCol(); i++) {
			rowSum += matrix.getmat()[row][i]; 
		}
		
		matrix.addMatrixSum(rowSum);
		
		
	} //end of run function

}
