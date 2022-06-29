package task2;

import java.util.Scanner;

public class Input {
    static Scanner scanner = new Scanner(System.in);

    public static String inputDirPath(String text) {
        System.out.print(text);
        return scanner.nextLine();
    }

    public static int inputCountOfFiles(String text) {
        System.out.print(text);
        return scanner.nextInt();
    }
}
