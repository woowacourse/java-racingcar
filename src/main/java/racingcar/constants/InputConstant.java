package racingcar.constants;

public enum InputConstant {
    CAR_NAME_INPUT_MESSAGE("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."),
    TRY_COUNT_INPUT_MESSAGE("시도할 회수는 몇회인가요?"),
    CAR_NAME_SPLIT_DELIMITER(",");

    private final String message;

    InputConstant(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
