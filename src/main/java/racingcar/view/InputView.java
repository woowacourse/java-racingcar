package racingcar.view;

import racingcar.utils.InputValidation;

import java.util.Scanner;

public class InputView {
    private Scanner scanner;
    private static String BLANK = " ";
    private static String EMPTY = "";
    private static String DELIMITER = ",";

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public String[] inputCarName() {
        String[] name = scanner.nextLine()
                .replace(BLANK, EMPTY)
                .split(DELIMITER);
        InputValidation.validateName(name);
        return name;
    }

    public int inputTime() {
        String input = scanner.nextLine();
        InputValidation.validateTime(input);
        return Integer.parseInt(input);
    }
}
