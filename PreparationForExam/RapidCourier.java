package JavaAdvanced.PreparationForExam;

import java.util.*;
import java.util.stream.Collectors;

public class RapidCourier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Packages stack
        Deque<Integer> packagesStack = new ArrayDeque<>();
        //Courier queue
        Deque<Integer> couriersQueue = new ArrayDeque<>();

        //Пълня стака
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(number -> packagesStack.push(number));
        //Пълня кюто
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(couriersQueue::offer);

        int totalDeliveredWeight = 0;

        while (!packagesStack.isEmpty() && !couriersQueue.isEmpty()){
            int firstPackage = packagesStack.pop();
            int firstCourier = couriersQueue.poll();

            if (firstCourier > firstPackage){
                totalDeliveredWeight += firstPackage;

                if (firstCourier - 2 * firstPackage > 0){
                    couriersQueue.offer(firstCourier - 2 * firstPackage);
                }

            } else if (firstCourier == firstPackage) {
                totalDeliveredWeight += firstPackage;
            } else if (firstCourier < firstPackage) {
                totalDeliveredWeight += firstCourier;
                int difference = firstPackage - firstCourier;

                if (difference > 0){
                    packagesStack.push(difference);
                }
            }
        }

        System.out.printf("Total weight: %d kg%n", totalDeliveredWeight);

        if (packagesStack.isEmpty() && couriersQueue.isEmpty()){
            System.out.println("Congratulations, all packages were delivered successfully by the couriers today.");
        }else if(couriersQueue.isEmpty() && !packagesStack.isEmpty()){
            System.out.print("Unfortunately, there are no more available couriers to deliver the following packages: ");
            //Printing Stack in reverse order
            System.out.print(getElements(packagesStack));
        }else {
            System.out.printf("Couriers are still on duty: %s but there are no more packages to deliver.", getCouriers(couriersQueue));
        }
    }

    private static String getCouriers(Deque<Integer> couriersQueue) {
     return couriersQueue.stream().map(String::valueOf).collect(Collectors.joining(", "));
    }

    private static String getElements(Deque<Integer> packagesStack) {
        Iterator<Integer> iteratot = packagesStack.descendingIterator();
        StringBuilder sb = new StringBuilder();

        sb.append(iteratot.next());
        while (iteratot.hasNext()){
            sb.append(", ");
            sb.append(iteratot.next());
        }

        return sb.toString();
    }
}
