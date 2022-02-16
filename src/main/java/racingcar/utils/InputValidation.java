package racingcar.utils;

public class InputValidation {

    private static final String NAME_LENGTH_ERROR = "이름은 5자리 이하만 가능합니다.";
    private static final String REPEATS_NON_INTEGER_ERROR = "반복횟수는 정수만 입력 가능합니다.";
    private static final String REPEATS_NEGATIVE_NUMBER_ERROR = "반복횟수는 양의 정수만 입력 가능합니다.";
    private final static int MAX_NAME_LENGTH = 5;
    private final static String CAR_NAME_DISTRIBUTOR = ",";

    public void validateName(final String names) {
        final String[] carNames = names.split(CAR_NAME_DISTRIBUTOR);
        for (String carName : carNames) {
            checkNameLength(carName);
        }
    }

    private void checkNameLength(final String carName) {
        if (carName.length() > MAX_NAME_LENGTH) {
            throw new RuntimeException(NAME_LENGTH_ERROR);
        }
    }

    public int checkIntegerRepeats(final String repeats) {
        try {
            return Integer.parseInt(repeats);
        } catch (NumberFormatException exception) {
            throw new RuntimeException(REPEATS_NON_INTEGER_ERROR);
        }
    }

    public void checkNegativeRepeats(final int repeatNumber) {
        if (repeatNumber < 0) {
            throw new RuntimeException(REPEATS_NEGATIVE_NUMBER_ERROR);
        }
    }
}
