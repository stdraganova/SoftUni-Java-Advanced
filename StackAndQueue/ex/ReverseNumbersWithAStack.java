package JavaAdvanced.StackAndQueue.ex;

import java.util.*;

public class ReverseNumbersWithAStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
               .mapToInt(Integer::parseInt).toArray();

        Deque <Integer> stack = new ArrayDeque<>();

        for (int n : numbers){
            stack.push(n);
        }

        for (int n : stack){
            System.out.print(n + " ");
        }
    }
}
