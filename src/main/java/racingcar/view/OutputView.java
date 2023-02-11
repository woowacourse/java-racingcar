package racingcar.view;

import racingcar.model.car.Car;
import racingcar.model.car.Cars;

import java.util.stream.Collectors;

public class OutputView {
    public static final String POSITION_CAR_FORMAT_SYMBOL = "-";
    public static final String POSITION_CAR_STATE_FORMAT = "%s : %s";
    private static final String WINNER_MESSAGE = "%s가 최종 우승했습니다.";
    private static final String CAR_SEPARATOR = ", ";
    private static final String LINE_BREAK = "\n";

    public void printWinnerCars1(String winnerCarsFormat) {
        System.out.printf(WINNER_MESSAGE, winnerCarsFormat);
    }

    public void printCurrentCarsPosition(Cars cars) {
        StringBuilder stringBuilder = new StringBuilder(LINE_BREAK);

        cars.getCarsCurrentInfo().forEach(car -> {
            stringBuilder.append(String.format(POSITION_CAR_STATE_FORMAT,
                    car.getCarName(),
                    POSITION_CAR_FORMAT_SYMBOL.repeat(car.getPosition())));
        });

        System.out.println(stringBuilder + LINE_BREAK);
    }

    public void printWinnerCars(Cars cars) {
        System.out.println(cars.getWinnerCars().stream()
                .map(Car::getCarName)
                .collect(Collectors.joining(CAR_SEPARATOR)));
    }

    public void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }
}
