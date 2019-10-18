package buaa.dal.basics;

public class TestArithmetic {
	public static void main(String[] args) {
		int n = 1859, m;
		int a, b, c, d;
		d = n / 1000;
		c = n / 100 % 10;
		b = n / 10 % 10;
		a = n % 10;
		m = a * 1000 + b * 100 + c * 10 + d;
		System.out.println("原来的四位数：n=" + n);
		System.out.println("每位逆序后的四位数：m=" + m);
	}
}
