package racingcar.constants.output;

public class RequestOutputMessages {

    private RequestOutputMessages() {
        throw new AssertionError();
    }

    public static final String REQUEST_CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    public static final String REQUEST_TOTAL_ROUNDS_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";
}
