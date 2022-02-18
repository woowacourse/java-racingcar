package racingcar.view.output;

public enum OutputMessage {

    REQUEST_CAR_NAMES_MESSAGE("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."),
    REQUEST_ROUND_MESSAGE("시도할 회수는 몇회인가요?"),
    PRINT_TITLE_OF_STATUS("실행 결과"),
    PRINT_WINNERS("%s가 최종 우승했습니다."),
    EMPTY_STRING("");

    private final String message;

    OutputMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

}
