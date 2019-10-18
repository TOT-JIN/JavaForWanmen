package buaa.com.exceptionEx;

public class ThrowTest {

	public ThrowTest() {
		// TODO Auto-generated constructor stub
	}
	public static void regist(int number)throws YourException{
		if (number<=0){
			throw new YourException(number);
		}
		else{
	          System.out.println("µÇ¼ÇÈËÊý" + number);
		}
	}
	public static void manager(){
		try{
			regist(100);
		}
		catch(YourException e){
			e.toString();
			System.out.println("×¢²áÊ§°Ü");
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThrowTest.manager();
	}

}
