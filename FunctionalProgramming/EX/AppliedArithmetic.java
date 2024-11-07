package JavaAdvanced.FunctionalProgramming.EX;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AppliedArithmetic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        //Commands:
        //add  n + 1
        //multiply  n * 2
        //subtract n - 1
        //print


        Function<List<Integer>, List<Integer>> correctedNumbers;
        String command = scanner.nextLine();

        while (!command.equals("end")){

            switch (command){
                case "add" -> {
                    correctedNumbers = list -> {
                        for (int i = 0; i < list.size(); i++) {
                            list.set(i, list.get(i) + 1);
                        }
                        return list;
                    };
                    correctedNumbers.apply(numbers);
                }
                case "subtract" -> {
                    correctedNumbers = list -> {
                        for (int i = 0; i < list.size(); i++) {
                            list.set(i, list.get(i) - 1);
                        }
                        return list;
                    };
                    correctedNumbers.apply(numbers);
                }
                case "multiply" -> {
                    correctedNumbers = list -> {
                        for (int i = 0; i < list.size(); i++) {
                            list.set(i, list.get(i) * 2);
                        }
                        return list;
                    };
                    correctedNumbers.apply(numbers);
                }
                case "print" -> {
                    Consumer<List<Integer>> print = list -> list.forEach(number -> System.out.print(number + " "));
                    print.accept(numbers);
                    System.out.println();
                }
            }

            command = scanner.nextLine();
        }

    }
}
