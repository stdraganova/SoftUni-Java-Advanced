package JavaAdvanced.StackAndQueue;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //четем входните данни и ги сплитваме по един или повече интервали
        String[] input = scanner.nextLine().split("\\s+");
        //създаваме стек
        ArrayDeque<String> stack = new ArrayDeque<>();
        //добавяме санните в стека
        Collections.addAll(stack,input);

        //сумираме елементите
        int sum = 0;

        while (stack.size() > 1){
            int firstNum = Integer.parseInt(stack.pop());
            String symbol = stack.pop();
            int secondNum = Integer.parseInt(stack.pop());

            switch (symbol){
                case "+" -> {sum = secondNum + firstNum;}
                case "-" -> {sum = firstNum - secondNum;}
            }

            stack.push("" + sum);
        }

        System.out.println(stack.peek());
    }
}
