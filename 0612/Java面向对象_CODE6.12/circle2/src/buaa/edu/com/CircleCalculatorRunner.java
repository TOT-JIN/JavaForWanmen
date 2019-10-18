package buaa.edu.com;



import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CircleCalculatorRunner {

    public static void main(String args[])   
    {   
    	CircleCalculator aa = new CircleCalculator();   
        aa.readInput();   
        aa.doCalculations();   
        aa.display();   
    } 
}
class CircleCalculator {

    private double r;   
    private double mian;   
    private double zhou;   
       
    public void readInput()   
    {   
        KeyBoardReader input = new KeyBoardReader();   
        System.out.println("Enter radius");   
        r=input.readDouble();   
    }   
    public void doCalculations()   
    {   
        mian= Math.PI * r*r;   
        zhou = Math.PI * r*2;   
    }   
    public void display()   
    {   
        System.out.println("你输入的半径为： "+r);   
        System.out.println("圆的面积为： "+mian);   
        System.out.println("圆的周长为："+zhou);   
    }  

}
class KeyBoardReader{   
    
    private BufferedReader br;   
       
    public KeyBoardReader(){   
        br = new BufferedReader(new InputStreamReader(System.in));   
    }   
       
    public BufferedReader getReader(){   
        return this.br;   
    }   
       
    public void setReader(BufferedReader br){   
        this.br = br;   
    }   
       
    public double readDouble(){   
        double value = 0.0;   
        try{   
            String s = br.readLine();   
            System.out.println("s: " + s);   
            value = Double.parseDouble(s);   
        }   
        catch(Exception e){   
            System.out.println("Exception: " + e.getMessage());   
        }   
        return value;   
    }   
}  

