package JavaAdvanced.DefiningClasses.EX.OpinionPoll;

public class Person {
    //Полета
    private String name;
    private int age;

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public int getAge(){
        return this.age;
    }

    public String getName(){
        return name;
    }

    @Override
    public String toString() {
        return String.format("%s - %d%n", name, age);
    }
}
