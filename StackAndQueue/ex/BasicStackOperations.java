package JavaAdvanced.StackAndQueue.ex;

import java.util.*;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        int n = Integer.parseInt(input[0]); //Бр.елементи, които да се пушнат в стака
        int s = Integer.parseInt(input[1]); // Бр.ел., които да се премахнат от стака(попнат)
        int x = Integer.parseInt(input[2]); // Ел., който да проверим дали се съдържа в стака

        //създаваме стака
        Deque<Integer> numbersStack = new ArrayDeque<>();
        //запълваме стака директно от входа на конзолата
        //С n/бр.ел
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).forEach(numbersStack::push);

        //Премахваме s/бр.ел
        for (int i = 1; i <= s; i++) {
            numbersStack.pop();
        }

        //Проверяваме дали елемента се съдържа в стека.
        if (numbersStack.isEmpty()){
            System.out.println(0);
        } else if (!numbersStack.contains(x)) {
            System.out.println(Collections.min(numbersStack));
        }else {
            System.out.println("true");
        }

    }
}
