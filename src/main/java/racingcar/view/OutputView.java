package racingcar.view;

import racingcar.controller.response.MovedResultResponse;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OutputView {

    private static final String CARS_STATE_FORMAT = "%s : %s\n"; // ex) name : ---
    private static final String WINNERS_FORMAT = "%s가 최종 우승했습니다."; // ex) 말랑, 채채가 최종 우승했습니다.
    private static final String RACE_RESULT_MESSAGE = "실행 결과";
    private static final String DELIMITER = ", ";
    private static final String BAR = "-";
    private static final int ZERO = 0;

    public static void printWinners(List<String> winners) {
        winners.sort(String::compareTo);
        String winnerNames = String.join(DELIMITER, winners);
        String message = String.format(WINNERS_FORMAT, winnerNames);
        System.out.println(message);
    }

    public static void printState(final MovedResultResponse result) {
        Map<String, Integer> positionMap = result.getPositionMap();

        String results = positionMap.keySet().stream()
                .map(name -> String.format(CARS_STATE_FORMAT, name, makeBar(positionMap.get(name)))
                ).collect(Collectors.joining());

        System.out.println(results);
    }

    private static String makeBar(final int size) {
        return IntStream.range(ZERO, size)
                .mapToObj(it -> BAR)
                .collect(Collectors.joining());
    }

    public static void printResult() {
        System.out.println(RACE_RESULT_MESSAGE);
    }
}
