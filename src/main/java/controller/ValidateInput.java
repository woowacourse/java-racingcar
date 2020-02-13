package controller;

import view.InputView;
import view.ValidationView;

import java.util.regex.Pattern;

public class ValidateInput {

    private static final String NUMBER_FORMAT = "^\\d+$";
    private static final int MAX_NAME_LENGTH = 5;

    public static String[] validateName(String[] names) {
        for (String name : names) {
            if (name.length() > MAX_NAME_LENGTH || name.isEmpty()) {
                names = IllegalNameException();
                break;
            }
        }
        return names;
    }

    public static int ValidateCount(String input) {
        int integerInput = Integer.parseInt(input);

        if (isNotInteger(input)) {
            return IllegalNotIntegerException();
        }
        if (isUnderZero(integerInput)) {
            integerInput = IllegalNegativeNumberException();
        }
        return integerInput;
    }

    private static int IllegalNotIntegerException() {
        ValidationView.printNotIntegerErrorMessage();
        return InputView.inputRound();
    }

    private static int IllegalNegativeNumberException() {
        ValidationView.printMinRoundNumberErrorMessage();
        return InputView.inputRound();
    }

    private static String[] IllegalNameException() {
        ValidationView.printNameErrorMessage();
        return InputView.inputCarName();

    }

    public static boolean isUnderZero(int round) {
        return round <= GameManager.ZERO;
    }


    private static boolean isNotInteger(String input) {
        Pattern pattern = Pattern.compile(NUMBER_FORMAT);
        return !pattern.matcher(input).matches();
    }
}
