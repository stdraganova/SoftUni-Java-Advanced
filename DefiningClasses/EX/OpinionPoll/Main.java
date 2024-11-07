package JavaAdvanced.DefiningClasses.EX.OpinionPoll;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Person person;
        List<Person> people = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);

            person = new Person(name, age);
            people.add(person);
        }

        people.stream().sorted(Comparator.comparing(Person::getName)).filter(person1 -> person1.getAge() > 30).forEach(System.out::print);
    }
}
