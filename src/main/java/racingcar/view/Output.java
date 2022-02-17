package racingcar.view;

import racingcar.domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class Output {
    private static final String SPLIT_DELIM = ", ";
    private static final String INFO_BETWEEN_WORD = " : ";
    private static final String POSITION_WORD = "-";
    private static final String OUTPUT_WINNER_MESSAGE = "가 최종 우승했습니다.";
    private static final String PRINT_RESULT = "실행 결과";

    public static void printStartRace() {
        System.out.println(PRINT_RESULT);
    };

    public static void printCarsStatus(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + INFO_BETWEEN_WORD + POSITION_WORD.repeat(car.getPosition()));
        }
    }

    public static void printWinner(List<Car> winners) {
        System.out.println(String.join(SPLIT_DELIM, getWinnerNamesFromWinners(winners)) + OUTPUT_WINNER_MESSAGE);
    }

    private static List<String> getWinnerNamesFromWinners(List<Car> winners) {
        return winners.stream()
                .map(winner -> winner.getName())
                .collect(Collectors.toList());
    }

    public static void printBlankLine() {
        System.out.println();
    }
}
