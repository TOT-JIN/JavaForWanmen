package buaa.dal.basics;

public class Sum {
	public static void main(String args[]) {
		int n = 1;
		int sum = 0;
		do
			sum += n++;
		while (n <= 10);
		System.out.println("前" + --n + "个数的总和为：" + sum);
	}
}
