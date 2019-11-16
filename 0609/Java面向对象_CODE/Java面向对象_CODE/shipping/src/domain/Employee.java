package domain;

public abstract class Employee extends Object implements interfaceExample {
    private final int ID;
    private static int counter=0;
    private String name;
    private Address homeAddress;
    private Address comAddress;

    public Employee() {
        // TODO Auto-generated constructor stub
        super();
        counter++;
        ID = counter;
    }
    public Employee(String name, Address homeAddress, Address comAddress) {
        this();
        this.name = name;
        this.homeAddress = homeAddress;
        this.comAddress = comAddress;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Address getHomeAddress() {
        return homeAddress;
    }
    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }
    public Address getComAddress() {
        return comAddress;
    }
    public void setComAddress(Address comAddress) {
        this.comAddress = comAddress;
    }
    public int getId() {
        return ID;
    }

    public void print() {}
    public void display() {}
}
