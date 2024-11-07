package JavaAdvanced.StackAndQueue;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] kids = scanner.nextLine().split("\\s+");
        int rotations = Integer.parseInt(scanner.nextLine());

        PriorityQueue<String> queue = new PriorityQueue<>();
        Collections.addAll(queue,kids);

        int cycle = 1;
        while (queue.size() > 1){

            for (int i = 1; i < rotations; i++) {
                String kid = queue.poll();
                queue.offer(kid);
            }

            if (isPrime(cycle)){
                System.out.println("Prime " + queue.peek());
            }else {
                System.out.println("Removed " + queue.poll());
            }
            cycle++;
        }
        System.out.println("Last is " + queue.poll());
    }

    public static boolean isPrime(int cycle){
        boolean isPrime = true;
        //просто число
        //започва от 2 понеже всяко число се дели на 1
        // стига до числото - 1 понеже всяко число се дели само на себе си
        //не трябва да се дели на нито едно от останалите числа в този интервал
        if (cycle <= 1){
            isPrime = false;
        }
        for (int i = 2; i < cycle; i++) {
            if (cycle % i == 0){
                isPrime = false;
            }
        }

        return isPrime;
    }
}
