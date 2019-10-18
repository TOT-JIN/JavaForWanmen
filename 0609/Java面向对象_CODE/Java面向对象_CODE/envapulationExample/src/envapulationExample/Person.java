package envapulationExample;

public class Person {
	final int ID=0;
	public String name;////
	public String sex;////
	protected int age;////
	public final double PAI=3.1415926; 
	
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Person(String name, String sex, int age) {
		super();
		this.name = name;
		this.sex = sex;
		this.age = age;
	}	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
