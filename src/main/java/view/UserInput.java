package view;

import java.util.Scanner;

public class UserInput implements Input {
    private static final Scanner scanner = new Scanner(System.in);

    @Override
    public int gameCountInput() {
        return scanner.nextInt();
    }

    @Override
    public String carNameInput() {
        return scanner.nextLine();
    }
}
