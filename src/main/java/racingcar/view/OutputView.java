package racingcar.view;

import java.util.List;

public class OutputView {
    private static final String ASK_INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String ASK_INPUT_NUMBER_OF_ROUNDS = "시도할 회수는 몇회인가요?";
    private static final String RESULT_STARTING_MESSAGE = "실행 결과";
    private static final String WINNER_INFO_MESSAGE_FORMAT = "%s가 최종 우승했습니다.";

    public void printAskingInputCarNames() {
        System.out.println(ASK_INPUT_CAR_NAMES_MESSAGE);
    }

    public void printAskingInputNumberOfRounds() {
        System.out.println(ASK_INPUT_NUMBER_OF_ROUNDS);
    }

    public void printResultStartingMessage() {
        System.out.println(RESULT_STARTING_MESSAGE);
    }

    public void printResult(String renderedRoundResult) {
        System.out.println(renderedRoundResult);
    }

    public void printWinners(String renderedWinners) {
        System.out.println(String.format(WINNER_INFO_MESSAGE_FORMAT, renderedWinners));
    }
}
