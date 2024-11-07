package JavaAdvanced.DefiningClasses.EX.CompanyRoster;

public class Employee {
    private String name;
    private double salary;
    private String position;
    private String department;
    private String email;
    private int age;

    //Constructor with mandatory 4
    //name, salary, position,department
    public Employee(String name, double salary, String position, String department){
        //С най-дългия конструктор запълваме по-малките
        this(name, salary,position,department,"n/a", -1);
    }

    //Constructor with 5 (with email without age)
    public Employee(String name, double salary, String position, String department, String email){
        this(name, salary,position,department,email, -1);
    }

    //Constructor with 5 (with age without email)
    public Employee(String name, double salary, String position, String department, int age){
        this(name, salary,position,department,"n/a", age);
    }

    //Constructor with all 6
    public Employee(String name, double salary, String position, String department, String email, int age){
            this.name = name;
            this.salary = salary;
            this.position = position;
            this.department = department;
            this.email = email;
            this.age = age;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %s %d",name, salary, email, age);
    }

    public double getSalary() {
        return salary;
    }
}
