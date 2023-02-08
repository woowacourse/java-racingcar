package view;

import java.util.Scanner;

public class Input {
    private static final Scanner scanner = new Scanner(System.in);

    public String carNameInput() {
        return scanner.nextLine();
    }

    public int gameCountInput() {
        return scanner.nextInt();
    }
}
