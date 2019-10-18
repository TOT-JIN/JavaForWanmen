package com.buaa.example;

import java.util.*;

public class LinkedListDemo {
	public static void main(String[] argv) {
		LinkedList<Object> l = new LinkedList<Object>();
		l.add(new Object());
		l.add("Hello");
		l.add("zhangsan");
		ListIterator<Object> li = l.listIterator();
		while (li.hasNext())
			System.out.println(li.next());
		if (l.indexOf("Hello") < 0)
			System.err.println("Lookup does not work");
		else
			System.err.println("Lookup works");
	}
}
