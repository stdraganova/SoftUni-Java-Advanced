package JavaAdvanced.StackAndQueue;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] kids = scanner.nextLine().split("\\s+");
        int rotations = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> queue = new ArrayDeque<>();
        Collections.addAll(queue,kids);

        int turn = 0;
        while (queue.size() > 1){
            turn++;

            if (turn % rotations == 0){
                System.out.println("Removed " + queue.poll());
            }else {
                String firstKid = queue.poll();
                queue.offer(firstKid);
            }
        }
        System.out.println("Last is " + queue.poll());
    }
}
