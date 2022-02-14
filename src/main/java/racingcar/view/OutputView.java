package racingcar.view;

import racingcar.vo.Winners;

public class OutputView {

    private static final String RACE_RESULT_MESSAGE = "실행 결과";

    public static void printRaceResult(String raceResult) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(RACE_RESULT_MESSAGE)
                .append(System.lineSeparator())
                .append(raceResult);
        System.out.print(stringBuilder);
    }

    public static void printWinners(Winners winners) {
        System.out.print(winners.toString());
    }
}
