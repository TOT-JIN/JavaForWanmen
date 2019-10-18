package buaa.com.exceptionEx;

public class ExceptionTest3 {

	/*
	 * 编写Java程序,包含三种异常：算术异常, 字符串越界异常,数组越界异常，
	 * 要求程序使用try、catch、finally进行处理。
	 * 运行程序并观察输出信息。
	 */
	public static void main(String args[]) {
		char c;
		int a, b = 0;
		int[] array = new int[7];
		String s = "Hello";
		try {
			a = 1 / b;
			array[8] = 0;
			c = s.charAt(8);
		}

		catch (ArithmeticException ae) {
			System.out.println("Catch " + ae);
		} catch (ArrayIndexOutOfBoundsException ai) {
			System.out.println("Catch " + ai);
		} catch (StringIndexOutOfBoundsException se) {
			System.out.println("Catch " + se);
		} finally {
			System.out.println("fianlly,I passed!!! ");
		}
	}
}
