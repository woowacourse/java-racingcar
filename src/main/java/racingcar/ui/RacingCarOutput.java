package racingcar.ui;

import racingcar.domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCarOutput {
    private static final String WINNERS_DELIMITER = ", ";
    private static final String ROUND_RESULT = "실행 결과";
    private static final String WINNER_MESSAGE = "가 최종 우승했습니다.";
    private static final String CAR_INFO_SEPARATOR = " : ";
    private static final String CAR_POSITION_BAR = "-";

    public static void printRoundResultMessage() {
        System.out.println(ROUND_RESULT);
    }

    public static void printErrorMessage(final String error) {
        System.out.println(error);
    }

    public static void printRoundResult(final List<Car> cars) {
        cars.forEach(RacingCarOutput::printCarPositionInfo);
        System.out.println();
    }

    private static void printCarPositionInfo(final Car car) {
        System.out.println(car.getName() + CAR_INFO_SEPARATOR + CAR_POSITION_BAR.repeat(Math.max(0, car.getPosition())));
    }

    public static void printWinners(final List<Car> winners) {
        System.out.println(toWinnerNameString(winners) + WINNER_MESSAGE);
    }

    private static String toWinnerNameString(final List<Car> winners) {
        return winners.stream()
            .map(Car::getName)
            .collect(Collectors.joining(WINNERS_DELIMITER));
    }

}
