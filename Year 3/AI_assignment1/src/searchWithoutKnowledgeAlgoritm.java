import java.util.Iterator;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
//Moran Arzi 200244945
//Almog Fadida 315544437

public class searchWithoutKnowledgeAlgoritm {
	
	int[][] costOperation;
	
	searchWithoutKnowledgeAlgoritm(int[][] costOperation){
		this.costOperation = costOperation;
	}
	
	//BFS
	public int bfsAlgorithmSearch(int[][] costOperation , int firstNode , int lastNode) {
		
		Queue<node> q = new LinkedList<node>();
		
		node startNode = new node(firstNode, null, String.valueOf((char) (firstNode + 'A')) , 0);
		
		boolean[] visited = new boolean[costOperation.length];
		
		q.add(startNode);
		visited[firstNode] = true;
		
		while(!(q.isEmpty())) {
			
			node temp = q.poll();
			
			System.out.println("q1 : " + (char) (temp.getState() + 'A'));
			
			if(temp.getState() == lastNode) {
				System.out.println("action : " + temp.getAction());
				return temp.getPathCost();
			}
			
			for(int i = 0; i < costOperation.length; i++) {
				if(costOperation[temp.getState()][i] != -1 && !(visited[i])) {
					q.add(temp.childNode(i, String.valueOf((char) (i + 'A')) , costOperation[temp.getState()][i]));
					visited[i] = true;
				}
			}
			
		}
		
		return -1; // fail
		
	}
	
	//UCS
	public int ucsAlgorithmSearch(int[][] costOperation , int firstNode , int lastNode) {
		
		Queue<node> q = new PriorityQueue<node>(new nodeComparator());
		
		node startNode = new node(firstNode, null, String.valueOf((char) (firstNode + 'A')) , 0);
		
		boolean[] visited = new boolean[costOperation.length];
		
		q.add(startNode);
		visited[firstNode] = true;
		
		while(!(q.isEmpty())) {
			
			node temp = q.poll();
			
			System.out.println("q2 : " + (char) (temp.getState() + 'A'));
			
			if(temp.getState() == lastNode) {
				System.out.println("action : " + temp.getAction());
				return temp.getPathCost();
			}
			
			visited[temp.getState()] = true;
			
			for(int i = 0; i < costOperation.length; i++) {
				if(costOperation[temp.getState()][i] != -1 && !(visited[i])) {
					q.add(temp.childNode(i, String.valueOf((char) (i + 'A')) , costOperation[temp.getState()][i]));
				}
			}
			
		}
		
		return -1;
	}
	
	//DFS
	public int dfsAlgorithmSearch(int[][] costOperation , int firstNode , int lastNode) {
		
		LinkedList<node> q = new LinkedList<node>();
		
		node startNode = new node(firstNode, null, String.valueOf((char) (firstNode + 'A')) , 0);
			
		boolean[] visited = new boolean[costOperation.length];
			
		q.add(startNode);
		visited[firstNode] = true;
			
		while(!(q.isEmpty())) {
				
			node temp = q.poll();
				
			System.out.println("q3 : " + (char) (temp.getState() + 'A'));
				
			if(temp.getState() == lastNode) {
				System.out.println("action : " + temp.getAction());
				return temp.getPathCost();
			}
				
			for(int i = costOperation.length - 1; i >= 0 ; i--) {
				if(costOperation[temp.getState()][i] != -1 && !(visited[i])) {
					q.addFirst(temp.childNode(i,String.valueOf((char) (i + 'A')) , costOperation[temp.getState()][i]));
					visited[i] = true;
				}
			}
		}
			
		return -1;
	}
	
	
}
