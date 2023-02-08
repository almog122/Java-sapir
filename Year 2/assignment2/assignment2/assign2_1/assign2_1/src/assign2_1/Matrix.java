package assign2_1;

public class Matrix {

	private int ourRow;
	private int ourCol;
	private int mat[][];
	
	//sum of matrix
	private int matrixSum; //the shared source
		
	 public synchronized int getMatrixSum() {
		return matrixSum;
	}
		
	 public synchronized void setMatrixSum(int matrixSum) {
		this.matrixSum = matrixSum;
	 }
	
	 public synchronized void addMatrixSum(int add) {
		this.matrixSum += add;
	}
	 
	public int getOurRow() {
		return ourRow;
	}
		
	public void setOurRow(int ourRow) {
		this.ourRow = ourRow;
	}
	
	public int getOurCol() {
		return ourCol;
	}
		
	public void setOurCol(int ourCol) {
		this.ourCol = ourCol;
	}
	
	public int[][] getmat() {
		return mat;
	}
	
	
	//constractor to create 2d matrix
	Matrix (int ourRow, int ourCol){ //or without public?
		
		setOurRow(ourRow);//or to put each one into set function instead?
		setOurCol(ourCol);
		mat = new int [ourRow][ourCol];
	}
	
	
	//method fill
	public void fill() {
		
		int i, j;
		
		for(i = 0; i < ourRow; i++) { 
			for(j = 0; j < ourCol; j++) {
				
				mat[i][j] = 1;
				
			}
		}
		
		
	} //end fill function
	
	//method calc to calculate the sum of matrix the put inside matrixSum
	//we assume the value inside every box is always 1;
	
	 public int calc() { 
		 
		setMatrixSum(ourRow * ourCol);
		return matrixSum;	
	}
	
	
}//end of Matrix class
