import java.util.ArrayList;
import java.util.List;

public class Dijkstra {
	int[] dist;
	Vertex[] prev;
	Graph graph;
	List<Vertex> vertexSet;
	List<Edge> edges;
	
	public Dijkstra(Graph graph) {
		this.graph = graph;
		dist = new int[graph.getVerticesSize()];
		prev = new Vertex[graph.getVerticesSize()];
		vertexSet = new ArrayList<Vertex>();
		edges = graph.getEdges();
	}
	
	public void process(String source) {
		int sourceIndex = getIndex(graph.getVertices(), source);
		for (int i = 0; i < graph.getVerticesSize(); i++) {
			dist[i] = -1;
			prev[i] = null;
			vertexSet.add(graph.getVertices().get(i));
			dist[sourceIndex] = 0;
		}
		
		while (vertexSet.size() > 0) {
			int minimum = dist[0];
			for (int i = 1; i < dist.length; i++) {
				
			}
			Vertex next = vertexSet.get(sourceIndex + 1);
		}
	}
	
	public int getIndex(List<Vertex> list, String name) {
		for (int i = 0; i < list.size(); i++) {
			if (graph.getVertices().get(i).getName().equals(name)) {
				return i;
			}
		}
		return -1;
	}
	
	private Vertex minDistVertex(String source) {
		for(int i = 0; i < graph.getVerticesSize(); i++) {
			
		}
	}
	
	public void printPath(Graph graph) {
	}
	
	public int getDistance() {
		
	}
	
	
}
