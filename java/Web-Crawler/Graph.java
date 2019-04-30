import java.util.List;
class Graph {
    //Map of adjacency lists for each node
	HashMap<Integer, List<Integer>> adj;
	HashMap<Integer, Node> idNodeConnections = new HashMap<>();
    public Graph() {
        adj = new HashMap<Integer, List<Integer>>();
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