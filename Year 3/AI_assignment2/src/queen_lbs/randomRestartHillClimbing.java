package queen_lbs;

//Moran Arzi 200244945
//Almog Fadida 315544437

import java.util.ArrayList;
import java.util.Collections;

public class randomRestartHillClimbing {

	
	char[][] createBoard(int boardSize) {
		
		char[][] board = new char[boardSize][boardSize];
		
		int queenLocation , queenNumber , queenRand;

		queenNumber = boardSize;
		
		ArrayList<Integer> list = new ArrayList<Integer>(boardSize);
	    for(int i = 0; i < boardSize; i++) {
	         list.add(i);
	    }
	    
		for(int i = 0; i < boardSize; i++) {
			for(int j = 0; j < boardSize; j++) {
				
				board[i][j] = 'X';		
			}
		}
		
		Collections.shuffle(list);
		while(queenNumber > 0) {
			queenRand = (int) ((Math.random() * boardSize));
			queenLocation = list.remove(0);
			Collections.shuffle(list);
			
			board[queenRand][queenLocation] = 'Q';
			
			queenNumber--;
		}
		
		
		return board;
	}
	
	
	void printBoard(char[][] board) {
		
		for(int i = 0; i < board.length; i++) {
			
			
			for(int j = 0; j < board[i].length; j++) {
				
				System.out.print(board[i][j] + " ");
				
			}
			System.out.println();
		}
	}
	
	int heuristicCost(char[][] board) {
		
		int cost = 0;
		int attFront;
		int attDiagonalLineUp;
		int attDiagonalLineDown;
		
		for(int i = 0; i < board.length; i++) {
			
			for(int j = 0; j < board[i].length; j++) {
				if(board[i][j] == 'Q') {
					attFront = j + 1;
					attDiagonalLineUp = i + 1;
					attDiagonalLineDown = i - 1;
					
					while(attFront < board[i].length) {
						if(board[i][attFront] == 'Q') {
							cost++;
						}
						attFront++;
					}
					
					attFront = j + 1;
					while(attDiagonalLineUp < board.length && attFront < board[i].length) {
						
						if(board[attDiagonalLineUp][attFront] == 'Q') {
							cost++;
						}
						attFront++;
						attDiagonalLineUp++;
					}
					
					attFront = j + 1;
					while(attDiagonalLineDown >= 0 && attFront < board[i].length) {
						if(board[attDiagonalLineDown][attFront] == 'Q') {
							cost++;
						}
						attFront++;
						attDiagonalLineDown--;
					}
				}
				
				
			}
		}
		
		return cost;
		
	}
	
	char[][] bestMoveBoard(char[][] board) {
		
		int bestHeuristicCost , queenIndexI ,queenIndexJ , direction;
		
		queenIndexI = 0;
		queenIndexJ = 0;
		direction = 0;
		bestHeuristicCost = heuristicCost(board);
		
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[i].length; j++) {
				
				if(board[i][j] == 'Q') {
					
					if(i + 1 < board.length) {
						board[i + 1][j] = 'Q';
						board[i][j] = 'X';
					
						if ( bestHeuristicCost > heuristicCost(board)) {
						
							bestHeuristicCost = heuristicCost(board);	
							queenIndexI = i;
							queenIndexJ = j;
							direction = 1;
						}
						
						board[i + 1][j] = 'X';
						board[i][j] = 'Q';
					}
					
					if(i - 1 > board.length) {
						board[i - 1][j] = 'Q';
						board[i][j] = 'X';
					
						if ( bestHeuristicCost > heuristicCost(board)) {
						
							bestHeuristicCost = heuristicCost(board);	
							queenIndexI = i;
							queenIndexJ = j;
							direction = -1;
						}
					
						board[i][j] = 'Q';
						board[i - 1][j] = 'X';
					
					}
					
				}
			}
		}
		
		if(direction != 0) {
			board[queenIndexI + direction][queenIndexJ] = 'Q';
			board[queenIndexI][queenIndexJ] = 'X';
		}
		
		return board;
	}
	
	void HillClimbing(int boardSize , int repeatNum) {
		
		int repeat ,stepNum , currentHeuristicCost;
		
		repeat = 1;
	
		char[][] board;
		
		while(repeatNum > 0) {
			
			stepNum = 0;
			board = createBoard(boardSize);
			
			currentHeuristicCost = heuristicCost(board);
			
			System.out.println("Restart " + repeat + " Step "+ stepNum + " -------- ");
			printBoard(board);
			
			System.out.println("Score = " + currentHeuristicCost);
			System.out.println("  --------- ");
			
			board = bestMoveBoard(board);
			
			while(currentHeuristicCost > heuristicCost(board) || currentHeuristicCost == 0) {
				
				
				stepNum ++;
				
				currentHeuristicCost = heuristicCost(board);
				
				System.out.println("Restart " + repeat + " Step "+ stepNum + " -------- ");
				printBoard(board);
				
				System.out.println("Score = " + currentHeuristicCost);
				System.out.println("    --------- ");
				
				if(currentHeuristicCost == 0 || heuristicCost(board) == 0) {
					System.out.println("SOLUTION  " + stepNum);
					return;
				}
				
				board = bestMoveBoard(board);
				
			}
			System.out.println();
			System.out.println(" RESTART ");
			System.out.println();
			
			repeat++;
			repeatNum--;
		}
		
		
		System.out.println("Fail after " + --repeat +" restarts");
		
		
	}
	


}