import java.util.ArrayList;
import java.util.List;


public class Graph {
	public static final int INFINITY = 1000000;
	//least cost for connecting edges to all nodes
	private ArrayList<Vertex> vertices;
	private ArrayList<Edge> edges;
	private int[] dist;
	private Vertex[] prev;
	public Graph() {
		vertices = new ArrayList<Vertex>();
		edges = new ArrayList<Edge>();
	}
	
	public int getVerticesSize() {
		return vertices.size();
	}
	
	public List<Vertex> getVertices(){
		return vertices;
	}
	
	public List<Edge> getEdges(){
		return edges;
	}
	
	private List<Edge> minimumSpanningTree() {
		//get list of edges with minimum cost
		List<Edge> minEdges = new ArrayList<Edge>();
		boolean sorted = false;
		int swaps = 0;
		System.out.println("edges size " + edges.size());
		for (Edge edge : edges) {
			minEdges.add(edge);
		}
		System.out.println("minEdges size " + minEdges.size());
		while (!sorted) {
			for (int i = 0; i < minEdges.size() - 1; i++) {
				if(minEdges.get(i).getCost() > minEdges.get(i + 1).getCost()) {
					Edge temp = minEdges.get(i + 1);
					minEdges.set(i + 1, minEdges.get(i));
					minEdges.set(i, temp);
					swaps++;
				}
			}
			if(swaps == 0) {
				sorted = true;
			}
			swaps = 0;
		}
		
		for(Edge edge : minEdges) {
			System.out.print(edge.getCost() + " ");
		}
		System.out.println();
		
		List<Edge> edgesAdded = new ArrayList<Edge>();
		
		boolean dupe;
		for (int i = 0; i < minEdges.size(); i++) {
			dupe = false;
			for(Edge edge : edgesAdded) {
				if((minEdges.get(i).getStart() == edge.getStart() || minEdges.get(i).getStart() == edge.getEnd()) && (minEdges.get(i).getEnd() == edge.getEnd() || minEdges.get(i).getEnd() == edge.getStart())){
					dupe = true;
				}
			}
			if (!dupe) {
				edgesAdded.add(minEdges.get(i));
				System.out.println(minEdges.get(i).getCost());
			}
		}
		if(edgesAdded.size() < vertices.size() - 1) {
			throw new IllegalArgumentException();
		}
		
		//System.out.println("edges added size " + edgesAdded.size());
		for (Edge edge : edgesAdded) {
			System.out.println(edge);
		}
		
		List<Edge> minEdgesAdded = new ArrayList<Edge>();
		for (Edge edge : edgesAdded) {
			if (!isCycle2(minEdgesAdded, edge)) {
				minEdgesAdded.add(edge);
				System.out.println(edge.getCost());
				//System.out.println("minEdgesAdded size " + minEdgesAdded.size());
			}
		}
		printMinTree(minEdgesAdded);
		return minEdgesAdded;
	}
	
	private void printMinTree(List<Edge> minTree) {
		System.out.println("Minimum Spanning Tree");
		for (Edge edge : minTree) {
			System.out.println(edge.toString());
		}
		System.out.println("Sum " + sum(minTree));
	}
	
	private boolean isCycle(List<Edge> minTree, Edge edge){
		//check duplicates
		boolean uniqueStart = true;
		boolean uniqueEnd = false;
		for(int i = 0; i < minTree.size(); i++) {
			//for(Vertex vertex : vertices) {
			
			if (edge.getStart().equals(minTree.get(i).getStart()) || edge.getStart().equals(minTree.get(i).getEnd())){
				uniqueStart = false;
			}
			if (edge.getEnd().equals(minTree.get(i).getStart()) || edge.getEnd().equals(minTree.get(i).getEnd())) {
				uniqueEnd = false;
			}
			
			//}
		}
		if (uniqueStart || uniqueEnd) {
			return false;
		}
		else {
			return true;
		}
	}
	
	private boolean isCycle2(List<Edge> minTree, Edge edge) {
		System.out.println("\nisCycle2");
		//check visited
		List<Edge> edges = new ArrayList<Edge>(minTree);
		edges.add(edge);
		List<Vertex> verticesVisited = new ArrayList<Vertex>();
		Vertex startpoint = edges.get(0).getStart();
		List<Vertex> verticesPending = new ArrayList<Vertex>();
		verticesPending.add(startpoint);
		
		//printVertexList(verticesVisited);
		
		while(verticesPending.size() > 0) {
			//printVertexList(verticesVisited);
			Vertex vertex = verticesPending.get(0);
			System.out.println("visiting vertex " + vertex.getName());
			//System.out.println("vertex pending " + vertex.getName());
			verticesPending.remove(0);
			//System.out.println("vertex visited" + verticesVisited.get(0));
			if(verticesVisited.contains(vertex)) {
				System.out.println("vertex already visited " + vertex.getName() + "\n");
				return true;
			}
			verticesVisited.add(vertex);
			
			for (int i = 0; i < edges.size(); i++) {
				if (edges.get(i).getStart().equals(vertex)) {
					verticesPending.add(edges.get(i).getEnd());
					
					System.out.println(edges.get(i).toString());
					edges.remove(i);
					i--;
				}
				else if (edges.get(i).getEnd().equals(vertex)) {
					verticesPending.add(edges.get(i).getStart());
					
					System.out.println(edges.get(i).toString());
					edges.remove(i);
					i--;
				}
			}
			
		}
		return false;
	}
	/*
	private boolean getShortestPath(Vertex starting, Vertex ending) {
		List<Vertex> verticesVisited = new ArrayList<Vertex>();
		List<Vertex> verticesPending = new ArrayList<Vertex>();
		verticesPending.add(starting);
		
		while(verticesPending.size() > 0) {
			Vertex vertex = verticesPending.get(0);
			verticesPending.remove(0);
			
			if(verticesVisited.contains(vertex){
				
			}
		}
	}
	*/
	public void dijkstra(String source) {
		System.out.println(source);
		List<Vertex> vertexSet = new ArrayList<Vertex>();
		dist = new int[vertices.size()];
		prev = new Vertex[vertices.size()];
		for (int i = 0; i < vertices.size(); i++) {
			dist[i] = INFINITY;
			prev[i] = null;
			vertexSet.add(vertices.get(i));
		}
		dist[findName(vertices, source)] = 0;
		System.out.println("Find name: " + findName(vertices, source));
		
		printDistArray();
		//boolean[] mins = new boolean[vertices.size()];
		while (vertexSet.size() > 0) {
			int u = minimumIndex(dist, vertexSet);
			Vertex minDist = vertices.get(u);
			System.out.println("Vertex minDist: " + minDist.getName());
			List<Vertex> neighbors = getNeighbors(vertices.get(u));
			vertexSet.remove(minDist);
			for (int i = 0; i < neighbors.size(); i++) {
				
				int alt = dist[u] + getEdge(minDist, neighbors.get(i)).getCost();
				System.out.println();
				/*
				System.out.println("dist[u]: " + dist[u]);
				System.out.println("MinDist: " + minDist.getName());
				System.out.println("alt: " + alt);
				System.out.println("Edge: " + getEdge(minDist, neighbors.get(i)).getStart().getName() + getEdge(minDist, neighbors.get(i)).getEnd().getName());
				System.out.println("Neighbor: " + neighbors.get(i).getName());
				System.out.println("Neighbor cost: " + getEdge(minDist, neighbors.get(i)).getCost());
				*/
				if (alt < dist[getVertexIndex(neighbors.get(i))]) {
					dist[getVertexIndex(neighbors.get(i))] = alt;
					prev[getVertexIndex(neighbors.get(i))] = minDist;
				}
			}
			System.out.println("*****");
			printDistArray();
			System.out.println("*****");
		}
		
	}
	
	public void printPath(String source, String dest) {
		dijkstra(source);
		System.out.println("Print path from: " + source + " to " + dest);
		/*
		printVertexArray(prev);
		printDistArray();
		printVertexList(vertices);
		*/
		reverse(prev, getVertex(dest), getVertex(source));
		System.out.println();
	}
	
	public void printShortestPath(String source, String dest) {
		dijkstra(source);
		System.out.println("Print shortest path from " + source + " to " + dest);
		System.out.println(dist[getVertexIndex(getVertex(dest))]);
		printPath(source, dest);
	}
	
	private void printVertexArray(Vertex[] array) {
		System.out.print("Vertex array: ");
		for (Vertex vertex : array) {
			if (vertex != null) {
				System.out.print(vertex.getName() + " ");
			}
			else {
				System.out.print("null ");
			}
			}
		
		System.out.println();
	}
	
	private void reverse(Vertex[] prev, Vertex dest, Vertex source) {
		System.out.println("Dest: " + dest.getName() + " Source: " + source.getName());
		
		
		if (dest.getName().equals(source.getName())) {
			;
		}
		else {
			reverse(prev, prev[getVertexIndex(dest)], source);
		}
		System.out.print(" " + dest.getName());
	}
	
	public void printDistArray() {
		System.out.print("Dist: ");
		for (int num : dist) {
			System.out.print(num + " ");
		}
		System.out.println();
	}
	
	private int getVertexIndex(Vertex vertex) {
		for (int i = 0; i < vertices.size(); i++) {
			if (vertices.get(i) == vertex) {
				return i;
			}
		}
		return -1;
	}
	
	private List<Vertex> getNeighbors(Vertex vertex) {
		List<Vertex> neighbors = new ArrayList<Vertex>();
		for (Edge edge : edges) {
			if (edge.getEnd() == vertex && edge.getStart() != null) {
				neighbors.add(edge.getStart());
			}
			if (edge.getStart() == vertex && edge.getEnd() != null) {
				neighbors.add(edge.getEnd());
			}
		}
		return neighbors;
	}
	
	private Edge getEdge(Vertex one, Vertex two) {
		for (Edge edge : edges) {
			if (edge.getEnd().getName() == one.getName() && edge.getStart().getName() == two.getName()){
				return edge;
			}
			if (edge.getStart().getName() == one.getName() && edge.getEnd().getName() == two.getName()) {
				return edge;
			}
		}
		return null;
	}
	
	private int findName(ArrayList<Vertex> vertexList, String name) {
		for (int i = 0; i < vertexList.size(); i++) {
			if (vertexList.get(i).getName().equals(name)) {
				return i;
			}
		}
		return -1;
	}
	
	private int minimumIndex(int[] dist, List<Vertex> vertexSet) {
		//find minimum and mins is true
		/*
		for (int i = 0; i < vertexSet.size(); i ++) {
			if () {
				
			}
		}
		*/
		
		int min = -1;
		for(int i = 0; i < dist.length; i++) {
			if (verticesContains(vertices.get(i), vertexSet) && (min == -1 || dist[min] > dist[i])) {
				min = i;
			}
		}
		/*
		for (int i = 0; i < dist.length; i++) {
			if (min > dist[i] && verticesContains(vertices.get(i), vertexSet)) {
				min = dist[i];
			}
		}
		for (int i = 0; i < dist.length; i++) {
			if (dist[i] == min && verticesContains(vertices.get(i), vertexSet)) {
				return i;
			}
		}
		*/
		return min;
	}
	
	private boolean verticesContains(Vertex vertex, List<Vertex> vertices) {
		for (Vertex vert : vertices) {
			if (vert.getName().equals(vertex.getName())) {
				return true;
			}
		}
		return false;
	}
	
	private void printVertexList(List<Vertex> list) {
		System.out.println("Vertex list: ");
		for(Vertex vertex : list) {
			System.out.println(vertex.getName());
		}
	}
	
	private void printEdgeList(List<Edge> list) {
		for(Edge edge : list) {
			System.out.println(edge.getCost());
		}
	}
	
	private int sum(List<Edge> edges) {
		int total = 0;
		for(Edge edge : edges) {
			total += edge.getCost();
		}
		return total;
	}
	
	public int minimum() {
		return sum(minimumSpanningTree());
	}
	
	public boolean addVertex(String name) {
		for(int i = 0; i < vertices.size(); i++) {
			if(vertices.get(i).getName().equals(name)) {
				return false;
			}
		}
		Vertex vertex = new Vertex(name);
		vertices.add(vertex);
		return true;
	}
	
	public boolean addEdge(int cost, String start, String end) {
		System.out.println("vertex size " + vertices.size());
		for (int i = 0; i < edges.size(); i++) {
			if (edges.get(i).getStart().getName() == start && edges.get(i).getEnd().getName() == end && edges.get(i).getCost() == cost) {
				return false;
			}
		}
		Edge edge = new Edge(cost, getVertex(start), getVertex(end));
		edges.add(edge);
		return true;
	}
	
	public Vertex getVertex(String name) {
		for(Vertex vertex : vertices) {
			if(vertex.getName() == name) {
				return vertex;
			}
		}
		return null;
	}

}
