
public class Node {
	private String data;
	private Node parent;
	private Integer weightEdge;
	private Integer lengthEdge;

	public Node(String data) {
		this.data = data;
		this.lengthEdge = 100000;
		this.parent = null;
	}
	public Node(String data, int weightEdge) {
		this.data = data;
		this.lengthEdge = 100000;
		this.weightEdge  = weightEdge;
	}
	public Integer getLengthEdge() {
		return lengthEdge;
	}
	public void setLengthEdge(Integer lengthEdge) {
		this.lengthEdge = lengthEdge;
	}
	public void setWeightEdge(Integer weightEdge) {
		this.weightEdge = weightEdge;
	}
	public Integer getWeightEdge() {
		return weightEdge;
	}

	public String getData() {
		return data;
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((lengthEdge == null) ? 0 : lengthEdge.hashCode());
		result = prime * result + ((parent == null) ? 0 : parent.hashCode());
		result = prime * result + ((weightEdge == null) ? 0 : weightEdge.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (lengthEdge == null) {
			if (other.lengthEdge != null)
				return false;
		} else if (!lengthEdge.equals(other.lengthEdge))
			return false;
		if (parent == null) {
			if (other.parent != null)
				return false;
		} else if (!parent.equals(other.parent))
			return false;
		if (weightEdge == null) {
			if (other.weightEdge != null)
				return false;
		} else if (!weightEdge.equals(other.weightEdge))
			return false;
		return true;
	}
}
