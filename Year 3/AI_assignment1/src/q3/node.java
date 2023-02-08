package q3;

//Moran Arzi 200244945
//Almog Fadida 315544437

public class node {
	
	private char[] state;// the state in the state space to which the node corresponds
	private int myLocation; //location of the 'B' or 'W'
	private int blankLocation; // location of the 'O'
	private String action; //the action that was applied to the state to generate the node
	private int f = 0; // the cost of h(n) + g(n)
	private int totalCost = 0; // total cost of the actions
	
	//constructor
	public node(char[] state, int myLocation,int blankLocation ,String action, int f , int totalCost) {
		this.state = state;
		this.myLocation = myLocation;
		this.action = action;
		this.f = f;
		this.totalCost = totalCost;
		this.blankLocation = blankLocation;
	}
	
	//Setters
	public void setState(char[] state) {
		this.state = state;
	}
	
	public void setMyLocation(int myLocation) {
		this.myLocation = myLocation;
	}
	
	public void setAction(String action) {
		this.action = action;
	}
	
	public void setF(int f) {
		this.f = f;
	}
	
	public void setTotalCost(int totalCost) {
		this.totalCost = totalCost;
	}
	
	public void setBlankLocation(int blankLocation) {
		this.blankLocation = blankLocation;
	}
	
	//Gettrs
	
	public char[] getState() {
		return this.state;
	}
	
	public int getMyLocation() {
		return this.myLocation;
	}
	
	public String getAction() {
		return this.action;
	}
	
	public int getF() {
		return this.f;
	}
	
	public int getTotalCost() {
		return totalCost;
	}
	
	public int getBlankLocation() {
		return blankLocation;
	}
	
	
	public node childNode(char[] state,int myLocation,int blankLocation ,String action, int f, int actionCost) {
		
		return new node(state, myLocation, blankLocation ,action, f ,totalCost + actionCost );
	}


}
