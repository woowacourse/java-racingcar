package racingcar.constants;

public enum OutputConstant {
    RESULT_MESSAGE("실행 결과"),
    CAR_INFORMATION_DELIMITER(" : "),
    DISTANCE_COMMAND("-");

    private final String message;

    OutputConstant(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
