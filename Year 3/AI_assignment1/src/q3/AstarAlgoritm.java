package q3;

import java.util.PriorityQueue;
import java.util.Queue;

//Moran Arzi 200244945
//Almog Fadida 315544437

public class AstarAlgoritm {
	
	private char[] problem;
	
	private int emptySquareIndex;

	//constructor
	AstarAlgoritm(char[] problem){
		
		this.problem = problem;
		
		setEmptySquareIndex();
		
	}
	
	//setters
	void setState(char[] state) {
		this.problem = state;
	}
	
	void setEmptySquareIndex() {
		
		for(int i = 0; i < problem.length; i++) {
			if(this.problem[i] == 'O') {
				emptySquareIndex = i;
			}
		}		
	}

	
	//functions
	
	//The number of white squares to the left of one or more black squares.
	int heuristicCost(char[] problem) {
		
		int hCost = 0;
		
		for(int i = 0; i < problem.length; i++) {
			if(problem[i] == 'W') {
				for(int j = i; j >= 0; j--) {
					if(problem[j] == 'B') {
						hCost++;
						break;
					}
				}
			}
		}
			
		return hCost;
		
	}
	
	//the distance between the index given block and the empty block
	int moveCost(int index) {
		
		//near or 1 block away from empty
		if(Math.abs(index - emptySquareIndex) >= 1 &&  Math.abs(index - emptySquareIndex) <= 2) {
			return 1;
		}
		//2 block away from empty
		if(Math.abs(index - emptySquareIndex) == 3) {
			return 2;
		}
		
		//3 or more block away from empty
		return -1;
		
	}
	
	
	int squareProblem() {

		Queue<node> q = new PriorityQueue<node>(new nodeComparator());
		
		char[] tempProblem = new char[problem.length];
		
		tempProblem = problem.clone(); //so that every node get its own state of the problem
		
		for(int i = 0 ; i < problem.length; i++) {
			if(moveCost(i) != -1) {
				
				tempProblem[emptySquareIndex] = problem[i];
				
				tempProblem[i] = 'O';
		
				q.add( new node(tempProblem,
						emptySquareIndex,
						i,
						"Switching " + problem[i] + " in index " + i  +" and blank in index " + emptySquareIndex ,
						moveCost(i)  + heuristicCost(tempProblem),
						moveCost(i)
						));
			}
			tempProblem = problem.clone();
		}
		
		System.out.println(problem);
		
		int optimalTotalCost = 999;
		
		while(!(q.isEmpty())) {
			
			
			node temp = q.poll();
			
			if(optimalTotalCost > temp.getTotalCost()) {
				optimalTotalCost = temp.getTotalCost();
			}
			
			emptySquareIndex = temp.getBlankLocation();
			problem = temp.getState();
			
			System.out.println(temp.getAction());
			System.out.println("Cost of this action is: " + moveCost(temp.getMyLocation()));
			System.out.println("Total cost so far is: " + temp.getTotalCost());
						
			if(heuristicCost(temp.getState()) != 0 && temp.getTotalCost() <= 28) { //if the number of white squares to the left of one or more black squares is 0.
					
				tempProblem = problem.clone();
			
				for(int i = 0 ; i < problem.length; i++) {
					if(moveCost(i) != -1) {
					
						tempProblem[emptySquareIndex] = problem[i];
					
						tempProblem[i] = 'O';
					
						q.add(temp.childNode(tempProblem,
								emptySquareIndex,
								i,
								"Switching " + problem[i] + " in index " + i  +" and blank in index " + emptySquareIndex ,
								moveCost(i)  + heuristicCost(tempProblem),
								moveCost(i)
								));
					}
					tempProblem = problem.clone();
				}
			
				System.out.println();
				System.out.println(temp.getState());
			}
		}
		
		System.out.println("Solution found, lowest cost possible is: " + optimalTotalCost);
		
		return -1;
		
		
	}
	
	
}
