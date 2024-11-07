package JavaAdvanced.FunctionalProgramming;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.function.Predicate;

public class FilterByAge {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Integer> people = new LinkedHashMap<>();
        fillMap(people, scanner, n);

        String command = scanner.nextLine();
        int controlAge = Integer.parseInt(scanner.nextLine());

        Map<String,Integer> correctAnswers = new LinkedHashMap<>();
        Predicate<Integer> predicate;
        switch (command){
            case "older" -> {
                predicate = age -> age >= controlAge;
                removingPeople(predicate, people,correctAnswers);
            }
            case "younger" -> {
                predicate = age -> age <= controlAge;
                removingPeople(predicate, people, correctAnswers);
            }
        }

        String condition = scanner.nextLine();
        print(condition, correctAnswers);

    }

    private static void print(String condition, Map<String, Integer> correctAnswers) {
        switch (condition){
            case "name" -> {
               for (Map.Entry<String, Integer> entry : correctAnswers.entrySet()){
                   System.out.println(entry.getKey());
               }
            }
            case "age" -> {
                for (Map.Entry<String, Integer> entry : correctAnswers.entrySet()){
                    System.out.println(entry.getValue());
                }
            }
            case "name age" -> {
                for (Map.Entry<String, Integer> entry : correctAnswers.entrySet()){
                    System.out.println(entry.getKey() + " - " + entry.getValue());
                }
            }
        }
    }

    private static void removingPeople(Predicate<Integer> predicate, Map<String, Integer> people, Map<String,Integer> correctAnswers ) {
        for (Map.Entry<String, Integer>entry : people.entrySet()){
            int age = entry.getValue();
            String name = entry.getKey();

            if (predicate.test(age)){
                correctAnswers.put(name,age);
            }
        }
    }

    private static void fillMap(Map<String, Integer> people, Scanner scanner, int n) {
        for (int i = 1; i <= n; i++) {
            String[] input = scanner.nextLine().split(", ");
            String name = input[0];
            int age = Integer.parseInt(input[1]);

            people.put(name, age);
        }
    }
}
