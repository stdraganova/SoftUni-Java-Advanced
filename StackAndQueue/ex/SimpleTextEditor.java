package JavaAdvanced.StackAndQueue.ex;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Deque<String> stack = new ArrayDeque<>();
        String text = "";

        for (int i = 0; i < n; i++) {
            String[] command = scanner.nextLine().split("\\s+");

            switch (command[0]){
                case "1" ->{
                    //append text
                    //първо пушваме настоящия текст в стака
                    //после променяме самия текст, за да се застраховаме за команда ънду
                    stack.push(text);
                    text += command[1];
                }
                case "2" ->{
                    stack.push(text);
                    int count = Integer.parseInt(command[1]);
                    text = text.substring(0, text.length() - count);

                }
                case "3" ->{
                    int index = Integer.parseInt(command[1]);
                    System.out.println(text.charAt(index - 1));
                }
                case "4" ->{
                    text = stack.pop();
                }
            }
        }

    }
}
