package JavaAdvanced.StreamsFilesAndDirectories.LabRessources;
import java.io.File;

public class NestedFolders {
    private static int folderCount = 0; // Променлива за броене на папките

    public static void main(String[] args) {
        // Относителен път до основната директория
        String path = "C:\\Users\\User\\IdeaProjects\\SoftUniJavaAdvnced\\src\\JavaAdvanced\\StreamsFilesAndDirectories\\LabRessources\\Files-and-Streams"; // Използваме относителен път
        File rootDir = new File(path);

        if (rootDir.exists() && rootDir.isDirectory()) {
            // Обработваме основната директория и всички вложени директории
            listDirectories(rootDir);
            System.out.printf("%d folders%n", folderCount); // Принтираме броя на папките накрая
        }
    }

    private static void listDirectories(File directory) {
        folderCount++; // Увеличаваме броя на папките
        System.out.println(directory.getName()); // Принтираме името на текущата директория

        // Извличаме всички файлове и директории в текущата директория
        File[] files = directory.listFiles();

        if (files != null) {
            // Обхождаме всички елементи в директорията
            for (File file : files) {
                if (file.isDirectory()) {
                    // Рекурсивно обработваме всяка намерена директория
                    listDirectories(file);
                }
            }
        }
    }
}
