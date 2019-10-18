package com.buaa.example;

import java.util.*;

public class ArrayListDemo {
	public static void main(String[] argv) {
		ArrayList<Object> al = new ArrayList<Object>();
		// Add lots of elements to the ArrayList...
		al.add(new Integer(11));
		al.add(new Integer(12));
		al.add(new Integer(13));
		al.add(new String("hello"));
		// First print them out using a for loop.
		System.out.println("Retrieving by index:");
		for (int i = 0; i < al.size(); i++) {
			System.out.println("Element " + i + " = " + al.get(i));
		}

		for (Object obj : al) { // 增强型的for循环
			System.out.println(obj);
		}
	}
}
