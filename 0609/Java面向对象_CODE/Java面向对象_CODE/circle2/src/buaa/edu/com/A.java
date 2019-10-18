package buaa.edu.com;



interface People {
	void peopleList();
}

class Student implements People {
	public void peopleList() {
		System.out.println("I’m a student.");
	}
}

class Teacher implements People {
	public void peopleList() {
		System.out.println("I’m a teacher.");
	}
}

public class A {
	public static void main(String args[]) {
		People a; // 声明接口变量
		a = new Student(); // 实例化，接口变量中存放对象的引用
		a.peopleList(); // 接口回调
		a = new Teacher(); // 实例化，接口变量中存放对象的引用
		a.peopleList(); // 接口回调
		String s1="abc";
		String s2="abc";
	System.out.println(s1==s2);
//	int x = 5.2%2;
    System.out.println(5.2%2);
    int i = 010, j = 10;
    System.out.println(i);
	System.out.println(++i + ", " + j--);

    char c='a';
    if(c==97){
		System.out.println(c);
    }else{
  		System.out.println('c');
    }
    System.out.println('c');

	}


}
