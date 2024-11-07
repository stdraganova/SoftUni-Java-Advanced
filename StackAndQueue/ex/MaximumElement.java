package JavaAdvanced.StackAndQueue.ex;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Deque<Integer> numbersStack = new ArrayDeque<>();

        for (int i = 1; i <= n; i++) {
            String[] command = scanner.nextLine().split("\\s+");

            switch (command[0]){
                case "1" ->{numbersStack.push(Integer.parseInt(command[1]));}
                case "2" ->{numbersStack.pop();}
                case "3" ->{
                    System.out.println(Collections.max(numbersStack));
                }
            }
        }

    }
}
