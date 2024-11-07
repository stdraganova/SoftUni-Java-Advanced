package JavaAdvanced.StackAndQueue;

import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();

        //създаваме опашка
        ArrayDeque<String> queue = new ArrayDeque<>();

        while (!command.equals("print")){
            if (command.equals("cancel")){
                if (queue.isEmpty()){
                    System.out.println("Printer is on standby");
                }else {
                    String document = queue.poll();
                    System.out.println("Canceled " + document);
                }
            }else {
                queue.offer(command);
            }

            command = scanner.nextLine();
        }

        for (String document : queue){
            System.out.println(document);
        }
    }
}
