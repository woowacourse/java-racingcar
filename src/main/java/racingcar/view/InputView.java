package racingcar.view;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static String requestCarName() {
        return scanner.nextLine();
    }

    public static String requestMoveCount() {
        return scanner.nextLine();
    }
}
