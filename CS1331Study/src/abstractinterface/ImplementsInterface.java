package abstractinterface;

public abstract class ImplementsInterface implements Comparable{
	
	public enum Things {ONE, TWO, THREE, FOUR}
	
	public void stuff() {
		Things that = Things.ONE;
		that.ordinal();
	}
	
}
