package racingcar.view;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);
    private static String BLANK = " ";
    private static String EMPTY = "";
    private static String DELIMITER = ",";

    private InputView() {
    }

    public static String[] inputCarName() {
        String[] name = scanner.nextLine()
                .replace(BLANK, EMPTY)
                .split(DELIMITER);
        return name;
    }

    public static String inputTime() {
        return scanner.nextLine();
    }
}
