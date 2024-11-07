package JavaAdvanced.Generics.EX.CountMethodStrings;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<String> list = new ArrayList<>();

        fillList(scanner, n, list);

        String compareElement = scanner.nextLine();
        compareListElements(compareElement,list);
    }

    private static <T extends Comparable<T>> void compareListElements(String compareElement, List<T> list) {
        int count = 0;

        for (Object object : list){
           if (compareElement.compareTo(object.toString()) <= -1){
               count++;
           }
        }

        System.out.println(count);
    }

    private static void fillList(Scanner scanner, int n, List<String> list) {

        for (int element = 0; element < n; element++) {
            list.add(scanner.nextLine());
        }
    }
}
