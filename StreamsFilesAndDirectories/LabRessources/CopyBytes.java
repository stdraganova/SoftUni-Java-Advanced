package JavaAdvanced.StreamsFilesAndDirectories.LabRessources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyBytes {
    public static void main(String[] args) throws IOException {
        
        //Четем байт по байт и записваме аски кода на символа в друг файл.
        String pathToRead = "C:\\Users\\User\\IdeaProjects\\SoftUniJavaAdvnced\\src\\JavaAdvanced\\StreamsFilesAndDirectories\\LabRessources\\input.txt";
        FileInputStream fileRead = new FileInputStream(pathToRead);

        String pathToWrite = "C:\\Users\\User\\IdeaProjects\\SoftUniJavaAdvnced\\src\\JavaAdvanced\\StreamsFilesAndDirectories\\LabRessources\\03.CopyBytesOutput.txt";
        FileOutputStream fileWrite = new FileOutputStream(pathToWrite);

        int asciiCode = fileRead.read();

        while (asciiCode >= 0){
            if (asciiCode == 32 || asciiCode == 10){
                char symbol = (char)asciiCode;
                fileWrite.write(symbol);
            }else {
                String symbol = "" + asciiCode;
                fileWrite.write(symbol.getBytes());
            }

            asciiCode = fileRead.read();
        }
        fileWrite.close();
    }
}
