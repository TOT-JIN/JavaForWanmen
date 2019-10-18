package com.buaa.libraryEx;

import java.util.Date;
import java.util.ArrayList;


/*
 * ArrayList类的初始长度是为0的,和Array相比,ArrayList有以下优点: 
 * 1:可以自动更改数组的长度
 * 2:可以灵活地插入和删掉元素
 * 3:ArrayList类中的一些方法很方便快捷
 */
public class TestArrayList{
	public static void main(String[] args) {
		ArrayList h = new ArrayList();
		h.add("1st");
		h.add("2nd");
		h.add(new Integer(3));
		h.add(new Double(4.0));
		h.add("2nd");      // 重复元素, 加入
		h.add(new Integer(3)); // 重复元素,加入
		System.out.println(h);  //[1st, 2nd, 3, 4.0, 2nd, 3],可以打印名称
		System.out.println("size=" + h.size());   //size=6
		System.out.println("-----替换指定元素-----");	
		h.set(3,"replace");		
		System.out.println("-----for循环遍历-----");
		for(int i=0;i<h.size();i++){
			System.out.println(h.get(i));
		}		
		System.out.println("-----取用特定元素-----");		
		Integer it = (Integer)h.get(2);   //索引从0开始
		System.out.println(it.intValue());	
	}
}