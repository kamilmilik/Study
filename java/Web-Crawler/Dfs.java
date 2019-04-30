import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Dfs {

	static HashSet<String> emailsSet = new HashSet<String>();
	// URL Pattern regex
	static String linkRegex = "http[s]*://(\\w+\\.)*(\\w+)";

	static String emailRegex = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?";

	static List<Integer> neighborsList = null;

	static List<Integer> dfsVertexList = new ArrayList<Integer>();

	static int dfsTime = 0;

	// DFS Routine
	static int countWhenEndDfsProgram = 1;

	public static void dfs(Graph graph, int startV, StringIntConverter converter) throws IOException {
		dfsVertexList.add(startV);
		for (int i = 0; i < dfsVertexList.size(); i++) {
			if (countWhenEndDfsProgram >= 100)
				return;
			int currentVertex = dfsVertexList.get(i);
			Node currentNode = Node.getNode(currentVertex, graph);
			Node parent = Node.getNode(currentVertex, graph);
			if (currentNode.getColor() == "") {
				dfsVisit(graph, currentVertex, converter, parent);
			}
		}
	}

	static int numberWrongDfsLinks = 1;

	public static void dfsVisit(Graph graph, int currentVertex, StringIntConverter converter, Node parent)
			throws IOException {
		URL url = null;
		BufferedReader br = null;
		try {
			url = new URL(converter.getOriginText(currentVertex));
			br = new BufferedReader(new InputStreamReader(url.openStream()));
		} catch (MalformedURLException e) {
			System.out.println("\nMalformedURL : " + converter.getOriginText(currentVertex) + "\n");
			numberWrongDfsLinks++;

			dfsTime--;
			dfsVertexList.remove(dfsVertexList.indexOf(currentVertex));
			currentVertex = parent.getData();
			return;
		} catch (IOException e) {
			System.out.println("\nIOException for URL : " + converter.getOriginText(currentVertex) + "\n");
			numberWrongDfsLinks++;

			dfsTime--;
			dfsVertexList.remove(dfsVertexList.indexOf(currentVertex));
			currentVertex = parent.getData();
			return;
		}
		System.out.println("The number of crawled pages: " + countWhenEndDfsProgram);
		System.out.println("\n=== Site crawled : " + converter.getOriginText(currentVertex) + " ===");
		countWhenEndDfsProgram++;
		String stringAddress = EmailsAndLinksOperation.readSourceCodePage(currentVertex, converter, br);
		Node startNode = Node.getNode(currentVertex, graph);
		parent = Node.getNode(currentVertex, graph);
		dfsTime++;
		startNode.setLengthEdge(dfsTime);
		startNode.setColor("gray");
		// We search for email
		EmailsAndLinksOperation.searchEmailAndAddToSet(stringAddress, emailsSet);

		Pattern linkPattern = Pattern.compile(linkRegex);
		Matcher linkMatcher = linkPattern.matcher(stringAddress);

		while (linkMatcher.find() && countWhenEndDfsProgram < 100) {
			String currentLink = linkMatcher.group();
			if (!converter.wasThisTextConvertedBefore(currentLink)) {

				// remove unndeeded links like http://google
				if (EmailsAndLinksOperation.deleteWrongLink(currentLink)) {

					int neighbor = converter.convertToNumber(currentLink);
					dfsVertexList.add(neighbor);
					graph.addNeighbor(currentVertex, neighbor);

					neighborsList = new ArrayList<Integer>();
					graph.addNode(neighbor, neighborsList);
					Node currentNode = Node.getNode(neighbor, graph);
					if (currentNode.getColor() == "") {
						currentNode.setParent(parent);
						System.out.println("Site added for crawling : " + converter.getOriginText(neighbor));
						if (countWhenEndDfsProgram >= 100) {
							return;
						}
						dfsVisit(graph, neighbor, converter, parent);
					}
				}
			}
		}
		startNode.setColor("black");
		dfsTime++;
		startNode.setEndLengthEdge(dfsTime);
	}

}