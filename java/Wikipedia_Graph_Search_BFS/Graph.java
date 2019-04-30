import java.util.Map;
import java.util.Queue;
import java.util.List;
import java.util.HashMap;
import java.util.LinkedList;
class Graph {
    //Map of adjacency lists for each node
    Map<Integer, List<Integer>> adj;
    Map<Integer, Node> idNodeConnections = new HashMap<>();
    public Graph() {
        //to make the indexing easier we will allocate an array of adjacency one element larger than necessary
        adj = new HashMap<Integer, List<Integer>>(766092 * 2 + 1);
    }
    public void addNode(int nodes, List<Integer> neighbors){
    		adj.put(nodes, neighbors);
    		idNodeConnections.put(nodes, new Node(nodes));
    }
    public void addNeighbor(int v1, int v2) {
    	adj.get(v1).add(v2);
    }

    public List<Integer> getNeighbors(int v) {
        return adj.get(v);
    }

	public boolean existNode(int key) {
		return adj.containsKey(key);
	}
	public void deleteEdge(int nodeKey, int edgeIndex){
		adj.get(nodeKey).remove(edgeIndex);
	}
}