package JavaAdvanced.PreparationForExam;

import java.util.*;
import java.util.stream.Collectors;

public class TempleOfDoom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Queue
        Deque<Integer> toolsQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(toolsQueue::offer);

        //Stack
        Deque<Integer> substancesStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(substancesStack::push);

        List<Integer> challenges  = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        while (!toolsQueue.isEmpty() && !substancesStack.isEmpty()){

            int firstElement = toolsQueue.poll();
            int lastElement = substancesStack.pop();

            int result = firstElement * lastElement;

            if (challenges.contains(result)){
                int index = challenges.indexOf(result);
                challenges.remove(index);
            }else {
                firstElement++;
                toolsQueue.offer(firstElement);

                lastElement--;

                if (lastElement > 0){
                    substancesStack.push(lastElement);
                }
            }
        }

        if ((substancesStack.isEmpty() || toolsQueue.isEmpty()) && !challenges.isEmpty()){
            System.out.println("Harry is lost in the temple. Oblivion awaits him.");
        }else if (challenges.isEmpty()){
            System.out.println("Harry found an ostracon, which is dated to the 6th century BCE.");
        }

        StringBuilder sb = new StringBuilder();
        if (!toolsQueue.isEmpty()){
            sb.append("Tools: ");
            sb.append(toolsQueue.stream().map(String::valueOf).collect(Collectors.joining(", ")));
            sb.append(System.lineSeparator());
        }
        if (!substancesStack.isEmpty()){
            sb.append("Substances: ");
            Iterator iterator = substancesStack.descendingIterator();

            sb.append(iterator.next());
            while (iterator.hasNext()){
                sb.append(", ");
                sb.append(iterator.next());
            }
            sb.append(System.lineSeparator());
        }
        if (!challenges.isEmpty()){
            sb.append("Challenges: ");
            Iterator iterator = challenges.iterator();

            sb.append(iterator.next());
            while (iterator.hasNext()){
                sb.append(", ");
                sb.append(iterator.next());
            }
            sb.append(System.lineSeparator());
        }

        System.out.println(sb);
    }
}
