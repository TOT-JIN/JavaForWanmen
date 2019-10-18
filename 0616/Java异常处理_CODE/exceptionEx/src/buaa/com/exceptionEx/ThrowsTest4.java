package buaa.com.exceptionEx;


//由调用方法处理该异常
class ThrowsTest4 {
	static void method() throws IllegalAccessException {  //声明异常，但本身并不处理异常
		System.out.println("\n在 method 中抛出一个异常");
		throw new IllegalAccessException();
	}

	public static void main(String args[])// throws IllegalAccessException
	{
		try {
			method();
		} catch (IllegalAccessException e) {
			System.out.println("在 main 中捕获异常：" + e);
		}
	}
}

//等同于：
/*
 class ThrowsTest4 {
	static void method() {   //自身处理异常
		try {
			System.out.println("\n在 method 中抛出一个异常");
			throw new IllegalAccessException();
		} catch (IllegalAccessException e) {
			System.out.println("在 method 中捕获异常：" + e);
		}
	}

	public static void main(String args[]) {
		method();
	}
}
*/