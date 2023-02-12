package racingcar.constants;

public enum OutputConstant {
    RESULT_MESSAGE("실행 결과"),
    CAR_INFORMATION_DELIMITER(" : "),
    DISTANCE_COMMAND("-"),
    WINNER_MESSAGE("가 최종 우승했습니다."),
    WINNER_NAME_DELIMITER(", ");

    private final String message;

    OutputConstant(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
