package JavaAdvanced.DefiningClasses.EX.Google;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private Car car;
    private Company company;
    private List<Pokemon> pokemons;
    private List<Parent> parents;
    private List<Children> children;

    public Person(String name) {
        this.name = name;
        this.pokemons = new ArrayList<>();
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void addPokemon(Pokemon pokemon) {
        this.pokemons.add(pokemon);
    }

    public void addParent(Parent parent) {
        this.parents.add(parent);
    }

    public void addChild(Children child) {
        this.children.add(child);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append("\n");

        sb.append("Company:").append("\n");
        if (company != null) {
            sb.append(company);
        }

        sb.append("Car:").append("\n");
        if (car != null) {
            sb.append(car);
        }

        sb.append("Pokemon:\n");
        for (Pokemon pokemon : pokemons) {
            sb.append(pokemon);
        }

        sb.append("Parents:\n");
        for (Parent parent : parents) {
            sb.append(parent);
        }

        sb.append("Children:\n");
        for (Children child : children) {
            sb.append(child);
        }

        return sb.toString();
    }


    public static class Company {
        private String companyName;
        private String department;
        private double salary;

        public Company(String companyName, String department, double salary) {
            this.companyName = companyName;
            this.department = department;
            this.salary = salary;
        }

        @Override
        public String toString() {
            return String.format("%s %s %.2f\n", companyName, department, salary);
        }
    }

    public static class Car {
        private String carModel;
        private int carSpeed;

        public Car(String carModel, int carSpeed) {
            this.carModel = carModel;
            this.carSpeed = carSpeed;
        }

        @Override
        public String toString() {
            return String.format("%s %d\n", carModel, carSpeed);
        }
    }

    public static class Parent {
        private String name;
        private String birthDay;

        public Parent(String name, String birthDay) {
            this.name = name;
            this.birthDay = birthDay;
        }

        @Override
        public String toString() {
            return String.format("%s %s\n", name, birthDay);
        }
    }

    public static class Children {
        private String childName;
        private String childBirthday;

        public Children(String childName, String childBirthday) {
            this.childName = childName;
            this.childBirthday = childBirthday;
        }

        @Override
        public String toString() {
            return String.format("%s %s\n", childName, childBirthday);
        }
    }

    public static class Pokemon {
        private String pokemonName;
        private String pokemonType;

        public Pokemon(String pokemonName, String pokemonType) {
            this.pokemonName = pokemonName;
            this.pokemonType = pokemonType;
        }

        @Override
        public String toString() {
            return String.format("%s %s\n", pokemonName, pokemonType);
        }
    }
}
