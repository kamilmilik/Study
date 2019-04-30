import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Bfs {

	static HashSet<String> emailsSet = new HashSet<String>();
	// URL Pattern regex
	static String linkRegex = "http[s]*://(\\w+\\.)*(\\w+)";

	static String emailRegex = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?";

	static List<Integer> neighborsList = null;
	// BFS Routine
	static int countWhenEndBfsProgram = 1;
	static int numberWrongBfsLinks = 1;

	public static void bfs(Graph graph, int startV, StringIntConverter converter) throws IOException {
		Node startNode = Node.getNode(startV, graph);
		startNode.setColor("grey");
		startNode.setLengthEdge(0);
		MyQueue<Integer> queue = new QueueLinkedList<>();
		queue.enqueue(startV);
		while (!queue.isEmpty()) {
			int currentVertex = queue.dequeue();
			Node parent = Node.getNode(currentVertex, graph);
			// Find only almost 100 websites.
			if (countWhenEndBfsProgram >= 100)
				return;

			boolean ok = false;
			URL url = null;
			BufferedReader br = null;

			while (!ok) {
				try {
					url = new URL(converter.getOriginText(currentVertex));
					br = new BufferedReader(new InputStreamReader(url.openStream()));
					ok = true;
				} catch (MalformedURLException e) {
					System.out.println("\nMalformedURL : " + converter.getOriginText(currentVertex) + "\n");
					numberWrongBfsLinks++;
					// Get next URL from queue
					if (!queue.isEmpty()) {
						currentVertex = queue.dequeue();
						parent = Node.getNode(currentVertex, graph);
					}
					ok = false;
				} catch (IOException e) {
					System.out.println("\nIOException for URL : " + converter.getOriginText(currentVertex) + "\n");
					numberWrongBfsLinks++;
					// Get next URL from queue
					if (!queue.isEmpty()) {
						currentVertex = queue.dequeue();
						parent = Node.getNode(currentVertex, graph);
					}
					ok = false;
				}
			}
			System.out.println("The number of crawled pages: " + countWhenEndBfsProgram);
			System.out.println("\n=== Site crawled : " + converter.getOriginText(currentVertex) + " ===");
			countWhenEndBfsProgram++;

			String stringAddress = EmailsAndLinksOperation.readSourceCodePage(currentVertex, converter, br);
			// We search for email
			EmailsAndLinksOperation.searchEmailAndAddToSet(stringAddress, emailsSet);

			Pattern linkPattern = Pattern.compile(linkRegex);
			Matcher linkMatcher = linkPattern.matcher(stringAddress);

			while (linkMatcher.find()) {
				String currentLink = linkMatcher.group();

				// remove unneeded link like http://google itd
				if (EmailsAndLinksOperation.deleteWrongLink(currentLink)) {

					if (!converter.wasThisTextConvertedBefore(currentLink)) {
						int v = converter.convertToNumber(currentLink);
						graph.addNeighbor(currentVertex, v);

						neighborsList = new ArrayList<Integer>();
						graph.addNode(v, neighborsList);
						Node currentNode = Node.getNode(v, graph);
						if (currentNode.getColor() == "") {
							currentNode.setColor("grey");
							currentNode.setParent(parent);
							currentNode.setLengthEdge(parent.getLengthEdge() + 1);
							System.out.println("Site added for crawling : " + converter.getOriginText(v));
							queue.enqueue(v);
						}
					}
				}
			}
			parent.setColor("black");
		}
	}

}
