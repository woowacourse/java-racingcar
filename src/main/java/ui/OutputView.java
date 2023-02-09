package ui;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class OutputView {
    private final String POSITION_MARK = "-";

    public void printGameResult(TreeMap<String, Integer> carPositions) {
        System.out.println("실행 결과");
        carPositions.forEach((name, position) -> System.out.println(name + " : " + convertPosition(position)));
        System.out.println();
    }

    private String convertPosition(int position) {
        String result = POSITION_MARK;
        return result.repeat(position + 1);
    }

    public void printWinners(List<String> winnerNames) {
        String winners = String.join(", ", winnerNames);
        System.out.println(winners + "가 최종 우승했습니다.");
    }
}
