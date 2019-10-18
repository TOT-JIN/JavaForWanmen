package buaa.com.exceptionEx;

//异常实际上是程序中错误导致中断了正常的指令流的一种事件，这里的异常指运行时异常

class ExceptionTestE {
	public static void main(String[] args) {
		try {
			int a = 0;
			System.out.println(5 / a);
		} catch (ArithmeticException e) {
			System.out.println(e.toString());
			System.out.println(e.getMessage());

		}
		System.out.println("the program is finished");
	}
}