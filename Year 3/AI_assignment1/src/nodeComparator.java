import java.util.Comparator;

//Moran Arzi 200244945
//Almog Fadida 315544437

public class nodeComparator implements Comparator<node>{

	@Override
	public int compare(node node1, node node2) {

		return node1.getPathCost() - node2.getPathCost();

		
	}

}
