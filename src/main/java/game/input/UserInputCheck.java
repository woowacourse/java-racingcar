package game.input;

public class UserInputCheck {
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MIN_NAME_LENGTH = 1;

    public static String[] checkCarNames(String userInput) {
        String[] carNames = splitWithComma(userInput);

        if (checkCarNamesLength(carNames)) {
            return carNames;
        }

        return UserInput.inputCarNames();
    }

    public static String[] splitWithComma(String inputCarName) {
        String carNames = removeBlankAndDoubleComma(inputCarName);
        return carNames.split(",");
    }

    public static String removeBlankAndDoubleComma(String inputCarName) {
        return inputCarName.replace(" ", "");
    }

    public static boolean checkCarNamesLength(String[] carNames) {
        boolean isFIveOrLess = true;

        for (String carName : carNames) {
            isFIveOrLess &= checkCarNameLength(carName);
        }

        return isFIveOrLess;
    }

    private static boolean checkCarNameLength(String carName) {
        return carName.length() >= MIN_NAME_LENGTH
                && carName.length() <= MAX_NAME_LENGTH;
    }
}
