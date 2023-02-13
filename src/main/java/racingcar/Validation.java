package racingcar;

public class Validation {

    private static final String SEPARATOR = ",";
    private static final int MINIMUM_PARTICIPANT = 2;
    private static final int MINIMUM_NAME_LENGTH = 1;
    private static final int MAXIMUM_NAME_LENGTH = 5;
    private static final int MINIMUM_TRY_COUNT = 1;

    public static void validateSeparator(String carNames) {
        if (!carNames.contains(SEPARATOR)) {
            throw new IllegalArgumentException("[ERROR] 구분자(" + SEPARATOR + ")가 필요해요.");
        }
    }

    public static void validateCarCount(String[] names) {
        if (names.length < MINIMUM_PARTICIPANT) {
            throw new IllegalArgumentException("[ERROR] 경주는 최소 " + MINIMUM_PARTICIPANT + "명이 필요해요.");
        }
    }

    public static void validateParseInt(String tryCount) {
        try {
            Integer.parseInt(tryCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력가능해요");
        }
    }

    public static void validateNameLength(String name) {
        if (name.length() < MINIMUM_NAME_LENGTH || name.length() > MAXIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException(
                    "[ERROR] 자동차 이름은 최소 " + MINIMUM_NAME_LENGTH + "글자, 최대 " + MAXIMUM_NAME_LENGTH + "글자까지 가능해요.");
        }
    }

    public static void validateTryCount(int tryCount) {
        if (tryCount < MINIMUM_TRY_COUNT) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 " + MINIMUM_TRY_COUNT + "미만일 수 없어요.");
        }
    }
}
