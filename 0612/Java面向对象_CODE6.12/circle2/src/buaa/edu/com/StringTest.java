package buaa.edu.com;

public class StringTest{
	  public static void main(String args[]) {
	       String hello = "你好";
	       String testOne = "你"+"好";             //【代码1】
	       System.out.println(hello == testOne);   //输出结果是true
	       System.out.println("你好" == testOne);  //输出结果是true
	       System.out.println("你好" == hello);    //输出结果是true
	       String you = "你";
	       String hi = "好";
	       String testTwo = you+hi;                //【代码2】
	       System.out.println(hello == testTwo);   //输出结果是false
	       String testThree = you+hi;                       
	       System.out.println(testTwo == testThree); //输出结果是false
	       System.out.println("byte取值范围:"+Byte.MIN_VALUE+"至"+Byte.MAX_VALUE); 
	       System.out.println("short取值范围:"+Short.MIN_VALUE+"至"+Short.MAX_VALUE);  
	       System.out.println("int取值范围:"+Integer.MIN_VALUE+"至"+Integer.MAX_VALUE); 
	       System.out.println("long取值范围:"+Long.MIN_VALUE+"至"+Long.MAX_VALUE); 
	       System.out.println("float取值范围:"+Float.MIN_VALUE+"至"+Float.MAX_VALUE); 
	       System.out.println("double取值范围:"+Double.MIN_VALUE+"至"+Double.MAX_VALUE); 
	       byte d[]="abc我们喜欢篮球".getBytes();
	       System.out.println(d.length);   //【代码1】
	       String s=new String(d,0,7);
	       System.out.println(s);         //【代码2】

	    }
	}
