package buaa.com.exceptionEx;


/*
 * 1、Public String toString();
 * 2、Public String getMessage();
 * 3、Public void printStackTrace();//没有返回值，它的功能是:
 *    在屏幕上输出当前异常对象的堆栈使用轨迹，即程序先后调用执行了哪些对象或类的哪些方法，
 *    使运行过程中产生了这个异常对象；
 */
public class ExceptionMethods
{   public static void main(String args[ ])
    {   try
        {   throw new Exception("Here's my Exception");  //有程序本身抛出异常
        }
        catch(Exception e)
        {   System.out.println("Caught Exception");
            System.out.println("e.getMessage( ):"+e.getMessage( ));//e.getMessage( )
            System.out.println("e.toString( ):"+e.toString( ));  //e.toString( )
            System.out.println("e.printStackTrace( ):");
            e.printStackTrace( );   //e.printStackTrace( )
        }
    }
}

