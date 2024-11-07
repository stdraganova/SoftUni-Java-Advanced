package JavaAdvanced.DefiningClasses.EX.CarSalesman;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfEngines = Integer.parseInt(scanner.nextLine());

        //Engine Info
        //model, power, displacement, efficiency
        Map<String, Engine> engineMap = new HashMap<>();

        for (int i = 0; i < numberOfEngines; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String model = tokens[0];
            int power = Integer.parseInt(tokens[1]);

            Engine engine;
            switch (tokens.length){
                case 2 -> {
                    engine = new Engine(model,power);
                    engineMap.put(model,engine);
                }
                case 3 -> {
                   if (tokens[2].matches("\\d+")){
                       int displacement = Integer.parseInt(tokens[2]);
                       engine = new Engine(model, power, displacement);
                       engineMap.put(model,engine);
                   }else {
                       String efficiency = tokens[2];
                       engine = new Engine(model, power, efficiency);
                       engineMap.put(model,engine);
                   }
                }
                case 4 -> {
                    int displacement = Integer.parseInt(tokens[2]);
                    String efficiency = tokens[3];
                    engine = new Engine(model, power, displacement, efficiency);
                    engineMap.put(model,engine);
                }
            }
        }


        int numberOfCars = Integer.parseInt(scanner.nextLine());
        List<Car> carList = new ArrayList<>();

        //Cars Info
        //Model EngineModel Weight Color
        for (int i = 0; i < numberOfCars; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String model = tokens[0];
            String engineModel = tokens[1];
            Engine engine = engineMap.get(engineModel);


            Car car;

            switch (tokens.length){
                case 2 -> {
                    car = new Car(model,engine);
                    carList.add(car);
                }
                case 3 -> {
                    if (tokens[2].matches("\\d+")){
                        int weight = Integer.parseInt(tokens[2]);
                        car = new Car(model,engine, weight);
                        carList.add(car);
                    }else {
                        String color = tokens[2];
                        car = new Car(model,engine, color);
                        carList.add(car);
                    }
                }
                case 4 -> {
                    int weight = Integer.parseInt(tokens[2]);
                    String color = tokens[3];

                    car = new Car(model,engine, weight, color);
                    carList.add(car);
                }
            }

        }

        carList.forEach(System.out::print);
    }
}
