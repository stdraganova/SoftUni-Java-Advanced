package JavaAdvanced.Generics.EX.CustomListSorter;

import java.util.Scanner;

public class Main {

    public static <T extends Comparable<T>> void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] command = scanner.nextLine().split("\\s+");
        CustomList2<T> list = new CustomList2<>();
        Sorter sorter = new Sorter();

        while (!command[0].equals("END")) {

            switch (command[0]) {
                case "Add" -> {
                    list.add((T) command[1]);
                }
                case "Remove" -> {
                    list.remove(Integer.parseInt(command[1]));
                }
                case "Contains" -> {
                    System.out.println(list.contains((T) command[1]));
                }
                case "Swap" -> {
                    int firstIndex = Integer.parseInt(command[1]);
                    int secondIndex = Integer.parseInt(command[2]);

                    list.swap(firstIndex, secondIndex);
                }
                case "Greater" -> {
                    int count = list.countGreaterThan((T) command[1]);

                    System.out.println(count);
                }
                case "Max" -> {
                    System.out.println(list.getMax());
                }
                case "Min" -> {
                    System.out.println(list.getMin());
                }
                case "Sort" -> {
                   sorter.sort(list);
                }
                case "Print" -> {
                    for (Object object : list) {
                        System.out.println(object);
                    }
                }
            }

            command = scanner.nextLine().split("\\s+");
        }
    }
}