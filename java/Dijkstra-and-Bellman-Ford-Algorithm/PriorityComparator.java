import java.util.Comparator;

public class PriorityComparator implements Comparator<Object> {

	@Override
	public int compare(Object o1, Object o2) {
		Node a1 = (Node)o1;
        Node a2 = (Node)o2;

        return Integer.compare(a1.getLengthEdge(), a2.getLengthEdge());
	}

}
