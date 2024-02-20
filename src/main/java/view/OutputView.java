package view;

import domain.Car;
import domain.RacingGame;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final String CAR_POSITION_MARK = "-";
    private static final String WINNERS_NAME_DELIMITER = ", ";

    public static void printRaceResultHeader() {
        System.out.println("\n실행 결과");
    }

    public static void printCarsPosition(final String result) {
        System.out.println(result);
    }

    public static void printResult(final RacingGame racingGame) {
        final List<Car> winners = racingGame.getWinners();

        if (winners.size() == 0) {
            System.out.println("우승자가 없습니다.");
            return;
        }

        final List<String> winnerNames = winners.stream()
                .map(Car::getName)
                .collect(Collectors.toList());

        final String result = String.join(WINNERS_NAME_DELIMITER, winnerNames).concat("가 최종 우승했습니다.");
        System.out.println(result);
    }

    public static void printExceptionMessage(final Exception ex) {
        System.out.println(ex.getMessage());
    }
}
