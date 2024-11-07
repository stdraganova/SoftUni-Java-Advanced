package JavaAdvanced.Generics.EX.CountMethodDoubles;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Double> list = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());
        fillList(n, scanner, list);

        double numberToCompare = Double.parseDouble(scanner.nextLine());

        compareElementts(list, numberToCompare);
    }

    private static <T> void compareElementts(List<T> list, double numberToCompare) {
        int count = 0;

        for (Object object : list){
            if (numberToCompare < Double.parseDouble(object.toString())){
                count++;
            }
        }

        System.out.println(count);
    }

    private static void fillList(int n, Scanner scanner, List<Double> list) {
        for (int element = 0; element < n; element++) {
            list.add(Double.parseDouble(scanner.nextLine()));
        }
    }
}
