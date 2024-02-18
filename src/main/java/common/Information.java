package common;

public enum Information {
    INPUT_CAR_NAMES("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."),
    INPUT_TRIAL_COUNT("시도할 회수는 몇회인가요?"),
    RESULT_COMMENT("실행 결과"),
    WINNER("%s가 최종 우승했습니다.");

    private final String message;

    Information(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
