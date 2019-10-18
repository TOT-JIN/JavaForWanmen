package buaa.com.exceptionEx;


//在Java语言中使用语句try...catch...finally进行异常处理，
//程序流程从引起异常的代码转移到最近的try语句的catch子句。

public class ExceptionTest2 {
	public static void main(String[] args) {
		System.out.println("这是一个异常处理的例子\n");
		try {
			int i = 10;
			String[] str = { "I", "Like", "Java" };
			str[5] = "Hello";
			i /= 0;
			// str[5]="Hello";
		} catch (ArithmeticException e) {
			System.out.println("异常是：" + e.getMessage());
		} catch (IndexOutOfBoundsException e) {
			System.out.println("异常是：" + e.getMessage());
		} finally {
			System.out.println("finally 语句被执行!");
		}
		System.out.println("Everything is fine!!!");
	}
}
