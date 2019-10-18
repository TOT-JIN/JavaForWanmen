package com.buaa.example;
import java.util.LinkedList;

public class Test3 {
	public static void main(String[] args) {
		Dog ououDog = new Dog("欧欧", "雪娜瑞");
		Dog yayaDog = new Dog("亚亚", "拉布拉多");
		Dog meimeiDog = new Dog("美美", "雪娜瑞");
		Dog feifeiDog = new Dog("菲菲", "拉布拉多");

		LinkedList<Object> dogs = new LinkedList<Object>(); 
//		LinkedList<Dog> dogs = new LinkedList<Dog>(); 
		dogs.add(ououDog);
		dogs.add(yayaDog);
		dogs.addFirst(meimeiDog);  //// 添加meimeiDog到指定位置
		dogs.addLast(feifeiDog); // 添加feifeiDog到指定位置

		System.out.println("共计有" + dogs.size() + "条狗狗。");

		System.out.println("分别是：");
		for (int i = 0; i < dogs.size(); i++) {
			Dog dog = (Dog) dogs.get(i);
			System.out.println(dog.getName() + "\t" + dog.getStrain());
		}
		
		Dog dogFirst= (Dog)dogs.getFirst();
		System.out.println("第一条狗狗昵称是"+dogFirst.getName() );
		
		Dog dogLast= (Dog)dogs.getLast();
		System.out.println("最后一条狗狗昵称是"+dogLast.getName());
				
		dogs.removeFirst();
		dogs.removeLast();	
		System.out.println("共计有" + dogs.size() + "条狗狗。");

		System.out.println("分别是：");
		for (int i = 0; i < dogs.size(); i++) {
			Dog dog = (Dog) dogs.get(i);
			System.out.println(dog.getName() + "\t" + dog.getStrain());
		}
	}
}
