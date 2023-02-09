package racingcar.view;

import java.util.List;

public class OutputView {
    private static final String GAME_RESULT_HEADER = "실행 결과";
    private static final String NAME_DELIMITER = ", ";
    private static final String WINNER_MESSAGE = "가 최종 우승했습니다.";

    private void printAll(List<String> texts) {
        for (String text : texts) {
            System.out.println(text);
        }
    }

    public void printRoundResult(List<String> roundResult) {
        printAll(roundResult);
        System.out.println();
    }

    public void printGameResultHeader() {
        System.out.println(GAME_RESULT_HEADER);
    }

    public void printWinners(List<String> winningCarsName) {
        String winners = String.join(NAME_DELIMITER, winningCarsName);
        System.out.println(winners + WINNER_MESSAGE);
    }
}
