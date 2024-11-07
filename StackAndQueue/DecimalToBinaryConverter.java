package JavaAdvanced.StackAndQueue;

import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinaryConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int decimal = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> stack = new ArrayDeque<>();

        if (decimal == 0){
            System.out.println("0");
        }else {
            while (decimal > 0) {
                int digit = decimal % 2;
                stack.push("" + digit);
                decimal /= 2;
            }
            //String.join() - работи само за стрингове
            System.out.println(String.join("", stack));
        }
    }
}
