package racingcar.view;

public class InputView {

    private static final String REQUEST_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String REQUEST_ATTEMPT_MESSAGE = "시도할 회수는 몇회인가요?";

    public static void requestCarName() {
        System.out.println(REQUEST_CAR_NAME_MESSAGE);
    }

    public static void requestAttempt() {
        System.out.println(REQUEST_ATTEMPT_MESSAGE);
    }
}
