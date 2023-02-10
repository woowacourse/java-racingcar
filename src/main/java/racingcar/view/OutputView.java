package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.car.Car;

public class OutputView {
    private static final String WINNER_MESSAGE = "%s가 최종 우승했습니다.";
    private static final String LINE_BREAK = "\n";
    private static final String CAR_SEPARATOR = ", ";


    public void printCarsResult(String carsPositionFormat) {
        System.out.println(carsPositionFormat + LINE_BREAK);
    }

    public void printWinnerCars(List<Car> winnerCars) {
        String winnerCarsFormat = winnerCars.stream()
                .map(Car::getCarName)
                .collect(Collectors.joining(CAR_SEPARATOR));
        System.out.printf(WINNER_MESSAGE, winnerCarsFormat);
    }

    public void printInitialCarPosition(String carsPositionFormat) {
        System.out.println(carsPositionFormat + LINE_BREAK);
    }

    public void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }
}
