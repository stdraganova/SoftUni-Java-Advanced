package JavaAdvanced.StreamsFilesAndDirectories.LabRessources;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

public class ListFiles {
    public static void main(String[] args) {
        String path = "C:\\Users\\User\\IdeaProjects\\SoftUniJavaAdvnced\\src\\JavaAdvanced\\StreamsFilesAndDirectories\\LabRessources\\Files-and-Streams";
        File file = new File(path);

        if (file.exists()){
            if (file.isDirectory()){
                File[] files = file.listFiles();
                for (File f : files){
                    if (!f.isDirectory()){
                        System.out.printf("%s: [%s]\n",f.getName(), f.length());
                    }
                }
            }
        }
    }
}
