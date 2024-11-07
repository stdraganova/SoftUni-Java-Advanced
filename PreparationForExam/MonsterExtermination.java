package JavaAdvanced.PreparationForExam;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class MonsterExtermination {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Queue - offer, poll
        Deque<Integer> monsterArmorQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(",")).map(Integer::parseInt).forEach(monsterArmorQueue::offer);

        //Stack - push, pop
        Deque<Integer> solderStrikingImpactStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(",")).map(Integer::parseInt).forEach(solderStrikingImpactStack::push);

        int totalMonstersKilled = 0;

        while (!monsterArmorQueue.isEmpty() && !solderStrikingImpactStack.isEmpty()){
            int monster = monsterArmorQueue.poll();
            int solderStrike = solderStrikingImpactStack.pop();

            if (solderStrike >= monster){
                solderStrike -= monster;
                totalMonstersKilled++;

                if (solderStrike > 0){
                    if (!solderStrikingImpactStack.isEmpty()) {
                        int nextElement = solderStrikingImpactStack.pop();
                        nextElement += solderStrike;
                        solderStrikingImpactStack.push(nextElement);
                    }else {
                        solderStrikingImpactStack.push(solderStrike);
                    }
                }

            }else {
                monster -= solderStrike;
                monsterArmorQueue.offer(monster);
            }
        }

        if (monsterArmorQueue.isEmpty()){
            System.out.println("All monsters have been killed!");
        }

        if (solderStrikingImpactStack.isEmpty()) {
            System.out.println("The soldier has been defeated.");
        }

        System.out.printf("Total monsters killed: %d", totalMonstersKilled);
    }
}
