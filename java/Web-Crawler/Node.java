public class Node {
	private Integer data;
	private Node parent;
	private String color;
	private Integer lengthEdge;
	private Integer endLengthEdge;

	public Node(int data) {
		this.data = data;
		this.color = "";
		this.lengthEdge = 0;
		this.endLengthEdge = 0;
	}
	public Integer getEndLengthEdge() {
		return endLengthEdge;
	}

	public void setEndLengthEdge(Integer endLengthEdge) {
		this.endLengthEdge = endLengthEdge;
	}

	public Integer getLengthEdge() {
		return lengthEdge;
	}

	public void setLengthEdge(Integer lengthEdge) {
		this.lengthEdge = lengthEdge;
	}

	public Integer getData() {
		return data;
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	public static Node getNode(int nodeKey, Graph graph) {
		return graph.idNodeConnections.get(nodeKey);
	}
}
