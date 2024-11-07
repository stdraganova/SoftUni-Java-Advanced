package JavaAdvanced.StreamsFilesAndDirectories.LabRessources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;

public class ReadFile {
    public static void main(String[] args) throws IOException {
        //Използваме FileInputStream понеже се изисква да се чете
        //байт по байт (символ по символ) и да се конвертира в бинарен код

        //Задаваме пътя/директорията
        String path = "C:\\Users\\User\\IdeaProjects\\SoftUniJavaAdvnced\\src\\JavaAdvanced\\StreamsFilesAndDirectories\\LabRessources\\input.txt";

        //четем файла байт по байт
        FileInputStream fileStream = new FileInputStream(path);
        int asciiCode = fileStream.read();

        while (asciiCode >= 0){
            System.out.print(Integer.toBinaryString(asciiCode) + " ");

            asciiCode = fileStream.read();
        }
    }
}
