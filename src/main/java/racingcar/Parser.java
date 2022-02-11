package racingcar;

public class Parser {
    private static final int EMPTY = 0;
    private static final int MAX_NAME_LENGTH = 5;

    public static String[] split(String text) {
        isValidInput(text);

        String[] carNames = text.split(",");
        isValidNames(carNames);

        for (String carName : carNames) {
            isValidCarName(carName);
        }

        return carNames;
    }

    private static void isValidInput(String text) {
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    private static void isValidNames(String[] carNames) {
        if (carNames.length == EMPTY) {
            throw new IllegalArgumentException();
        }
    }

    private static void isValidCarName(String carName) {
        if (carName == null || carName.isEmpty() || carName.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    public static void isValidRounds(String round) {
        if (!isDigit(round) || !isPositiveNumber(round)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isDigit(String round) {
        if (round.chars().allMatch(Character::isDigit)) {
            return true;
        }
        return false;
    }

    private static boolean isPositiveNumber(String round) {
        if (Integer.parseInt(round) > 0) {
            return true;
        }
        return false;
    }
}
