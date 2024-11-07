package JavaAdvanced.StackAndQueue.ex;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //fib(5) = fib(4) + fib(3)
        //fib(n) = fib(n-1) + fib(n-2)
        Deque<Long> fibonacciStack = new ArrayDeque<>();

        fibonacciStack.push(0L);
        fibonacciStack.push(1L);

        int number = Integer.parseInt(scanner.nextLine());

        if (number < 2){
            System.out.println(1);
            return;
        }

        for (int i = 1; i <= number; i++) {
                // n - 1
                long firstNumber = fibonacciStack.pop();
                // n- 2
                long secondNumber = fibonacciStack.pop();

                fibonacciStack.push(firstNumber);
                fibonacciStack.push(firstNumber + secondNumber);

        }

        long result = fibonacciStack.peek();
        System.out.println(result);
    }
}
