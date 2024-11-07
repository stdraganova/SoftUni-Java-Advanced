package JavaAdvanced.Generics.EX.SwapMethodIntegers;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> list = new ArrayList<>();

        int numberOfelements = Integer.parseInt(scanner.nextLine());

        fillList(scanner, list, numberOfelements);

        int firstIndex = scanner.nextInt();
        int secondIndex = scanner.nextInt();

        swapElements(firstIndex,secondIndex, list);
        print(list);

    }

    private static void print(List<?> list) {

        for (Object object : list){
            System.out.printf("%s: %s%n", object.getClass().getName(), object);
        }
    }

    private static <T> void swapElements(int firstIndex, int secondIndex, List<? super T> list) {

        T firstElement = (T)list.get(firstIndex);
        T secondElement = (T)list.get(secondIndex);

        list.set(firstIndex, secondElement);
        list.set(secondIndex, firstElement);

    }

    private static void fillList(Scanner scanner, List<Integer> list, int numberOfelements) {
        for (int i = 0; i < numberOfelements; i++) {
            int input = Integer.parseInt(scanner.nextLine());
            list.add(input);
        }
    }
}

