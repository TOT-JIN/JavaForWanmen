package buaa.edu.com;

class Dog {
    Dog(int m){ 
    }
    Dog(double  m){ 
    }
    int Dog(int m){ 
       return 23;
    }
    void Dog(double m){
    }
    public static void main(String[] args){
    	Dog d=new Dog(10);
    	int m=d.Dog(1);
    	System.out.println(m);
    }
}
