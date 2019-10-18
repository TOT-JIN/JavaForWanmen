package envapulationExample;

public class Employee extends Person{//
	private String comName;  ///	
	
	public Employee() {//
		super();////
		// TODO Auto-generated constructor stub
	}
	public Employee(String name, String sex, int age,String comName) {///
	//	super(name,sex,age);//////
		super.name=name;
		super.sex=sex;
		super.age=age;
		
		this.comName = comName;//////
	}
	public Employee(String comName) {///
		super();
		this.comName = comName;
	}
	public String getComName() {
		return comName;
	}
	public void setComName(String comName) {
		this.comName = comName;
	}
   
	



     
}
