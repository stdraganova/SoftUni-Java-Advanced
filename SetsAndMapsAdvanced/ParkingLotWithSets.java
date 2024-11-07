package JavaAdvanced.SetsAndMapsAdvanced;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class ParkingLotWithSets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Set<String> carsSet = new LinkedHashSet<>();

        while (!input.equals("END")){
            String command = input.split(", ")[0];
            String carNumber = input.split(", ")[1];

            switch (command){
                case "IN" -> {carsSet.add(carNumber);}
                case "OUT" -> {carsSet.remove(carNumber);}
            }

            input = scanner.nextLine();
        }

        if (carsSet.isEmpty()){
            System.out.println("Parking Lot is Empty");
        }else {
            for (String carNumber : carsSet) {
                System.out.println(carNumber);
            }
        }
    }
}
