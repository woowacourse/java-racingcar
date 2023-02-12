package view;

import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String RESULT_MESSAGE = "\n실행 결과";
    private static final String WINNER_MESSAGE = "%s가 최종 우승했습니다.";
    private static final String CAR_MOVEING_HISTROY = "-";
    private static final String DELIMITER_OF_CAR_NAME_AND_CAR_HISTORY = " : ";

    public void printNotice() {
        System.out.println(RESULT_MESSAGE);
    }

    public void printRacingResult(Map<String, Integer> history) {
        for (String name : history.keySet()) {
            Integer positionValue = history.get(name);
            System.out.println(
                    name + DELIMITER_OF_CAR_NAME_AND_CAR_HISTORY + CAR_MOVEING_HISTROY.repeat(positionValue));
        }
        System.out.println();
    }

    public void printWinner(List<String> winners) {
        String winnerNames = winners.toString();
        System.out.printf(WINNER_MESSAGE, winnerNames.substring(1, winnerNames.length()-1));
    }
}
