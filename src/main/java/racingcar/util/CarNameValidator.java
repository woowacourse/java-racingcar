package racingcar.util;

public class CarNameValidator {
    private static final int EMPTY = 0;
    private static final int MAX_NAME_LENGTH = 5;

    public static void validate(String text) {
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("참가자 명단은 공백일 수 없습니다.");
        }
    }

    public static void checkQuantity(String[] carNames) {
        if (carNames.length == EMPTY) {
            throw new IllegalArgumentException("1대 이상의 자동차가 참여해야합니다.");
        }
    }

    public static void checkCarName(String carName) {
        if (carName == null || carName.isEmpty() || carName.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하여야 합니다.");
        }
    }
}
