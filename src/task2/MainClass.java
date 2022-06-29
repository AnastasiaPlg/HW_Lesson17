package task2;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        try {
            String directoryPath = Input.inputDirPath("Enter directory path: ");
            int countOfFiles = Input.inputCountOfFiles("Enter count of files: ");

            WorkWithFiles workWithFiles = new WorkWithFiles(directoryPath);
            Information information = new Information();

            workWithFiles.analyseFiles(countOfFiles, information);
            information.showInfo();
        } catch (IOException | EmptyDirectoryException | WrongFilesFormatException e) {
            System.out.println(e);
        }


    }
}
