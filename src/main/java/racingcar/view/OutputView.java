package racingcar.view;

import java.util.Map;

public class OutputView {

    private static final String OUTPUT_RESULT_GUIDE_MESSEAGE = "실행 결과";
    private static final String RESULT_DELIMITER = ":";
    private static final String POSITION_LETTER = "-";

    public static void printResultInitMessage() {
        System.out.println();
        System.out.println(OUTPUT_RESULT_GUIDE_MESSEAGE);
    }

    public static void printResult(Map<String, Integer> carNameAndPositions) {
        for (String carName : carNameAndPositions.keySet()) {
            System.out.println(carName + " " + RESULT_DELIMITER + " " + POSITION_LETTER.repeat(carNameAndPositions.get(carName)));
        }
        System.out.println();
    }
}
