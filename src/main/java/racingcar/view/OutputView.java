package racingcar.view;

public class OutputView {
    private static final String ASK_INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";

    public void printAskingInputCarNames() {
        System.out.println(ASK_INPUT_CAR_NAMES_MESSAGE);
    }
}
