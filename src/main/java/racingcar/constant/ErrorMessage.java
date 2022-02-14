package racingcar.constant;

public class ErrorMessage {

    private ErrorMessage() {
    }

    private static String ERROR = "[ERROR] ";

    public static final String EMPTY_CAR_NAME = ERROR + "자동차 이름이 입력되지 않았습니다.";
    public static final String MORE_THAN_ONE_LETTER = ERROR + "1글자 미만의 자동차 이름은 허용되지 않습니다.";
    public static final String LESS_THAN_FIVE_LETTER = ERROR + "5글자 초과의 자동차 이름은 허용되지 않습니다.";
    public static final String NO_SPACE = ERROR + "공백을 포함하는 자동차 이름은 허용되지 않습니다.";
    public static final String DUPLICATED = ERROR + "중복된 자동차 이름은 허용되지 않습니다.";

    public static final String MUST_BE_INTEGER = ERROR + "시도 횟수는 숫자만 허용됩니다.";
    public static final String MUST_BE_POSITIVE = ERROR + "1미만의 시도횟수는 허용되지 않습니다.";
}
