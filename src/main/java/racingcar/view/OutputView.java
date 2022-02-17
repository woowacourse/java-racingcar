package racingcar.view;

import racingcar.vo.Winners;

public class OutputView {

    private static final String RACE_RESULT_MESSAGE = "실행 결과";
    private static final String WINNER_MESSAGE_FORM = "%s가 최종 우승했습니다.";

    public static void printRaceResult(String raceResult) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(System.lineSeparator())
                .append(RACE_RESULT_MESSAGE)
                .append(System.lineSeparator())
                .append(raceResult);
        System.out.print(stringBuilder);
    }

    public static void printWinners(Winners winners) {
        System.out.print(String.format(WINNER_MESSAGE_FORM, winners.toString()));
    }
}
