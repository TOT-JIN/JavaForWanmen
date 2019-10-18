package buaa.edu.com;

class Person{
	String name;
	public Person(){
		System.out.println("This is a person");
	}
}
public class SchoolMaster extends Person{
	String ID;
	public SchoolMaster(){
		super();
		System.out.println("This is a SchoolMaster");
	}
	public static void main(String[] args){
		SchoolMaster tea=new SchoolMaster();
		System.out.println(tea.name);
	}
}
