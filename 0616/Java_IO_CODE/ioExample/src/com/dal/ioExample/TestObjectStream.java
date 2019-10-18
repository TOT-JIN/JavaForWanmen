package com.dal.ioExample;
import java.io.*;

public class TestObjectStream{
	public static void main(String args[]){
		Person[] p=new Person[5];
		for(int i=0;i<p.length;i++){
			p[i]=new Person("name-"+i,'m',i+20);
		}	
		try{
	//创建对象输出流oos，将多个对象保存到文件person.dat
			FileOutputStream fos=new FileOutputStream("person.dat");
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			for(int i=0;i<p.length;i++){
				oos.writeObject(p[i]);	
			}	
			oos.flush();
			oos.close();
		//创建对象输入流ois，读取文件中的对象并显示在屏幕上
			FileInputStream fis=new FileInputStream("person.dat");
			ObjectInputStream ois=new ObjectInputStream(fis);
			Person p1;
			System.out.println("先是文件中读取的各对象:");
			for(int i=0;i<p.length;i++){
			//将读取对象强制转换为Person类对象并赋给p1
				p1=(Person)ois.readObject();
				System.out.println(p1.toString());	
			}
			ois.close();//关闭流
		}
		catch(ClassNotFoundException e){
			System.out.println(e);	
		}
		catch(IOException e){
			System.out.println(e);	
		}
	}

}
class Person implements Serializable{
	String name;
	char sex;
	int age;
	public Person(String s, char c, int i){
		name = s;
		sex=c;
		age=i;	
	}	
	public String toString(){
		String s="姓名："+name+" 性别："+sex+" 年龄："+age;
		return s;	
	}
}