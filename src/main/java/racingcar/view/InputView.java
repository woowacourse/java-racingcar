package racingcar.view;

import java.util.Scanner;

public class InputView {

    private static Scanner scanner = new Scanner(System.in);

    public static String readCarNamesInput() {
        return scanner.nextLine();
    }

    public static int readRoundNumberInput() {
        return Integer.parseInt(scanner.nextLine());
    }

    public static void terminate() {
        scanner.close();
    }
}
