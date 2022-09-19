package collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Employees {
	private List<PersonEdu> employees;
	public Employees() {
		this.employees = new ArrayList<>();
	}
	
	public List<PersonEdu> getEmployees(){
		return this.employees;
	}
	
	public void add(PersonEdu personToAdd) {
		getEmployees().add(personToAdd);
	}
	
	public void add(List<PersonEdu> peopleToAdd) {
		Iterator<PersonEdu> iterator = peopleToAdd.iterator();
		while (iterator.hasNext()) {
			getEmployees().add(iterator.next());
		}
	}
	
	public void print() {
		Iterator<PersonEdu> iterator = getEmployees().iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
	
	public void print(Education education) {
		Iterator<PersonEdu> iterator = getEmployees().iterator();
		while (iterator.hasNext()) {
			PersonEdu employee = iterator.next();
			if (employee.getEducation() == education) {
				System.out.println(employee);
			}
		}
	}
	
	public void fire(Education education) {
		Iterator<PersonEdu> iterator = getEmployees().iterator();
		while (iterator.hasNext()) {
			PersonEdu employee = iterator.next();
			if (employee.getEducation() == education) {
				iterator.remove();
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employees university = new Employees();
		university.add(new PersonEdu("Petrus", Education.PHD));
		university.add(new PersonEdu("Arto", Education.HS));
		university.add(new PersonEdu("Elina", Education.PHD));

		university.print();

		university.fire(Education.HS);

		System.out.println("==");

		university.print();
	}

}
