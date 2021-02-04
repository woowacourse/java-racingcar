package racingcar.view;

public class RacingCarError {
    private static final String OVERLAPPED_MESSAGE = "[ERROR] 이름을 중복하여 사용할 수 없습니다";
    private static final String LENGTH_MESSAGE = "[ERROR] 이름은 5자 이하로 입력해주세요";
    private static final String NULL_MESSAGE = "[ERROR] 경주할 자동차를 1대 이상 입력해주세요";
    private static final String INTEGER_TURN_MESSAGE = "[ERROR] 시도 횟수는 정수여야만 합니다.";
    private static final String NEGATIVE_TURN_MESSAGE = "[ERROR] 시도 횟수는 음수일 수 없습니다";

    public static void overlapped() {
        throw new IllegalArgumentException(OVERLAPPED_MESSAGE);
    }

    public static void length() {
        throw new IllegalArgumentException(LENGTH_MESSAGE);
    }

    public static void nullCar() {
        throw new IllegalArgumentException(NULL_MESSAGE);
    }

    public static void notInteger() {
        throw new IllegalArgumentException(INTEGER_TURN_MESSAGE);
    }

    public static void negativeInteger() {
        throw new IllegalArgumentException(NEGATIVE_TURN_MESSAGE);
    }
}

