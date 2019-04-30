import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Start {

	static List<Integer> weightEdgeList = new ArrayList<Integer>();
	static String[] topArray = null;
	static String[] edgeArray = null;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Wpisz litere aby uzyc algorytmu:");
		System.out.println(" 'd' - dijksta");System.out.println(" 'b' - bellman ford");
		String chooseOprion = in.nextLine();
		System.out.println("Podaj liczbe wierzcholkow: ");
		int topSize = in.nextInt();
		in.nextLine();
		System.out.println("Podaj wierzcholki: ");
		String top = in.nextLine();
		top = top.toLowerCase();
		topArray = top.split(" ");
		// create graph
		Graph graph = new Graph(topArray);
		System.out.println("Podaj liczbe krawedzi: ");
		int edgeSize = in.nextInt();
		in.nextLine();

		if (edgeSize != 0) {
			System.out.println("Podaj krawedzie i ich wagi: ");
			String edge = null;
			String[] edgeArrayTemp = null;
			edgeArray = new String[3 * edgeSize];
			int j = 0;
			int l = 0;
			int t = 0;
			for (int i = 0; i < edgeSize; i++) {
				edge = in.nextLine();
				edge = edge.toLowerCase();
				edgeArrayTemp = edge.split(" ");
				edgeArray[j] = edgeArrayTemp[l];
				l++;
				j++;
				edgeArray[j] = edgeArrayTemp[l];
				graph.addNeighbor(edgeArray[j-1], new Node(edgeArray[j],Integer.parseInt(edgeArrayTemp[l+1])) );
				t = t + 3;
				j++;
				l++;
				edgeArray[j] = edgeArrayTemp[l];
				weightEdgeList.add(Integer.parseInt(edgeArrayTemp[l]));
				j++;
				l = 0;
			}
		}
		System.out.println("Podaj wezel pocz¹tkowy przeszukiwania");
		String v0 = in.nextLine();
		v0 = v0.toLowerCase();
		switch(chooseOprion){
		case "d":
			dijkstra(graph, v0);
			break;
		case "b":
			bellmanFord(graph,v0);
			break;
		default:
			System.out.println("Podales zla wartosc. Wpisz d je¿eli chcesz u¿yc dijksty lub b je¿eli chcesz u¿yc bellmana forda");
		}
		check(graph);
		for(int i = 0 ; i < topArray.length;i++){
			int length = graph.getNode(topArray[i]).getLengthEdge().intValue();
			System.out.println(graph.getNode(topArray[i]).getData() +" " + length);
			System.out.println();
		}
		in.close();
	}
	static void dijkstra(Graph graph, String v0){
		PriorityComparator priorityComparator = new PriorityComparator();
		PriorityQueue<Node> queue = new PriorityQueue<>(priorityComparator);
		graph.getNode(v0).setLengthEdge(0);;
		for(String o : topArray){
			queue.offer((graph.getNode(o)));
		}
		while(!queue.isEmpty()){
			String vertex = queue.poll().getData();
			for(int i = 0; i < graph.adj.get(vertex).size();i++){
				String neighbor = graph.adj.get(vertex).get(i).getData();
				Node neighborNodeInAdjencyList = graph.adj.get(vertex).get(i);//to jest node na liscie sasiedztwa on ma jedynie informacje o weightEdgeLength
				relaxDijkstra(graph.getNode(vertex),graph.getNode(neighbor),neighborNodeInAdjencyList , queue);
			}
		}
	}
	static void bellmanFord(Graph graph, String v0){
		graph.getNode(v0).setLengthEdge(0);
		int k = 1;
		int weightEdgeIndex = 0;

		for ( int i = 0 ; i < topArray.length;i++ ){
			k = 1;
			weightEdgeIndex = 0;
			for (int j = 0; j < edgeArray.length; j = j + 3) {
				if (j < edgeArray.length) {
					relaxBellmanFord(graph.getNode(edgeArray[j]), graph.getNode(edgeArray[k]), weightEdgeList, weightEdgeIndex);
					k = k + 3;
					weightEdgeIndex++;
				}

			}
		}
	}
	private static void relaxBellmanFord(Node u, Node v, List<Integer> weightEdge, int weightEdgeIndex) {
		if(v.getLengthEdge() > u.getLengthEdge() + weightEdge.get(weightEdgeIndex)){
			v.setLengthEdge(u.getLengthEdge() + weightEdge.get(weightEdgeIndex));
			v.setParent(u);
		}
	}

	private static void check(Graph graph) {
		int k = 1;
		int weightEdgeIndex = 0;

		for (int i = 0; i < topArray.length; i++) {
			k = 1;
			weightEdgeIndex = 0;
			for (int j = 0; j < edgeArray.length; j = j + 3) {
				if (j < edgeArray.length) {
					if (checkNegativeCycle(graph.getNode(edgeArray[j]), graph.getNode(edgeArray[k]), weightEdgeList,
							weightEdgeIndex)) {
						System.out.println("!");
						System.exit(0);
					}
					k = k + 3;
					weightEdgeIndex++;
				}

			}
		}
	}
	private static boolean checkNegativeCycle(Node u, Node v, List<Integer> weightEdge, int weightEdgeIndex){
		if(v.getLengthEdge() > u.getLengthEdge() + weightEdge.get(weightEdgeIndex)){
			return true;//cykl ujemny
		}
		return false;//graf jest ok
	}
	private static void relaxDijkstra(Node u, Node v, Node neighborNodeInAdjencyList,PriorityQueue<Node> queue) {
	//System.out.println("if(" + v.getLengthEdge() + " > " + u.getLengthEdge() + " + " + neighborNodeInAdjencyList.getWeightEdge() + " = " + v.getLengthEdge() + " > " + (u.getLengthEdge() + " + " + neighborNodeInAdjencyList.getWeightEdge()));
		if(v.getLengthEdge() > u.getLengthEdge() + neighborNodeInAdjencyList.getWeightEdge()){
			v.setLengthEdge(u.getLengthEdge() + neighborNodeInAdjencyList.getWeightEdge());
			v.setParent(u);
			queue.remove(v);
			queue.offer(v);
		}

	}

}
//Przykady :
//5
//a b c d e
//10
//A B 1
//A D 17
//B A 16
//B E 1
//C A 5
//C B 2
//C D 14
//D C 11
//E A 3
//E C 25
//a


//10
//A B C D E F G H I J
//17
//A H 3
//B C 18
//B E 0
//B G 5
//C E 19
//D A 5
//E F 3
//F B 18
//F J 15
//G D 8
//G E 12
//G I 11
//H J 15
//I D 17
//I E 8
//I F 7
//J E 12
//A


//5
//s t x y z
//9
//s t 10
//t x 1
//x z 4
//z x 6
//y z 2
//y x 9
//s y 5
//t y 2
//y t 3
//S

//24
//A B C D E F G H I J K L M N O P Q R S T U V W X
//107
//A B 10
//A C 5
//A U 17
//B D 13
//B W 13
//C D 12
//C F 18
//C J 4
//C M 15
//C Q 10
//C R 4
//D A 4
//D C 14
//D G 10
//D H 12
//D R 10
//E A 10
//E F 1
//E G 11
//E J 7
//E P 15
//E T 0
//E W 17
//E X 7
//F A 12
//F O 4
//G B 7
//G D 7
//G E 17
//G L 11
//G Q 12
//G T 0
//G U 11
//H C 17
//H K 13
//H M 5
//H O 7
//H P 7
//H U 9
//I G 6
//I L 7
//I P 16
//I S 14
//J K 9
//J O 14
//J R 10
//K S 2
//K T 9
//K V 2
//L D 6
//L F 1
//L H 16
//L I 1
//L X 5
//M D 12
//M G 12
//M O 2
//M R 10
//M T 3
//N D 3
//N F 10
//N M 15
//N Q 8
//N U 6
//N V 2
//O B 4
//O F 2
//O G 16
//O X 4
//P A 11
//P C 0
//P D 19
//P F 6
//P G 9
//P L 2
//P O 14
//P X 16
//Q J 2
//Q S 6
//R B 6
//R D 9
//R G 5
//R I 1
//R K 7
//R L 19
//R O 0
//R S 2
//R X 7
//S G 10
//S L 17
//S U 13
//T A 15
//T B 17
//T L 5
//T Q 16
//U B 5
//U R 15
//V C 17
//V G 3
//W B 9
//W D 15
//W F 18
//W J 3
//W M 7
//X L 11
//X P 9
//X U 1
//A

//4
//A B C D
//3
//A B 6
//B D 9
//D A 3
//A

//4
//A B C D
//5
//A B 11
//A D 3
//B C 8
//C A 14
//D C -19
//A