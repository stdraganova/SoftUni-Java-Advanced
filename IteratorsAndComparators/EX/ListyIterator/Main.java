package JavaAdvanced.IteratorsAndComparators.EX.ListyIterator;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] command = scanner.nextLine().split("\\s+");
        ListyIterator listyIterator = new ListyIterator();

        while (!command[0].equals("END")){

            switch (command[0]){
                case "Create" -> {
                    if (command.length > 1){
                        //Пускаме стрийм и със скип изпускаме първия елемент
                        listyIterator.setElements(Arrays.stream(command).skip(1).toArray(String[]::new));
                    }
                   }
                case "HasNext" -> {
                    System.out.println(listyIterator.hasNext());
                    }
                case "Move" -> {
                    System.out.println(listyIterator.move());
                }
                case "Print" -> {
                    listyIterator.print();
                }
                case "PrintAll" -> {
                    listyIterator.printAll();
                }
            }
            command = scanner.nextLine().split("\\s+");
        }
    }
}
