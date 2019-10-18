package com.dal.anoExample;
import com.dal.example.Director;
import envapulationExample.*;

public class Test extends Person{
    public static void main(String[] args){
    	Person p=new Person();
    	
    	Employee e=new Employee();
    	Director d=new Director();
    	System.out.println(p.PAI);/////public 
    	System.out.println(p.name);///// protected
    	System.out.println(p.sex);/////protected
    //	System.out.println(p.ID); ///°ü±äÁ¿
    }
}
