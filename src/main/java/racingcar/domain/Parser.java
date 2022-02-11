package racingcar.domain;

public class Parser {
    private static final int EMPTY = 0;
    private static final int MAX_NAME_LENGTH = 5;
    private static final String DELIMITER = ",";
    private static final int CAN_START = 1;

    public static String[] split(String text) {
        isValidInput(text);

        String[] carNames = text.split(DELIMITER);
        isValidAmount(carNames);

        for (String carName : carNames) {
            isValidCarNames(carName);
        }
        return carNames;
    }

    private static void isValidInput(String text) {
        if (text == null) {
            throw new IllegalArgumentException();
        }
    }

    private static void isValidAmount(String[] carNames) {
        if (carNames.length == EMPTY) {
            throw new IllegalArgumentException();
        }
    }

    private static void isValidCarNames(String carName) {
        if (carName == null || carName.isEmpty() || carName.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    public static void isValidRounds(String round) {
        if (!round.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException();
        }
        if (Integer.parseInt(round) < CAN_START) {
            throw new IllegalArgumentException();
        }
    }
}
