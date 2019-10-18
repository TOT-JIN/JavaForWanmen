package buaa.dal.basics;

public class Sum1 {
	public static void main(String arg[]) {
		int n = 10, sum = 0;
		while (n > 0) {
			sum = 0;
			for (int i = 1; i <= n; i++)
				sum += i;
			System.out.println("前" + n + "个数的总和为：" + sum);
			n--;
		}
	}
}
