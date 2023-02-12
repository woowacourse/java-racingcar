package racing.view;

import java.util.List;
import java.util.Map;

import racing.domain.Name;
import racing.domain.Position;

public class OutputView {
    private static final String RESULT_MESSAGE = "\n실행 결과";
    private static final String WINNER_MESSAGE = "%s가 최종 우승했습니다.";

    public void printNotice() {
        System.out.println(RESULT_MESSAGE);
    }

    public void printRacingResult(Map<Name, Position> history) {
        for (Name name : history.keySet()) {
            Position position = history.get(name);
            System.out.println(name + " : " + "-".repeat(position.getPosition()));
        }
        System.out.println();
    }

    public void printWinner(List<Name> winners) {
        String winnerNames = winners.toString();
        System.out.printf(WINNER_MESSAGE, winnerNames.substring(1, winnerNames.length()-1));
    }
}
