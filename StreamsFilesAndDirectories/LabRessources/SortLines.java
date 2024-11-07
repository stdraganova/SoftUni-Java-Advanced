package JavaAdvanced.StreamsFilesAndDirectories.LabRessources;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

public class SortLines {
    public static void main(String[] args) throws IOException {
        Path pathToRead = Path.of("C:\\Users\\User\\IdeaProjects\\SoftUniJavaAdvnced\\src\\JavaAdvanced\\StreamsFilesAndDirectories\\LabRessources\\input.txt");
        Path pathToWrite = Path.of("C:\\Users\\User\\IdeaProjects\\SoftUniJavaAdvnced\\src\\JavaAdvanced\\StreamsFilesAndDirectories\\LabRessources\\06.SortLinesOutput.txt");

        // Четене на линиите от файла
        List<String> lines = Files.readAllLines(pathToRead);
        // Сортиране на линиите
        Collections.sort(lines);
        // Записване на сортираните линии в новия файл
        Files.write(pathToWrite, lines);
    }
}
