package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.car.Car;
import racingcar.model.car.Cars;

public class OutputView {
    private static final String POSITION_FORMAT_SYMBOL = "-";
    private static final String POSITION_STATE_FORMAT = "%s : %s";
    private static final String WINNER_MESSAGE = "%s가 최종 우승했습니다.";
    private static final String LINE_BREAK = "\n";
    private static final String CAR_SEPARATOR = ", ";


    public void printWinnerCars(List<Car> winnerCars) {
        String winnerCarsFormat = winnerCars.stream()
                .map(Car::getCarName)
                .collect(Collectors.joining(CAR_SEPARATOR));
        System.out.printf(WINNER_MESSAGE, winnerCarsFormat);
    }

    public void printCarsPosition(Cars cars) {
        String carsFormat = cars.getCars().stream()
                .map(this::carPositionFormat)
                .collect(Collectors.joining(LINE_BREAK));
        System.out.println(carsFormat + LINE_BREAK);
    }

    private String carPositionFormat(Car car) {
        String positionFormat = POSITION_FORMAT_SYMBOL.repeat(car.getPosition());
        return String.format(POSITION_STATE_FORMAT, car.getCarName(), positionFormat);
    }


    public void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }
}
