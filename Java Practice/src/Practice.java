
public abstract class Practice {
	private int count = 0;
	
	public Practice(int count) {
		if (count < 0) {
			throw new IllegalArgumentException("Count cannot be negative");
		}
		this.count = count;
	}
	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
}
