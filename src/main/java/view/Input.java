package view;

import java.util.Scanner;

public class Input {
    private static final String DELIMITER = ",";
    private static final Validate validate = new Validate();
    private static final Scanner sc = new Scanner(System.in);

    public static String getInput() {
        return sc.nextLine();
    }

    public static String[] getCarNames(String input) {
        String[] carNames = input.split(DELIMITER);
        validate.checkValidCarNames(carNames);
        return carNames;
    }

    public static int getTryCount(String input) {
        validate.checkDigits(input);
        int tryCount = Integer.parseInt(input);
        validate.checkRange(tryCount);
        return tryCount;
    }
}
