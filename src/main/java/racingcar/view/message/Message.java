package racingcar.view.message;

public enum Message {

    CAR_NAME_INPUT_GUIDE("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."),
    GAME_ROUND_INPUT_GUIDE("시도할 횟수는 몇 회인가요?"),
    GAME_RESULT_GUIDE("실행 결과"),
    RESULT_DELIMITER("%s : %s"),
    POSITION_MARKER("-"),
    WINNER_DELIMITER(", "),
    EMPTY_MESSAGE(""),
    WINNER_GUIDE("%s가 최종 우승했습니다.");
    private final String message;

    Message(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
