package collections;

public class PersonEdu {
	private String name;
	private Education education;
	public PersonEdu(String name, Education education) {
		this.name = name;
		this.education = education;
	}
	
	public Education getEducation() {
		return this.education;
	}
	
	@Override
	public String toString() {
		return name + ", " + getEducation();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PersonEdu anna = new PersonEdu("Anna", Education.PHD);
		System.out.println(anna);
	}

}
