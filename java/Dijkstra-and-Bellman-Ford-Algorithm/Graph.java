import java.util.ArrayList;
import java.util.List;


class Graph {
    //Map of adjacency lists for each node
	HashMap<String, List<Node>> adj;
	HashMap<String, Node> idNodeConnections = new HashMap<>();
    public Graph(String[] nodes) {
        adj = new HashMap<String, List<Node>>();
        for (int i = 0; i < nodes.length; i++) {
        	adj.put(nodes[i], new ArrayList<Node>());
        	idNodeConnections.put(nodes[i], new Node(nodes[i]));
        }
    }

    public void addNeighbor(String v1, Node neighbor) {
    	adj.get(v1).add(neighbor);
    }
    public  Node getNode(String nodeKey){
		return idNodeConnections.get(nodeKey);
	}

}