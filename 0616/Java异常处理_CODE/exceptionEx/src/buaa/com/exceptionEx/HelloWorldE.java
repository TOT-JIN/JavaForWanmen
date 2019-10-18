package buaa.com.exceptionEx;

/*
 * 异常的优点：
 * 1、把错误代码从常规代码中分离出来
 * 2、按错误类型和错误差别分组
 * 3、系统提供了对于一些无法预测的错误的捕获和处理
 * 4、克服了传统方法的错误信息有限的问题
 */

public class HelloWorldE {
	public static void main(String args[]) {
		int i = 0;
		String greetings[] = { "Hello world!", "No, I mean it!",
				"HELLO WORLD!!" };
		try {
			while (i < 4) {

				System.out.println(greetings[i]);
				i++;

			}
		} catch (Exception e) {
			System.out.println(e.toString());
			System.out.println(e.getMessage());

		}
		System.out.println("the program is end!");
	}
}