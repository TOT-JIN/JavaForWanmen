package com.buaa.example;
import java.util.*;

public class SetDemo {
    public static void main(String[] argv) {
        HashSet<String> h = new HashSet<String>(); //р╡©ирт Set h=new HashSet()
        h.add("One");
        h.add("Two");
        h.add("One"); // DUPLICATE
        h.add("Three");
        Iterator<String> it = h.iterator();
        while (it.hasNext()) {
             System.out.println(it.next());
        }
    }
}
