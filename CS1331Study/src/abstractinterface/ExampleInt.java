package abstractinterface;

public interface ExampleInt {
	
	public void doThis();
	
	public void doAnother(int something);
	
	public default int returnNum() {
		return 1;
	}
	
}
