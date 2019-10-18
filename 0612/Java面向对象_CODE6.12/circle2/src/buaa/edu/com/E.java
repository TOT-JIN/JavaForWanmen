package buaa.edu.com;

class MyString {
	  public String getString(String s) {
	      StringBuffer str = new StringBuffer();
	      for(int i=0;i<s.length();i++) {
	         if(i%2==0) {
	            char c = s.charAt(i);
	            str.append(c);
	          }
	      }
	     return new String(str);
	   }
	}
	public class E {
	public static void main(String args[ ]) {
	String s = "1234567890";
	      MyString ms = new MyString();
	      System.out.println(ms.getString(s)); //¡¾´úÂë¡¿
	      int i=1;
	      switch (i) { 
	      default:
	         System.out.println("default");
	      case 0:
	         System.out.println("zero");
	         break;
	      case 1:
	         System.out.println("one");
	      case 2:
	         System.out.println("two");
	      }

	   }
	}