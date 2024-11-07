package JavaAdvanced.IteratorsAndComparators.EX.StrategyPattern;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        Set<Person> personList1 = new TreeSet<>(new PersonComparator1());
        Set<Person> personList2 = new TreeSet<>(new PersonComparator2());

        for (int i = 0; i < rows; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);

            Person person = new Person(name, age);
            personList1.add(person);
            personList2.add(person);
        }

        personList1.forEach(e -> System.out.println(e));
        personList2.forEach(e -> System.out.println(e));

        scanner.close();
    }
}
