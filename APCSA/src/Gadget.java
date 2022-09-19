
public class Gadget {

	private static int status = 0;

	private int notstatic = 0;
	public Gadget()

	{

	status = 10;

	}

	public static void setStatus(int s)

	{

	status = s;

	}
	
	public static void setNotStatic(int s) {
		notstatic = s;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Gadget a = new Gadget();
		System.out.println(Gadget.status);
		Gadget.setStatus(3);
		System.out.println(Gadget.status);
		Gadget b = new Gadget();
		System.out.println(Gadget.status);
	}

}
