package JavaAdvanced.StackAndQueue.ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;
import java.util.stream.*;
import java.util.stream.Collectors;

public class PoisonousPlants {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int plantNumber = Integer.parseInt(scanner.nextLine());

        List <Integer> plantsPesticides;

        plantsPesticides = Arrays.stream(scanner.nextLine().
                split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        ArrayDeque<Integer> plantsToRemoveIndexesQueue = new ArrayDeque<>();

        int counter = 0;
        while (plantsPesticides.size() > 1) {
            for (int i = 1; i < plantsPesticides.size(); i++) {
                int first = plantsPesticides.get(i);
                int second = plantsPesticides.get(i - 1);
                if (first > second) {
                    plantsToRemoveIndexesQueue.offer(i);
                }
            }
            if (plantsToRemoveIndexesQueue.isEmpty()){
                System.out.println(counter);
                return;
            }

            int removedCounter = 0;
            while (!plantsToRemoveIndexesQueue.isEmpty()){
                int indexToRemove = plantsToRemoveIndexesQueue.poll() - removedCounter;
                plantsPesticides.remove(indexToRemove);
                removedCounter++;
            }

            counter++;
        }

        System.out.println(counter);

    }
}
