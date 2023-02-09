package view;

import java.util.List;
import java.util.Map;

public class OutputView {

    public void printNotice() {
        System.out.println("\n실행 결과");
    }

    public void printRacingResult(Map<String, Integer> history) {
        for (String name : history.keySet()) {
            Integer positionValue = history.get(name);
            System.out.println(name + " : " + "-".repeat(positionValue));
        }
        System.out.println();
    }

    public void printWinner(List<String> winners) {
        String winnerNames = winners.toString();
        System.out.printf("%s가 최종 우승했습니다.", winnerNames.substring(1, winnerNames.length()-1));
    }
}
