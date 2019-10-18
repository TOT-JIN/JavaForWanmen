package buaa.dal.basics;

public class ArrDemo {
	public static void main(String args[]) {
		int i;
		int a[] = new int[5]; // 声明同时初始化

		for (i = a.length - 1; i >= 0; i--)
			System.out.println("a[" + i + "] = " + a[i]); // 隐含初值

		for (i = 0; i < 5; i++)
			a[i] = i; // 引用数组，重新赋值

		// a.length获得数组长度
		for (i = a.length - 1; i >= 0; i--)
			System.out.println("a[" + i + "] = " + a[i]); // 重新打印

		String[] strArray = new String[5]; // 隐含初值，null
		for (i = a.length - 1; i >= 0; i--)
			System.out.println("strArray[" + i + "] = " + strArray[i]);

		// 引用数组，重新赋值
		strArray[0] = new String("Hello");
		strArray[1] = new String("Hello");
		strArray[2] = new String("Hello");
		strArray[3] = new String("Hello");
		strArray[4] = new String("Hello");
		// strArray.length获得数组长度
		for (i = strArray.length - 1; i >= 0; i--)
			System.out.println("strArray[" + i + "] = " + strArray[i]); // 重新打印
	}
}
