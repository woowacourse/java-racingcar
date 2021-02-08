package racingcar.view;

import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final String RUN_RESULT_MESSAGE = "실행 결과";
    private static final String DELIMITER_COLON = " : ";
    private static final String DELIMITER_COMMA = ", ";
    private static final String POSITION_HYPHEN = "-";
    private static final String WINNER_MESSAGE = "가 최종 우승했습니다.";

    private OutputView() {
    }

    public static void printRunResult(List<Cars> runResult) {
        System.out.println(RUN_RESULT_MESSAGE);
        runResult.forEach(OutputView::printCars);
    }

    private static void printCars(Cars cars) {
        cars.getCars().forEach(OutputView::printCarsStatus);
        System.out.println();
    }

    private static String printPosition(int position) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < position; i++) {
            stringBuilder.append(POSITION_HYPHEN);
        }

        return stringBuilder.toString();
    }

    public static void printWinners(List<Car> winners) {
        List<String> carNames = winners.stream()
                .map(Car::getName)
                .collect(Collectors.toList());

        String winnerNames = String.join(DELIMITER_COMMA, carNames);
        System.out.println(winnerNames + WINNER_MESSAGE);
    }

    private static void printCarsStatus(Car car) {
        System.out.println(car.getName() + DELIMITER_COLON + printPosition(car.getPosition()));
    }
}