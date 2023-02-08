import java.util.Scanner;

public class TaskA
{
	public static Scanner sc = new Scanner(System.in);
	
	public static int BOARD_SIZE = 10;
	
	public static char[][] board = null;
	
	public static void print_board()
	
	{
		if (board == null)
			System.out.println("Null board");
		else
		{
			for (int i = 0; i < board.length; i++)
			{
				for (int j = 0; j < board[i].length; j++)
				{
					System.out.print(" " + String.valueOf(board[i][j]) + " ");
				}
				System.out.println();
			}
		}
	}
	
	public static void update_board0()
	{
		if (board == null)
		{
			board = new char[BOARD_SIZE][BOARD_SIZE];
			
			for (int i = 0; i < board.length; i++)
			{
				for (int j = 0; j < board[i].length; j++)
				{
					board[i][j] = '=';
				}
			}
		}
	}
	
	public static void make_board() 
	{
		int tempRow,tempCol;
		
		for(int i = 0; i < board.length; i++) 
		{
			for(int j = 0; j < board[i].length; j++)
			{
				board[i][j] = (char) (int) (Math.random() * 5 + '1');
				
				if(j > 2)
					
					if(board[i][j] == board[i][j-1] && board[i][j] == board[i][j-2]) {
						
						tempRow = board[i][j-2];
						
						while(tempRow == board[i][j-2])
							board[i][j-2] = (char) (int) (Math.random() * 5 + '1');
		
					}
				
				if(i > 2) {
					
					if(board[i][j] == board[i-1][j] && board[i][j] == board[i-2][j]) {
							
						tempCol = board[i-2][j];
							
						while(tempCol == board[i-2][j])
							board[i-2][j] = (char) (int) (Math.random() * 5 + '1');	
					}	
				}		
			}
		}
	}
	

	public static void main(String[] args)
	{
		update_board0();
		make_board();
		print_board();
	}
}