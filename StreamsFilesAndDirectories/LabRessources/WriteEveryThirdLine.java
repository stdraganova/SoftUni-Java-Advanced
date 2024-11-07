package JavaAdvanced.StreamsFilesAndDirectories.LabRessources;

import java.io.*;
import java.nio.Buffer;
import java.nio.file.Path;
import java.util.List;

public class WriteEveryThirdLine {
    public static void main(String[] args) throws IOException {

        String path ="C:\\Users\\User\\IdeaProjects\\SoftUniJavaAdvnced\\src\\JavaAdvanced\\StreamsFilesAndDirectories\\LabRessources\\input.txt";
        FileReader file = new FileReader(path);
        BufferedReader reader = new BufferedReader(file);
        PrintWriter writer = new PrintWriter("C:\\Users\\User\\IdeaProjects\\SoftUniJavaAdvnced\\src\\JavaAdvanced\\StreamsFilesAndDirectories\\LabRessources\\05.WriteEveryThirdLineOutput.txt");

        int count = 1;
        String line = reader.readLine();
        while (line != null){
            if (count % 3 == 0){
               writer.write(line + "\n");
            }
            count++;

            line = reader.readLine();
        }
        writer.close();
    }
}
