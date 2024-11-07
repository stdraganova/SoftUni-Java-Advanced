package JavaAdvanced.PreparationForExam;

import java.util.Arrays;
import java.util.Scanner;

public class MouseInTheKitchen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] tokens = Arrays.stream(scanner.nextLine().split(","))
                .mapToInt(Integer::parseInt).toArray();

        char[][] kitchen =new char[tokens[0]][tokens[1]];
        int[] mouseCoordinates = fillMatrix(kitchen, scanner);
        int cheeseCount = countCheese(kitchen);

        String command = scanner.nextLine();

        while (!command.equals("danger")){

            int currentMouseRow = mouseCoordinates[0];
            int currentMouseCol = mouseCoordinates[1];

            switch (command){
                case "up" -> {currentMouseRow--;}
                case "down" -> {currentMouseRow++;}
                case "left" -> {currentMouseCol--;}
                case "right" -> {currentMouseCol++;}
            }

            if (checkCoordinates(currentMouseRow,currentMouseCol, kitchen)){
                System.out.println("No more cheese for tonight!");
                printMatrix(kitchen);
                return;
            }

            char symbol = kitchen[currentMouseRow][currentMouseCol];

            switch (symbol){
                case 'C' -> {
                    moveMouse(kitchen, mouseCoordinates, currentMouseRow, currentMouseCol);
                    cheeseCount--;
                    if (cheeseCount <= 0){
                        System.out.println("Happy mouse! All the cheese is eaten, good night!");
                        printMatrix(kitchen);
                        return;
                    }
                }
                case '*' -> {
                    moveMouse(kitchen, mouseCoordinates, currentMouseRow, currentMouseCol);
                }
                case 'T' -> {
                    moveMouse(kitchen, mouseCoordinates, currentMouseRow, currentMouseCol);
                    System.out.println("Mouse is trapped!");
                    printMatrix(kitchen);
                    return;
                }
            }

            command = scanner.nextLine();
        }

        if (cheeseCount != 0){
            System.out.println("Mouse will come back later!");
            printMatrix(kitchen);
        }
    }

    private static void moveMouse(char[][] kitchen, int[] mouseCoordinates, int currentMouseRow, int currentMouseCol) {
        kitchen[currentMouseRow][currentMouseCol] = 'M';
        kitchen[mouseCoordinates[0]][mouseCoordinates[1]] = '*';

        mouseCoordinates[0] = currentMouseRow;
        mouseCoordinates[1] = currentMouseCol;
    }

    private static void printMatrix(char[][] kitchen) {
        for (int row = 0; row < kitchen.length; row++) {
            System.out.println(kitchen[row]);
        }
    }

    private static int countCheese(char[][] kitchen) {
        int count = 0;

        for (int row = 0; row < kitchen.length; row++) {
            for (int col = 0; col < kitchen[0].length; col++) {
                if (kitchen[row][col] == 'C'){
                    count++;
                }
            }
        }

        return count;
    }

    private static boolean checkCoordinates(int currentMouseRow, int currentMouseCol, char[][] kitchen) {
        boolean wrongCoordinates = false;
        if (currentMouseRow < 0 || currentMouseRow > kitchen.length - 1){
               wrongCoordinates = true;
        }
        if (currentMouseCol < 0 || currentMouseCol > kitchen[0].length - 1){
                wrongCoordinates = true;
        }

        return wrongCoordinates;
    }

    private static int[] fillMatrix(char[][] kitchen, Scanner scanner) {
        int[] mouseCoordinates = new int[2];
        boolean mouseFound = false;

        for (int row = 0; row < kitchen.length; row++) {
            kitchen[row] = scanner.nextLine().toCharArray();

            if (!mouseFound) {
                for (int col = 0; col < kitchen[row].length; col++) {
                    if (kitchen[row][col] == 'M') {
                        mouseCoordinates[0] = row;
                        mouseCoordinates[1] = col;
                        mouseFound = true;
                        break;
                    }
                }
            }
        }

        return mouseCoordinates;
    }
}
