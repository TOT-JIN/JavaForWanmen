package buaa.edu.com;

public class Test1 {
	public int div(int a, int b) {
	try {
		return a/b;
	}
	catch(ArithmeticException e){
		System.out.println("ArithmeticException");
	}
	catch(NullPointerException e){
		System.out.println("NullPointerException");
	}
	catch (Exception e) {
		System.out.println("Exception");
	} 
	finally {
		System.out.println("finally");
    	return 0;
	}}
	public static void main(String[] args) {
		Test1 demo = new Test1();
		System.out.println("ÉÌÊÇ£º" + demo.div(9, 0));
		String s1=new String("abc");
		String s2=s1;
		String s3="abc";
		System.out.println(s1==s2);
		System.out.println(s2==s3);
		System.out.println(s1==s3);
		System.out.println(s1.equals(s2));
		System.out.println(s1.equals(s3));
		System.out.println(s2.equals(s3));

	}
}

