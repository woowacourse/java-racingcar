package racingcar.constant;

public enum Message {
    CAR_NAMES_REQUEST("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."),
    TIMES_REQUEST("시도할 회수는 몇회인가요?"),
    BLANK(" "),
    COMMA(","),
    COMMA_WITH_BLANK(COMMA.message + BLANK.message),
    COLON(":"),
    COLON_WITH_BLANK(BLANK.message + COLON.message + BLANK.message),
    HYPHEN("-"),
    TWO_COMMAS(",,"),

    ERROR("[ERROR] "),
    TWO_COMMAS_ERROR(ERROR + "2개 이상의 쉼표가 연속으로 올 수 없습니다."),
    NON_DIGIT_ERROR(ERROR + "숫자만 입력해 주세요."),
    NON_POSITIVE_ERROR(ERROR + "양수만 입력해 주세요."),
    LIMITATION_ERROR(ERROR + "한계값 이하만 입력해 주세요."),
    CAR_NAME_LENGTH_ERROR(ERROR + "자동차 이름은 "
            + Digit.MINIMUM_CAR_NAME_LENGTH.getDigit() + " 이상 "
            + Digit.MAXIMUM_CAR_NAME_LENGTH.getDigit() + " 이하로 입력해 주세요."),
    CAR_NAME_DUPLICATION_ERROR(ERROR + "자동차 이름은 중복되지 않게 입력해 주세요."),
    RESULT_MESSAGE("실행 결과"),
    WINNER_MESSAGE("가 최종 우승했습니다.");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
