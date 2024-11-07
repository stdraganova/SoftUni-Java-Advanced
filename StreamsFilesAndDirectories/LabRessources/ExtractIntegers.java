package JavaAdvanced.StreamsFilesAndDirectories.LabRessources;

import java.io.*;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class ExtractIntegers {
    public static void main(String[] args) throws IOException {

        FileInputStream file  =new FileInputStream("C:\\Users\\User\\IdeaProjects\\SoftUniJavaAdvnced\\src\\JavaAdvanced\\StreamsFilesAndDirectories\\LabRessources\\input.txt");
        Scanner scanner = new Scanner(file);

        while (scanner.hasNext()){
            if (scanner.hasNextInt()){
                System.out.println(scanner.nextInt());
            }

            scanner.next();
        }
    }
}
