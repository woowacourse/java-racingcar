package game.input;

import java.util.ArrayList;
import java.util.List;

public class UserInputCheck {
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MIN_NAME_LENGTH = 1;

    public static String[] checkCarNames(String userInput) {
        String[] carNames = splitWithComma(userInput);

        if (checkCarNamesLength(carNames)) {
            return carNames;
        }

        return null;
    }

    private static String[] splitWithComma(String inputCarName) {
        String carNames = removeBlank(inputCarName);
        return carNames.split(",");
    }

    private static String removeBlank(String inputCarName) {
        return inputCarName.replace(" ", "");
    }

    private static boolean checkCarNamesLength(String[] carNames) {
        List<Boolean> isCarName = new ArrayList<>();

        if (carNames.length == 0) {
            return false;
        }

        return hasIncorrectCarName(carNames, isCarName);
    }

    private static boolean hasIncorrectCarName(String[] carNames, List<Boolean> isCarName) {
        for (String carName : carNames) {
            isCarName.add(checkCarNameLength(carName));
        }
        return !(isCarName.contains(false));
    }

    private static boolean checkCarNameLength(String carName) {
        return carName.length() >= MIN_NAME_LENGTH
                && carName.length() <= MAX_NAME_LENGTH;
    }
}
