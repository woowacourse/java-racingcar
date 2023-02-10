package racingcar.view;

public class InputView {

    private static final String INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String INPUT_TRY_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";

    private final Output output;
    private final Input input;

    public InputView(Output output, Input input) {
        this.output = output;
        this.input = input;
    }

    public int inputTryCount() {
        output.println(INPUT_TRY_COUNT_MESSAGE);
        return input.gameCountInput();
    }

    public String inputCarName() {
        output.println(INPUT_CAR_NAME_MESSAGE);
        return input.carNameInput();
    }
}
