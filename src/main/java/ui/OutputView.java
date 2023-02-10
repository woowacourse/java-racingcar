package ui;

import java.util.LinkedHashMap;
import java.util.List;

public class OutputView {

    private static final String POSITION_MARK = "-";
    private static final int POSITION_MARK_DEFAULT_VALUE = 1;

    public void printCarsStatus(LinkedHashMap<String, Integer> carsStatus) {
        carsStatus.forEach((name, position) -> System.out.println(name + " : " + convertPosition(position)));
        System.out.println();
    }

    private String convertPosition(int position) {
        return POSITION_MARK.repeat(POSITION_MARK_DEFAULT_VALUE + position);
    }

    public void printWinners(List<String> winnerNames) {
        String winners = String.join(", ", winnerNames);
        System.out.println(winners + "가 최종 우승했습니다.");
    }

    public void printResultMessage() {
        System.out.println("실행 결과");
    }
}
