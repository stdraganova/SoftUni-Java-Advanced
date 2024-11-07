package JavaAdvanced.StreamsFilesAndDirectories.EX.Problems;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SumLines {
    public static void main(String[] args) throws IOException {
        Path path = Path.of("C:\\Users\\User\\IdeaProjects\\SoftUniJavaAdvnced\\src\\JavaAdvanced\\StreamsFilesAndDirectories\\EX\\Files\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt");
        BufferedReader bf = Files.newBufferedReader(path);

        String line = bf.readLine();

        while (line != null){
            long sum = 0;

            for (char c : line.toCharArray()){

                if ((int)c != 10 && (int)c != 32){
                    sum += c;
                }
            }

            System.out.println(sum);
            line = bf.readLine();
        }

    }
}
