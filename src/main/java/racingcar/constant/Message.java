package racingcar.constant;

public enum Message {
    CAR_NAMES_REQUEST("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."),
    TIMES_REQUEST("시도할 회수는 몇회인가요?"),
    COMMA(","),
    TWO_COMMAS(",,"),

    ERROR("[ERROR] "),
    TWO_COMMAS_ERROR(ERROR + "2개 이상의 쉼표가 연속으로 올 수 없습니다."),
    NON_DIGIT_ERROR(ERROR + "숫자만 입력해 주세요."),
    NON_POSITIVE_ERROR(ERROR + "양수만 입력해 주세요."),
    LIMITATION_ERROR(ERROR + "한계값 이하만 입력해 주세요.");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
