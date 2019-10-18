package com.dal.ioExample;

import java.io.*;
public class CreateFile{
    private static File f1, f2, f3, p1, p2;
    public static void main(String[] s){
		f1 = new File("aNewFile.txt");
		p1 = new File("bdfz2");
		f2 = new File(p1, "F.sql");
		p2 = new File("bdfz/root/");
		f3 = new File("bdfz/root/", "anotherFile.java");
		try{
			f1.createNewFile();
			p1.mkdir();
			f2.createNewFile();
			p2.mkdirs();
			f3.createNewFile();
		}catch(IOException ioe){}
    }
}

