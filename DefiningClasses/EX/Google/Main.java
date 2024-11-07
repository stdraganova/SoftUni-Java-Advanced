package JavaAdvanced.DefiningClasses.EX.Google;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        Map<String, Person> people = new LinkedHashMap<>();

        while (!command.equals("End")) {
            String[] tokens = command.split("\\s+");
            String personName = tokens[0];

            // Get or create the person
            people.putIfAbsent(personName, new Person(personName));
            Person person = people.get(personName);

            switch (tokens[1]) {
                case "car" -> {
                    String model = tokens[2];
                    int speed = Integer.parseInt(tokens[3]);
                    Person.Car car = new Person.Car(model, speed);
                    person.setCar(car);
                }
                case "company" -> {
                    String companyName = tokens[2];
                    String position = tokens[3];
                    double salary = Double.parseDouble(tokens[4]);
                    Person.Company company = new Person.Company(companyName, position, salary);
                    person.setCompany(company);
                }
                case "pokemon" -> {
                    String pokemonName = tokens[2];
                    String pokemonType = tokens[3];
                    Person.Pokemon pokemon = new Person.Pokemon(pokemonName, pokemonType);
                    person.addPokemon(pokemon);
                }
                case "parents" -> {
                    String parentName = tokens[2];
                    String birthDay = tokens[3];
                    Person.Parent parent = new Person.Parent(parentName, birthDay);
                    person.addParent(parent);
                }
                case "children" -> {
                    String childName = tokens[2];
                    String childBirthday = tokens[3];
                    Person.Children child = new Person.Children(childName, childBirthday);
                    person.addChild(child);
                }
            }

            command = scanner.nextLine();
        }

        String name = scanner.nextLine();

        // Print the details of the person
        if (people.containsKey(name)) {
            Person person = people.get(name);
            System.out.println(person);
        }
    }
}
