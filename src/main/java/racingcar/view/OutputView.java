package racingcar.view;

import java.util.stream.Collectors;
import racingcar.vo.RoundResult;
import racingcar.vo.RoundResults;
import racingcar.vo.Winners;

public class OutputView {

    private static final String RACE_RESULT_MESSAGE = "실행 결과";
    private static final String POSITION_BAR = "-";
    private static final String RESULT_DELIMITER = " : ";

    private static final String WINNERS_DELIMITER = ",";
    private static final String WINNER_MESSAGE_FORM = "%s가 최종 우승했습니다.";

    public static void printRaceResult(RoundResults results) {
        System.out.println(RACE_RESULT_MESSAGE);
        while (results.hasResult()) {
            printResult(results.poll());
        }
    }

    private static void printResult(RoundResult result) {
        for (String name : result.getNames()) {
            printResultOne(name, result.getPosition(name));
        }
        System.out.println();
    }

    private static void printResultOne(String name, Integer position) {
        StringBuilder builder = new StringBuilder();
        builder.append(name).append(RESULT_DELIMITER);
        for (int i = 0; i < position; i++) {
            builder.append(POSITION_BAR);
        }
        System.out.println(builder.toString());
    }

    public static void printWinners(Winners winners) {
        String winnersString = winners.getWinners().stream()
                .map(car -> car.getName().get())
                .collect(Collectors.joining(WINNERS_DELIMITER));
        System.out.printf(WINNER_MESSAGE_FORM, winnersString);
    }
}
