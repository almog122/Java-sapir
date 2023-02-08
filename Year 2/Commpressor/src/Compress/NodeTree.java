package Compress;

import java.util.Comparator;
import java.util.PriorityQueue;

//Almog fadida 315544437
//Ariel simantov 207366865

public class NodeTree implements Comparator<NodeTree> {
    
	NodeTree rightNode;
    NodeTree leftNode;
    int frequency;
    char ch;
    
    //Constructor

    public NodeTree(NodeTree rightNode, NodeTree leftNode, int frequency, char ch){
        this.rightNode = rightNode;
        this.leftNode = leftNode;
        this.frequency = frequency;
        this.ch = ch;

    }

    public boolean Isleaf(){ //Check if the Node is a leaf in the tree
        return (rightNode == null && leftNode == null);
    }
    
    public int countLeafs(NodeTree root) { //Count the amount of leaf (character) in the tree
    	
    	if(root.Isleaf()) {
    		return 1;
    	}
    	
    	else {
    		return countLeafs(root.leftNode) + countLeafs(root.rightNode);
    		
    	}
    	
    }

    @Override
    public int compare(NodeTree N1, NodeTree N2) { //Compare two Nodes who has the bigger character frequency
        return N1.frequency - N2.frequency;
    }

    public NodeTree createTree(int[] freq){//Gets the frequency of every character 
    	
    	//A min heap for the two minimum frequency Nodes we need to take
        PriorityQueue<NodeTree> minHeap = new PriorityQueue<NodeTree>(new NodeTreeCompare());

        for (int i = 0; i < freq.length; i++) {

            if (freq[i] > 0) { //If the character appear in the File

                minHeap.add(new NodeTree(null, null, freq[i], (char) i)); //character get a node with her frequency
            }															
        }

        while (minHeap.size() > 1) { //Do it as long as there are more then 1 Node in the heap
        	
            NodeTree left = minHeap.poll(); //Take the Node with the lowest frequency currently
            
            NodeTree right = minHeap.poll(); //Take the Node with the lowest frequency currently
            
            //Create a new Node that is the combined frequency of them with them being the children
            NodeTree parent = new NodeTree(right, left, left.frequency + right.frequency, '\0');
           
            minHeap.add(parent); //Add the new Node to the heap
        }

        return (minHeap.poll()); // Return the Highest frequency Node
    }
}
