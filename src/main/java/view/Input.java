package view;

import java.util.Scanner;

public class Input {
    private static final String DELIMITER = ",";
    private static final Validator validator = new Validator();
    private static final Scanner scanner = new Scanner(System.in);

    public static String getInput() {
        return scanner.nextLine();
    }

    public static String[] getCarNames(String input) {
        String[] carNames = input.split(DELIMITER);
        validator.checkValidCarNames(carNames);
        return carNames;
    }

    public static int getTryCount(String input) {
        validator.checkDigits(input);
        int tryCount = Integer.parseInt(input);
        validator.checkRange(tryCount);
        return tryCount;
    }
}
