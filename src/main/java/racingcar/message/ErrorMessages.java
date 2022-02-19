package racingcar.message;

public class ErrorMessages {
    public static final String EMPTY_NAME = "[ERROR] 이름은 빈 값으로 입력할 수 없습니다.";
    public static final String LONG_NAME = "[ERROR] 너무 긴 이름입니다.";
    public static final String DUPLICATED_NAME = "[ERROR] 중복된 이름이 있습니다";
    public static final String TRY_CNT_NOT_NUMBER = "[ERROR] 시도할 횟수는 숫자여야 합니다.";
    public static final String TRY_CNT_NOT_POSITIVE = "[ERROR] 시도할 횟수는 음수일 수 없습니다.";

    private ErrorMessages() {

    }
}
