package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.List;

public class Output {
    private static final String SPLIT_DELIM = ", ";
    private static final String INFO_BETWEEN_WORD = " : ";
    private static final String POSITION_WORD = "-";
    private static final String OUTPUT_WINNER_MESSAGE = "가 최종 우승했습니다.";
    private static final String PRINT_RESULT = "실행 결과";

    public static void printStartRace() {
        System.out.println(PRINT_RESULT);
    };

    public static void printCarStatus(Car car) {
        System.out.println(car.getName() + INFO_BETWEEN_WORD + POSITION_WORD.repeat(car.getPosition()));
    }

    public static void printWinner(List<String> winnerNames) {
        System.out.println(String.join(SPLIT_DELIM, winnerNames) + OUTPUT_WINNER_MESSAGE);
    }

    public static void printBlankLine() {
        System.out.println();
    }
}
