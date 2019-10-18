package buaa.dal.basics;

class ArrayTest {
	public static void main(String args[]) {
		// 初始数组
		int elements[] = { 1, 2, 3, 4, 5, 6 };
		// 增大后的新数组
		int hold[] = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		// 把elements数组中的所有元素复制到
		// hold数组中，下标从0开始

		System.arraycopy(elements, 0, hold, 0, elements.length);
		for (int i = 0; i < elements.length; i++)
			System.out.println("elements[" + i + "]=" + elements[i]);
		for (int i = 0; i < hold.length; i++)
			System.out.println("hold[" + i + "]=" + hold[i]);
	}
}
