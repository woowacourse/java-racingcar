package view;

import domain.Car;
import java.util.List;

public class OutputView {

    private final String DELIMITER = ", ";
    private final String BAR = "-";

    public void printStart(List<Car> cars) {
        printNewLine();
        System.out.println(Messages.OUTPUT_START);
        printCarsStatus(cars);
    }

    private void printNewLine() {
        System.out.println();
    }

    public void printCarsStatus(List<Car> cars) {
        cars.forEach(this::printCarStatus);
        printNewLine();
    }

    private void printCarStatus(Car car) {
        System.out.printf(Messages.OUTPUT_CAR_STATUS, car.getName(), toBar(car.getPosition()));
    }

    private String toBar(int count) {
        return BAR.repeat(count);
    }

    public void printWinners(List<String> carNames) {
        String result = carNames.get(0);
        boolean isCoWinner = carNames.size() > 1;
        if (isCoWinner) {
            result = String.join(DELIMITER, carNames);
        }
        System.out.printf(Messages.OUTPUT_WINNER, result);
    }

    public void printErrorMessage(Exception exception) {
        System.out.println(exception.getMessage());
    }
}
