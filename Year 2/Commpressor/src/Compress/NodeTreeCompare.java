package Compress;

import java.util.Comparator;

public class NodeTreeCompare implements Comparator<NodeTree> {


    @Override
    public int compare(NodeTree N1, NodeTree N2) { //A compare for the Heap
        return N1.frequency - N2.frequency;
    }
}
