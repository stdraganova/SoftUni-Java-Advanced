package JavaAdvanced.Generics.EX.GenericBox;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < number; i++) {
            BoxFirst<String> box = new BoxFirst<>(scanner.nextLine());
            System.out.println(box);
        }

    }
}

