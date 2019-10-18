package buaa.dal.basics;

public class Person {

	private String name;
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static void main(String[] args) {
		Person p1 = new Person();
		p1.setName("Jack");
		p1.setName("0001");
		System.out.println("ID=" + p1.getId());
		System.out.println("Name+" + p1.getName());
	}
}
