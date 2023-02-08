//Moran Arzi 200244945
//Almog Fadida 315544437

public class node {
	
	private int state;// the state in the state space to which the node corresponds
	private node parent; //  the node in the search tree that generated this node
	private String action = ""; //the action that was applied to the parent to generate the node
	private int pathCost = 0; // the cost of the path from the initial state to the node
	
	
	//constructor
	public node(int state, node parent, String action, int pathCost) {
		this.state = state;
		this.parent = parent;
		this.action = action;
		this.pathCost = pathCost;
	}
	
	//Setters
	public void setState(int state) {
		this.state = state;
	}
	
	public void setParent(node parent) {
		this.parent = parent;
	}
	
	public void setAction(String action) {
		this.action = action;
	}
	
	public void setPathCost(int pathCost) {
		this.pathCost = pathCost;
	}
	
	//Gettrs
	
	public int getState() {
		return this.state;
	}
	
	public node getParent() {
		return this.parent;
	}
	
	public String getAction() {
		return this.action;
	}
	
	public int getPathCost() {
		return this.pathCost;
	}
	
	
	
	public node childNode(int state, String action, int pathCost) {
		
		return new node(state, this, this.action + " ->" + action, this.pathCost + pathCost);
	}
}
