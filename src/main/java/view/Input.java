package view;

import java.util.Scanner;

public class Input {
    private static final Scanner scanner = new Scanner(System.in);

    private Input() {
    }

    public static int gameCountInput() {
        return scanner.nextInt();
    }

    public static String carNameInput() {
        return scanner.nextLine();
    }
}
