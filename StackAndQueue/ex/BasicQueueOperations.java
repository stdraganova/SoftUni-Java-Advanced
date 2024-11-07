package JavaAdvanced.StackAndQueue.ex;

import java.util.*;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] elements = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        //Number of elements to OFFER
        int n = elements[0];
        //Number of elements to PULL
        int s = elements[1];
        //Number to check if is present
        int x = elements[2];

        //Creating the QUEUE
        Deque<Integer> numbersQueue = new ArrayDeque<>();
        //Filling the queue
        for (int i = 1; i <= n; i++) {
            numbersQueue.offer(scanner.nextInt());
        }
        //Polling from the queue
        for (int i = 1; i <= s; i++) {
            numbersQueue.poll();
        }
        //Check the number if is present
        if (numbersQueue.isEmpty()){
            System.out.println(0);
        } else if (!numbersQueue.contains(x)) {
            System.out.println(Collections.min(numbersQueue));
        }else {
            System.out.println("true");
        }
    }
}
