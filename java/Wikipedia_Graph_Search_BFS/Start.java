
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;


public class Start {


	public static void main(String[] args) throws IOException {
		StringIntConverter converter = new StringIntConverter();
		Graph graph2 = new Graph();
		FileInputStream inputStream = null;
		Scanner sc = null;
		try {
			inputStream = new FileInputStream("plwiki.txt");
			sc = new Scanner(inputStream, "UTF-8");
			int node = 0;
			List<Integer> neighbors = null;
			while (sc.hasNext()) {
				String line = sc.nextLine();
				line = line.toLowerCase();
				line = line.replace("\uFEFF", "");// remove ? from this
													// string(this is a bug of
													// UTF-8 in java)
				if (Character.isWhitespace(line.charAt(0))) {
					neighbors.add(converter.convertToNumber(line.trim()));
				} else {
					node = converter.convertToNumber(line.trim());
					neighbors = new ArrayList<>();
					graph2.addNode(node, neighbors);
				}
			}
		} catch (Exception ex) {
			System.out.println(ex);
		} finally {
			if (inputStream != null) {
				inputStream.close();
			}
			if (sc != null) {
				sc.close();
			}
		}
		System.out.println("Start page?");
		Scanner in = new Scanner(System.in);
		String startV = in.nextLine().toLowerCase();
		int startVInt = converter.getNumberByText(startV);
		System.out.println("Destination page?");
		String endV = in.nextLine().toLowerCase();
		int endVInt = converter.getNumberByText(endV);

		bfs(graph2, startVInt, endVInt, converter);
		in.close();

	}

	public static void bfs(Graph graph, int startV, int endV, StringIntConverter converter) {
		Node startNode = getNode(startV, graph);
		startNode.setColor("grey");
		startNode.setLengthEdge(0);
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(startV);


		while (!queue.isEmpty()) {
			int u = queue.poll();
			Node parent = getNode(u, graph);


			List<Integer> edges = graph.adj.get(u);
			for (int i = 0; i < edges.size(); i++) {

				int v = edges.get(i);

				if (!graph.existNode(v)) {
					graph.deleteEdge(u, i);
					i--;
					continue;
				}
				Node currentNode = getNode(v, graph);
				if (currentNode.getColor() == "") {
					currentNode.setColor("grey");
					currentNode.setParent(parent);
					currentNode.setLengthEdge(parent.getLengthEdge() + 1);

					queue.add(v);
				}
			}
			parent.setColor("black");
		}

		List<Node> output = new ArrayList<>();
		Node currentNode = getNode(endV, graph);
		output.add(currentNode);

		while(currentNode.getData() != startNode.getData()){
				currentNode = currentNode.getParent();
				output.add(currentNode);
		}

		System.out.println("Path length: " +(output.size()-1));
		for (int i = output.size() - 1; i >= 0; i--) {
			System.out
					.println("[" + output.get(i).getLengthEdge()+ "] " + converter.getOriginText(output.get(i).getData()));
		}
	}

	public static Node getNode(int nodeKey, Graph graph){
		return graph.idNodeConnections.get(nodeKey);
	}
}
