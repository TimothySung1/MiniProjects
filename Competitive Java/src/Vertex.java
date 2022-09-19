public class Vertex {
	String name;
	public Vertex(String name1) {
		name = name1;
	}
	public String getName() {
		return name;
	}
	
	public boolean equals(Vertex vertex) {
		if (getName().equals(vertex.getName())) {
			return true;
		}
		return false;
	}
}
