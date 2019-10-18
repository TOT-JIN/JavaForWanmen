package buaa.com.exceptionEx;

public class NullRefE {
	int i = 1;

	public static void main(String[] args) {

		NullRef t = new NullRef();
		t = null;
		try {
			System.out.println(t.i);
		} catch (NullPointerException e) {

		}
	}
}
