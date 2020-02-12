package racingcar.util;

public class InputHandler {

    private static final int NAME_LENGTH_LIMIT = 5;
    private static final int COUNT_LOWER_LIMIT = 1;
    private static final int COUNT_UPPER_LIMIT = 10;
    private static final int CAR_LIMIT = 5;

    public static void validateNullOrEmpty(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("빈 값 혹은 Null 입력입니다!");
        }
    }

    public static void validateNameLength(String name) {
        if (name.length() > NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException("이름 길이 5자 초과입니다!");
        }
    }

    public static void validateCount(int count) {
        if (count < COUNT_LOWER_LIMIT || count > COUNT_UPPER_LIMIT ) {
            throw new IllegalArgumentException("횟수가 1보다 작거나 10번 초과입니다!");
        }
    }

    public static int validateNumber(String input) {
        int count;
        try {
            count = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 횟수 입력");
        }
        return count;
    }

    public static void validateCarCount(int carCount) {
        if (carCount > CAR_LIMIT) {
            throw new IllegalArgumentException("자동차 5대 초과입니다!");
        }
    }
}
