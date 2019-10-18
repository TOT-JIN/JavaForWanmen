package com.buaa.example;

import java.util.*;

public class Test5 {
	public static void main(String[] args) {
		Dog ououDog = new Dog("欧欧", "雪娜瑞");
		Dog yayaDog = new Dog("亚亚", "拉布拉多");
		Dog meimeiDog = new Dog("美美", "雪娜瑞");
		Dog feifeiDog = new Dog("菲菲", "拉布拉多");

		List<Dog> dogs = new ArrayList<Dog>(); // 泛型
		dogs.add(ououDog);
		dogs.add(yayaDog);
		dogs.add(meimeiDog);
		dogs.add(2, feifeiDog); // 添加feifeiDog到指定位置

		System.out.println("共计有" + dogs.size() + "条狗狗。");

		System.out.println("分别是：");
		for (int i = 0; i < dogs.size(); i++) {
			Dog dog = (Dog) dogs.get(i);
			System.out.println(dog.getName() + "\t" + dog.getStrain());
		}
		
		System.out.println("使用Iterator遍历，所有狗狗昵称和品种是:");
		Iterator<Dog> it = dogs.iterator();
		while (it.hasNext()) {
			Dog dog = (Dog) it.next();
			System.out.println(dog.getName()+"\t"+dog.getStrain());
		}

	}
}