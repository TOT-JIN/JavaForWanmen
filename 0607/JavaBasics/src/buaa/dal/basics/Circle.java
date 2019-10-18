package buaa.dal.basics;

//将圆周率设为类常量，再计算圆的周长与面积
public class Circle {
	final static double PI=3.1415926;
	public static void main(String args[]){
		double r=5;
		System.out.println("圆的半径:" +r);
		System.out.println("圆的周长:" +2*PI*r);
		System.out.println("圆的面积:" +PI*r*r);
		}
}
