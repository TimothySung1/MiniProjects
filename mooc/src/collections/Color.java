package collections;

public enum Color {
	RED("#FF0000"),
	GREEN("#00FF00"),
	BLUE("#0000FF");
	
	private String code;
	
	private Color(String code) {
		this.code = code;
	}
	
	public String getCode() {
		return this.code;
	}
}
