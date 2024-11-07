package JavaAdvanced.StreamsFilesAndDirectories.LabRessources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteFoFile {
    public static void main(String[] args) throws IOException {

        //Четем байт по байт (символ по символ)
        //Пътя се взима като кликнев на файла и натиснеш
        //Ctrl + Shift + C
        String pathToRead = "C:\\Users\\User\\IdeaProjects\\SoftUniJavaAdvnced\\src\\JavaAdvanced\\StreamsFilesAndDirectories\\LabRessources\\input.txt";
        FileInputStream fileRead = new FileInputStream(pathToRead);

        String pathToWrite = "C:\\Users\\User\\IdeaProjects\\SoftUniJavaAdvnced\\src\\JavaAdvanced\\StreamsFilesAndDirectories\\LabRessources\\02.WriteToFileOutput.txt";
        FileOutputStream fileWrite = new FileOutputStream(pathToWrite);

        int characterCode = fileRead.read();

        while (characterCode >= 0){
            char symbol = (char) characterCode;

            if (symbol != ',' && symbol != '.' && symbol != '!' && symbol != '?'){
                fileWrite.write(symbol);
            }

            characterCode = fileRead.read();
        }

        fileWrite.close();
    }
}
