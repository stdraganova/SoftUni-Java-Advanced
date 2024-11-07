package JavaAdvanced.DefiningClasses.EX.RawData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        List<Car> carsList = new ArrayList<>();
        Car car;

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String model = tokens[0];
            int speed = Integer.parseInt(tokens[1]);
            int power = Integer.parseInt(tokens[2]);
            int weight = Integer.parseInt(tokens[3]);
            String cargoType = tokens[4];
            List<Double> tires = new ArrayList<>();

            for (int token = 5; token < tokens.length; token += 2) {
                tires.add(Double.parseDouble(tokens[token]));
            }

            car = new Car(model,speed,power, weight,cargoType,tires);
            carsList.add(car);
        }

        String command = scanner.nextLine();

        switch (command){
            case "fragile" -> {
                carsList.stream().forEach(entry -> {
                    String type = entry.getCargoType();
                    List<Double> tires = entry.getTires();
                    double pressure = 0;

                    for (Double tire : tires){
                        if (tire > 1 ){
                            pressure += tire;
                        }
                    }

                    pressure = pressure / tires.size();

                    if (pressure < 1 && type.equals(command)){
                        System.out.println(entry.getModel());
                    }
                });
            }
            case "flamable" -> {
                carsList.stream().forEach(entry -> {
                    String type = entry.getCargoType();
                   int power = entry.getEnginePower();

                   if (power > 250 && type.equals(command)){
                       System.out.println(entry.getModel());
                   }
                });
            }
        }
    }
}
