package racingcar.constant;

public class ErrorMessage {
    private static String ERROR = "[ERROR] ";

    public static final String MORE_THAN_ONE_LETTER = ERROR + "자동차 이름은 1글자 이상이어야 합니다.";
    public static final String LESS_THAN_FIVE_LETTER = ERROR + "자동차 이름은 5글자 이하이어야 합니다.";
    public static final String NO_SPACE = ERROR + "공백 없이 입력해주세요.";
    public static final String DUPLICATED = ERROR + "자동차 이름이 중복되면 안됩니다.";

    public static final String MUST_BE_INTEGER = ERROR + "시도 횟수는 숫자여야 합니다.";
    public static final String MUST_BE_POSITIVE = ERROR + "양수를 입력해주세요.";
}
