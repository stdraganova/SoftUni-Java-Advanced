package JavaAdvanced.StackAndQueue;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String instruction = scanner.nextLine();

        ArrayDeque<String> stack = new ArrayDeque<>();

        while (!instruction.equals("Home")){
            if (instruction.equals("back")){
                if (stack.size() > 1){
                    stack.pop();
                    System.out.println(stack.peek());
                }else {
                    System.out.println("no previous URLs");
                }
            }else {
                stack.push(instruction);
                System.out.println(instruction);
            }

            instruction = scanner.nextLine();
        }
    }
}
