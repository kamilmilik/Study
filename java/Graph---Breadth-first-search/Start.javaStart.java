import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
//8
//a b c d e f g h
//10
//a e
//a b
//b f
//f c
//f g
//c g
//c d
//g d
//g h
//h d

//A E
//A B
//B F
//F C
//F G
//C G
//C D
//G D
//G H
//H D


//10
//A B C D E F G H I J
//13
//A G
//B E
//B I
//C I
//D G
//D I
//E F
//G H
//H J
//A I
//D F
//G B
//A C
public class Start {
	static List<String> colors = new ArrayList<>();
	static List<String> topList;
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		System.out.println("Podaj liczbe wierzcholkow: ");
		int topSize = in.nextInt();
		in.nextLine();
		System.out.println("Podaj wierzcholki: ");
		String top = in.nextLine();
		top = top.toLowerCase();
		String[] topArray = top.split(" ");
		System.out.println("Podaj liczbe krawedzi: ");
		int edgeSize = in.nextInt();
		in.nextLine();
		String[] edgeArray = null;
		if (edgeSize == 0) {
			for (String s : topArray)
				System.out.println(s);
		}
//		if(edgeSize==0){
//			for(String s : topArray)System.out.println(s);
//		}
		if (edgeSize != 0) {
			System.out.println("Podaj krawedzie: ");
			String edge = null;
			String[] edgeArrayTemp = null;
			edgeArray = new String[2 * edgeSize];
			int j = 0;
			int l = 0;
			for (int i = 0; i < edgeSize; i++) {
				edge = in.nextLine();
				edge = edge.toLowerCase();
				edgeArrayTemp = edge.split(" ");
				edgeArray[j] = edgeArrayTemp[l];
				l++;
				j++;
				edgeArray[j] = edgeArrayTemp[l];
				j++;
				l = 0;
			}
		}
		System.out.println("Podaj wezel pocz¹tkowy przeszukiwania");
		String v0 = in.nextLine(); v0 = v0.toLowerCase();
		//create graph
		Graph graph = new Graph(topArray);
		//read edges
		int j = 1;
		for(int i = 0; i <2* edgeSize;i = i +2){
			graph.addNeighbor(edgeArray[i], edgeArray[j]);
			graph.addNeighbor(edgeArray[j], edgeArray[i]);
			j = j + 2;
		}
		colors = new ArrayList<String>(Collections.nCopies(topSize, ""));
		topList = new ArrayList<String>(graph.adj.keySet());

		if(edgeSize != 0)bfs(graph,v0);
		else {
			for(String s : topArray)System.out.println(s);
		}
	}
	public static void bfs(Graph graph,String v0){
		for(String o : topList){
			setColor(o,"white");
		}
		Queue<String> queue = new LinkedList<String>();
		setColor(v0,"grey");
		System.out.println(v0.toUpperCase());
		queue.add(v0);
		while(!queue.isEmpty()){
			String u = queue.poll();
			for(int i = 0; i < graph.adj.get(u).size();i++){
				String v = graph.adj.get(u).get(i);
					String getColor = getColor(v);
					if (getColor == "white") {
						setColor(v, "grey");
						System.out.println(v.toUpperCase());
						queue.add(v);
					}
			}
			setColor(u,"black");

		}
	}
	public static void setColor(String v,String color){
		int index = topList.indexOf(v);
		colors.set(index, color);
		//System.out.println("ustawiam kolor dla: "+v +" na: "+colors.get(index));
	}
	public static String getColor(String v){
		int index = topList.indexOf(v);
		//System.out.println("zwracam dla v= " + v + " kolor= " + colors.get(index) );
		return colors.get(index);
	}
}
