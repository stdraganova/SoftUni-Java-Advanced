package JavaAdvanced.IteratorsAndComparators.EX.ComparingObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Person> personList = new ArrayList<>();

        String[] command = scanner.nextLine().split("\\s+");

        while (!command[0].equals("END")){
            String name = command[0];
            int age = Integer.parseInt(command[1]);
            String town = command[2];

            Person person = new Person(name, age, town);
            personList.add(person);

            command = scanner.nextLine().split("\\s+");
        }

        int personToCompareIndex = Integer.parseInt(scanner.nextLine()) - 1;
        Person personToCompare = personList.get(personToCompareIndex);
        int allPeopleNumber = personList.size();
        int equalPeopleNumber = 0;
        int notEqualPeopleNumber = 0;

        for (Person person : personList){
            if (personToCompare.compareTo(person) == 0){
                equalPeopleNumber++;
            }else {
                notEqualPeopleNumber++;
            }
        }

        if (equalPeopleNumber > 1){
            System.out.println(equalPeopleNumber + " " + notEqualPeopleNumber + " " + allPeopleNumber);
        }else {
            System.out.println("No matches");
        }
    }
}
