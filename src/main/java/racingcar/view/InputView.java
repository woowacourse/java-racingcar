package racingcar.view;

import racingcar.client.InputClient;

public class InputView {

    private static final String CAR_NAME_PROMPT = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).\n";
    private static final String ROUND_NUMBER_PROMPT = "시도할 회수는 몇회인가요?\n";

    private final InputClient inputClient;

    public InputView(InputClient inputClient) {
        this.inputClient = inputClient;
    }

    public String inputCarNames() {
        return inputClient.input(CAR_NAME_PROMPT);
    }

    public String inputRoundNumber() {
        return inputClient.input(ROUND_NUMBER_PROMPT);
    }
}
