package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class Output {
    private static final String SPLIT_DELIM = ", ";
    private static final String OUTPUT_WINNER_MESSAGE = "가 최종 우승했습니다.";
    private static final String POSITION_WORD = "-";
    private static final String INFO_BETWEEN_WORD = " : ";
    private static final String PRINT_RESULT = "실행 결과";

    public static void printName(final Car car) {
        String printValue = car.getName() + INFO_BETWEEN_WORD;
        System.out.print(printValue);
    }

    public static void printWinner(final List<String> winnerNames) {
        System.out.println(String.join(SPLIT_DELIM, winnerNames) + OUTPUT_WINNER_MESSAGE);
    }

    public static void printPositionWord(final Car car) {
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print(POSITION_WORD);
        }
    }

    public static void printResultWord() {
        System.out.println(PRINT_RESULT);
    }
}
