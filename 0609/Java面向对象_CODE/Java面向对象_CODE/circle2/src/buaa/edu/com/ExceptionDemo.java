package buaa.edu.com;

public class ExceptionDemo {
	public static void main(String[] args) {
		method();
	}

	public static void method() {
		int a = 10;
		int b = 0;
		int[] arr = { 1, 2, 3 }; 
		//原来处理方案
/*		try { 
			System.out.println(arr[3]); 
			System.out.println(a / b); 
		} catch (ArithmeticException e) { 
			System.out.println("除数不能为0"); 
		} catch (ArrayIndexOutOfBoundsException e) { 
			System.out.println("数据越界"); 
		} catch (Exception e) { 
			System.out.println("有问题"); 
		} 
		*/
		// JDK7的处理方案
		try { 
			System.out.println(arr[3]); 
			System.out.println(a/b);
		}
		catch (ArithmeticException | ArrayIndexOutOfBoundsException e) 
		{ 
			System.out.println("出问题了");  
		    System.out.println("over"); 
		}

	}
}