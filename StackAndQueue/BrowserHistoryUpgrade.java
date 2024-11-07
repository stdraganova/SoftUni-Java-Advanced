package JavaAdvanced.StackAndQueue;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();

        ArrayDeque<String> firstStack = new ArrayDeque<>();
        ArrayDeque<String> secondStack = new ArrayDeque<>();

        while (!command.equals("Home")){
            if (command.equals("forward")){
                if (secondStack.size() >= 1){
                    String url = secondStack.pop();
                    firstStack.push(url);
                    System.out.println(url);
                }else {
                    System.out.println("no next URLs");
                }
                
            } else if (command.equals("back")) {
                if (firstStack.size() > 1) {
                    String url = firstStack.pop();
                    secondStack.push(url);
                    System.out.println(firstStack.peek());
                }else {
                    System.out.println("no previous URLs");
                }
            }else {
                firstStack.push(command);
                secondStack.clear();
                System.out.println(command);
            }
            command = scanner.nextLine();
        }
    }
}
