package generics;

public class Hideout<T> {
	T thing;
	
	public Hideout(){
		this.thing = null;
	}
	
	public void putIntoHideout(T toHide) {
		this.thing = toHide;
	}
	
	public T takeFromHideout() {
		T temp = this.thing;
		this.thing = null;
		return temp;
	}
	
	public boolean isInHideout() {
		if (this.thing != null) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hideout<String> den = new Hideout<>();
		System.out.println(den.isInHideout());
		den.putIntoHideout("peekaboo");
		System.out.println(den.isInHideout());
		System.out.println(den.takeFromHideout());
		System.out.println(den.isInHideout());
		den.putIntoHideout("toodaloo");
		den.putIntoHideout("heelloo");
		System.out.println(den.isInHideout());
		System.out.println(den.takeFromHideout());
		System.out.println(den.isInHideout());
	}

}
