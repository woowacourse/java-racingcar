package racingcar.view;

import java.util.Scanner;

public class InputView {
    private static final String BLANK = " ";
    private static final String NON_BLANK = "";
    private static final String DELIMITER = ",";

    private Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public String[] inputCarName() {
        String[] names = scanner.nextLine()
                .replace(BLANK, NON_BLANK)
                .split(DELIMITER);
        return names;
    }

    public String inputTime() {
        return scanner.nextLine();
    }
}
