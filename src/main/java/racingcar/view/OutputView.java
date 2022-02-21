package racingcar.view;

import java.util.List;
import java.util.Map;

public class OutputView {

    private static final String OUTPUT_RESULT_GUIDE_MESSEAGE = "실행 결과";
    private static final String OUTPUT_WINNERS_GUIDE_MESSEAGE = "가 최종 우승했습니다.";
    private static final String RESULT_DELIMITER = ":";
    private static final String POSITION_LETTER = "-";
    private static final String OUTPUT_WINNERS_DELIMITER = ", ";

    public static void printResultInitMessage() {
        System.out.println();
        System.out.println(OUTPUT_RESULT_GUIDE_MESSEAGE);
    }

    public static void printResult(final Map<String, Integer> carNameAndPositions) {
        for (String carName : carNameAndPositions.keySet()) {
            System.out.println(carName + " " + RESULT_DELIMITER + " " + POSITION_LETTER.repeat(carNameAndPositions.get(carName)));
        }
        System.out.println();
    }

    public static void printWinners(final List<String> winners) {
        System.out.print(String.join(OUTPUT_WINNERS_DELIMITER, winners));
        System.out.println(OUTPUT_WINNERS_GUIDE_MESSEAGE);
    }
}
