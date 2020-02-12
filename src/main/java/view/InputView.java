package view;

import controller.ValidateInput;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static String inputCarName() {
        return scanner.nextLine();
    }

    public static int inputCount() {
        String input = scanner.next();
        return ValidateInput.inputCount(input);
    }
}
