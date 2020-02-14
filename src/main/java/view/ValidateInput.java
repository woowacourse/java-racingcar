package view;

import java.util.regex.Pattern;

public class ValidateInput {

    private static final String NUMBER_FORMAT = "^\\d+$";
    private static final Pattern pattern = Pattern.compile(NUMBER_FORMAT);
    public static final int ZERO = 0;
    private static final int MAX_NAME_LENGTH = 5;

    public static String[] validateName(String[] names) {
        if (names == null) {
            IllegalNameException();
        }
        for (String name : names) {
            if (name.isEmpty() || name.length() > MAX_NAME_LENGTH) {
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
        return round <= ZERO;
    }


    private static boolean isNotInteger(String input) {
        return !pattern.matcher(input).matches();
    }
}
