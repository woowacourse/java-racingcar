package racingcar.view;

public enum Messages {
    REQUEST_CAR_NAME("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."),
    REQUEST_MOVE_COUNT("시도할 회수는 몇회인가요?");

    private String message;

    Messages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}