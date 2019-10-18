import java.io.*;
public class ValueOfChar{
  public static void main(String Args[]) {
    char ch=' ';
    System.out.print("请输入一个字符:");
    try {// 异常处理块
      ch=(char)System.in.read();
    }
    catch (IOException e) {}
    System.out.println("字符"+ch+"的ASCII值为:"+(int)ch);
  }
}
