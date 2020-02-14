package racingcar.domain;

public class CarName {

    private final static String BLANK = " ";
    private final static int NAME_LENGTH_LIMIT = 5;

    private final String carName;

    public CarName(String carName) {
        validateHasNotBlank(carName);
        validateNameLength(carName);
        this.carName = carName;
    }

    private static void validateHasNotBlank(String input) {
        if (input.contains(BLANK)) {
            throw new IllegalArgumentException("공백은 허용되지 않습니다.");
        }
    }

    private static void validateNameLength(String input) {
        if (input.length() > NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException(NAME_LENGTH_LIMIT + "자 이상 이름은 허용되지 않습니다.");
        }
    }
}
