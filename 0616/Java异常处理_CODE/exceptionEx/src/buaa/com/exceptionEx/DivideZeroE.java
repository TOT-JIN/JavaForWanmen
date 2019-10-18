package buaa.com.exceptionEx;

public class DivideZeroE {
	int x;

	public static void main(String[] args) {
		int y;
		DivideZero c = new DivideZero();
		try {
			y = 3 / c.x;
		}
//		catch (ArithmeticException e) {
//			System.out.println(e.toString());
//		}
		finally{
			System.out.println("无条件的被执行！");
		}
		System.out.println("program ends ok!");
	}
}
