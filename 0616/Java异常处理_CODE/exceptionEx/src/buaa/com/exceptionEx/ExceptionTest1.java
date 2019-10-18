package buaa.com.exceptionEx;

/*
 * 1、运行时错误会引起异常(Exception),没有异常处理代码的程序可能非正常结束，引起严重问题。（银行问题）
 * 2、Java给程序员提供了处理运行时错误的功能，有了这种称为异常处理(exception handling)的功能，
 *    就能开发用于重要计算的稳定程序。
 */
//下面的程序虽然有异常。但是正常退出的
/*
 * 异常的重要性在于程序不但能发现异常，还能处理异常，使程序正常退出。
 */
public class ExceptionTest1 {
	public static void main(String[] args) {
		int a = 0;
		try {
			System.out.println(5 / a);
		} catch (Exception ex) {
			System.out.println("Error: " + ex.getMessage());
		}
		System.out.println("Execution continues");///程序正常退出
	}
}
