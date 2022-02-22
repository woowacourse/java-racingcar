package racingcar.utils;

public class ExceptionMessage {
    private final static String ERROR_SYMBOL = "[ERROR]";
    public final static String BLANK_INPUT_EXCEPTION_MESSAGE = ERROR_SYMBOL + "입력이 비어있습니다.";
    public static final String NOT_POSITIVE_DIGIT = ERROR_SYMBOL + "시도횟수는 양의 정수만 가능합니다.";
    public static final String IS_NOT_NUMBER = "시도 횟수는 숫자만 가능합니다";

    public static final String LONGER_THAN_FIVE_CAR_NAME = "자동차 이름은 최대 5자입니다.";
    public static final String BLANK_CAR_NAME = "공백으로만 이루어진 자동차 이름이 있습니다.";
    public static final String NULL_CAR_NAME = "비어있는 자동차 이름이 있습니다.";
    public static final String DUPLICATED_CAR_NAMES = "자동차 이름들 간 중복이 있습니다.";
}
