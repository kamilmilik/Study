import java.util.Map;
import java.util.Queue;
import java.util.List;
import java.util.HashMap;
import java.util.LinkedList;
class Graph {
    //Map of adjacency lists for each node
    Map<String, LinkedList<String>> adj;
    public Graph(String[] nodes) {
        //to make the indexing easier we will allocate an array of adjacency one element larger than necessary
        adj = new HashMap<String, LinkedList<String>>();
        for (int i = 0; i < nodes.length; ++i) {
        	adj.put(nodes[i], new LinkedList<String>());
        }
    }

    public void addNeighbor(String v1, String v2) {
    	adj.get(v1).add(v2);
    }

    public List<String> getNeighbors(String v) {
        return adj.get(v);
    }
}
