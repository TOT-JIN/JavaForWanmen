package com.dataapplab.springboot.example;

import java.math.BigDecimal;
import java.math.MathContext;
/**
 * 
 * @author joshuaz
 * http://java-performance.info/bigdecimal-vs-double-in-financial-calculations/
 * Avoid working with non-integral values while using double (calculate in the smallest currency units).
 * Round any multiplication/division results using Math.round/rint/ceil/floor (per your system requirements).
 * as long as your calculations fit in 53 bits (double precision) and you stick to the 2 rules listed above
 * 
 * Store monetary values in the smallest currency units (for example, cents) in long variables
 * Avoid working with non-integral values while using double (calculate in the smallest currency units)
 * Add/subtract using long.
 * Round any multiplication/division results using Math.round/rint/ceil/floor (per your system requirements).
 */
public class ExampleApp {
	public static void main(String[] args){
		System.out.println( "362.2 - 362.6 = " + ( 362.2 - 362.6 ) );
        System.out.println("--- Normal Print-----");
        System.out.println(2.00 - 1.1);
        System.out.println(2.00 - 1.2);
        System.out.println(2.00 - 1.3);
        System.out.println(2.00 - 1.4);
        System.out.println(2.00 - 1.5);
        System.out.println(2.00 - 1.6);
        System.out.println(2.00 - 1.7);
        System.out.println(2.00 - 1.8);
        System.out.println(2.00 - 1.9);
        System.out.println(2.00 - 2);
        
        System.out.println("--- BigDecimal-----");
        System.out.println(new BigDecimal("2.00").subtract(new BigDecimal("1.1")));
        System.out.println(new BigDecimal("2.00").subtract(new BigDecimal("1.2")));
        System.out.println(new BigDecimal("2.00").subtract(new BigDecimal("1.3")));
        System.out.println(new BigDecimal("2.00").subtract(new BigDecimal("1.4")));
        System.out.println(new BigDecimal("2.00").subtract(new BigDecimal("1.5")));
        System.out.println(new BigDecimal("2.00").subtract(new BigDecimal("1.6")));
        System.out.println(new BigDecimal("2.00").subtract(new BigDecimal("1.7")));
        System.out.println(new BigDecimal("2.00").subtract(new BigDecimal("1.8")));
        System.out.println(new BigDecimal("2.00").subtract(new BigDecimal("1.9")));
        System.out.println(new BigDecimal("2.00").subtract(new BigDecimal("2")));


		System.out.println(  new BigDecimal( "362.2" ).subtract(new BigDecimal( "362.6")) );
	
		int res = 0;
		final BigDecimal orig = new BigDecimal( "362.2" );
		final BigDecimal mult = new BigDecimal( "0.015" ); //1.5%
		for ( int i = 0; i < 10; ++i )
		{
		    final BigDecimal result = orig.multiply( mult, MathContext.DECIMAL64 );
		    if ( result != null ) res++;
		}
		
		int dRes = 0;
		final double dorig = 36220; //362.2 in cents
		final double dmult = 0.015; //1.5%
		for ( int i = 0; i < 10; ++i )
		{
		    final long result = Math.round( dorig * dmult );
		    if ( result != 543 ) dRes++;    //543.3 cents actually
		}
		
		//Runnable：接口名称。这里还可以填写抽象类、普通类的名称
	    // ()：这个括号表示构造函数的参数列表
		// {...}：大括号中间的代码表示这个类内部的一些结构
	    // new class-name ( [ argument-list ] ) { class-body }
	    // new interface-name () { class-body }
		Runnable hello = new Runnable() {
		    public void run() {
		        System.out.println("hello");
		    }
		};
		hello.run();
	}
}
