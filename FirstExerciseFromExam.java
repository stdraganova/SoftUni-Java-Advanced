import java.util.*;

public class FirstExerciseFromExam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> strengthStack = new ArrayDeque<>();
        Deque<Integer> accuracyQueue = new ArrayDeque<>();

        // Parse strength values (stack)
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).forEach(strengthStack::push);

        // Parse accuracy values (queue)
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).forEach(accuracyQueue::offer);

        int score = 0;

        // Main loop for checking strength and accuracy
        while (!strengthStack.isEmpty() && !accuracyQueue.isEmpty()) {
            int lastStrength = strengthStack.peek();
            int firstAccuracy = accuracyQueue.peek();

            int sum = lastStrength + firstAccuracy;

            if (sum == 100) {
                // Goal scored
                strengthStack.pop();
                accuracyQueue.poll();
                score++;
            } else if (sum < 100) {
                // If the sum is less than 100, remove the smaller value
                if (lastStrength < firstAccuracy) {
                    strengthStack.pop();
                } else if (lastStrength > firstAccuracy) {
                    accuracyQueue.poll();
                } else {
                    // If both values are equal, pop and push the sum into strength
                    strengthStack.pop();
                    strengthStack.push(sum);
                    accuracyQueue.poll();
                }
            } else {
                // If the sum is more than 100, decrease strength and try again
                strengthStack.pop(); // Pop before modifying
                lastStrength -= 10;
                if (lastStrength > 0) {
                    strengthStack.push(lastStrength); // Push the modified value back
                }
                accuracyQueue.offer(accuracyQueue.poll()); // Move accuracy to the back
            }
        }

        // Print result based on the score
        if (score == 3) {
            System.out.println("Paul scored a hat-trick!");
        } else if (score == 0) {
            System.out.println("Paul failed to score a single goal.");
        } else if (score > 3) {
            System.out.println("Paul performed remarkably well!");
        } else if (score > 0 && score < 3) {
            System.out.println("Paul failed to make a hat-trick.");
        }

        // Print the number of goals scored
        if (score > 0) {
            System.out.printf("Goals scored: %d%n", score);
        }

        // Print remaining strength values, if any
        if (!strengthStack.isEmpty()) {
            System.out.println(printStack(strengthStack));
        }

        // Print remaining accuracy values, if any
        if (!accuracyQueue.isEmpty()) {
            System.out.println(printQueue(accuracyQueue));
        }
    }

    // Helper method to print remaining accuracy values
    private static String printQueue(Deque<Integer> accuracyQueue) {
        StringBuilder sb = new StringBuilder();
        sb.append("Accuracy values left: ");

        Iterator<Integer> iterator = accuracyQueue.iterator();

        if (iterator.hasNext()) {
            sb.append(iterator.next());
        }

        while (iterator.hasNext()) {
            sb.append(", ");
            sb.append(iterator.next());
        }

        return sb.toString();
    }

    // Helper method to print remaining strength values
    private static String printStack(Deque<Integer> strengthStack) {
        StringBuilder sb = new StringBuilder();
        sb.append("Strength values left: ");

        Iterator<Integer> iterator = strengthStack.descendingIterator();

        if (iterator.hasNext()) {
            sb.append(iterator.next());
        }

        while (iterator.hasNext()) {
            sb.append(", ");
            sb.append(iterator.next());
        }

        return sb.toString();
    }
}
