package buaa.edu.com;

public class Test{
    public static void main(String args[]) {
        Runtime runtime = Runtime.getRuntime();
        long free = runtime.freeMemory();
        System.out.println("Java虚拟机可用空闲内存 "+free+" bytes");
        long total = runtime.totalMemory();
        System.out.println("Java虚拟机占用总内存 "+total+" bytes");
        long n1 = System.currentTimeMillis();
        for(int i=1;i<=100;i++){
           int j = 2;
           for(;j<=i/2;j++){
             if(i%j==0) break;
           }
           if(j>i/2)  System.out.print(" "+i);
        }
        long n2 = System.currentTimeMillis();
        System.out.printf("\n循环用时:"+(n2-n1)+"毫秒\n");
        free = runtime.freeMemory();
        System.out.println("Java虚拟机可用空闲内存 "+free+" bytes");
        total=runtime.totalMemory();
        System.out.println("Java虚拟机占用总内存 "+total+" bytes");
    }
}