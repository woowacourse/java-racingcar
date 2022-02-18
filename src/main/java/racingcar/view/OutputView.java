package racingcar.view;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import racingcar.domain.Car;

public class OutputView {
    private static final String ROUND_RESULT = "실행 결과";
    private static final String WINNER_MESSAGE = "가 최종 우승했습니다.";
    private static final String CAR_INFO_SEPARATOR = " : ";
    private static final String CAR_POSITION_BAR = "-";
    private static final String WINNER_NAME_DELIMITER = ", ";

    public static void printRoundResult(Map<Integer, List<Car>> raceResult) {
        System.out.println(ROUND_RESULT);
        for (Integer round : raceResult.keySet()) {
            raceResult.get(round).forEach(OutputView::printCarPositionInfo);
            System.out.println();
        }
    }

    private static void printCarPositionInfo(Car car) {
        System.out.println(
                car.getName() + CAR_INFO_SEPARATOR + CAR_POSITION_BAR.repeat(Math.max(0, car.getPosition())));
    }

    public static void printWinners(List<Car> winners) {
        System.out.println(toWinnerNameString(winners) + WINNER_MESSAGE);
    }

    private static String toWinnerNameString(List<Car> winners) {
        return winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(WINNER_NAME_DELIMITER));
    }

}
