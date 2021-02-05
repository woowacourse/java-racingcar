package racingcar.constant;

public enum Message {
    CAR_NAMES_REQUEST("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."),
    COMMA(","),
    TWO_COMMAS(",,"),

    ERROR("[ERROR] "),
    TWO_COMMAS_ERROR(ERROR + "2개 이상의 쉼표가 연속으로 올 수 없습니다.");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
