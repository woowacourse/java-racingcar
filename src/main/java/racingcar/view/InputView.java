package racingcar.view;

import java.util.Scanner;

public class InputView {
    private static final String BLANK = " ";
    private static final String NON_BLANK = "";
    private static final String DELIMITER = ",";

    private final Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public String[] inputCarName() {
        return scanner.nextLine()
                .replace(BLANK, NON_BLANK)
                .split(DELIMITER);
    }

    public String inputTime() {
        return scanner.nextLine();
    }
}
