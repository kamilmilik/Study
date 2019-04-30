public class Node {
	private Integer data;
	private Node parent;
	private String color;
	private Integer lengthEdge;

	public Node(int data) {
		this.data = data;
		this.color = "";
		this.lengthEdge = 0;
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
}
