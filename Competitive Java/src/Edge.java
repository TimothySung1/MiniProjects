
public class Edge {
	int cost;
	Vertex start;
	Vertex end;
	public Edge(int cost1, Vertex start1, Vertex end1) {
		cost = cost1;
		start = start1;
		end = end1;
	}
	public int getCost() {
		return cost;
	}
	
	public Vertex getStart() {
		return start;
	}
	
	public Vertex getEnd() {
		return end;
	}
	
	public String toString() {
		return start.name + " " + end.name + " " + cost;
	}
}
