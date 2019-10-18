package buaa.com.exceptionEx;
//用户自定义异常类MyException，用于描述数据取值范围错误信息。用户自己的异常类必须继承现有的异常类。

public class YourException extends Exception{
	private int id;
	public YourException() {
		// TODO Auto-generated constructor stub
	}	
	public YourException(int id) {
		super();
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
