package racingcar.view;

public class RacingCarView {
    private static final String INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).\n";
    private static final String TURN_INPUT_MESSAGE = "시도할 회수는 몇회인가요?\n";

    public static void carListInput() {
        System.out.printf(INPUT_MESSAGE);
    }

    public static void turnNumberInput() {
        System.out.printf(TURN_INPUT_MESSAGE);
    }
}
