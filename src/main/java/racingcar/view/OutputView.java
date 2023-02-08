package racingcar.view;

public class OutputView {
    private static final String ASK_INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String ASK_INPUT_NUMBER_OF_ROUNDS = "시도할 회수는 몇회인가요?";
    private static final String RESULT_STARTING_MESSAGE = "실행 결과";

    public void printAskingInputCarNames() {
        System.out.println(ASK_INPUT_CAR_NAMES_MESSAGE);
    }

    public void printAskingInputNumberOfRounds() {
        System.out.println(ASK_INPUT_NUMBER_OF_ROUNDS);
    }

    public void printResultStartingMessage() {
        System.out.println(RESULT_STARTING_MESSAGE);
    }
}
