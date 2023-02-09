package racingcar.view;

public class InputView {
    private static final String INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String INPUT_TRY_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";
    private final Output output;

    public InputView(Output output) {
        this.output = output;
    }

    public void printInputTryCountGuide() {
        output.println(INPUT_TRY_COUNT_MESSAGE);
    }

    public void printInputCarNameGuide() {
        output.println(INPUT_CAR_NAME_MESSAGE);
    }
}
