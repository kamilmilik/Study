import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Start {
	static List<Integer> neighborsList = null;
	static String root = "http://lists.w3.org";


	public static void main(String[] args) {
		final long startTime = System.currentTimeMillis();
		Graph graph = new Graph();
		StringIntConverter converter = new StringIntConverter();
		int node = converter.convertToNumber(root);
		neighborsList = new ArrayList<Integer>();
		graph.addNode(node, neighborsList);
		Scanner in = new Scanner(System.in);
		System.out.println("Podaj jak chcesz przeszukiwac siec: ");
		System.out.println("1 - dfs" + "\n" + "2 - bfs");
		int choiceNumber = in.nextInt();
		try {
			switch(choiceNumber){
			case 1 :
				Dfs.dfs(graph, node, converter);
				System.out.println("Number of bad addresses: " + Dfs.numberWrongDfsLinks + ". Number of e-mail addresses searched: " + EmailsAndLinksOperation.numberSearchedEmails);
				break;
			case 2 :
				 Bfs.bfs(graph, node, converter);
				 System.out.println("Number of bad addresses: " + Bfs.numberWrongBfsLinks + ". Number of e-mail addresses searched " + EmailsAndLinksOperation.numberSearchedEmails);
				 break;
			default:
				System.out.println("Wybrales zla liczbe, wpisz 1 lub 2!");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		final long endTime = System.currentTimeMillis();
		final long millis = endTime - startTime;
		long minutes = TimeUnit.MILLISECONDS.toMinutes(millis);
		long seconds = TimeUnit.MILLISECONDS.toSeconds(millis);
		System.out.println("Total execution time: " + seconds + " seconds = " + minutes + " minutes "
				+ seconds % (minutes*60) + " seconds");
	}
}
